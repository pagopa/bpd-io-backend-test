package it.gov.pagopa.bpd.io_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class, SessionAutoConfiguration.class})
@EnableSwagger2
@ComponentScan(basePackages = {	"eu.sia.meda", "it.gov.pagopa.bpd.io_backend"})
public class IOBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IOBackendApplication.class, args);
	}
	
}
