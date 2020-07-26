package br.com.job.schedulingjob.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.job.schedulingjob.dto.JobDto;

public interface JobService {
	
	List<List<Integer>> definirJobsExecucao(LocalDateTime janelaExecucaoInicio, LocalDateTime janelaExecucaoFinal, List<JobDto> jobsExecucao);


}
