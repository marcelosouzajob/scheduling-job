package br.com.job.schedulingjob.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.job.schedulingjob.dto.JobsExecucao;
import br.com.job.schedulingjob.service.JobService;

@RunWith(SpringRunner.class)
public class JobServiceImplTest {
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public JobService jobService() {
            return new JobServiceImpl();
        }
    }

	@Autowired
	private JobService jobService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void definirJobsExecucao_testCase1() {
		List<List<Integer>> esperado = 
				Arrays.asList(Arrays.asList(Integer.valueOf(1), Integer.valueOf(3)),
					          Arrays.asList(Integer.valueOf(2)));
		
		JobsExecucao jobsExecucao = inputTestCase1();
		List<List<Integer>> retorno = jobService.definirJobsExecucao(jobsExecucao.getJanelaExecucaoInicio(),
				                                                     jobsExecucao.getJanelaExecucaoFinal(),
				                                                     jobsExecucao.getJobsExecucao());
		
		assertThat(retorno).isEqualTo(esperado);
	}
	
	@Test
	public void definirJobsExecucao_testCase2() {
		List<List<Integer>> esperado = 
				Arrays.asList(Arrays.asList(Integer.valueOf(6), Integer.valueOf(3)),
					          Arrays.asList(Integer.valueOf(1), Integer.valueOf(2)));
		
		JobsExecucao jobsExecucao = inputTestCase2();
		List<List<Integer>> retorno = jobService.definirJobsExecucao(jobsExecucao.getJanelaExecucaoInicio(),
				                                                     jobsExecucao.getJanelaExecucaoFinal(),
				                                                     jobsExecucao.getJobsExecucao());
		
		assertThat(retorno).isEqualTo(esperado);
	}
	
	@Test
	public void definirJobsExecucao_testCase3() {
		List<List<Integer>> esperado = 
				Arrays.asList(Arrays.asList(Integer.valueOf(6), Integer.valueOf(3)),
					          Arrays.asList(Integer.valueOf(1)));
		
		JobsExecucao jobsExecucao = inputTestCase3();
		List<List<Integer>> retorno = jobService.definirJobsExecucao(jobsExecucao.getJanelaExecucaoInicio(),
				                                                     jobsExecucao.getJanelaExecucaoFinal(),
				                                                     jobsExecucao.getJobsExecucao());
		
		assertThat(retorno).isEqualTo(esperado);
	}
	
	private JobsExecucao inputTestCase1() {
		String json = "{\r\n" + 
				"    \"janelaExecucaoInicio\": \"2019-11-10T09:00:00\",\r\n" + 
				"    \"janelaExecucaoFinal\":  \"2019-11-11T12:00:00\",\r\n" + 
				"    \"jobsExecucao\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": 1,\r\n" + 
				"            \"descricao\": \"Importação de arquivos de fundos\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T12:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 2\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 2,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-11T12:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 4\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 3,\r\n" + 
				"            \"descricao\": \"Importação de dados de integração\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-11T08:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 6\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		
        return parseJsonToObject(json);
	}
	
	
	private JobsExecucao inputTestCase2() {
		String json = "{\r\n" + 
				"    \"janelaExecucaoInicio\": \"2019-11-10T09:00:00\",\r\n" + 
				"    \"janelaExecucaoFinal\":  \"2019-11-11T12:00:00\",\r\n" + 
				"    \"jobsExecucao\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": 1,\r\n" + 
				"            \"descricao\": \"Importação de arquivos de fundos\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T20:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 2\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 2,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T23:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 5\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 3,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T17:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 4\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 4,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T11:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 3\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 5,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T22:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 6\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 6,\r\n" + 
				"            \"descricao\": \"Importação de dados de integração\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T12:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 3\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		
        return parseJsonToObject(json);
	}
	
	private JobsExecucao inputTestCase3() {
		String json = "{\r\n" + 
				"    \"janelaExecucaoInicio\": \"2019-11-10T09:00:00\",\r\n" + 
				"    \"janelaExecucaoFinal\":  \"2019-11-10T22:00:00\",\r\n" + 
				"    \"jobsExecucao\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": 1,\r\n" + 
				"            \"descricao\": \"Importação de arquivos de fundos\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T20:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 2\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 2,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T23:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 5\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 3,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T17:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 4\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 4,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T11:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 3\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 5,\r\n" + 
				"            \"descricao\": \"Importação de dados da Base Legada\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T22:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 6\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"id\": 6,\r\n" + 
				"            \"descricao\": \"Importação de dados de integração\",\r\n" + 
				"            \"dataMaximaConclusao\": \"2019-11-10T12:00:00\",\r\n" + 
				"            \"tempoEstimadoExecucao\": 3\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		
        return parseJsonToObject(json);
	}
	
	private JobsExecucao parseJsonToObject(String json) {
		try {
        	ObjectMapper objectMapper = new ObjectMapper();
        	objectMapper.registerModule(new JavaTimeModule());
        	return objectMapper.readValue(json, JobsExecucao.class);
        	
        } catch (IOException e) {
            return null;
        }
	}
}
