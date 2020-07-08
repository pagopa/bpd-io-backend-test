package it.gov.pagopa.bpd.io_backend.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class PaymentInstrumentController implements PaymentInstrumentApi{

    private final String salt;

    public PaymentInstrumentController(@Value("${bpd.hash.salt}") String salt) {
        this.salt = salt;
    }

    @Override
    public ResponseEntity<String> getHpan(String id) {
        return new ResponseEntity<>(DigestUtils.sha256Hex(id+salt), HttpStatus.OK);
    }

}
