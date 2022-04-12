package it.gov.pagopa.bpd.io_backend.jpa.config;

import it.gov.pagopa.bpd.common.connector.jpa.config.BaseJpaConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/jpa/jpaConnectionConfig.properties")
public class JpaConfig extends BaseJpaConfig {
}
