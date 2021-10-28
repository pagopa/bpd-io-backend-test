package it.gov.pagopa.bpd.io_backend.rest.transaction;

import io.swagger.annotations.ApiParam;
import it.gov.pagopa.bpd.io_backend.rest.model.transaction.PosTransactionRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Customer Rest Client
 */
@FeignClient(name = "${rest-client.transaction.serviceCode}", url = "${rest-client.transaction.base-url}")
public interface TransactionRestClient {

    @PostMapping(value = "${rest-client.transaction.request.url}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String createPosTransaction(
            @ApiParam(value = "${swagger.transaction.transactionId}", required = true)
            @PathVariable("transactionId") @Valid @NotBlank
                    String transactionId,
            @Valid @RequestBody PosTransactionRequestDTO request
    );
}
