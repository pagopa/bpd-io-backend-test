package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.builder.TokenBuilder;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")
@Controller
public class UserApiController implements UserApi {

	TokenBuilder builder = TokenBuilder.getIstance();


//	public ResponseEntity<ExtendedPagoPAUser> getUser(
//			@ApiParam(value = "", allowableValues = "20200114") @Valid @RequestParam(value = "version", required = false) String version,
//			@Valid @RequestParam(value = "token", required = true) String token) {
//		String fiscalCode = "gfgettwqr54f65";
//
//		return ResponseEntity.ok(ExtendedPagoPAUser.builder().fiscalCode(fiscalCode).build());
//	}
//	public ResponseEntity<String> getUser(
//			@ApiParam(value = "", allowableValues = "20200114") @Valid @RequestParam(value = "version", required = false) String version,
//			@Valid @RequestParam(value = "token", required = true) String token) {
//		String fiscalCode = "gfgettwqr54f65".toUpperCase();
//		Claims claims = builder.decodeJWT(token);
//		String fiscalCode = claims.getSubject();
//		if(fiscalCode == null ){
//			throw  new RuntimeException();
//		}
//		return ResponseEntity.ok(builder.buildToken(fiscalCode));
//	}

}
