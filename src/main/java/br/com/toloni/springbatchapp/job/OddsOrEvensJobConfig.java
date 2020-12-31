package br.com.toloni.springbatchapp.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class OddsOrEvensJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    private Step step;

    @Bean
    public Job job() {
        return jobBuilderFactory
                .get("oddsOrEvensJob")
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Scheduled(cron = "0 */1 * * * ?") // job will run every one minute after application is started.
    public void perform() throws Exception {

        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job(), params);
    }

}