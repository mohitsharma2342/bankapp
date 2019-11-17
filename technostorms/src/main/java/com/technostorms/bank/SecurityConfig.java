
package com.technostorms.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.technostorms.bank.service.UserDetailService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService userDetailsservice;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsservice);
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	protected void configure(HttpSecurity http) throws Exception {
		
		  http .authorizeRequests()
		  .antMatchers("/Bank/*").permitAll()
		  .anyRequest().authenticated().and().formLogin().
		  defaultSuccessUrl("/Bank/credit").and().csrf().disable();
		 
		
		
		/*
		 * http .httpBasic() // it indicate basic authentication is requires .and()
		 * .authorizeRequests()
		 * .antMatchers("/createAccount").permitAll().and().authorizeRequests() //
		 * /index will be accessible directly, no need of any authentication
		 * .anyRequest().authenticated(); // it's indicate all request will be secure
		 * http.csrf().disable();
		 */
		
	}

}
