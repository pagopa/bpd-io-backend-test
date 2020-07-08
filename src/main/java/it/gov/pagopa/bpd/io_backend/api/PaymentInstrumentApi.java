package it.gov.pagopa.bpd.io_backend.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/bpd/pagopa/api/v1")
public interface PaymentInstrumentApi {

    @RequestMapping(value = "payment-instruments/hpan/{id}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<String> getHpan(@PathVariable("id") String id);

}
