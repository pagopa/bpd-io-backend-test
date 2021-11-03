package it.gov.pagopa.bpd.io_backend.api;

import eu.sia.meda.core.controller.StatelessController;
import eu.sia.meda.event.transformer.SimpleEventRequestTransformer;
import eu.sia.meda.event.transformer.SimpleEventResponseTransformer;
import it.gov.pagopa.bpd.io_backend.event.model.RegisterTransaction;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.event.publisher.CsvTransactionPublisherConnector;
import it.gov.pagopa.bpd.io_backend.model.ade.MockAddress;
import it.gov.pagopa.bpd.io_backend.model.ade.MockPerson;
import it.gov.pagopa.bpd.io_backend.model.provider.dto.InvoiceRequestDto;
import it.gov.pagopa.bpd.io_backend.model.provider.dto.ProviderRequestDto;
import it.gov.pagopa.bpd.io_backend.model.provider.resource.InvoiceProviderResource;
import it.gov.pagopa.bpd.io_backend.rest.model.transaction.PosTransactionRequestDTO;
import it.gov.pagopa.bpd.io_backend.rest.transaction.TransactionRestClient;
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
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

	private final TransactionRestClient transactionRestClient;

	@Autowired
	public FAMockPOCApiController(HttpServletRequest request,
								  CsvTransactionPublisherConnector transactionPublisherConnector,
								  SimpleEventRequestTransformer<Transaction> simpleEventRequestTransformer,
								  SimpleEventResponseTransformer simpleEventResponseTransformer,
								  TransactionRestClient transactionRestClient
	) {
		this.request = request;
		this.transactionPublisherConnector=transactionPublisherConnector;
		this.simpleEventRequestTransformer=simpleEventRequestTransformer;
		this.simpleEventResponseTransformer=simpleEventResponseTransformer;
		this.transactionRestClient=transactionRestClient;
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
	public void cashRegisterSender(RegisterTransaction transaction, String posType) {

		PosTransactionRequestDTO request = null;
		if (transaction==null) {
			request = getMockPosTransactionRequest("S".equals(posType) ? RegisterTransaction.PosType.STAND_ALONE_POS : RegisterTransaction.PosType.ASSERVED_POS);
		}else{
			request = new PosTransactionRequestDTO();
			BeanUtils.copyProperties(transaction,request);
		}

		String transactionId = request.getAmount().toString()
				.concat(request.getTerminalId().toString())
				.concat(request.getAcquirerId().toString())
				.concat(request.getBinCard())
				.concat(request.getTrxDate().format(DateTimeFormatter.ISO_DATE_TIME));

		transactionRestClient.createPosTransaction(request);
	}

	@Override
	public HttpStatus sendTransactionDetails(@Valid ProviderRequestDto request) {
		return HttpStatus.OK;
	}

	@Override
	public InvoiceProviderResource getInvoiceDetails(@Valid InvoiceRequestDto request) {

		InvoiceProviderResource resource = new InvoiceProviderResource();
		resource.setAuthCode(request.getAuthCode());
		resource.setAmount(request.getAmount());
		resource.setTrxDate(request.getTrxDate());
		resource.setBinCard(request.getBinCard());
		resource.setTerminalId(request.getTerminalId());
		resource.setInvoiceStatusDate(OffsetDateTime.now());
		resource.setInvoiceCode(Long.toString(resource.getInvoiceStatusDate().toInstant().toEpochMilli()));
		boolean evenAmount = new BigDecimal(String.valueOf(request.getAmount())).longValue() % 2 == 0;
		if (!evenAmount) {
			resource.setInvoiceStatus(InvoiceProviderResource.Status.NON_EMESSA);
			resource.setInvoiceRejectReason(getRandomReason().code());
		} else resource.setInvoiceStatus(InvoiceProviderResource.Status.EMESSA);

		return resource;
	}

	private InvoiceProviderResource.Reason getRandomReason() {

		InvoiceProviderResource.Reason[] reason = InvoiceProviderResource.Reason.values();
		Random random = new Random();
		return reason[random.nextInt(reason.length)];

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

	private PosTransactionRequestDTO getMockPosTransactionRequest(RegisterTransaction.PosType posType) {
		return new PosTransactionRequestDTO().builder()
				.trxDate(OffsetDateTime.parse("2020-04-09T16:22:45.304Z", DateTimeFormatter.ISO_DATE_TIME))
				.amount(new BigDecimal("1313.13"))
				.terminalId("0")
				.binCard("1234")
				.vatNumber("12345678977")
				.acquirerId(12385L)
				.authCode("12345685")
				.build();
	}

}
