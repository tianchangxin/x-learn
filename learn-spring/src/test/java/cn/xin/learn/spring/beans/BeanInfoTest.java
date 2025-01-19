package cn.xin.learn.spring.beans;

import cn.xin.learn.spring.ioc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @author tiancx
 * @description: BeanInfoTest
 * @date 2024年11月19日
 */
@Slf4j
public class BeanInfoTest {
    @Test
    public void test() throws IntrospectionException {
        // 获得BeanInfo对象
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    log.info(propertyDescriptor.toString());
                });
    }
}
