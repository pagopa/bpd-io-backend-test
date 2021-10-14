package it.gov.pagopa.bpd.io_backend.model.ade;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Problem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T07:23:25.920Z[GMT]")
public class Problem   {
	@JsonProperty("detail")
	private String detail = null;

	@JsonProperty("instance")
	private String instance = null;

	@JsonProperty("status")
	private Integer status = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("type")
	private String type = "about:blank";

	public Problem detail(String detail) {
		this.detail = detail;
		return this;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Problem instance(String instance) {
		this.instance = instance;
		return this;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public Problem status(Integer status) {
		this.status = status;
		return this;
	}

	@Min(100) @Max(600)   public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Problem title(String title) {
		this.title = title;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Problem type(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Problem problem = (Problem) o;
		return Objects.equals(this.detail, problem.detail) &&
				Objects.equals(this.instance, problem.instance) &&
				Objects.equals(this.status, problem.status) &&
				Objects.equals(this.title, problem.title) &&
				Objects.equals(this.type, problem.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(detail, instance, status, title, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Problem {\n");

		sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
		sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
