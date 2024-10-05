package com.ananth.dataflow;

import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;

public interface FileExecutorOptions extends PipelineOptions{
	
    @Validation.Required
    String getInputFile();
    void setInputFile(String value);

}
