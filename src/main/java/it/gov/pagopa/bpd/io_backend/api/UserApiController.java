package it.gov.pagopa.bpd.io_backend.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import it.gov.pagopa.bpd.io_backend.model.ExtendedPagoPAUser;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")
@Controller
public class UserApiController implements UserApi {

	public ResponseEntity<ExtendedPagoPAUser> getUser(
			@ApiParam(value = "", allowableValues = "20200114") @Valid @RequestParam(value = "version", required = false) String version,
			@Valid @RequestParam(value = "token", required = true) String token) {
		String fiscalCode = null;
		
		
		

		return ResponseEntity.ok(ExtendedPagoPAUser.builder().fiscalCode(fiscalCode).build());
	}

}
