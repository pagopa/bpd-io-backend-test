package it.gov.pagopa.bpd.io_backend.model.ade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MockPerson {

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("fiscalCode")
    private String fiscalCode;

    @JsonProperty("fiscalAddress")
    private MockAddress fiscalAddress;

}
