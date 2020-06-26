package it.gov.pagopa.bpd.io_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationMessage {

    @JsonProperty("time_to_live")
    private Long timeToLive;

    @JsonProperty("fiscal_code")
    private String fiscalCode;

    @JsonProperty("default_addresses")
    private MessageAddresses defaultAddresses;

    private MessageContent content;

}
