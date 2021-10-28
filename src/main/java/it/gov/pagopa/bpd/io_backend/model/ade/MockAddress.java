package it.gov.pagopa.bpd.io_backend.model.ade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MockAddress {

    @JsonProperty("street")
    private String street = null;

    @JsonProperty("house_number")
    private String houseNumber = null;

    @JsonProperty("city")
    private String city = null;

}
