package tn.enis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	/** Routage statique (TP section III.5) */
	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/membres/**").uri("lb://MEMBRE-SERVICE"))
				.route(r -> r.path("/publications/**").uri("lb://PUBLICATION-SERVICE"))
				.build();
	}

	// Routage dynamique (TP III.7) : spring.cloud.gateway.server.webflux.discovery.locator.enabled=true
}
