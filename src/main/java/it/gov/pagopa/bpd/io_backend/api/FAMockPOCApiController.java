package it.gov.pagopa.bpd.io_backend.api;

import eu.sia.meda.core.controller.StatelessController;
import eu.sia.meda.event.transformer.SimpleEventRequestTransformer;
import eu.sia.meda.event.transformer.SimpleEventResponseTransformer;
import it.gov.pagopa.bpd.io_backend.event.model.RegisterTransaction;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.event.publisher.CsvTransactionPublisherConnector;
import it.gov.pagopa.bpd.io_backend.rest.model.transaction.PosTransactionRequestDTO;
import it.gov.pagopa.bpd.io_backend.rest.transaction.TransactionRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T07:23:25.920Z[GMT]")
@RestController
public class FAMockPOCApiController extends StatelessController implements FAMockPOCApi {

	private static final Logger log = LoggerFactory.getLogger(FAMockPOCApiController.class);

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
		}else{
			topicElement = new Transaction();
			BeanUtils.copyProperties(transaction,topicElement);
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
