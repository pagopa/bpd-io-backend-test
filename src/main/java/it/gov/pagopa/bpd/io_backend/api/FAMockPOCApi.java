package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.event.model.RegisterTransaction;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.merchant.model.CheckMerchantResource;
import it.gov.pagopa.bpd.io_backend.model.ade.MockPerson;
import it.gov.pagopa.bpd.io_backend.model.provider.dto.InvoiceRequestDto;
import it.gov.pagopa.bpd.io_backend.model.provider.dto.ProviderRequestDto;
import it.gov.pagopa.bpd.io_backend.model.provider.resource.InvoiceProviderResource;
import it.gov.pagopa.bpd.io_backend.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;

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
    ResponseEntity<HttpStatus> sendTransactionDetails(@RequestBody @Valid ProviderRequestDto request);

    @PostMapping(value = "/provider/invoice/response")
    ResponseEntity<InvoiceProviderResource> getInvoiceDetails(@RequestBody @Valid InvoiceRequestDto request);

    @GetMapping(value = "/merchant/check/{vatNumber}")
    ResponseEntity<CheckMerchantResource> checkMerchantProvider(@PathVariable String vatNumber);

}

