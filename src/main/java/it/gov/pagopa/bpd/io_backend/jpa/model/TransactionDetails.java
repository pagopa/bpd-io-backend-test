package it.gov.pagopa.bpd.io_backend.jpa.model;


import it.gov.pagopa.bpd.io_backend.jpa.util.TransactionDetailsCompositeKey;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@Builder
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

    @Column(name = "transaction_id_s")
    private String transactionId;

    @Column(name = "customer_data_s")
    private String customerData;

    @Column(name = "merchant_data_s")
    private String merchantData;

    @Column(name = "customer_address_s")
    private String customerAddress;

    @Column(name = "merchant_address_s")
    private String merchantAddress;

    @Column(name = "payment_lable_s")
    private String paymentLable;

    @Column(name = "dest_code_s")
    private String destCode;

    @Column(name = "acquirer_id_s")
    private String acquirerId;

    @Column(name = "contract_id_s")
    private String contractId;


}
