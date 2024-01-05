/**
 * Initializes the Spring MVC Dispatcher Servlet for the application.
 * 
 * This class extends the AbstractAnnotationConfigDispatcherServletInitializer class
 * and overrides its methods to configure the Dispatcher Servlet.
 */
package com.java.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { DemoAppConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
