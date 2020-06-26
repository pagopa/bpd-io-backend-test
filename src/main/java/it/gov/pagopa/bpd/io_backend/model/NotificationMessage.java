package it.gov.pagopa.bpd.io_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NotificationMessage {

    @Min(value = 3600)
    @Max(value = 604800)
    @JsonProperty("time_to_live")
    private Long timeToLive;

    @JsonProperty("fiscal_code")
    private String fiscalCode;

    @JsonProperty("default_addresses")
    private MessageAddresses defaultAddresses;

    @NotNull
    private MessageContent content;

}
