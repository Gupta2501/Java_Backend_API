package com.gupta.JavaEEProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.gupta.JavaEEProject.data.domain.User;
import com.gupta.JavaEEProject.data.enm.Role;
import com.gupta.JavaEEProject.repository.UserRepository;

@SpringBootApplication
public class JavaEeProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaEeProjectApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner usersMockup(UserRepository repository) {
		return (args) -> {
			// mockup data
			repository.save(new User("Elena", "Rutsson", "Elena.Rutsson@gmail.com", "fndjsfnsjk", Role.ADMIN));
		};
	}
	*/




	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/user/edituser/**").allowedOrigins("http://localhost:8080");
			}
		};
	}
}

