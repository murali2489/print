package com.saimuga.abp.fileupload.tasklet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ReadInputFile implements Tasklet {
	
	private Resource inputResource;
	private String   targetDirectory;
	/**
	 * @return the targetDirectory
	 */
	public String getTargetDirectory() {
		return targetDirectory;
	}


	/**
	 * @param targetDirectory the targetDirectory to set
	 */
	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}


	private String   targetFile;
	

	/**
	 * @return the inputResource
	 */
	public Resource getInputResource() {
		return inputResource;
	}


	/**
	 * @param inputResource the inputResource to set
	 */
	public void setInputResource(Resource inputResource) {
		this.inputResource = inputResource;
	}





	/**
	 * @return the targetFile
	 */
	public String getTargetFile() {
		return targetFile;
	}


	/**
	 * @param targetFile the targetFile to set
	 */
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}


	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		System.out.println("FileRead is in Progress !!!");
		System.out.println(this.targetDirectory+this.targetFile+this.inputResource);
		System.out.println("FileRead is in Progress !!!");
		
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));

		
		File targetDirectoryAsFile = new File(targetDirectory);
		if(!targetDirectoryAsFile.exists()) {
			FileUtils.forceMkdir(targetDirectoryAsFile);
		}		
		
		File target = new File(targetDirectory,targetFile);
		
		BufferedOutputStream dest = null;
        while(zis.getNextEntry() != null) {
           if(!target.exists()) {
        	   target.createNewFile();
           }
           FileOutputStream fos = new FileOutputStream(target);
           dest = new BufferedOutputStream(fos);
           IOUtils.copy(zis,dest);
           dest.flush();
           dest.close();
        }
        zis.close();
        
        if(!target.exists()) {
        	throw new IllegalStateException("Could not decompress anything from the archive!");
        }
		
		return RepeatStatus.FINISHED;
	}

}
