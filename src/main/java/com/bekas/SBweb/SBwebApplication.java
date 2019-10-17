package com.bekas.SBweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableJpaAuditing

public class SBwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBwebApplication.class, args);
	}
        
        @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurerAdapter() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/mahasiswas").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            registry.addMapping("/mahasiswas/create").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            registry.addMapping("/mahasiswas/edit/{id}").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            registry.addMapping("/mahasiswas/{id}").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
         }
      };
   }
    
  

}
