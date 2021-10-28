package it.gov.pagopa.bpd.io_backend.event.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Model for transaction to be sent in the outbound channel
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"idTrxAcquirer", "acquirerCode", "trxDate"}, callSuper = false)
public class RegisterTransaction {

    String trxDate;//id

    String idTrxIssuer;//id

    BigDecimal amount;//id

    String terminalId;//id

    String bin;//id

    String merchantVatNumber;//

    PosType posType;//

    public enum PosType {
        ASSERVED_POS,
        STAND_ALONE_POS
    }

}