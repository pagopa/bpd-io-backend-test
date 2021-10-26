package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.provider.ProviderRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-26T13:06:25.650Z[GMT]")
@RestController
public class ProviderApiController implements ProviderApi {


    @Override
    public HttpStatus sendTransactionDetails(@Valid ProviderRequestDto request) {
        return HttpStatus.OK;
    }
}
