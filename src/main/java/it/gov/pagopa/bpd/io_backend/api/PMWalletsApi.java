package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.WalletsResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequestMapping(value = "/pp-restapi-rtd/v1")
public interface PMWalletsApi {

    @RequestMapping(value = "/wallets", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<WalletsResource> getHpan(@Valid @NotBlank @NotNull @RequestParam("pan") String pan);

}
