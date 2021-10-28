package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.model.ade.MockPerson;
import it.gov.pagopa.bpd.io_backend.model.provider.ProviderRequestDto;
import it.gov.pagopa.bpd.io_backend.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import it.gov.pagopa.bpd.io_backend.event.model.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "pocmock")
@RequestMapping("/fa/mock/poc")
@Validated
public interface FAMockPOCApi {

    @PostMapping(value = "/transaction/rtd/send")
    void sendRTDTransaction(@RequestBody(required = false) Transaction transaction);

    @PostMapping(value = "/cash/register/pos/transaction/sender")
    void cashRegisterSender(@RequestBody(required = false) RegisterTransaction transaction,
                            @RequestParam(required = false, value = "posType") String posType);

    @GetMapping(value = "/ade/users/{fiscalCode}")
    ResponseEntity<MockPerson> datiAnagraficiPersonaFisica(
            @PathVariable @Valid @Size(min = 16, max = 16) @Pattern(regexp = Constants.FISCAL_CODE_REGEX)
                    String fiscalCode)
            throws UnsupportedEncodingException;

    @PostMapping(value = "/provider/invoice/request", produces = {"application/json", "application/problem+json"})
    @ResponseStatus(HttpStatus.OK)
    HttpStatus sendTransactionDetails(@RequestBody @Valid ProviderRequestDto request);

}

