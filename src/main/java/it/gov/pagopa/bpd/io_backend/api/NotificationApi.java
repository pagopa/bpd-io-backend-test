package it.gov.pagopa.bpd.io_backend.api;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.io_backend.model.MessageResponse;
import it.gov.pagopa.bpd.io_backend.model.ProfileResponse;
import it.gov.pagopa.bpd.io_backend.model.notification.NotificationMessage;
import it.gov.pagopa.bpd.io_backend.model.notification.ProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Api(value = "notification")
@Validated
@RequestMapping(value = "/io/notification/api/v1")
public interface NotificationApi {

    @PostMapping(value = "messages", produces = {"application/json"})
    ResponseEntity<MessageResponse> submitMessage(@Valid @RequestBody NotificationMessage notificationDTO);

    @PostMapping(value = "profiles", produces = {"application/json"})
    ResponseEntity<ProfileResponse> profiles(@Valid @RequestBody ProfileDTO profileDTO);

}
