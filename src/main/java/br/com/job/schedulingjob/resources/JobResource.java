package br.com.job.schedulingjob.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/scheduling-job")
@Api(value="SchedulingJob", tags="SchedulingJob")
public class JobResource {

	/**
	 * Retorna os jobs selecionados para o schedule.
	 * URL: localhost:8080/scheduling-job/jobs
	 * 
	 * Valores de retorno mockados para teste do endpoint
	 * @return
	 */
	@ApiOperation(
			value = "swagger.api.operation.schedulingjob.parametros.value",
			notes = "swagger.api.operation.schedulingjob.parametros.notes",
			tags = {"SchedulingJob"})
	@GetMapping("jobs")
	public ResponseEntity<List<List<Integer>>> definirJobsExecucao() {
		
		List<List<Integer>> retorno = 
				Arrays.asList(Arrays.asList(Integer.valueOf(1), Integer.valueOf(3)),
					  Arrays.asList(Integer.valueOf(2)));
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
