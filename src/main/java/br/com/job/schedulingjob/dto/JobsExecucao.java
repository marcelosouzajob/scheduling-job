package br.com.job.schedulingjob.dto;

import java.time.LocalDateTime;
import java.util.List;

public class JobsExecucao {
	private LocalDateTime janelaExecucaoInicio;
	private LocalDateTime janelaExecucaoFinal;
	private List<JobDto> lsJobExecucao;
	public LocalDateTime getJanelaExecucaoInicio() {
		return janelaExecucaoInicio;
	}
	public void setJanelaExecucaoInicio2(LocalDateTime janelaExecucaoInicio) {
		this.janelaExecucaoInicio = janelaExecucaoInicio;
	}
	public LocalDateTime getJanelaExecucaoFinal() {
		return janelaExecucaoFinal;
	}
	public void setJanelaExecucaoFinal(LocalDateTime janelaExecucaoFinal) {
		this.janelaExecucaoFinal = janelaExecucaoFinal;
	}
	public List<JobDto> getJobsExecucao() {
		return lsJobExecucao;
	}
	public void setJobsExecucao(List<JobDto> jobsExecucao) {
		this.lsJobExecucao = jobsExecucao;
	}
	public JobsExecucao(LocalDateTime janelaExecucaoInicio, LocalDateTime janelaExecucaoFinal,
			List<JobDto> jobsExecucao) {
		super();
		this.janelaExecucaoInicio = janelaExecucaoInicio;
		this.janelaExecucaoFinal = janelaExecucaoFinal;
		this.lsJobExecucao = jobsExecucao;
	}
	public JobsExecucao() {
	}
}
