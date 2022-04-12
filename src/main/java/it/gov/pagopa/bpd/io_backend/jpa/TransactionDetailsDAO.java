package it.gov.pagopa.bpd.io_backend.jpa;

import it.gov.pagopa.bpd.common.connector.jpa.CrudJpaDAO;
import it.gov.pagopa.bpd.io_backend.jpa.model.TransactionDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Repository
public interface TransactionDetailsDAO extends CrudJpaDAO<TransactionDetails, String> {

    @Query(value = "select tr " +
            "from TransactionDetails tr " +
            "where tr.binCard = :binCard " +
            "and tr.amount = :amount " +
            "and tr.authCode = :authCode " +
            "and tr.terminalId = :terminalId " +
            "and date_trunc('day', tr.trxDate) = :trxDate"
    )
    Optional<TransactionDetails> findTransaction(@Param("binCard") String binCard, @Param("amount") BigDecimal amount,
                                                 @Param("authCode") String authCode, @Param("trxDate") Date trxDate, @Param("terminalId") String terminalId);
}
