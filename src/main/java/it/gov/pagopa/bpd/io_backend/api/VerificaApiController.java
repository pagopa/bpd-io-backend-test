package it.gov.pagopa.bpd.io_backend.api;

import eu.sia.meda.core.controller.StatelessController;
import it.gov.pagopa.bpd.io_backend.model.ade.VerificaPartitaIva;
import it.gov.pagopa.bpd.io_backend.model.ade.VerificaPartitaIva.StatoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T07:23:25.920Z[GMT]")
@RestController
public class VerificaApiController extends StatelessController implements VerificaApi {

	private static final Logger log = LoggerFactory.getLogger(VerificaApiController.class);

	private final HttpServletRequest request;
	private final static Set<String> partiteIvaNonValide = new HashSet<>();
	static{
		partiteIvaNonValide.add("01248163264");
		partiteIvaNonValide.add("02468101214");
		partiteIvaNonValide.add("13579111317");
		partiteIvaNonValide.add("51015202530");
		partiteIvaNonValide.add("04200420042");
		partiteIvaNonValide.add("36912151821");
		partiteIvaNonValide.add("61218243036");
		partiteIvaNonValide.add("71421283542");
	}
	private final Random random;

	@Autowired
	public VerificaApiController(HttpServletRequest request) {
		this.request = request;
		this.random = new Random();
	}

	public ResponseEntity<VerificaPartitaIva> getPartitaIva(@PathVariable("partitaIva") final String partitaIva) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") && partitaIva.matches("[0-9]+")) {
			log.debug("Building VerificaPartitaIva response for partita iva {}", partitaIva);
			return ResponseEntity.ok(getVerificaPartitaIvaResponse(partitaIva));
		} else {
			log.error("Not valid partita iva {}", partitaIva);
			return new ResponseEntity<VerificaPartitaIva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private VerificaPartitaIva getVerificaPartitaIvaResponse(final String partitaIva) {
		final boolean isValida = !VerificaApiController.partiteIvaNonValide.contains(partitaIva);
		final String denominazione = "Denominazione ".concat(partitaIva);
		final StatoEnum  stato = isValida 
				? StatoEnum.ATTIVA : 
					random.nextBoolean() ? StatoEnum.CESSATA : StatoEnum.SOSPESA;
		return VerificaPartitaIva.builder()
				.valida(isValida)
				.denominazione(denominazione)
				.partitaIva(partitaIva)
				.stato(stato)
				.dataInizioAttivita(LocalDate.now().minus(Period.of(1, 2, 3)))
				.dataCessazioneAttivita( 
						!isValida && StatoEnum.CESSATA.equals(stato) ? LocalDate.now().minus(Period.ofDays(42)) : null)
				.dataInizioSospensione( 
						!isValida && StatoEnum.SOSPESA.equals(stato) ? LocalDate.now().minus(Period.ofDays(42)) : null)
				.isGruppoIva(Boolean.FALSE)
				.dataInizioPartecipazioneGruppoIva(null)
				.build();
	}
	
}
