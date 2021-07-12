package it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * WalletCardInfoInput
 */
public class WalletCardInfoInput implements WalletInfo   {
  @JsonProperty("pan")
  private String pan;

  @JsonProperty("expireMonth")
  private String expireMonth;

  @JsonProperty("expireYear")
  private String expireYear;

  @JsonProperty("type")
  private CardType type;

  @JsonProperty("holder")
  private String holder;

  /**
   * Gets or Sets brand
   */
  public enum BrandEnum {
    VISA("VISA"),
    
    MASTERCARD("MASTERCARD"),
    
    MAESTRO("MAESTRO"),
    
    VISA_ELECTRON("VISA_ELECTRON"),
    
    AMEX("AMEX"),
    
    OTHER("OTHER");

    private String value;

    BrandEnum(String value) {
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
    public static BrandEnum fromValue(String value) {
      for (BrandEnum b : BrandEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("brand")
  private BrandEnum brand;

  @JsonProperty("issuerAbiCode")
  private String issuerAbiCode;

  public WalletCardInfoInput pan(String pan) {
    this.pan = pan;
    return this;
  }

  /**
   * encrypted with PGP
   * @return pan
  */
  @ApiModelProperty(required = true, value = "encrypted with PGP")
  @NotNull


  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }

  public WalletCardInfoInput expireMonth(String expireMonth) {
    this.expireMonth = expireMonth;
    return this;
  }

  /**
   * Get expireMonth
   * @return expireMonth
  */
  @ApiModelProperty(example = "01", required = true, value = "")
  @NotNull

@Size(min=2,max=2) 
  public String getExpireMonth() {
    return expireMonth;
  }

  public void setExpireMonth(String expireMonth) {
    this.expireMonth = expireMonth;
  }

  public WalletCardInfoInput expireYear(String expireYear) {
    this.expireYear = expireYear;
    return this;
  }

  /**
   * Get expireYear
   * @return expireYear
  */
  @ApiModelProperty(example = "2022", required = true, value = "")
  @NotNull

@Size(min=4,max=4) 
  public String getExpireYear() {
    return expireYear;
  }

  public void setExpireYear(String expireYear) {
    this.expireYear = expireYear;
  }

  public WalletCardInfoInput type(CardType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CardType getType() {
    return type;
  }

  public void setType(CardType type) {
    this.type = type;
  }

  public WalletCardInfoInput holder(String holder) {
    this.holder = holder;
    return this;
  }

  /**
   * Get holder
   * @return holder
  */
  @ApiModelProperty(value = "")


  public String getHolder() {
    return holder;
  }

  public void setHolder(String holder) {
    this.holder = holder;
  }

  public WalletCardInfoInput brand(BrandEnum brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  */
  @ApiModelProperty(value = "")


  public BrandEnum getBrand() {
    return brand;
  }

  public void setBrand(BrandEnum brand) {
    this.brand = brand;
  }

  public WalletCardInfoInput issuerAbiCode(String issuerAbiCode) {
    this.issuerAbiCode = issuerAbiCode;
    return this;
  }

  /**
   * Get issuerAbiCode
   * @return issuerAbiCode
  */
  @ApiModelProperty(value = "")

@Size(min=5,max=5) 
  public String getIssuerAbiCode() {
    return issuerAbiCode;
  }

  public void setIssuerAbiCode(String issuerAbiCode) {
    this.issuerAbiCode = issuerAbiCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletCardInfoInput walletCardInfoInput = (WalletCardInfoInput) o;
    return Objects.equals(this.pan, walletCardInfoInput.pan) &&
        Objects.equals(this.expireMonth, walletCardInfoInput.expireMonth) &&
        Objects.equals(this.expireYear, walletCardInfoInput.expireYear) &&
        Objects.equals(this.type, walletCardInfoInput.type) &&
        Objects.equals(this.holder, walletCardInfoInput.holder) &&
        Objects.equals(this.brand, walletCardInfoInput.brand) &&
        Objects.equals(this.issuerAbiCode, walletCardInfoInput.issuerAbiCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pan, expireMonth, expireYear, type, holder, brand, issuerAbiCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletCardInfoInput {\n");
    
    sb.append("    pan: ").append(toIndentedString(pan)).append("\n");
    sb.append("    expireMonth: ").append(toIndentedString(expireMonth)).append("\n");
    sb.append("    expireYear: ").append(toIndentedString(expireYear)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    issuerAbiCode: ").append(toIndentedString(issuerAbiCode)).append("\n");
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

