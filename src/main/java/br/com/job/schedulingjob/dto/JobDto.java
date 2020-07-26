package br.com.job.schedulingjob.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa um job a ser executado.
 * O tempoEstimadoExecucao deve ser expresso em horas.
 * Note: this class has a natural ordering that is inconsistent with equals
 */
public class JobDto implements Comparable<JobDto> {
	
	private static final long FATOR_CONVERSAO_MILLIS = 3600000l;
	
	private Integer id;
	private String descricao;
	private LocalDateTime dataMaximaConclusao;
	private Integer tempoEstimadoExecucao;
	
	public JobDto() {
	}
	
	public JobDto(Integer id, String descricao, LocalDateTime dataMaximaConclusao, Integer tempoEstimadoExecucao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataMaximaConclusao = dataMaximaConclusao;
		this.tempoEstimadoExecucao = tempoEstimadoExecucao;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataMaximaConclusao() {
		return dataMaximaConclusao;
	}
	public void setDataMaximaConclusao(LocalDateTime dataMaximaConclusao) {
		this.dataMaximaConclusao = dataMaximaConclusao;
	}
	public Integer getTempoEstimadoExecucao() {
		return tempoEstimadoExecucao;
	}
	public void setTempoEstimadoExecucao(Integer tempoEstimadoExecucao) {
		this.tempoEstimadoExecucao = tempoEstimadoExecucao;
	}
	
	public long getTempoEstimadoExecucaoMillis() {
		return tempoEstimadoExecucao*FATOR_CONVERSAO_MILLIS;
	}

	@Override
	public int compareTo(JobDto arg0) {
		return this.dataMaximaConclusao.compareTo(arg0.dataMaximaConclusao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobDto other = (JobDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", descricao=" + descricao + ", dataMaximaConclusao=" + dataMaximaConclusao
				+ ", tempoEstimadoExecucao=" + tempoEstimadoExecucao + "]";
	}
}
