package com.ananth.dataflow;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.Compression;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class FileExecutor {
	
	
	public static void main(String[] args) {
		FileExecutorOptions options =PipelineOptionsFactory.fromArgs(args).
				withValidation().as(FileExecutorOptions.class);
		
		// Create the pipeline object
        Pipeline p = Pipeline.create(options);
        
     // Read the input from GCS
        p.apply("Read from GCS", TextIO.read().from(options.getInputFile()))
         .apply("Filter and Sum Transactions", new FilterAndSumTransactions())
         .apply("Write to GCS", TextIO.write()
                 .to("../outputs/results")
                 .withSuffix(".jsonl")
                 .withCompression(Compression.GZIP)
                 .withoutSharding());
        p.run().waitUntilFinish();
	}



}
