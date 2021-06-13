package com.github.jmpala.Imageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.github.jmpala.Imageboard.dao"} )
@EnableJpaRepositories(basePackages = {"com.github.jmpala.Imageboard.repository"})
public class ImageboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageboardApplication.class, args);
	}

}
