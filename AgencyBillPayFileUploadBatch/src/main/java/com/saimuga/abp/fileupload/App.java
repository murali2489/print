package com.saimuga.abp.fileupload;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
    {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "ABPBatchInfrastructure.xml",
                "AgencyBillPayFileUploadApp.xml"
        );
        
        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
        Job job = ctx.getBean(Job.class);       
        
		jobLauncher.run(job,
				new JobParametersBuilder().addString("inputResource", "file:./products.zip")
						.addString("targetDirectory", "./importproductsbatch/").addString("targetFile", "products.txt")
						.addString("date", "2020-05-20").toJobParameters());
    	
    }
}
