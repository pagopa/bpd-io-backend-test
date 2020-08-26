package it.gov.pagopa.bpd.io_backend.model.user;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

/**
 * User data needed by PagoPA proxy with custom user email.
 */
@ApiModel(description = "User data needed by PagoPA proxy with custom user email.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")
@Builder
public class ExtendedPagoPAUser   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("family_name")
  private String familyName = null;

  @JsonProperty("spid_email")
  private String spidEmail = null;

  @JsonProperty("notice_email")
  private String noticeEmail = null;

  @JsonProperty("mobile_phone")
  private String mobilePhone = null;

  @JsonProperty("fiscal_code")
  private String fiscalCode = null;

  public ExtendedPagoPAUser name(String name) {
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

  public ExtendedPagoPAUser familyName(String familyName) {
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

  public ExtendedPagoPAUser spidEmail(String spidEmail) {
    this.spidEmail = spidEmail;
    return this;
  }

  /**
   * Get spidEmail
   * @return spidEmail
  **/
  @ApiModelProperty(value = "")


  public String getSpidEmail() {
    return spidEmail;
  }

  public void setSpidEmail(String spidEmail) {
    this.spidEmail = spidEmail;
  }

  public ExtendedPagoPAUser noticeEmail(String noticeEmail) {
    this.noticeEmail = noticeEmail;
    return this;
  }

  /**
   * Get noticeEmail
   * @return noticeEmail
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNoticeEmail() {
    return noticeEmail;
  }

  public void setNoticeEmail(String noticeEmail) {
    this.noticeEmail = noticeEmail;
  }

  public ExtendedPagoPAUser mobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  /**
   * Get mobilePhone
   * @return mobilePhone
  **/
  @ApiModelProperty(value = "")

@Size(min=1) 
  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public ExtendedPagoPAUser fiscalCode(String fiscalCode) {
    this.fiscalCode = fiscalCode;
    return this;
  }

  /**
   * Get fiscalCode
   * @return fiscalCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFiscalCode() {
    return fiscalCode;
  }

  public void setFiscalCode(String fiscalCode) {
    this.fiscalCode = fiscalCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtendedPagoPAUser extendedPagoPAUser = (ExtendedPagoPAUser) o;
    return Objects.equals(this.name, extendedPagoPAUser.name) &&
        Objects.equals(this.familyName, extendedPagoPAUser.familyName) &&
        Objects.equals(this.spidEmail, extendedPagoPAUser.spidEmail) &&
        Objects.equals(this.noticeEmail, extendedPagoPAUser.noticeEmail) &&
        Objects.equals(this.mobilePhone, extendedPagoPAUser.mobilePhone) &&
        Objects.equals(this.fiscalCode, extendedPagoPAUser.fiscalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, familyName, spidEmail, noticeEmail, mobilePhone, fiscalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtendedPagoPAUser {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    spidEmail: ").append(toIndentedString(spidEmail)).append("\n");
    sb.append("    noticeEmail: ").append(toIndentedString(noticeEmail)).append("\n");
    sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
    sb.append("    fiscalCode: ").append(toIndentedString(fiscalCode)).append("\n");
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

