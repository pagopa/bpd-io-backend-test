package it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

/**
 * WalletNPResource
 */
@Builder
public class WalletNPResource   {
  @JsonProperty("taxCode")
  private String taxCode;

  @JsonProperty("hashCode")
  private String hashCode;

  @JsonProperty("salt")
  private String salt;

  @JsonProperty("createTimestamp")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate createTimestamp;

  public WalletNPResource taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

  /**
   * Get taxCode
   * @return taxCode
  */
  @ApiModelProperty(value = "")

@Size(min=16,max=16) 
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public WalletNPResource hashCode(String hashCode) {
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

  public WalletNPResource salt(String salt) {
    this.salt = salt;
    return this;
  }

  /**
   * Get salt
   * @return salt
  */
  @ApiModelProperty(value = "")


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public WalletNPResource createTimestamp(LocalDate createTimestamp) {
    this.createTimestamp = createTimestamp;
    return this;
  }

  /**
   * Get createTimestamp
   * @return createTimestamp
  */
  @ApiModelProperty(value = "")

  @Valid
@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}$")
  public LocalDate getCreateTimestamp() {
    return createTimestamp;
  }

  public void setCreateTimestamp(LocalDate createTimestamp) {
    this.createTimestamp = createTimestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletNPResource walletNPResource = (WalletNPResource) o;
    return Objects.equals(this.taxCode, walletNPResource.taxCode) &&
        Objects.equals(this.hashCode, walletNPResource.hashCode) &&
        Objects.equals(this.salt, walletNPResource.salt) &&
        Objects.equals(this.createTimestamp, walletNPResource.createTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxCode, hashCode, salt, createTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletNPResource {\n");
    
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    hashCode: ").append(toIndentedString(hashCode)).append("\n");
    sb.append("    salt: ").append(toIndentedString(salt)).append("\n");
    sb.append("    createTimestamp: ").append(toIndentedString(createTimestamp)).append("\n");
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

