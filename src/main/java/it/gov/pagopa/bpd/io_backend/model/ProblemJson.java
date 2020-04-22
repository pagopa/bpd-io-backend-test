package it.gov.pagopa.bpd.io_backend.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProblemJson
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T10:19:03.448Z")

public class ProblemJson {
	@JsonProperty("type")
	private String type = "about:blank";

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("status")
	private Integer status = null;

	@JsonProperty("detail")
	private String detail = null;

	@JsonProperty("instance")
	private String instance = null;

	public ProblemJson type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * An absolute URI that identifies the problem type. When dereferenced, it
	 * SHOULD provide human-readable documentation for the problem type (e.g., using
	 * HTML).
	 * 
	 * @return type
	 **/
	@ApiModelProperty(example = "https://example.com/problem/constraint-violation", value = "An absolute URI that identifies the problem type. When dereferenced, it SHOULD provide human-readable documentation for the problem type (e.g., using HTML).")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProblemJson title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * A short, summary of the problem type. Written in english and readable for
	 * engineers (usually not suited for non technical stakeholders and not
	 * localized); example: Service Unavailable
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non technical stakeholders and not localized); example: Service Unavailable")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ProblemJson status(Integer status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ProblemJson detail(String detail) {
		this.detail = detail;
		return this;
	}

	/**
	 * A human readable explanation specific to this occurrence of the problem.
	 * 
	 * @return detail
	 **/
	@ApiModelProperty(example = "There was an error processing the request", value = "A human readable explanation specific to this occurrence of the problem.")

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ProblemJson instance(String instance) {
		this.instance = instance;
		return this;
	}

	/**
	 * An absolute URI that identifies the specific occurrence of the problem. It
	 * may or may not yield further information if dereferenced.
	 * 
	 * @return instance
	 **/
	@ApiModelProperty(value = "An absolute URI that identifies the specific occurrence of the problem. It may or may not yield further information if dereferenced.")

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProblemJson problemJson = (ProblemJson) o;
		return Objects.equals(this.type, problemJson.type) && Objects.equals(this.title, problemJson.title)
				&& Objects.equals(this.status, problemJson.status) && Objects.equals(this.detail, problemJson.detail)
				&& Objects.equals(this.instance, problemJson.instance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, title, status, detail, instance);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProblemJson {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
		sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
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
