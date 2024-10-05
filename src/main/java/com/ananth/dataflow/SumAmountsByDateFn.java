package com.ananth.dataflow;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

public class SumAmountsByDateFn extends DoFn<KV<String, Iterable<String>>,  String> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7502041085791583535L;

	@ProcessElement
    public void process(@Element KV<String, Iterable<String>> record,OutputReceiver<String>ouputReceiver) {
        String output="";
    	String date = record.getKey();
        Iterable<String> amounts = record.getValue();

        double totalAmount = 0.0;
        for (String amount : amounts) {
            totalAmount += Double.valueOf(amount);
        }
        
        output=date+','+totalAmount;
        System.out.println(output);
        ouputReceiver.output(output);
    }
}