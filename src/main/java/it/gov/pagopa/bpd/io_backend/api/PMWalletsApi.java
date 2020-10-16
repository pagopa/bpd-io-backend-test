package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.wallets.dto.WalletNPInput;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.NPWallet;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.WalletsResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(value = "/pp-restapi-rtd/v1")
public interface PMWalletsApi {

    @RequestMapping(value = "/wallets/np-wallets", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<NPWallet>> getHpan(@Valid @NotBlank @NotNull @RequestParam("pan") String pan);

    @RequestMapping(value = "/wallets/np-wallets", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<NPWallet> saveHpan(@Valid @NotNull @RequestBody WalletNPInput walletNPInput);

}
