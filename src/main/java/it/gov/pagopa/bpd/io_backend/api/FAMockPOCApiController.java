package it.gov.pagopa.bpd.io_backend.api;

import eu.sia.meda.core.controller.StatelessController;
import eu.sia.meda.event.transformer.SimpleEventRequestTransformer;
import eu.sia.meda.event.transformer.SimpleEventResponseTransformer;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.event.publisher.CsvTransactionPublisherConnector;
import it.gov.pagopa.bpd.io_backend.model.ade.MockAddress;
import it.gov.pagopa.bpd.io_backend.model.ade.MockPerson;
import it.gov.pagopa.bpd.io_backend.model.provider.ProviderRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T07:23:25.920Z[GMT]")
@RestController
public class FAMockPOCApiController extends StatelessController implements FAMockPOCApi {

	private static final Logger log = LoggerFactory.getLogger(FAMockPOCApiController.class);

	private static List<String> notFoundFiscalCodes = Arrays.asList(
			"BNLCRT88E12C352D", "BRNSVN68R05G273R", "SNTCRL55A46F205R", "GMNTTV85A01F839S", "SCGRMO91H09D969H");

	private final HttpServletRequest request;
	private final CsvTransactionPublisherConnector transactionPublisherConnector;
	private final SimpleEventRequestTransformer<Transaction> simpleEventRequestTransformer;
	private final SimpleEventResponseTransformer simpleEventResponseTransformer;

	@Autowired
	public FAMockPOCApiController(HttpServletRequest request,
								  CsvTransactionPublisherConnector transactionPublisherConnector,
								  SimpleEventRequestTransformer<Transaction> simpleEventRequestTransformer,
								  SimpleEventResponseTransformer simpleEventResponseTransformer
	) {
		this.request = request;
		this.transactionPublisherConnector=transactionPublisherConnector;
		this.simpleEventRequestTransformer=simpleEventRequestTransformer;
		this.simpleEventResponseTransformer=simpleEventResponseTransformer;
	}

	public void sendRTDTransaction(Transaction transaction) {
		Transaction topicElement = null;
		if (transaction==null) {
			topicElement = getMockTransactionResponse();
		}else {
			topicElement = new Transaction();
			BeanUtils.copyProperties(transaction, topicElement);
		}
		transactionPublisherConnector.doCall(topicElement, simpleEventRequestTransformer, simpleEventResponseTransformer);
	}

	@Override
	public void cashRegisterSender() {

	}

	@Override
	public HttpStatus sendTransactionDetails(@Valid ProviderRequestDto request) {
		return HttpStatus.OK;
	}

	@Override
	public ResponseEntity<MockPerson> datiAnagraficiPersonaFisica(final String fiscalCode) throws UnsupportedEncodingException {
		log.debug("Retrieve mock data for person with fiscal code {}", fiscalCode);

		if (notFoundFiscalCodes.contains(fiscalCode)) return ResponseEntity.noContent().build();

		final MockPerson person = MockPerson.builder()
				.name("John")
				.surname("Doe")
				.fiscalCode(fiscalCode)
				.fiscalAddress(
						MockAddress.builder()
								.city("Rome")
								.street("Via del Corso")
								.houseNumber("42")
								.build())
				.build();
		return ResponseEntity.ok(person);
	}

	private Transaction getMockTransactionResponse() {
		return new Transaction().builder()
				.idTrxAcquirer("1")
				.acquirerCode("001")
				.trxDate("2020-04-09T16:22:45.304Z")
				.amount(BigDecimal.valueOf(1313.13))
				.operationType("00")
				.hpan("hpan")
				.merchantId("0")
				.circuitType("00")
				.mcc("813")
				.idTrxIssuer("0")
				.amountCurrency("833")
				.correlationId("1")
				.acquirerId("0")
				.terminalId("0")
				.bin("000004")
				.build();
	}
	
}
