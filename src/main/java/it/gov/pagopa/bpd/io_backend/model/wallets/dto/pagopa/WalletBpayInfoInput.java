package it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * WalletBpayInfoInput
 */
public class WalletBpayInfoInput implements WalletInfo  {
  @JsonProperty("codGruppo")
  private String codGruppo;

  @JsonProperty("codIstituto")
  private String codIstituto;

  @JsonProperty("nomeBanca")
  private String nomeBanca;

  @JsonProperty("nomeOffuscato")
  private String nomeOffuscato;

  @JsonProperty("cognomeOffuscato")
  private String cognomeOffuscato;

  @JsonProperty("numeroTelefonicoOffuscato")
  private String numeroTelefonicoOffuscato;

  @JsonProperty("numeroTelefonicoCriptato")
  private String numeroTelefonicoCriptato;

  @JsonProperty("UIDCriptato")
  private String uiDCriptato;

  /**
   * Gets or Sets statoServizio
   */
  public enum StatoServizioEnum {
    ATT("ATT"),
    
    DIS("DIS"),
    
    SOSP("SOSP"),
    
    SAT_GG("SAT_GG"),
    
    SAT_MM("SAT_MM"),
    
    SAT_NO("SAT_NO"),
    
    NFC_IN_COR("NFC_IN_COR"),
    
    NFC_ESTINTO("NFC_ESTINTO"),
    
    ATTPND("ATTPND"),
    
    DISPND("DISPND");

    private String value;

    StatoServizioEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatoServizioEnum fromValue(String value) {
      for (StatoServizioEnum b : StatoServizioEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("statoServizio")
  private StatoServizioEnum statoServizio;

  @JsonProperty("infoStrumenti")
  @Valid
  private List<InfoStrumenti> infoStrumenti = new ArrayList<>();

  public WalletBpayInfoInput codGruppo(String codGruppo) {
    this.codGruppo = codGruppo;
    return this;
  }

  /**
   * Get codGruppo
   * @return codGruppo
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCodGruppo() {
    return codGruppo;
  }

  public void setCodGruppo(String codGruppo) {
    this.codGruppo = codGruppo;
  }

  public WalletBpayInfoInput codIstituto(String codIstituto) {
    this.codIstituto = codIstituto;
    return this;
  }

  /**
   * Get codIstituto
   * @return codIstituto
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCodIstituto() {
    return codIstituto;
  }

  public void setCodIstituto(String codIstituto) {
    this.codIstituto = codIstituto;
  }

  public WalletBpayInfoInput nomeBanca(String nomeBanca) {
    this.nomeBanca = nomeBanca;
    return this;
  }

  /**
   * Get nomeBanca
   * @return nomeBanca
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNomeBanca() {
    return nomeBanca;
  }

  public void setNomeBanca(String nomeBanca) {
    this.nomeBanca = nomeBanca;
  }

  public WalletBpayInfoInput nomeOffuscato(String nomeOffuscato) {
    this.nomeOffuscato = nomeOffuscato;
    return this;
  }

  /**
   * Get nomeOffuscato
   * @return nomeOffuscato
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNomeOffuscato() {
    return nomeOffuscato;
  }

  public void setNomeOffuscato(String nomeOffuscato) {
    this.nomeOffuscato = nomeOffuscato;
  }

  public WalletBpayInfoInput cognomeOffuscato(String cognomeOffuscato) {
    this.cognomeOffuscato = cognomeOffuscato;
    return this;
  }

  /**
   * Get cognomeOffuscato
   * @return cognomeOffuscato
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCognomeOffuscato() {
    return cognomeOffuscato;
  }

  public void setCognomeOffuscato(String cognomeOffuscato) {
    this.cognomeOffuscato = cognomeOffuscato;
  }

  public WalletBpayInfoInput numeroTelefonicoOffuscato(String numeroTelefonicoOffuscato) {
    this.numeroTelefonicoOffuscato = numeroTelefonicoOffuscato;
    return this;
  }

  /**
   * Get numeroTelefonicoOffuscato
   * @return numeroTelefonicoOffuscato
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNumeroTelefonicoOffuscato() {
    return numeroTelefonicoOffuscato;
  }

  public void setNumeroTelefonicoOffuscato(String numeroTelefonicoOffuscato) {
    this.numeroTelefonicoOffuscato = numeroTelefonicoOffuscato;
  }

  public WalletBpayInfoInput numeroTelefonicoCriptato(String numeroTelefonicoCriptato) {
    this.numeroTelefonicoCriptato = numeroTelefonicoCriptato;
    return this;
  }

  /**
   * Get numeroTelefonicoCriptato
   * @return numeroTelefonicoCriptato
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNumeroTelefonicoCriptato() {
    return numeroTelefonicoCriptato;
  }

  public void setNumeroTelefonicoCriptato(String numeroTelefonicoCriptato) {
    this.numeroTelefonicoCriptato = numeroTelefonicoCriptato;
  }

  public WalletBpayInfoInput uiDCriptato(String uiDCriptato) {
    this.uiDCriptato = uiDCriptato;
    return this;
  }

  /**
   * Get uiDCriptato
   * @return uiDCriptato
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUiDCriptato() {
    return uiDCriptato;
  }

  public void setUiDCriptato(String uiDCriptato) {
    this.uiDCriptato = uiDCriptato;
  }

  public WalletBpayInfoInput statoServizio(StatoServizioEnum statoServizio) {
    this.statoServizio = statoServizio;
    return this;
  }

  /**
   * Get statoServizio
   * @return statoServizio
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public StatoServizioEnum getStatoServizio() {
    return statoServizio;
  }

  public void setStatoServizio(StatoServizioEnum statoServizio) {
    this.statoServizio = statoServizio;
  }

  public WalletBpayInfoInput infoStrumenti(List<InfoStrumenti> infoStrumenti) {
    this.infoStrumenti = infoStrumenti;
    return this;
  }

  public WalletBpayInfoInput addInfoStrumentiItem(InfoStrumenti infoStrumentiItem) {
    this.infoStrumenti.add(infoStrumentiItem);
    return this;
  }

  /**
   * Get infoStrumenti
   * @return infoStrumenti
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<InfoStrumenti> getInfoStrumenti() {
    return infoStrumenti;
  }

  public void setInfoStrumenti(List<InfoStrumenti> infoStrumenti) {
    this.infoStrumenti = infoStrumenti;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletBpayInfoInput walletBpayInfoInput = (WalletBpayInfoInput) o;
    return Objects.equals(this.codGruppo, walletBpayInfoInput.codGruppo) &&
        Objects.equals(this.codIstituto, walletBpayInfoInput.codIstituto) &&
        Objects.equals(this.nomeBanca, walletBpayInfoInput.nomeBanca) &&
        Objects.equals(this.nomeOffuscato, walletBpayInfoInput.nomeOffuscato) &&
        Objects.equals(this.cognomeOffuscato, walletBpayInfoInput.cognomeOffuscato) &&
        Objects.equals(this.numeroTelefonicoOffuscato, walletBpayInfoInput.numeroTelefonicoOffuscato) &&
        Objects.equals(this.numeroTelefonicoCriptato, walletBpayInfoInput.numeroTelefonicoCriptato) &&
        Objects.equals(this.uiDCriptato, walletBpayInfoInput.uiDCriptato) &&
        Objects.equals(this.statoServizio, walletBpayInfoInput.statoServizio) &&
        Objects.equals(this.infoStrumenti, walletBpayInfoInput.infoStrumenti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codGruppo, codIstituto, nomeBanca, nomeOffuscato, cognomeOffuscato, numeroTelefonicoOffuscato, numeroTelefonicoCriptato, uiDCriptato, statoServizio, infoStrumenti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletBpayInfoInput {\n");
    
    sb.append("    codGruppo: ").append(toIndentedString(codGruppo)).append("\n");
    sb.append("    codIstituto: ").append(toIndentedString(codIstituto)).append("\n");
    sb.append("    nomeBanca: ").append(toIndentedString(nomeBanca)).append("\n");
    sb.append("    nomeOffuscato: ").append(toIndentedString(nomeOffuscato)).append("\n");
    sb.append("    cognomeOffuscato: ").append(toIndentedString(cognomeOffuscato)).append("\n");
    sb.append("    numeroTelefonicoOffuscato: ").append(toIndentedString(numeroTelefonicoOffuscato)).append("\n");
    sb.append("    numeroTelefonicoCriptato: ").append(toIndentedString(numeroTelefonicoCriptato)).append("\n");
    sb.append("    uiDCriptato: ").append(toIndentedString(uiDCriptato)).append("\n");
    sb.append("    statoServizio: ").append(toIndentedString(statoServizio)).append("\n");
    sb.append("    infoStrumenti: ").append(toIndentedString(infoStrumenti)).append("\n");
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

