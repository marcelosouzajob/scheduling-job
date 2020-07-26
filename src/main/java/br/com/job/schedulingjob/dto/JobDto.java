package br.com.job.schedulingjob.dto;

import java.time.LocalDateTime;

public class JobDto implements Comparable<JobDto> {
	
	public JobDto() {
	}

	private Integer id;
	private String descricao;
	private LocalDateTime dataMaximaConclusao;
	private Integer tempoEstimadoExecucao;
	
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

	@Override
	public int compareTo(JobDto arg0) {
		return this.dataMaximaConclusao.compareTo(arg0.dataMaximaConclusao);
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", descricao=" + descricao + ", dataMaximaConclusao=" + dataMaximaConclusao
				+ ", tempoEstimadoExecucao=" + tempoEstimadoExecucao + "]";
	}
}
