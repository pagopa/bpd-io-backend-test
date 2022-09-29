package it.gov.pagopa.bpd.io_backend.model.wallets.dto.pagopa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * WalletsHashingEvaluationInput
 */
public class WalletsHashingEvaluationInput   {
  @JsonProperty("pan")
  private String pan;

  public WalletsHashingEvaluationInput pan(String pan) {
    this.pan = pan;
    return this;
  }

  /**
   * Get pan
   * @return pan
  */
  @ApiModelProperty(value = "")


  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletsHashingEvaluationInput walletsHashingEvaluationInput = (WalletsHashingEvaluationInput) o;
    return Objects.equals(this.pan, walletsHashingEvaluationInput.pan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pan);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletsHashingEvaluationInput {\n");
    
    sb.append("    pan: ").append(toIndentedString(pan)).append("\n");
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

