package it.gov.pagopa.bpd.io_backend.model.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.gov.pagopa.bpd.io_backend.model.notification.ContentPaymentData;
import it.gov.pagopa.bpd.io_backend.model.notification.ContentPrescriptionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageContent {

    @NotNull
    @NotBlank
    @Length(min = 10, max = 120)
    private String subject;

    @NotNull
    @NotBlank
    @Length(min = 80, max = 10000)
    private String markdown;

    @JsonProperty("payment_data")
    private ContentPaymentData paymentData;

    @JsonProperty("prescription_data")
    private ContentPrescriptionData prescriptionData;

    @JsonProperty("due_date")
    private OffsetDateTime dueDate;
}

