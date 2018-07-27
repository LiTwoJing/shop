package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfid extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() // 配置页面授权
			.antMatchers("/uc/**").authenticated()
			.antMatchers("/**").permitAll() // 登录页面允许所有用户访问（包括匿名）
			//.antMatchers("/**").authenticated() // 其他页面仅限于登录用户访问
			.and()
			.formLogin() // 配置表单登录
			.loginPage("/login") // 指定登录页面的路径：显示表单（自己写） GET /login；提交表单（springsecurity自带） POST /login
			.defaultSuccessUrl("/cellphone/")  // 指定默认的登录成功页面（比如直接访问登录页面，而不是其他需要登录的页面触发的）
			
		.and()
          .rememberMe()
           .tokenValiditySeconds(7 * 24 * 3600)
           .key("test123456") // 避免开发中需要反复登录，上线时注释掉，默认为随机数会导致服务器重启之后重启前的记住我cookie失效
           .userDetailsService(userDetailsService);
	
	}
}
