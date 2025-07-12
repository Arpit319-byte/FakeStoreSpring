package com.example.FakeStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FakeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeStoreApplication.class, args);
	}

}
