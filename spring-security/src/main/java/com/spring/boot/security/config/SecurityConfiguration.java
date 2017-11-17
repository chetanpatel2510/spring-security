package com.spring.boot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This class is security configuration. All security configurations are placed
 * in separate line for better readability.
 * 
 * @author Chetan
 *
 */
/*
 * Ordering is required when there are more than one configuration class. We
 * created subclass MvcConfig extends WebMvcConfigurerAdapter
 */
@Order(10)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		
		// Specify Login page and permit all to access it.
		httpSecurity.formLogin().loginPage("/login").failureUrl("/login?error").permitAll();
		
		// Set the roles for particular URLs
		httpSecurity.authorizeRequests().antMatchers("/product/admin/**").hasRole("ADMIN")
										.antMatchers("/order/**").hasRole("USER");
		
		// Specify logout 
		httpSecurity.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/index.html").invalidateHttpSession(true).permitAll();
		
		// Disable CSRF
		httpSecurity.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("XXX").password("YYY").accountLocked(false).accountExpired(false).roles("ADMIN").
								and().withUser("PPP").password("QQQ").accountLocked(false).accountExpired(false).roles("USER");
	}
}
