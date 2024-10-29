package cn.xin.learn.design.behavioral.chain.core;

/**
 * @author tiancx
 * @description: 责任链接口
 * @date 2024年10月27日
 */
public interface ChainHandler<T> {
    /**
     * 责任链标记
     */
    String mark();

    /**
     * 处理
     * @param t 参数
     */
    void handler(T t);
}
