package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.wallets.dto.WalletNPInput;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.LEWallet;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.NPWallet;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.WalletsResource;
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
import java.util.List;

@Controller
@Slf4j
public class PMWalletsController implements PMWalletsApi {

    private final String salt;

    public PMWalletsController(@Value("${bpd.hash.salt}") String salt) {
        this.salt = salt;
    }

    @Override
    public ResponseEntity<List<NPWallet>> getHpan(@Valid @NotBlank @NotNull String pan) {
        String hpan = DigestUtils.sha256Hex(pan+salt);
        return new ResponseEntity<>(
                Collections.singletonList(NPWallet.builder().hashPan(hpan).build()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NPWallet> saveHpan(@Valid @NotNull WalletNPInput walletNPInput) {
        String hpan = DigestUtils.sha256Hex(walletNPInput.getPan()+salt);
        return new ResponseEntity<>(
                NPWallet.builder().hashPan(hpan).build(),
                HttpStatus.CREATED);
    }


}
