package it.gov.pagopa.bpd.io_backend.service;

import it.gov.pagopa.bpd.io_backend.jpa.TransactionDetailsDAO;
import it.gov.pagopa.bpd.io_backend.jpa.model.TransactionDetails;
import it.gov.pagopa.bpd.io_backend.rest.model.transaction.PosTransactionRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private TransactionDetailsDAO transactionDetailsDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDetailsDAO transactionDetailsDAO) {
        this.transactionDetailsDAO = transactionDetailsDAO;
    }

    @Override
    public void createInvoiceTransaction(PosTransactionRequestDTO request) {

        TransactionDetails entity = new TransactionDetails();
        entity.setAmount(request.getAmount());
        entity.setBinCard(request.getBinCard());
        entity.setAuthCode(request.getAuthCode());
        entity.setTrxDate(request.getTrxDate());
        entity.setTerminalId(request.getTerminalId());

        transactionDetailsDAO.save(entity);
    }

    @Override
    public boolean find(String authCode, OffsetDateTime trxDate, String terminalId, BigDecimal amount, String binCard) {
        Date comparingDate = java.sql.Date.valueOf(trxDate.toLocalDate());
        Optional<TransactionDetails> transaction = transactionDetailsDAO.findTransaction(authCode, amount, terminalId, comparingDate, authCode);
        return transaction.isPresent();
    }
}
