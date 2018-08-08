package shop.config;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("shop")
@EnableWebMvc
@MapperScan("shop.mapper")
@PropertySource({"classpath:jdbc.properties","classpath:alipay.properties"})
@EnableTransactionManagement
@EnableScheduling // 开启调度支持
@EnableAsync // 开启异步执行任务支持
public class Appconfig extends WebMvcConfigurerAdapter{
	public void configureViewResolvers(ViewResolverRegistry vr){
		vr.jsp("/WEB-INF/jsp/", ".jsp");
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    // 当springmvc遇到没有控制器映射的路径时（如webapp下的静态资源），交给默认的servlet处理
	    configurer.enable(); 
	}
	@Bean
	public DataSource dataSource(Environment env) { 
		DriverManagerDataSource ds = new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.DriverClassName"));
		return ds;
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds){
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sf.setDataSource(ds);
		return sf;
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource ds){
		return new DataSourceTransactionManager(ds);
	}
	
	@Bean
	public AlipayClient alipayClient(Environment env) throws IOException{
		
		return new DefaultAlipayClient(
				"https://openapi.alipay.com/gateway.do",
				env.getProperty("alipay.appId"),
				FileUtils.readFileToString(new File(env.getProperty("alipay.appPrivateKeyFile")), "UTF-8"),
				"json",
				"UTF-8",
				FileUtils.readFileToString(new File(env.getProperty("alipay.appPrivateKeyFile")), "UTF-8"),
				env.getProperty("alipay.signType")
				);
	}
	
	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
	
	@Bean // 简化了http请求的发送和响应的处理
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
