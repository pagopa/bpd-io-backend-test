package it.gov.pagopa.bpd.io_backend.service;

import it.gov.pagopa.bpd.io_backend.builder.TokenBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
class TokenServiceImpl implements TokenService {

    private final TokenBuilder tokenBuilder;

    @Value("${bpd.jwt.key}")
    private String jwtKey;


    @Override
    public @Valid String buildToken(String fiscalCode) {
        return TokenBuilder.getIstance().buildToken(fiscalCode, jwtKey);
    }

    @Override
    public @Valid String validateToken(String token) {
        return TokenBuilder.decodeJWT(token, jwtKey).getSubject();
    }

}
