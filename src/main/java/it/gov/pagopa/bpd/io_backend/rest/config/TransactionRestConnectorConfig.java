package it.gov.pagopa.bpd.io_backend.rest.config;

import it.gov.pagopa.bpd.common.connector.config.RestConnectorConfig;
import it.gov.pagopa.bpd.io_backend.rest.transaction.TransactionRestClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(RestConnectorConfig.class)
@EnableFeignClients(clients = TransactionRestClient.class)
@PropertySource("classpath:config/transaction/rest-client.properties")
public class TransactionRestConnectorConfig {
}
