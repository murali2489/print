package com.cna.abp.printbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.cna.abp.printbatch.tasklet.worker.SimplexWorker;

public class ProcessSimplexTasklet implements Tasklet {

	private SimplexWorker simplex;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the simplex
	 */
	public SimplexWorker getSimplex() {
		return simplex;
	}

	/**
	 * @param simplex the simplex to set
	 */
	public void setSimplex(SimplexWorker simplex) {
		this.simplex = simplex;
	}

}
