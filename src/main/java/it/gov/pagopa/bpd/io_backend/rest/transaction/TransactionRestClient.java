package it.gov.pagopa.bpd.io_backend.rest.transaction;

import it.gov.pagopa.bpd.io_backend.rest.model.transaction.PosTransactionRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

/**
 * Customer Rest Client
 */
@FeignClient(name = "${rest-client.transaction.serviceCode}", url = "${rest-client.transaction.base-url}")
public interface TransactionRestClient {

    @PostMapping(value = "${rest-client.transaction.request.url}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String createPosTransaction(
            @Valid @RequestBody PosTransactionRequestDTO request
    );
}
