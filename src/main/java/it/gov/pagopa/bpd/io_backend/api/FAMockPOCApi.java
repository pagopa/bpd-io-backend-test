package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "pocmock")
@RequestMapping("/fa/mock/poc")
@Validated
public interface FAMockPOCApi {

    @PostMapping(value = "/transaction/rtd/send")
    void sendRTDTransaction(@RequestBody(required = false) Transaction transaction);

    @PostMapping(value = "/cash/register/pos/transaction/sender")
    void cashRegisterSender();

}

