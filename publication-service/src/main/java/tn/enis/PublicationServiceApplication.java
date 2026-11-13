package tn.enis;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class PublicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}

	@RestController
	static class PublicationController {

		@GetMapping("/publications")
		List<Map<String, String>> publications() {
			return List.of(Map.of("titre", "Exemple", "auteur", "A. Chercheur"));
		}
	}
}
