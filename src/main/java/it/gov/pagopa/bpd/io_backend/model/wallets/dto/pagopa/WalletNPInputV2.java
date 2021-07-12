package it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WalletNPInputV2
 */
public class WalletNPInputV2 {
  @JsonProperty("taxCode")
  private String taxCode;

  @JsonProperty("channel")
  private String channel;

  /**
   * Gets or Sets walletType
   */
  public enum WalletTypeEnum {
    CARD("Card"),
    
    BANCOMAT("Bancomat"),
    
    SATISPAY("Satispay"),
    
    BPAY("BPay");

    private String value;

    WalletTypeEnum(String value) {
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
    public static WalletTypeEnum fromValue(String value) {
      for (WalletTypeEnum b : WalletTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("walletType")
  private WalletTypeEnum walletType;

  @JsonProperty("info")
  private WalletInfo info;

  public WalletNPInputV2 taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

  /**
   * Get taxCode
   * @return taxCode
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public WalletNPInputV2 channel(String channel) {
    this.channel = channel;
    return this;
  }

  /**
   * Get channel
   * @return channel
  */
  @ApiModelProperty(value = "")


  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public WalletNPInputV2 walletType(WalletTypeEnum walletType) {
    this.walletType = walletType;
    return this;
  }

  /**
   * Get walletType
   * @return walletType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public WalletTypeEnum getWalletType() {
    return walletType;
  }

  public void setWalletType(WalletTypeEnum walletType) {
    this.walletType = walletType;
  }

  public WalletNPInputV2 info(WalletInfo info) {
    this.info = info;
    return this;
  }

  /**
   * Get info
   * @return info
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public WalletInfo getInfo() {
    return info;
  }

  public void setInfo(WalletInfo info) {
    this.info = info;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletNPInputV2 walletNPInput = (WalletNPInputV2) o;
    return Objects.equals(this.taxCode, walletNPInput.taxCode) &&
        Objects.equals(this.channel, walletNPInput.channel) &&
        Objects.equals(this.walletType, walletNPInput.walletType) &&
        Objects.equals(this.info, walletNPInput.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxCode, channel, walletType, info);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletNPInputV2 {\n");
    
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    walletType: ").append(toIndentedString(walletType)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
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

