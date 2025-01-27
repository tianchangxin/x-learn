package cn.xin.learn.community.client;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.*;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;


/**
 * feign调用客户端
 *
 * @author xin
 */
@Component
public class FeignClient {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T getFeignService(Class<T> t, String baseUrl) {
        Feign.Builder builder = Feign.builder()
                .decoder(new feignDecoder())
                .encoder(new feignEncoder());
        return builder.target(t, baseUrl);
    }


    public static FeignClient getInstance() {
        return FeignServiceHolder.FEIGN_SERVICE;
    }


    /**
     * 静态内部类，单例
     */
    private static class FeignServiceHolder {
        private static final FeignClient FEIGN_SERVICE = new FeignClient();
    }

    class feignDecoder implements Decoder {

        @Override
        public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
            Reader reader = response.body().asReader();
            if (!reader.markSupported()) {
                reader = new BufferedReader(reader, 1);
            }
            reader.mark(1);
            if (reader.read() == -1) {
                return null;
            }
            reader.reset();
            return objectMapper.readValue(reader, objectMapper.constructType(type));
        }
    }

    class feignEncoder implements Encoder {

        @Override
        public void encode(Object o, Type type, RequestTemplate requestTemplate) {
            Request.Body body = null;
            if (o == null) {
                o = "";
            }
            body = Request.Body.encoded(JSONUtil.toJsonStr(o).getBytes(StandardCharsets.UTF_8), Util.UTF_8);
            requestTemplate.body(body);
        }
    }

}