package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.model.provider.ProviderRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Api("Provider_gestione_flussi")
public interface ProviderApi {

    @PostMapping(value = "/fa/invoice/request", produces = {"application/json", "application/problem+json"})
    @ResponseStatus(HttpStatus.OK)
    HttpStatus sendTransactionDetails(@RequestBody @Valid ProviderRequestDto request);

}
