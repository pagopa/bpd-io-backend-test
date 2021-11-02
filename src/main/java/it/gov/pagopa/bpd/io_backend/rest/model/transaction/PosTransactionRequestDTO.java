package it.gov.pagopa.bpd.io_backend.rest.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "${swagger.transactionRequest.authCode}", required = true)
    @JsonProperty(required = true)
    @NotNull
    String authCode;
    @ApiModelProperty(value = "${swagger.transactionRequest.amount}", required = true)
    @JsonProperty(required = true)
    @NotNull
    BigDecimal amount;
    @ApiModelProperty(value = "${swagger.transactionRequest.trxDate}", required = true)
    @JsonProperty(required = true)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    OffsetDateTime trxDate;
    @ApiModelProperty(value = "${swagger.transactionRequest.vatNumber}", required = true)
    @JsonProperty(required = true)
    @NotNull @NotBlank
    String vatNumber;
    @ApiModelProperty(value = "${swagger.transactionRequest.acquirerId}", required = true)
    @JsonProperty(required = true)
    Long acquirerId;
    @ApiModelProperty(value = "${swagger.transactionRequest.binCard}", required = true)
    @JsonProperty(required = true)
    @NotNull @NotBlank
    String binCard;
    @ApiModelProperty(value = "${swagger.transactionRequest.terminalId}", required = true)
    @JsonProperty(required = true)
    @NotNull
    String terminalId;
    @ApiModelProperty(value = "${swagger.transactionRequest.merchantId}", required = true)
    @JsonProperty(required = true)
    @NotNull
    String merchantId;

}
