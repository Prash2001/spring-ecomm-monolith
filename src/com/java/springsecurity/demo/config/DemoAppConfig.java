/**
 * Configuration class for the Spring MVC application.
 * Enables web MVC and sets up the view resolver for JSP views.
 *
 * @Configuration - Indicates that this class is a configuration class.
 * @EnableWebMvc - Enables Spring MVC configuration.
 * @ComponentScan - Scans the specified base packages for components to be managed by Spring.
 */
package com.java.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.java.springdemo")
public class DemoAppConfig {
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
}
