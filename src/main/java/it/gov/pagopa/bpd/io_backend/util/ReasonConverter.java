package it.gov.pagopa.bpd.io_backend.util;

import it.gov.pagopa.bpd.io_backend.model.provider.resource.InvoiceProviderResource;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class ReasonConverter implements AttributeConverter<InvoiceProviderResource.Reason, String> {

    @Override
    public String convertToDatabaseColumn(InvoiceProviderResource.Reason reason) {

        return Objects.isNull(reason) ? null : reason.code();
    }

    @Override
    public InvoiceProviderResource.Reason convertToEntityAttribute(String code) {
        return Objects.isNull(code) ? null : InvoiceProviderResource.Reason.fromString(code);
    }
}
