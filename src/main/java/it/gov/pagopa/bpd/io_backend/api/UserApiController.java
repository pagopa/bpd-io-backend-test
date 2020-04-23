package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.ApiParam;
import it.gov.pagopa.bpd.io_backend.model.ExtendedPagoPAUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")
@Controller
public class UserApiController implements UserApi {

	public ResponseEntity<ExtendedPagoPAUser> getUser(
			@ApiParam(value = "", allowableValues = "20200114") @Valid @RequestParam(value = "version", required = false) String version,
			@Valid @RequestParam(value = "token", required = true) String token) {
		String fiscalCode = "gfgettwqr54f65";

		return ResponseEntity.ok(ExtendedPagoPAUser.builder().fiscalCode(fiscalCode).build());
	}

	public ResponseEntity<ExtendedPagoPAUser> getUserTest(
			@ApiParam(value = "", allowableValues = "20200114") @Valid @RequestParam(value = "version", required = false) String version,
			@Valid @RequestParam(value = "token", required = true) String token) {
		String fiscalCode = "fFffwtrhthy";

		return ResponseEntity.ok(ExtendedPagoPAUser.builder().fiscalCode(fiscalCode).build());
	}

}
