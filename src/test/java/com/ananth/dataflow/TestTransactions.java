package com.ananth.dataflow;

import java.util.Arrays;
import java.util.List;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.values.PCollection;
import org.junit.Rule;
import org.junit.Test;

public class TestTransactions {
	
	   @Rule
	    public final transient TestPipeline testPipeline = TestPipeline.create();

    @Test
    public void testTransactionProcessingTransform() {
        // Test input data: List of transactions in format "date,transaction_amount,year"
        List<String> inputTransactions = Arrays.asList(
            "2011-01-01,30.0", 
            "2009-12-31,50.0",
            "2012-02-02,25.0",
            "2011-01-01,10.0",
            "2010-05-10,50.0" 
        );

        // Apply the test pipeline with input transactions
        PCollection<String> inputCollection = testPipeline.apply(Create.of(inputTransactions));

        // Apply the composite transform
        PCollection<String> outputCollection = inputCollection.apply(new FilterAndSumTransactions());

        // Expected output after filtering and summing amounts by date
        List<String> expectedOutput = Arrays.asList(
            "2011-01-01,30.0",
            "2012-02-02,25.0",
            "2010-05-10,50.0"
        );

        // Use PAssert to check the output
        PAssert.that(outputCollection).containsInAnyOrder(expectedOutput);

        // Run the pipeline
        testPipeline.run().waitUntilFinish();
    }

}
