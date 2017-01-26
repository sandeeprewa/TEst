package com.iexp.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
 * @author sandeep
 */
@Configuration
@ComponentScan("com.iexp.aspect")
@EnableAspectJAutoProxy
public class AspectConfiguration {

}