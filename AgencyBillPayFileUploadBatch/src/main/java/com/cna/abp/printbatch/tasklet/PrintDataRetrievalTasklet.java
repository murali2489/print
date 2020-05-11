package com.cna.abp.printbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PrintDataRetrievalTasklet implements Tasklet{

	private String mailGroup;
	private String documentClass;
	private String type;
	
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		
		
		return RepeatStatus.FINISHED;
	}


	public String getMailGroup() {
		return mailGroup;
	}


	public void setMailGroup(String mailGroup) {
		this.mailGroup = mailGroup;
	}


	public String getDocumentClass() {
		return documentClass;
	}


	public void setDocumentClass(String documentClass) {
		this.documentClass = documentClass;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
