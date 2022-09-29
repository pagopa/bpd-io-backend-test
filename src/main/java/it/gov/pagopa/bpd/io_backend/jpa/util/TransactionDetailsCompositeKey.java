package it.gov.pagopa.bpd.io_backend.jpa.util;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class TransactionDetailsCompositeKey implements Serializable {

    private String terminalId;
    private BigDecimal amount;
    private OffsetDateTime trxDate;
    private String authCode;
    private String binCard;
}
