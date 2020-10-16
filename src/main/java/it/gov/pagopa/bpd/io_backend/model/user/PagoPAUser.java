package it.gov.pagopa.bpd.io_backend.model.user;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User data needed by PagaPA proxy.
 */
@ApiModel(description = "User data needed by PagaPA proxy.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")

public class PagoPAUser   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("family_name")
  private String familyName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("mobile_phone")
  private String mobilePhone = null;

  public PagoPAUser name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PagoPAUser familyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  /**
   * Get familyName
   * @return familyName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public PagoPAUser email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PagoPAUser mobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  /**
   * Get mobilePhone
   * @return mobilePhone
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=1) 
  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagoPAUser pagoPAUser = (PagoPAUser) o;
    return Objects.equals(this.name, pagoPAUser.name) &&
        Objects.equals(this.familyName, pagoPAUser.familyName) &&
        Objects.equals(this.email, pagoPAUser.email) &&
        Objects.equals(this.mobilePhone, pagoPAUser.mobilePhone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, familyName, email, mobilePhone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagoPAUser {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

