package com.spring.boot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// Permit all the requests.
		httpSecurity.authorizeRequests().antMatchers("/rest/helloForAdmin").hasRole("ADMIN");
		
		// HTTP Basic security for restful web service.
		httpSecurity.httpBasic();
		
		// Disable CSRF
		httpSecurity.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Chetan").password("Patel").roles("ADMIN").and().withUser("Dhara").password("Patel").roles("USER");
	}
}
