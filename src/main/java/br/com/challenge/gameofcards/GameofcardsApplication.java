package br.com.challenge.gameofcards;

import br.com.challenge.gameofcards.model.DeckApiResponseModel;
import br.com.challenge.gameofcards.service.DeckApiService;
import br.com.challenge.gameofcards.service.GameService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class GameofcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameofcardsApplication.class, args);
	}
}
