package br.com.job.schedulingjob.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.job.schedulingjob.dto.JobsExecucao;
import br.com.job.schedulingjob.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/scheduling-job")
@Api(value="SchedulingJob", tags="SchedulingJob")
public class JobResource {
	
	@Autowired
	private JobService jobService;

	/**
	 * Retorna os jobs selecionados para o schedule.
	 * URL: localhost:8080/scheduling-job/jobs
	 * Exemplo de json para preencher o body: resources/jsonExemplo.json
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "swagger.api.operation.schedulingjob.parametros.value",
			notes = "swagger.api.operation.schedulingjob.parametros.notes",
			tags = {"SchedulingJob"})
	@PostMapping("jobs")
	public ResponseEntity<List<List<Integer>>> definirJobsExecucao(@RequestBody JobsExecucao jobsExecucao) {
		
		jobService.definirJobsExecucao(jobsExecucao.getJanelaExecucaoInicio(),  jobsExecucao.getJanelaExecucaoFinal(),  jobsExecucao.getJobsExecucao());
		
		List<List<Integer>> retorno = 
				Arrays.asList(Arrays.asList(Integer.valueOf(1), Integer.valueOf(3)),
					  Arrays.asList(Integer.valueOf(2)));
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
