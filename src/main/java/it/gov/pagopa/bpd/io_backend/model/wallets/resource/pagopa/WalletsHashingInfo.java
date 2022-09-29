package it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.util.Objects;

/**
 * WalletsHashingInfo
 */
@Builder
public class WalletsHashingInfo   {
  @JsonProperty("family")
  private String family;

  @JsonProperty("salt")
  private String salt;

  public WalletsHashingInfo family(String family) {
    this.family = family;
    return this;
  }

  /**
   * Get family
   * @return family
  */
  @ApiModelProperty(example = "SHA-256", value = "")


  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public WalletsHashingInfo salt(String salt) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletsHashingInfo walletsHashingInfo = (WalletsHashingInfo) o;
    return Objects.equals(this.family, walletsHashingInfo.family) &&
        Objects.equals(this.salt, walletsHashingInfo.salt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(family, salt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletsHashingInfo {\n");
    
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    salt: ").append(toIndentedString(salt)).append("\n");
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

