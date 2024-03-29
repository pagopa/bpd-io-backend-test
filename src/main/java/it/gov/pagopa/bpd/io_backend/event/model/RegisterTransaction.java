package it.gov.pagopa.bpd.io_backend.event.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Model for transaction to be sent in the outbound channel
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"idTrxAcquirer", "acquirerCode", "trxDate"}, callSuper = false)
public class RegisterTransaction {

    OffsetDateTime trxDate;

    String idTrxIssuer;

    BigDecimal amount;

    String terminalId;

    String bin;

    String merchantVatNumber;

    PosType posType;

    String acquirerId;

    String merchantId;

    String contractId;

    public enum PosType {
        ASSERVED_POS,
        STAND_ALONE_POS
    }

}