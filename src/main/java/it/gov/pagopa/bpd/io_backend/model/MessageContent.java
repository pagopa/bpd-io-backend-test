package it.gov.pagopa.bpd.io_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageContent {

    private String subject;

    private String markdown;

    @JsonProperty("payment_data")
    private ContentPaymentData paymentData;

    @JsonProperty("prescription_data")
    private ContentPrescriptionData prescriptionData;

    @JsonProperty("due_date")
    private OffsetDateTime dueDate;
}

