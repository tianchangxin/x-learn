package cn.xin.learn.design.creational.singleton.core;

/**
 * @author tiancx
 * @description: 枚举单例模式
 * @date 2024年07月20日
 */
public enum EnumSingleton {
    INSTANCE;
    private String url;
    private String username;
    private String password;

    // 构造函数私有化，防止外部创建实例
    private EnumSingleton() {
        //从配置文件中读取数据库连接信息
       //这里就不写了
    }
}
