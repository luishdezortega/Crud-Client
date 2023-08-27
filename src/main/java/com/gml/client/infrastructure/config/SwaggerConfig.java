package com.gml.client.infrastructure.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {
		return new ApiInfo("API CLIENTE",
				"Documentacion de las Apis Rest para operaciones con informacion del empleado", "1.0",
				"Términos y Condiciones",
				new Contact("Desarrollador", "Ingeniero de Sitemas", "luis.hernandez@pragma.com.co"), "License", "",
				Collections.emptyList());
	}
}
