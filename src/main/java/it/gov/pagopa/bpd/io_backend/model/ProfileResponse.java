package it.gov.pagopa.bpd.io_backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {

    private String email;

    private String version;
}
