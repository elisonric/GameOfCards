package br.com.challenge.gameofcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GameofcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameofcardsApplication.class, args);
	}
}
