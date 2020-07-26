package br.com.job.schedulingjob.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.job.schedulingjob.dto.JobDto;
import br.com.job.schedulingjob.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Override
	public List<List<Integer>> definirJobsExecucao(LocalDateTime janelaExecucaoInicio,
			LocalDateTime janelaExecucaoFinal, List<JobDto> jobsExecucao) {
		if (Objects.isNull(janelaExecucaoInicio) || Objects.isNull(janelaExecucaoFinal) || Objects.isNull(jobsExecucao)) 
			return null;
		
		final Long tempoParaExecucaoMillis = ChronoUnit.MILLIS.between(janelaExecucaoInicio, janelaExecucaoFinal);
		final AtomicLong counter = new AtomicLong(0);
		List<List<JobDto>> output = new ArrayList<>(); //array de execução de jobs
		
		/**
		 * Adiciona job em uma array de execução caso ele caiba dentro da janela de execução.
		 */
		Consumer<JobDto> adicionaJob = job -> {
			long finalExecucaoDesteJob = counter.get()+job.getTempoEstimadoExecucaoMillis();
			long ponteiroDataMaximaConclusao = ponteiroDataMaximaConclusao(job, janelaExecucaoInicio);
			if (!(finalExecucaoDesteJob > tempoParaExecucaoMillis) && !(finalExecucaoDesteJob > ponteiroDataMaximaConclusao) ) {
				counter.getAndAdd(job.getTempoEstimadoExecucaoMillis());
				getJobList(job, output).add(job);
			}
		};
		
		jobsExecucao
	      .stream()
	      .filter(job -> job.getDataMaximaConclusao().compareTo(janelaExecucaoInicio.plusHours(job.getTempoEstimadoExecucao())) >=0) //data maxima de conclusão do job precisa ser no minimo a data de inicio de execução + o tempo estimado
	      .sorted()
	      .forEach(adicionaJob);
		
		/**
		 * Retorna somente os ids a serem executados
		 */
		return output.stream()
				     .map(l -> l.stream()
				    		    .map(JobDto::getId)
				    		    .collect(Collectors.toList()))
				     .collect(Collectors.toList());
	}
	
	/**
	 * Calcula o momento máximo em que um job precisa concluir a sua execução dentro da janela de execução.
	 * @param job
	 * @param janelaExecucaoInicio
	 * @return
	 */
	private long ponteiroDataMaximaConclusao(JobDto job, LocalDateTime janelaExecucaoInicio) {
		return ChronoUnit.MILLIS.between(janelaExecucaoInicio, job.getDataMaximaConclusao());
	}
	
	/**
	 * Recupera a lista de jobs para o job específico. Se o tempo de execução de job cabe dentro da execução da última array, retorna a última array.
	 * Caso contrário, retorna uma nova array.
	 * @param job
	 * @return
	 */
	private List<JobDto> getJobList(JobDto job, List<List<JobDto>> output) {
		if (!output.isEmpty() && 
				isDentroDoTempoExecucaoDaArray(job, output))
		{
			return getUltimaListaDeJobs(output);
		}
		else {
			return criaNovaListaDeJobs(output);
		}
	}
	
	/**
	 * Verifica se o tempo de execução de job irá estourar o tempo máximo de execução da última array de jobs a serem executados, 8h;
	 * @return
	 */
	private boolean isDentroDoTempoExecucaoDaArray(JobDto job, List<List<JobDto>> output) {
		return getUltimaListaDeJobs(output)
				.stream()
				.mapToInt(JobDto::getTempoEstimadoExecucao)
				.reduce((job1, job2) -> job1 + job2)
				.orElse(0) + job.getTempoEstimadoExecucao() <= 8;	
	}
	
	/**
	 * Retorna a última array de jobs.
	 * @return
	 */
	private List<JobDto> getUltimaListaDeJobs(List<List<JobDto>> output) {
		return output.get(output.size()-1);
	}
	
	/**
	 * Cria e retorna uma nova array de jobs
	 * @return
	 */
	private List<JobDto> criaNovaListaDeJobs(List<List<JobDto>> output) {
		List<JobDto> l = new ArrayList<>();
		output.add(l);
		return l;
	}
}
