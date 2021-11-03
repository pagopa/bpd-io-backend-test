package it.gov.pagopa.bpd.io_backend.model.provider.resource;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.stream.Stream;

@Data
public class InvoiceProviderResource {

    private String transactionId;
    private String binCard;
    private String terminalId;
    private OffsetDateTime trxDate;
    private String authCode;
    private BigDecimal amount;
    private String idTrxAcquirer;
    private String fiscalCode;
    private InvoiceProviderResource.Status invoiceStatus;
    private String invoiceCode;
    private OffsetDateTime invoiceStatusDate;
    private String invoiceRejectReason;


    public enum Status {
        EMESSA,
        NON_EMESSA
    }

    public enum Reason {
        RICONCILIAZIONE_NON_RIUSCITA("RICONCILIAZIONE NON RIUSCITA"),
        MANCATA_EMISSIONE("MANCATA EMISSIONE PER PROBLEMI ESTERNI AD FA");

        private String code;

        Reason(String code) {
            this.code = code;
        }

        public static Reason fromString(String code) {
            return Stream.of(InvoiceProviderResource.Reason.values())
                    .filter(c -> c.code().equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public String code() {
            return code;
        }
    }

}
