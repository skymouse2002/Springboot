package com.bimenche.Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.PropertySource;



@SpringBootApplication
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)  
public class App implements EmbeddedServletContainerCustomizer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }

	/* (non-Javadoc)
	 * @see org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer#customize(org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer)
	 */
	public void customize(ConfigurableEmbeddedServletContainer arg0) {
		//配置端口号
		arg0.setPort(11080);
	}
}
