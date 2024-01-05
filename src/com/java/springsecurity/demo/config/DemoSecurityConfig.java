/**
 * Configuration class for Spring Security.
 * This class extends WebSecurityConfigurerAdapter to provide custom security configurations.
 */
package com.java.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("john").roles("EMPLOYEE").password("{noop}test123");
    ;
    auth.inMemoryAuthentication().withUser("mary").roles("MANAGER").password("{noop}test123");
    ;
    auth.inMemoryAuthentication().withUser("susan").roles("ADMIN").password("{noop}test123");
    ;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage")
        .loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll();
  }
}
