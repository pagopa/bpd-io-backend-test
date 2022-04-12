package it.gov.pagopa.bpd.io_backend.event.config;

import it.gov.pagopa.bpd.io_backend.event.publisher.CsvTransactionPublisherConnector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration class for {@link CsvTransactionPublisherConnector}
 */
@Configuration
@PropertySource("classpath:config/csvTransactionPublisher.properties")
public class CsvTransactionPublisherConfig { }
