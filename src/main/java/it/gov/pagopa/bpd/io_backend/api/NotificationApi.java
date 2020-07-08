package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.model.MessageResponse;
import it.gov.pagopa.bpd.io_backend.model.NotificationMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Api(value = "notification")
@Validated
@RequestMapping(value = "/bpd/pagopa/api/v1")
public interface NotificationApi {

    @RequestMapping(value = "c/progetto-io/messages", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<MessageResponse> submitMessage(@Valid @RequestBody NotificationMessage notificationDTO);

}
