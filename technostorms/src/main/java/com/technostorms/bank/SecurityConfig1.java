
package com.technostorms.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.technostorms.bank.service.UserDetailService;

public class SecurityConfig1 extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService userDetailsservice;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//	auth.userDetailsService(userDetailsservice);
		auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}1234")
        .roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .csrf().disable() .authorizeRequests().anyRequest().authenticated()
		 * .and() .httpBasic();
		 */
		
		
		 http
         .httpBasic()                      // it indicate basic authentication is requires
         .and()
         .authorizeRequests()
          .antMatchers("/createAccount").permitAll() // /index will be accessible directly, no need of any authentication
         .anyRequest().authenticated();    // it's indicate all request will be secure
		 http.csrf().disable();
		
	}

}
