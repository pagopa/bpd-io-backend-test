package it.gov.pagopa.bpd.io_backend.model;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class NPWallet {

    private String id;
    private String vatCode;
    private String hashPan;
    private OffsetDateTime createTimestamp;

}
