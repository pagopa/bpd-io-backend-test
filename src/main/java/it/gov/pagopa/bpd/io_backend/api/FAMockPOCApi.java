package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.model.provider.ProviderRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Api(value = "pocmock")
@RequestMapping("/fa/mock/poc")
@Validated
public interface FAMockPOCApi {

    @PostMapping(value = "/transaction/rtd/send")
    void sendRTDTransaction(@RequestBody(required = false) Transaction transaction);

    @PostMapping(value = "/cash/register/pos/transaction/sender")
    void cashRegisterSender();

    @PostMapping(value = "/fa/invoice/request", produces = {"application/json", "application/problem+json"})
    @ResponseStatus(HttpStatus.OK)
    HttpStatus sendTransactionDetails(@RequestBody @Valid ProviderRequestDto request);

}

