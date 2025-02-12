package cn.xin.learn.community.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author xin
 * @description: 数据源配置
 * @date 2024年12月28日
 */
@Configuration
@MapperScan(basePackages = "cn.xin.learn.community.dao", sqlSessionFactoryRef = "getSqlsessionFactroyBean")
@RequiredArgsConstructor
public class DataSourceConfig {
    @Resource
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Resource
    private MetaObjectHandler communityMetaObjectHandler;

    @Bean("myDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/community_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }


    /**
     * SqlSessionFactoryBean 负责给我们产生sqlSession
     * 知道数据源 ，在创建这个对象的时候指定你的数据源
     */
    @Bean
    @Primary
    public SqlSessionFactory getSqlsessionFactroyBean(@Autowired DataSource dataSource) throws Exception {

        //mapper xml文件路径
        //创建SqlSessionFactoryBean
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        //注入数据源
        factoryBean.setDataSource(dataSource);
        //创建mybatis配置项类  可以配置驼峰命名、日志实现、、、、
        MybatisConfiguration config = new MybatisConfiguration();
        config.setLogImpl(StdOutImpl.class);
        //插件
        config.addInterceptor(mybatisPlusInterceptor);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        factoryBean.setConfiguration(config);
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setBanner(false);
        globalConfig.setMetaObjectHandler(communityMetaObjectHandler);
        //逻辑删除
        globalConfig.setDbConfig(new GlobalConfig.DbConfig()
                .setLogicDeleteValue("1")
                .setLogicNotDeleteValue("0"));
        factoryBean.setGlobalConfig(globalConfig);
        return factoryBean.getObject();
    }


}
