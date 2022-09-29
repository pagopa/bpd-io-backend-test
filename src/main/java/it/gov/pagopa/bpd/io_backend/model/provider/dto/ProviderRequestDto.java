package it.gov.pagopa.bpd.io_backend.model.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class ProviderRequestDto {

    @NotBlank
    @JsonProperty(required = true)
    private String transactionId;

    @NotBlank
    @JsonProperty(required = true)
    private String binCard;

    @NotBlank
    @JsonProperty(required = true)
    private String terminalId;

    @NotNull
    @JsonProperty(required = true)
    private OffsetDateTime trxDate;

    @NotBlank
    @JsonProperty(required = true)
    private String authCode;

    @NotNull
    @JsonProperty(required = true)
    private BigDecimal amount;

    @NotBlank
    @JsonProperty(required = true)
    private String customerData;

    @NotBlank
    @JsonProperty(required = true)
    private String merchantData;

    @JsonProperty(required = false)
    private String customerAdress;

    @JsonProperty(required = false)
    private String merchantAdress;

    @NotBlank
    @JsonProperty(required = true)
    private String paymentLabel;

    @NotBlank
    @JsonProperty(required = true)
    private String destCode;

}
