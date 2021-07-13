package it.gov.pagopa.bpd.io_backend.api.pagopa;

import it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa.WalletsHashingEvaluation;
import it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa.WalletsHashingEvaluationInput;
import it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa.WalletsHashingInfo;
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
public class StaticContentsApiV2Controller implements StaticContentsApiV2 {

    private final NativeWebRequest request;
    private final String salt;

    @Autowired
    public StaticContentsApiV2Controller(NativeWebRequest request, @Value("${bpd.hash.salt}") String salt) {
        this.request = request;
        this.salt = salt;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<WalletsHashingEvaluation>> evaluateStaticWalletHashEnc(WalletsHashingEvaluationInput walletsHashingEvaluationInput) {
        String hpan = DigestUtils.sha256Hex(walletsHashingEvaluationInput.getPan()+salt);
        return new ResponseEntity<>(
                Collections.singletonList(WalletsHashingEvaluation.builder().hashPan(hpan).build()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WalletsHashingEvaluation> evaluateStaticWalletsHash(WalletsHashingEvaluationInput body) {
        String hpan = DigestUtils.sha256Hex(body.getPan()+salt);
        return new ResponseEntity<>(
                WalletsHashingEvaluation.builder().hashPan(hpan).build(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WalletsHashingInfo> getStaticWalletsHash() {
        return new ResponseEntity<>(
                WalletsHashingInfo.builder().salt(salt).build(),
                HttpStatus.OK);
    }

}
