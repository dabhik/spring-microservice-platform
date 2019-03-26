package com.deloitte.msplatform.adminservice;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableWebSecurity
public class AdminserviceApplication extends WebSecurityConfigurerAdapter{
	
	@Resource
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(AdminserviceApplication.class, args);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated();
		http.httpBasic();
		http.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		final String[] ignoredUrls = env.getProperty("urls.ignored", String[].class);
		if(null != ignoredUrls && ignoredUrls.length > 0){
                web.ignoring().antMatchers(ignoredUrls);
          }
          super.configure(web);
    }

}
