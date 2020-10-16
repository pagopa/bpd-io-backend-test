package it.gov.pagopa.bpd.io_backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalTime;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")

@Configuration
public class IOSwaggerDocumentationConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("IO Backend TEST API").description("TEST IO Backend API server.").license("")
				.licenseUrl("http://unlicense.org").termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("", "", "")).build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("it.gov.pagopa.bpd.io_backend.api")).build()
				.directModelSubstitute(LocalTime.class, String.class)
				.apiInfo(apiInfo());
	}

}
