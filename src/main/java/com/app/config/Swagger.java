package com.app.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//--> http://localhost:port/swagger-ui.html
@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket getShoesApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.app"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Address Book API",
				"API for Pharma Fast - medicare",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Arpan Ghosh", "https://github.com/arpan6452", "arpang2@gmail.com"),
				"API License",
				"https://github.com/arpan6452",
				Collections.emptyList());
		
	}
}
