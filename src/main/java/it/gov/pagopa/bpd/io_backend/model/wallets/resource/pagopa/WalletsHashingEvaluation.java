package it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.util.Objects;

/**
 * WalletsHashingEvaluation
 */
@Builder
public class WalletsHashingEvaluation   {
  @JsonProperty("hashPan")
  private String hashPan;

  @JsonProperty("salt")
  private String salt;

  public WalletsHashingEvaluation hashPan(String hashPan) {
    this.hashPan = hashPan;
    return this;
  }

  /**
   * Get hashPan
   * @return hashPan
  */
  @ApiModelProperty(value = "")


  public String getHashPan() {
    return hashPan;
  }

  public void setHashPan(String hashPan) {
    this.hashPan = hashPan;
  }

  public WalletsHashingEvaluation salt(String salt) {
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
    WalletsHashingEvaluation walletsHashingEvaluation = (WalletsHashingEvaluation) o;
    return Objects.equals(this.hashPan, walletsHashingEvaluation.hashPan) &&
        Objects.equals(this.salt, walletsHashingEvaluation.salt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashPan, salt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletsHashingEvaluation {\n");
    
    sb.append("    hashPan: ").append(toIndentedString(hashPan)).append("\n");
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

