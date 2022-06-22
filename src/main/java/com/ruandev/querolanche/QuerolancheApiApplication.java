package com.ruandev.querolanche;

import com.ruandev.querolanche.infrastucture.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class QuerolancheApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuerolancheApiApplication.class, args);
	}

}
