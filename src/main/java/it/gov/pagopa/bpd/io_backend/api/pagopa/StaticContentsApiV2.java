/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package it.gov.pagopa.bpd.io_backend.api.pagopa;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa.WalletsHashingEvaluationInput;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa.WalletsHashingEvaluation;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa.WalletsHashingInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
public interface StaticContentsApiV2 {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /static-contents/wallets/hashing/actions/evaluate/enc : Returns an hashpan starting from a pgp-encrypted pan
     *
     * @param walletsHashingEvaluationInput  (required)
     * @return hashpan returned (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Returns an hashpan starting from a pgp-encrypted pan", nickname = "evaluateStaticWalletHashEnc", notes = "", response = WalletsHashingEvaluation.class, responseContainer = "List", tags={ "static-contents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "hashpan returned", response = WalletsHashingEvaluation.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(
        value = "/static-contents/wallets/hashing/actions/evaluate/enc",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<List<WalletsHashingEvaluation>> evaluateStaticWalletHashEnc(@ApiParam(value = "" ,required=true )  @Valid @RequestBody WalletsHashingEvaluationInput walletsHashingEvaluationInput);


    /**
     * POST /static-contents/wallets/hashing/actions/evaluate : Evaluates the cryptographic hash function used with wallets against a PAN provided in input
     *
     * @param body  (required)
     * @return Result of evaluating the cryptographic hash function used with wallets against the PAN provided in input (status code 200)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Evaluates the cryptographic hash function used with wallets against a PAN provided in input", nickname = "evaluateStaticWalletsHash", notes = "", response = WalletsHashingEvaluation.class, tags={ "static-contents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Result of evaluating the cryptographic hash function used with wallets against the PAN provided in input", response = WalletsHashingEvaluation.class),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(
        value = "/static-contents/wallets/hashing/actions/evaluate",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<WalletsHashingEvaluation> evaluateStaticWalletsHash(@ApiParam(value = "" ,required=true )  @Valid @RequestBody WalletsHashingEvaluationInput body);

    /**
     * GET /static-contents/wallets/hashing : Gets info about cryptographic hash function used with wallets
     *
     * @return Info about cryptographic hash function used with wallets (status code 200)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Gets info about cryptographic hash function used with wallets", nickname = "getStaticWalletsHash", notes = "", response = WalletsHashingInfo.class, tags={ "static-contents", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Info about cryptographic hash function used with wallets", response = WalletsHashingInfo.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(
        value = "/static-contents/wallets/hashing",
        produces = { "application/json" }
    )
    ResponseEntity<WalletsHashingInfo> getStaticWalletsHash();

}
