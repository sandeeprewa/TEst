package com.iexp.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.iexp.*"})
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    	@Autowired
    	private Environment environment;
    	/*
    	 * (non-Javadoc)
    	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
    	 *	
           It tells Spring to use the container's default servlet for certain requests, like for static resources.
    	 */
    	@Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }
    	
    	@Override
		public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
		    registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
		}
    	
        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
          configurer.defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML);
        }
        
    	/*
		 * View Configuration
		 */
		@Bean(name = "viewResolver")
	    public InternalResourceViewResolver getViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
		
		@Bean
		public PasswordEncoder getPasswordEncoder(){
			return new BCryptPasswordEncoder();
		}
		/*
		 * Adding Interceptors
		 * (non-Javadoc)
		 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
		 */
		@Override
	    public void addInterceptors(InterceptorRegistry registry) {
		} 		
		
}
