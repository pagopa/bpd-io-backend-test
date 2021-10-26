package it.gov.pagopa.bpd.io_backend.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.model.ade.VerificaPartitaIva;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("AdE_verifica_CF")
@RequestMapping("/WsAnagraficaDL78Web/services/VerificaAnagraficaDL78InterfaceEndpoint")
@Validated
public interface VerificaApi {

    @GetMapping(value = "/verifica/{partitaIva}", produces = { "application/json", "application/problem+json" })
    ResponseEntity<VerificaPartitaIva> getPartitaIva(@PathVariable("partitaIva") String partitaIva);

}

