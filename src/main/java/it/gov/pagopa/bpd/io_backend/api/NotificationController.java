package it.gov.pagopa.bpd.io_backend.api;

import it.gov.pagopa.bpd.io_backend.model.NotificationMessage;
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
public class NotificationController implements NotificationApi {

    @Override
    public ResponseEntity<String> submitMessage(@Valid NotificationMessage notificationDTO) {
        return new ResponseEntity<String>(UUID.randomUUID().toString(), HttpStatus.OK);
    }
}
