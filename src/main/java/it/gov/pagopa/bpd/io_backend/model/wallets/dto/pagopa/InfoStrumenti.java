package it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * InfoStrumenti
 */
public class InfoStrumenti   {
  @JsonProperty("iban")
  private String iban;

  @JsonProperty("flgPreferitoPagamento")
  private Boolean flgPreferitoPagamento;

  @JsonProperty("flgPreferitoRicezione")
  private Boolean flgPreferitoRicezione;

  public InfoStrumenti iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public InfoStrumenti flgPreferitoPagamento(Boolean flgPreferitoPagamento) {
    this.flgPreferitoPagamento = flgPreferitoPagamento;
    return this;
  }

  /**
   * Get flgPreferitoPagamento
   * @return flgPreferitoPagamento
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getFlgPreferitoPagamento() {
    return flgPreferitoPagamento;
  }

  public void setFlgPreferitoPagamento(Boolean flgPreferitoPagamento) {
    this.flgPreferitoPagamento = flgPreferitoPagamento;
  }

  public InfoStrumenti flgPreferitoRicezione(Boolean flgPreferitoRicezione) {
    this.flgPreferitoRicezione = flgPreferitoRicezione;
    return this;
  }

  /**
   * Get flgPreferitoRicezione
   * @return flgPreferitoRicezione
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getFlgPreferitoRicezione() {
    return flgPreferitoRicezione;
  }

  public void setFlgPreferitoRicezione(Boolean flgPreferitoRicezione) {
    this.flgPreferitoRicezione = flgPreferitoRicezione;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfoStrumenti infoStrumenti = (InfoStrumenti) o;
    return Objects.equals(this.iban, infoStrumenti.iban) &&
        Objects.equals(this.flgPreferitoPagamento, infoStrumenti.flgPreferitoPagamento) &&
        Objects.equals(this.flgPreferitoRicezione, infoStrumenti.flgPreferitoRicezione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iban, flgPreferitoPagamento, flgPreferitoRicezione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoStrumenti {\n");
    
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    flgPreferitoPagamento: ").append(toIndentedString(flgPreferitoPagamento)).append("\n");
    sb.append("    flgPreferitoRicezione: ").append(toIndentedString(flgPreferitoRicezione)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

