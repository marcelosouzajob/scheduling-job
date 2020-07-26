package br.com.job.schedulingjob.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JobsExecucao {
	private LocalDateTime janelaExecucaoInicio;
	private LocalDateTime janelaExecucaoFinal;
	private ArrayList<JobDto> jobsExecucao;
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
	public ArrayList<JobDto> getJobsExecucao() {
		return jobsExecucao;
	}
	public void setJobsExecucao(ArrayList<JobDto> jobsExecucao) {
		this.jobsExecucao = jobsExecucao;
	}
	public JobsExecucao(LocalDateTime janelaExecucaoInicio, LocalDateTime janelaExecucaoFinal,
			ArrayList<JobDto> jobsExecucao) {
		super();
		this.janelaExecucaoInicio = janelaExecucaoInicio;
		this.janelaExecucaoFinal = janelaExecucaoFinal;
		this.jobsExecucao = jobsExecucao;
	}
	public JobsExecucao() {
	}
}
