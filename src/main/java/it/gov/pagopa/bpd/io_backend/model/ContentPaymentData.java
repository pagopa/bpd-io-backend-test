package it.gov.pagopa.bpd.io_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContentPaymentData {

    private Long amount;

    @JsonProperty("notice_number")
    private String noticeNumber;

    @JsonProperty("invalid_after_due_date")
    private Boolean invalidAfterDueDate;
}