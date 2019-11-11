/*
 * package com.technostorms.bank;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * import com.technostorms.bank.service.UserDetailService;
 * 
 * @Configuration public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private UserDetailService userDetailsservice;
 * 
 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
 * {
 * 
 * auth.inMemoryAuthentication().withUser("user1").password("secret1").roles(
 * "USER").and().withUser("admin1") .password("secret1").roles("USER", "ADMIN");
 * 
 * }
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.cors().and().authorizeRequests().antMatchers("/Bank/createAccount").
 * permitAll()
 * .anyRequest().authenticated().and().formLogin().loginProcessingUrl(
 * "/authenticate").and(). csrf().disable(); }
 * 
 * 
 * protected void configure(HttpSecurity http) throws Exception {
 * http.httpBasic().and().authorizeRequests().antMatchers("/Bank/**").
 * authenticated().and().csrf().disable() .headers().frameOptions().disable(); }
 * 
 * 
 * }
 */