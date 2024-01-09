package br.com.mysthenrpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TccApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
	}

}
