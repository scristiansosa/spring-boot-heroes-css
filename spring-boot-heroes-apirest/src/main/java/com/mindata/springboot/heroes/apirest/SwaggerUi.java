package com.mindata.springboot.heroes.apirest;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerUi {

	public static final Contact DEFAULT_CONTACT = new Contact("Cristian Sosa", "https://github.com/scristiansosa",
			"scristiansosa@gmail.com");
	@SuppressWarnings("rawtypes")
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Sosa Spring Boot Cliente", "Challenge Tecnico", "v1.0",
			"urn:tos", DEFAULT_CONTACT, "", "", new ArrayList<VendorExtension>());

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).select()
				.apis(RequestHandlerSelectors.basePackage("com.mindata.springboot.heroes.apirest")).paths(PathSelectors.any())
				.build();
	}
}
