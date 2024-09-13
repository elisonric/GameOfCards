package br.com.challenge.gameofcards;

import br.com.challenge.gameofcards.model.DeckApiResponseModel;
import br.com.challenge.gameofcards.service.DeckApiService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class GameofcardsApplication {

	@Autowired
	private DeckApiService deckApiService;

	public static void main(String[] args) {
		SpringApplication.run(GameofcardsApplication.class, args);
	}
}
