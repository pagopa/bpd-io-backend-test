package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.wallets.dto.WalletNPInput;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.NPWallet;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.WalletsResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(value = "/pp-restapi-rtd/v1")
public interface PMWalletsApi {

    @GetMapping(value = "/wallets/np-wallets", produces = {"application/json"})
    public ResponseEntity<List<NPWallet>> getHpan(@Valid @NotBlank @NotNull @RequestParam("pan") String pan);

    @PostMapping(value = "/wallets/np-wallets", produces = {"application/json"})
    public ResponseEntity<NPWallet> saveHpan(@Valid @NotNull @RequestBody WalletNPInput walletNPInput);

}
