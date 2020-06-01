package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.*;
import it.gov.pagopa.bpd.io_backend.model.ExtendedPagoPAUser;
import it.gov.pagopa.bpd.io_backend.model.ProblemJson;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")

@Api(value = "user")
@RequestMapping(value = "/bpd/pagopa/api/v1")
@Validated
public interface UserApi {

    @ApiOperation(value = "Get user's token", nickname = "getToken",
            notes = "Returns a token to be used in the PagoPA backend, using user's fiscalCode.",
            response = String.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Found.", response = String.class),
            @ApiResponse(code = 400, message = "Bad request."),
            @ApiResponse(code = 401, message = "Fiscal code null or invalid."),
            @ApiResponse(code = 500, message = "There was an error in retrieving the user data.",
                    response = ProblemJson.class)})
    @RequestMapping(value = "/login", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<String> getToken(
            @ApiParam(value = "", allowableValues = "")
            @Valid @RequestParam(value = "version", required = false) String version,
            @Valid @NotNull @NotBlank @RequestParam(value = "fiscalCode", required = true) String fiscalCode)
            throws UnsupportedEncodingException;

	@ApiOperation(value = "Get user's data", nickname = "getUser",
            notes = "Returns the user data needed by PagoPA Wallet backend.",
            response = ExtendedPagoPAUser.class, authorizations = {
			@Authorization(value = "Token") }, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Found.", response = String.class),
            @ApiResponse(code = 400, message = "Bad request."),
            @ApiResponse(code = 401, message = "Token null or invalid."),
            @ApiResponse(code = 500, message = "There was an error in retrieving the user data.",
                    response = ProblemJson.class)})
    @RequestMapping(value = "/user", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<String> getUser(
            @ApiParam(value = "", allowableValues = "")
            @Valid @RequestParam(value = "version", required = false) String version,
            @Valid @NotNull @NotBlank @RequestParam(value = "token", required = true) String token)
            throws UnsupportedEncodingException;

}
