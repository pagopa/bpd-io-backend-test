package it.gov.pagopa.bpd.io_backend.model.ade;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Builder;

/**
 * VerificaPartitaIva
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T07:23:25.920Z[GMT]")
@Builder
public class VerificaPartitaIva   {

	@JsonProperty("partitaIva")
	private String partitaIva = null;

	@JsonProperty("valida")
	private Boolean valida = null;

	/**
	 * Gets or Sets stato
	 */
	public enum StatoEnum {
		ATTIVA("ATTIVA"),

		CESSATA("CESSATA"),

		SOSPESA("SOSPESA");

		private String value;

		StatoEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatoEnum fromValue(String text) {
			for (StatoEnum b : StatoEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
	@JsonProperty("stato")
	private StatoEnum stato = null;

	@JsonProperty("denominazione")
	private String denominazione = null;

	@JsonProperty("dataInizioAttivita")
	private LocalDate dataInizioAttivita = null;

	@JsonProperty("dataCessazioneAttivita")
	private LocalDate dataCessazioneAttivita = null;

	@JsonProperty("dataInizioSospensione")
	private LocalDate dataInizioSospensione = null;

	@JsonProperty("isGruppoIva")
	private Boolean isGruppoIva = null;

	@JsonProperty("partitaIvaGruppo")
	private String partitaIvaGruppo = null;

	@JsonProperty("dataInizioPartecipazioneGruppoIva")
	private LocalDate dataInizioPartecipazioneGruppoIva = null;

	@JsonProperty("isPartecipanteGruppoIva")
	private Boolean isPartecipanteGruppoIva = null;

	public VerificaPartitaIva partitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
		return this;
	}

	@Pattern(regexp="^[0-9]+") @Size(min=11,max=11)   public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public VerificaPartitaIva valida(Boolean valida) {
		this.valida = valida;
		return this;
	}

	public Boolean isValida() {
		return valida;
	}

	public void setValida(Boolean valida) {
		this.valida = valida;
	}

	public VerificaPartitaIva stato(StatoEnum stato) {
		this.stato = stato;
		return this;
	}

	public StatoEnum getStato() {
		return stato;
	}

	public void setStato(StatoEnum stato) {
		this.stato = stato;
	}

	public VerificaPartitaIva denominazione(String denominazione) {
		this.denominazione = denominazione;
		return this;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public VerificaPartitaIva dataInizioAttivita(LocalDate dataInizioAttivita) {
		this.dataInizioAttivita = dataInizioAttivita;
		return this;
	}

	@Valid
	public LocalDate getDataInizioAttivita() {
		return dataInizioAttivita;
	}

	public void setDataInizioAttivita(LocalDate dataInizioAttivita) {
		this.dataInizioAttivita = dataInizioAttivita;
	}

	public VerificaPartitaIva dataCessazioneAttivita(LocalDate dataCessazioneAttivita) {
		this.dataCessazioneAttivita = dataCessazioneAttivita;
		return this;
	}

	@Valid
	public LocalDate getDataCessazioneAttivita() {
		return dataCessazioneAttivita;
	}

	public void setDataCessazioneAttivita(LocalDate dataCessazioneAttivita) {
		this.dataCessazioneAttivita = dataCessazioneAttivita;
	}

	public VerificaPartitaIva dataInizioSospensione(LocalDate dataInizioSospensione) {
		this.dataInizioSospensione = dataInizioSospensione;
		return this;
	}

	@Valid
	public LocalDate getDataInizioSospensione() {
		return dataInizioSospensione;
	}

	public void setDataInizioSospensione(LocalDate dataInizioSospensione) {
		this.dataInizioSospensione = dataInizioSospensione;
	}

	public VerificaPartitaIva isGruppoIva(Boolean isGruppoIva) {
		this.isGruppoIva = isGruppoIva;
		return this;
	}

	public Boolean isIsGruppoIva() {
		return isGruppoIva;
	}

	public void setIsGruppoIva(Boolean isGruppoIva) {
		this.isGruppoIva = isGruppoIva;
	}

	public VerificaPartitaIva partitaIvaGruppo(String partitaIvaGruppo) {
		this.partitaIvaGruppo = partitaIvaGruppo;
		return this;
	}

	@Pattern(regexp="^[0-9]+") @Size(min=11,max=11)   public String getPartitaIvaGruppo() {
		return partitaIvaGruppo;
	}

	public void setPartitaIvaGruppo(String partitaIvaGruppo) {
		this.partitaIvaGruppo = partitaIvaGruppo;
	}

	public VerificaPartitaIva dataInizioPartecipazioneGruppoIva(LocalDate dataInizioPartecipazioneGruppoIva) {
		this.dataInizioPartecipazioneGruppoIva = dataInizioPartecipazioneGruppoIva;
		return this;
	}

	@Valid
	public LocalDate getDataInizioPartecipazioneGruppoIva() {
		return dataInizioPartecipazioneGruppoIva;
	}

	public void setDataInizioPartecipazioneGruppoIva(LocalDate dataInizioPartecipazioneGruppoIva) {
		this.dataInizioPartecipazioneGruppoIva = dataInizioPartecipazioneGruppoIva;
	}

	public VerificaPartitaIva isPartecipanteGruppoIva(Boolean isPartecipanteGruppoIva) {
		this.isPartecipanteGruppoIva = isPartecipanteGruppoIva;
		return this;
	}

	public Boolean isIsPartecipanteGruppoIva() {
		return isPartecipanteGruppoIva;
	}

	public void setIsPartecipanteGruppoIva(Boolean isPartecipanteGruppoIva) {
		this.isPartecipanteGruppoIva = isPartecipanteGruppoIva;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VerificaPartitaIva verificaPartitaIva = (VerificaPartitaIva) o;
		return Objects.equals(this.partitaIva, verificaPartitaIva.partitaIva) &&
				Objects.equals(this.valida, verificaPartitaIva.valida) &&
				Objects.equals(this.stato, verificaPartitaIva.stato) &&
				Objects.equals(this.denominazione, verificaPartitaIva.denominazione) &&
				Objects.equals(this.dataInizioAttivita, verificaPartitaIva.dataInizioAttivita) &&
				Objects.equals(this.dataCessazioneAttivita, verificaPartitaIva.dataCessazioneAttivita) &&
				Objects.equals(this.dataInizioSospensione, verificaPartitaIva.dataInizioSospensione) &&
				Objects.equals(this.isGruppoIva, verificaPartitaIva.isGruppoIva) &&
				Objects.equals(this.partitaIvaGruppo, verificaPartitaIva.partitaIvaGruppo) &&
				Objects.equals(this.dataInizioPartecipazioneGruppoIva, verificaPartitaIva.dataInizioPartecipazioneGruppoIva) &&
				Objects.equals(this.isPartecipanteGruppoIva, verificaPartitaIva.isPartecipanteGruppoIva);
	}

	@Override
	public int hashCode() {
		return Objects.hash(partitaIva, valida, stato, denominazione, dataInizioAttivita, dataCessazioneAttivita, dataInizioSospensione, isGruppoIva, partitaIvaGruppo, dataInizioPartecipazioneGruppoIva, isPartecipanteGruppoIva);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VerificaPartitaIva {\n");

		sb.append("    partitaIva: ").append(toIndentedString(partitaIva)).append("\n");
		sb.append("    valida: ").append(toIndentedString(valida)).append("\n");
		sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
		sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
		sb.append("    dataInizioAttivita: ").append(toIndentedString(dataInizioAttivita)).append("\n");
		sb.append("    dataCessazioneAttivita: ").append(toIndentedString(dataCessazioneAttivita)).append("\n");
		sb.append("    dataInizioSospensione: ").append(toIndentedString(dataInizioSospensione)).append("\n");
		sb.append("    isGruppoIva: ").append(toIndentedString(isGruppoIva)).append("\n");
		sb.append("    partitaIvaGruppo: ").append(toIndentedString(partitaIvaGruppo)).append("\n");
		sb.append("    dataInizioPartecipazioneGruppoIva: ").append(toIndentedString(dataInizioPartecipazioneGruppoIva)).append("\n");
		sb.append("    isPartecipanteGruppoIva: ").append(toIndentedString(isPartecipanteGruppoIva)).append("\n");
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
