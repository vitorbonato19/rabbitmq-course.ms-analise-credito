package com.udemy.analisecredito;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.service.AnaliseCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnalisecreditoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}

}
