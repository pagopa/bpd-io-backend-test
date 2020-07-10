package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.LEWallet;
import it.gov.pagopa.bpd.io_backend.model.NPWallet;
import it.gov.pagopa.bpd.io_backend.model.WalletsResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Controller
@Slf4j
public class PaymentInstrumentController implements PaymentInstrumentApi{

    private final String salt;

    public PaymentInstrumentController(@Value("${bpd.hash.salt}") String salt) {
        this.salt = salt;
    }

    @Override
    public ResponseEntity<WalletsResource> getHpan(@Valid @NotBlank @NotNull String pan) {
        String hpan = DigestUtils.sha256Hex(pan+salt);
        return new ResponseEntity<>(
                WalletsResource.builder()
                 .leWalletsCollection(Collections.singletonList(LEWallet.builder().hashPan(hpan).build()))
                 .npWalletsCollection(Collections.singletonList(NPWallet.builder().hashPan(hpan).build()))
                 .build(),
                HttpStatus.OK);
    }

}
