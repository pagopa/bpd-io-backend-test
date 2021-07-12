package it.gov.pagopa.bpd.io_backend.model.wallets.resource.pagopa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * SecretKey
 */
public class SecretKey   {
  @JsonProperty("algorithm")
  private String algorithm;

  @JsonProperty("format")
  private String format;

  @JsonProperty("encoded")
  private String encoded;

  @JsonProperty("destroyed")
  private String destroyed;

  public SecretKey algorithm(String algorithm) {
    this.algorithm = algorithm;
    return this;
  }

  /**
   * Get algorithm
   * @return algorithm
  */
  @ApiModelProperty(value = "")


  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public SecretKey format(String format) {
    this.format = format;
    return this;
  }

  /**
   * Get format
   * @return format
  */
  @ApiModelProperty(value = "")


  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public SecretKey encoded(String encoded) {
    this.encoded = encoded;
    return this;
  }

  /**
   * Get encoded
   * @return encoded
  */
  @ApiModelProperty(value = "")


  public String getEncoded() {
    return encoded;
  }

  public void setEncoded(String encoded) {
    this.encoded = encoded;
  }

  public SecretKey destroyed(String destroyed) {
    this.destroyed = destroyed;
    return this;
  }

  /**
   * Get destroyed
   * @return destroyed
  */
  @ApiModelProperty(value = "")


  public String getDestroyed() {
    return destroyed;
  }

  public void setDestroyed(String destroyed) {
    this.destroyed = destroyed;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecretKey secretKey = (SecretKey) o;
    return Objects.equals(this.algorithm, secretKey.algorithm) &&
        Objects.equals(this.format, secretKey.format) &&
        Objects.equals(this.encoded, secretKey.encoded) &&
        Objects.equals(this.destroyed, secretKey.destroyed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, format, encoded, destroyed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretKey {\n");
    
    sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    encoded: ").append(toIndentedString(encoded)).append("\n");
    sb.append("    destroyed: ").append(toIndentedString(destroyed)).append("\n");
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

