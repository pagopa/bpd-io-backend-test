package it.gov.pagopa.bpd.io_backend.model.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class InvoiceRequestDto {

    @NotBlank
    @NotNull
    @JsonProperty(required = true)
    private String transactionId;

    @NotBlank
    @NotNull
    @JsonProperty(required = true)
    private String binCard;

    @NotBlank
    @NotNull
    @JsonProperty(required = true)
    private String terminalId;

    @NotNull
    @JsonProperty(required = true)
    private OffsetDateTime trxDate;

    @NotBlank
    @NotNull
    @JsonProperty(required = true)
    private String authCode;

    @NotNull
    @JsonProperty(required = true)
    private BigDecimal amount;

    @NotNull
    @JsonProperty(required = true)
    private String idTrxAcquirer;

    @NotNull
    @JsonProperty(required = true)
    private String fiscalCode;

}
