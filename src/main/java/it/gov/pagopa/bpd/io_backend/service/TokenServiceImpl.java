package it.gov.pagopa.bpd.io_backend.service;

import it.gov.pagopa.bpd.io_backend.builder.TokenBuilder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
class TokenServiceImpl implements TokenService {

    @Override
    public @Valid String buildToken(String fiscalCode) {
        return TokenBuilder.getIstance().buildToken(fiscalCode);
    }

    @Override
    public @Valid String validateToken(String token) {
        return TokenBuilder.decodeJWT(token).getSubject();
    }

}
