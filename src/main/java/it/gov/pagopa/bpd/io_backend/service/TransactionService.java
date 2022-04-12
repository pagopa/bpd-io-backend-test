package it.gov.pagopa.bpd.io_backend.service;

import it.gov.pagopa.bpd.io_backend.jpa.model.TransactionDetails;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface TransactionService {

    void createInvoiceTransaction(TransactionDetails request);

    boolean find(String authCode, OffsetDateTime trxDate,
                 String terminalId, BigDecimal amount, String binCard);
}
