package com.cna.abp.printbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.cna.abp.printbatch.tasklet.worker.DuplexWorker;

public class ProcessDuplexTasklet implements Tasklet {
	
	private DuplexWorker duplex;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the duplex
	 */
	public DuplexWorker getDuplex() {
		return duplex;
	}

	/**
	 * @param duplex the duplex to set
	 */
	public void setDuplex(DuplexWorker duplex) {
		this.duplex = duplex;
	}

}
