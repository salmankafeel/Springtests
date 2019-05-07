package com.fs.springtests.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.fs.springtests.app"})
public class AppStarter {

	
	public static void main(String[] args) {
	ApplicationContext applicationContext = SpringApplication.run(AppStarter.class, args);
	for (String name : applicationContext.getBeanDefinitionNames()) {
		System.out.println(name);
	}
	}
	/*
	 * @Bean ServletRegistrationBean h2servletRegistration(){
	 * 
	 * ServletRegistrationBean registrationBean = new ServletRegistrationBean(new
	 * Webservlet());
	 * 
	 * registrationBean.addUrlMappings("/h2console/*");
	 * 
	 * return registrationBean;
	 * 
	 * 
	 * 
	 * }
	 */
}	
