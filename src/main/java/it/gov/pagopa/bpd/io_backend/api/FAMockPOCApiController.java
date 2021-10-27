package it.gov.pagopa.bpd.io_backend.api;

import eu.sia.meda.core.controller.StatelessController;
import eu.sia.meda.event.transformer.SimpleEventRequestTransformer;
import eu.sia.meda.event.transformer.SimpleEventResponseTransformer;
import it.gov.pagopa.bpd.io_backend.event.model.Transaction;
import it.gov.pagopa.bpd.io_backend.event.publisher.CsvTransactionPublisherConnector;
import it.gov.pagopa.bpd.io_backend.model.provider.ProviderRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T07:23:25.920Z[GMT]")
@RestController
public class FAMockPOCApiController extends StatelessController implements FAMockPOCApi {

	private static final Logger log = LoggerFactory.getLogger(FAMockPOCApiController.class);

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
		}else{
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
