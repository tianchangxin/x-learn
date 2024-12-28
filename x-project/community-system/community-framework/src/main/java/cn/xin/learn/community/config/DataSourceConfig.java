package cn.xin.learn.community.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author xin
 * @description: 数据源配置
 * @date 2024年12月28日
 */
@Configuration
@MapperScan(basePackages = "cn.xin.learn.community.dao", sqlSessionFactoryRef = "getSqlsessionFactroyBean")
public class DataSourceConfig {

    @Bean("myDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/community_system?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("tcx119");
        return dataSource;
    }


    /**
     * SqlSessionFactoryBean 负责给我们产生sqlSession
     * 知道数据源 ，在创建这个对象的时候指定你的数据源
     */
    @Bean
    @Primary
    public SqlSessionFactoryBean getSqlsessionFactroyBean(@Autowired DataSource dataSource) throws IOException {

        //mapper xml文件路径
        //创建SqlSessionFactoryBean
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //注入数据源
        factoryBean.setDataSource(dataSource);
        //注入mybatis核心配置文件路径

        //创建mybatis配置项类  可以配置驼峰命名、日志实现、、、、
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setLogImpl(StdOutImpl.class);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml");
        factoryBean.setMapperLocations(resources);
        factoryBean.setConfiguration(config);
        return factoryBean;
    }

}
