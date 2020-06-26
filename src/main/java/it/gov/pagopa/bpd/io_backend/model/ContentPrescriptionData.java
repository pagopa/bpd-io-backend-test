package it.gov.pagopa.bpd.io_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContentPrescriptionData {

    private String nre;

    private String iub;

    @JsonProperty("prescriber_fiscal_code")
    private String prescriberFiscalCode;
}

