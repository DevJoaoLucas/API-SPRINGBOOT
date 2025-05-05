package com.joaodev.apicursos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Estudo de API com Java SpringBoot")
		                .version("1.0.0")
		                .description("Essa é uma API de exemplo feita em Java com Spring Boot para o meu github"));
	}
}