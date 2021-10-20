package it.gov.pagopa.bpd.io_backend.api;

import eu.sia.meda.core.controller.StatelessController;
import it.gov.pagopa.bpd.io_backend.model.MessageResponse;
import it.gov.pagopa.bpd.io_backend.model.ProfileResponse;
import it.gov.pagopa.bpd.io_backend.model.notification.NotificationMessage;
import it.gov.pagopa.bpd.io_backend.model.notification.ProfileDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")
@Controller
@RequiredArgsConstructor
@Slf4j
public class NotificationController extends StatelessController implements NotificationApi {

    @Override
    public ResponseEntity<MessageResponse> submitMessage(@Valid NotificationMessage notificationDTO) {
        return new ResponseEntity<MessageResponse>(
                MessageResponse.builder().id(UUID.randomUUID().toString()).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProfileResponse> profiles(@Valid ProfileDTO profileDTO) {
        return new ResponseEntity<ProfileResponse>(
                ProfileResponse.builder().email("email@example.com").version("v1").build(), HttpStatus.OK);
    }
}
