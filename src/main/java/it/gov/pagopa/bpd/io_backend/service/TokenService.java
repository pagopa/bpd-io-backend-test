package it.gov.pagopa.bpd.io_backend.service;

import javax.validation.Valid;

/**
 * A service to manage the Business Logic related to IO_Backend
 */
public interface TokenService {

    @Valid
    String buildToken(String token);

    @Valid
    String validateToken(String fiscalCode);
}
