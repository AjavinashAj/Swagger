package com.avinashit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration

public class SwaggerConfig {

	/*
	 * @Bean public Docket apiDoc() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .apis(RequestHandlerSelectors .basePackage("com.avinashit"))
	 * .paths(PathSelectors.any()) .build(); }
	 */

	@Bean
	public OpenAPI openAPI() {

		return new OpenAPI().info(new Info().title("IRCTC").description("Irctc booking").version("1.0")
				.contact(new Contact().name("Avinash").email("avi@gmail.com")).license(new License().name("IRCTC")))
				.externalDocs(new ExternalDocumentation().description("IRCTC train booking api"));
	}

}
