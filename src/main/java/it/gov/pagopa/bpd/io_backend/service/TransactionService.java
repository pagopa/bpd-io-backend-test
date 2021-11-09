package it.gov.pagopa.bpd.io_backend.service;

import it.gov.pagopa.bpd.io_backend.rest.model.transaction.PosTransactionRequestDTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface TransactionService {

    void createInvoiceTransaction(PosTransactionRequestDTO request);

    boolean find(String authCode, OffsetDateTime trxDate,
                 String terminalId, BigDecimal amount, String binCard);
}
