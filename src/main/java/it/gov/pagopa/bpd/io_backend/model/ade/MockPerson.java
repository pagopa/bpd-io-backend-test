package it.gov.pagopa.bpd.io_backend.model.ade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MockPerson {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("surname")
    private String surname = null;

    @JsonProperty("fiscalCode")
    private String fiscalCode = null;

    @JsonProperty("fiscalAddress")
    private MockAddress fiscalAddress = null;

}
