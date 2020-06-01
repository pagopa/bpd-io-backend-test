package it.gov.pagopa.bpd.io_backend.api;

import io.jsonwebtoken.ClaimJwtException;
import it.gov.pagopa.bpd.io_backend.builder.TokenBuilder;
import it.gov.pagopa.bpd.io_backend.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;

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
		return new ResponseEntity<String>(tokenService.buildToken(fiscalCode), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> getUser(
			String version, String token)
			throws UnsupportedEncodingException {
		try {
			return new ResponseEntity<String>(tokenService.validateToken(token), HttpStatus.OK);
		} catch (ClaimJwtException e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage(),e);
			}
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
	}
}
