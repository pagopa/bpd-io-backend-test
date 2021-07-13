package it.gov.pagopa.bpd.io_backend.api.pagopa;

import it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa.WalletNPInputV2;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa.WalletNPResource;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa.WalletNPResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagopa-mock/pp-restapi-rtd/v1")
public class WalletsApiV2Controller implements WalletsApiV2 {

    private final NativeWebRequest request;
    private final String salt;

    @Autowired
    public WalletsApiV2Controller(NativeWebRequest request, @Value("${bpd.hash.salt}") String salt) {
        this.request = request;
        this.salt = salt;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<WalletNPResource> createWalletNP(WalletNPInputV2 body) {
        String hpan = DigestUtils.sha256Hex(body.getTaxCode()+salt);
        return new ResponseEntity<>(
                WalletNPResource.builder().hashCode(hpan).build(),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<WalletNPResponse>> getUserRtdWallets(String fiscalCode) {
        String hpan = DigestUtils.sha256Hex(fiscalCode+salt);
        return new ResponseEntity<>(
                Collections.singletonList(WalletNPResponse.builder().hashCode(hpan).build()),
                HttpStatus.OK);
    }

}
