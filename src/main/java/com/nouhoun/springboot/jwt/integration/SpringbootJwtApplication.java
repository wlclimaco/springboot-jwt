package com.nouhoun.springboot.jwt.integration;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootJwtApplication extends SpringBootServletInitializer {


	


/**
 * @param args Arguments
*/

public static void main(String[] args) {
SpringApplication application = new SpringApplication(SpringbootJwtApplication.class);
/* Setting Boot banner off default value is true */
application.setBannerMode(Banner.Mode.OFF);
application.run(args);
}

/**
  * @param builder a builder for the application context
  * @return the application builder
  * @see SpringApplicationBuilder
 */
 @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder 
  builder) {
    return super.configure(builder);
   }
}
