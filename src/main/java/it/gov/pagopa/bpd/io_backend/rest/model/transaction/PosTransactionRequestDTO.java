package it.gov.pagopa.bpd.io_backend.rest.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PosTransactionRequestDTO {

    @JsonProperty(required = true)
    @NotNull
    String authCode;
    @JsonProperty(required = true)
    @NotNull
    BigDecimal amount;
    @JsonProperty(required = true)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    OffsetDateTime trxDate;
    @JsonProperty(required = true)
    String acquirerId;
    @JsonProperty(required = true)
    @NotNull @NotBlank
    String binCard;
    @JsonProperty(required = true)
    @NotNull
    String terminalId;
    @JsonProperty(required = true)
    @NotNull
    String transactionId;
    @JsonProperty(required = true)
    @NotNull
    String vatNumber;
    @JsonProperty(required = true)
    @NotNull
    String contractId;

}
