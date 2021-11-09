package it.gov.pagopa.bpd.io_backend.jpa.model;


import it.gov.pagopa.bpd.io_backend.jpa.util.TransactionDetailsCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TransactionDetailsCompositeKey.class)
@EqualsAndHashCode(of = {"terminalId", "amount", "trxDate", "binCard", "authCode"}, callSuper = false)
@Table(name = "mock_provider", schema = "fa_mock")
public class TransactionDetails implements Serializable {

    @Id
    @Column(name = "bin_card_s")
    private String binCard;

    @Id
    @Column(name = "terminal_id_s")
    private String terminalId;

    @Id
    @Column(name = "amount_i")
    private BigDecimal amount;

    @Id
    @Column(name = "transaction_date_t")
    private OffsetDateTime trxDate;

    @Id
    @Column(name = "auth_code_s")
    private String authCode;

}
