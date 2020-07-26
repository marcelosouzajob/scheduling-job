package br.com.job.schedulingjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication(scanBasePackages = "br.com.job.schedulingjob")
@PropertySource(value = "classpath:swagger.properties", encoding = "UTF-8")
public class SchedulingJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingJobApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages, classpath:swagger");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
