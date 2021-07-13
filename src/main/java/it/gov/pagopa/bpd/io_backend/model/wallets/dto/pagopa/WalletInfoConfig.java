package it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "walletType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = WalletCardInfoInput.class, name = "Card"),
        @JsonSubTypes.Type(value = WalletCardInfoInput.class, name = "Bancomat"),
        @JsonSubTypes.Type(value = WalletSatispayInfoInput.class, name = "Satispay"),
        @JsonSubTypes.Type(value = WalletBpayInfoInput.class, name = "BPay")
})
public @interface WalletInfoConfig {
}
