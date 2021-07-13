package it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa.WalletInfo;
import lombok.Builder;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WalletNPResponse
 */
@Builder
public class WalletNPResponse   {
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

  @JsonProperty("hsmEnabledHashEncryptionKey")
  private String hsmEnabledHashEncryptionKey;

  @JsonProperty("hsmDisabledEncryptionKey")
  private SecretKey hsmDisabledEncryptionKey;

  @JsonProperty("hashCode")
  private String hashCode;

  public WalletNPResponse taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

  /**
   * Get taxCode
   * @return taxCode
  */
  @ApiModelProperty(value = "")


  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public WalletNPResponse channel(String channel) {
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

  public WalletNPResponse walletType(WalletTypeEnum walletType) {
    this.walletType = walletType;
    return this;
  }

  /**
   * Get walletType
   * @return walletType
  */
  @ApiModelProperty(value = "")


  public WalletTypeEnum getWalletType() {
    return walletType;
  }

  public void setWalletType(WalletTypeEnum walletType) {
    this.walletType = walletType;
  }

  public WalletNPResponse info(WalletInfo info) {
    this.info = info;
    return this;
  }

  /**
   * Get info
   * @return info
  */
  @ApiModelProperty(value = "")

  @Valid

  public WalletInfo getInfo() {
    return info;
  }

  public void setInfo(WalletInfo info) {
    this.info = info;
  }

  public WalletNPResponse hsmEnabledHashEncryptionKey(String hsmEnabledHashEncryptionKey) {
    this.hsmEnabledHashEncryptionKey = hsmEnabledHashEncryptionKey;
    return this;
  }

  /**
   * Get hsmEnabledHashEncryptionKey
   * @return hsmEnabledHashEncryptionKey
  */
  @ApiModelProperty(value = "")


  public String getHsmEnabledHashEncryptionKey() {
    return hsmEnabledHashEncryptionKey;
  }

  public void setHsmEnabledHashEncryptionKey(String hsmEnabledHashEncryptionKey) {
    this.hsmEnabledHashEncryptionKey = hsmEnabledHashEncryptionKey;
  }

  public WalletNPResponse hsmDisabledEncryptionKey(SecretKey hsmDisabledEncryptionKey) {
    this.hsmDisabledEncryptionKey = hsmDisabledEncryptionKey;
    return this;
  }

  /**
   * Get hsmDisabledEncryptionKey
   * @return hsmDisabledEncryptionKey
  */
  @ApiModelProperty(value = "")

  @Valid

  public SecretKey getHsmDisabledEncryptionKey() {
    return hsmDisabledEncryptionKey;
  }

  public void setHsmDisabledEncryptionKey(SecretKey hsmDisabledEncryptionKey) {
    this.hsmDisabledEncryptionKey = hsmDisabledEncryptionKey;
  }

  public WalletNPResponse hashCode(String hashCode) {
    this.hashCode = hashCode;
    return this;
  }

  /**
   * Get hashCode
   * @return hashCode
  */
  @ApiModelProperty(value = "")


  public String getHashCode() {
    return hashCode;
  }

  public void setHashCode(String hashCode) {
    this.hashCode = hashCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletNPResponse walletNPResponse = (WalletNPResponse) o;
    return Objects.equals(this.taxCode, walletNPResponse.taxCode) &&
        Objects.equals(this.channel, walletNPResponse.channel) &&
        Objects.equals(this.walletType, walletNPResponse.walletType) &&
        Objects.equals(this.info, walletNPResponse.info) &&
        Objects.equals(this.hsmEnabledHashEncryptionKey, walletNPResponse.hsmEnabledHashEncryptionKey) &&
        Objects.equals(this.hsmDisabledEncryptionKey, walletNPResponse.hsmDisabledEncryptionKey) &&
        Objects.equals(this.hashCode, walletNPResponse.hashCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxCode, channel, walletType, info, hsmEnabledHashEncryptionKey, hsmDisabledEncryptionKey, hashCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletNPResponse {\n");
    
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    walletType: ").append(toIndentedString(walletType)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    hsmEnabledHashEncryptionKey: ").append(toIndentedString(hsmEnabledHashEncryptionKey)).append("\n");
    sb.append("    hsmDisabledEncryptionKey: ").append(toIndentedString(hsmDisabledEncryptionKey)).append("\n");
    sb.append("    hashCode: ").append(toIndentedString(hashCode)).append("\n");
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

