package it.gov.pagopa.bpd.io_backend.model.wallets.resource;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
public class NPWallet {

    private String id;
    private String vatCode;
    private String hashPan;
    private OffsetDateTime createTimestamp;
    private List<String> hashTokenList;

}
