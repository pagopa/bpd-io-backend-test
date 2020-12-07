package it.gov.pagopa.bpd.io_backend.api;

import io.jsonwebtoken.ClaimJwtException;
import it.gov.pagopa.bpd.io_backend.builder.TokenBuilder;
import it.gov.pagopa.bpd.io_backend.model.user.ExtendedPagoPAUser;
import it.gov.pagopa.bpd.io_backend.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserApiController implements UserApi {

    TokenBuilder builder = TokenBuilder.getIstance();

    private final TokenService tokenService;

    @Override
    public ResponseEntity<String> getToken(String version, String fiscalCode)
            throws UnsupportedEncodingException {
        if (log.isErrorEnabled()) {
            log.debug("UserApiController.getToken");
            log.debug("version = " + version + ", fiscalCode = " + fiscalCode);
        }

        OffsetDateTime execStart = null;
        if (log.isInfoEnabled()) {
            execStart = OffsetDateTime.now();
        }

        @Valid final String token = tokenService.buildToken(fiscalCode);
        if (log.isErrorEnabled()) {
            log.debug("token = " + token);
        }

        if (log.isInfoEnabled()) {
            OffsetDateTime endExec = OffsetDateTime.now();
            log.info(String.format("Executed getToken for fiscalCode: %s - - Started at %s, Ended at %s - Total exec time: %d", fiscalCode, execStart, endExec, ChronoUnit.MILLIS.between(execStart, endExec)));
        }

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExtendedPagoPAUser> getUser(
            String version, String token)
            throws UnsupportedEncodingException {
        if (log.isErrorEnabled()) {
            log.debug("UserApiController.getUser");
            log.debug("version = " + version + ", token = " + token);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OffsetDateTime execStart = null;
        if (log.isInfoEnabled()) {
            execStart = OffsetDateTime.now();
        }
        try {
            ExtendedPagoPAUser pagoPAUser =
                    ExtendedPagoPAUser.builder()
                            .fiscalCode(tokenService.validateToken(token))
                            .build();
            if (log.isErrorEnabled()) {
                log.debug("result OK = " + pagoPAUser);
            }
            if (log.isInfoEnabled()) {
                OffsetDateTime endExec = OffsetDateTime.now();
                log.info(String.format("Executed getToken for token: %s - - Started at %s, Ended at %s - Total exec time: %d", token, execStart, endExec, ChronoUnit.MILLIS.between(execStart, endExec)));
            }
            return new ResponseEntity<ExtendedPagoPAUser>(
                    pagoPAUser, HttpStatus.OK
            );
        } catch (ClaimJwtException e) {
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }
            if (log.isInfoEnabled()) {
                OffsetDateTime endExec = OffsetDateTime.now();
                log.info(String.format("Executed getToken for token: %s - - Started at %s, Ended at %s - Total exec time: %d", token, execStart, endExec, ChronoUnit.MILLIS.between(execStart, endExec)));
            }
            return new ResponseEntity<ExtendedPagoPAUser>(HttpStatus.UNAUTHORIZED);
        }
    }

}
