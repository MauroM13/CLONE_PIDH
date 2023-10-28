package br.com.digital_hoteis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.com.digital_hoteis.model.repository")
@SpringBootApplication
@EnableJpaAuditing
@EntityScan("br.com.digital_hoteis.model.entity")
public class DigitalHoteisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalHoteisApplication.class, args);
	}

}
