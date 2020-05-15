package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")

@Api(value = "user")
@RequestMapping(value = "/bpd/pagopa/api/v1")
@Validated
public interface UserApi {

//	@ApiOperation(value = "Get user's data", nickname = "getUser", notes = "Returns the user data needed by PagoPA Wallet backend.", response = ExtendedPagoPAUser.class, authorizations = {
//			@Authorization(value = "Token") }, tags = {})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Found.", response = ExtendedPagoPAUser.class),
//            @ApiResponse(code = 400, message = "Bad request.", response = ProblemJson.class),
//            @ApiResponse(code = 401, message = "Token null or invalid."),
//            @ApiResponse(code = 404, message = "User Profile not found", response = ProblemJson.class),
//            @ApiResponse(code = 429, message = "Too many requests", response = ProblemJson.class),
//            @ApiResponse(code = 500, message = "There was an error in retrieving the user data.", response = ProblemJson.class)})
//    @RequestMapping(value = "/user", produces = {"application/json"}, method = RequestMethod.GET)
//    ResponseEntity<String> getUser(
//            @ApiParam(value = "", allowableValues = "20200114") @Valid @RequestParam(value = "version", required = false) String version,
//            @Valid @RequestParam(value = "token", required = true) String token) throws UnsupportedEncodingException;

}
