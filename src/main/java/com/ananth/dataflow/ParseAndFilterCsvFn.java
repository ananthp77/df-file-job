package com.ananth.dataflow;

import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseAndFilterCsvFn extends DoFn<String, KV<String, String>> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8133686737405285796L;

	@ProcessElement
    public void process(@Element String inputData,OutputReceiver<KV<String,String>>outputReceiver) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	String tr_date=inputData.split(",")[0];
            LocalDate date = LocalDate.parse(tr_date, formatter);
        	String amnt=inputData.split(",")[1];
        	if(Double.valueOf(amnt)>20 && date.getYear()>=2010) {
        		outputReceiver.output(KV.of(tr_date, amnt));
        	}
        } catch (Exception e) {
            System.err.println("Error processing record: " + e.getMessage());
        }
    }
}