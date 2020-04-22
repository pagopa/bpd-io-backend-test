package it.gov.pagopa.bpd.io_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"it.gov.pagopa.bpd.io_backend.api" , "it.gov.pagopa.bpd.io_backend.configuration"})
public class IOBackendApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(IOBackendApplication.class, args);
	}
	
}
