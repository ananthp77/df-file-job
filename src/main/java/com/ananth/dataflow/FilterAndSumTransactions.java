package com.ananth.dataflow;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;


public class FilterAndSumTransactions extends PTransform<PCollection<String>, PCollection<String>> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2298393811022855161L;

	@Override
    public PCollection<String> expand(PCollection<String> input) {
        return input
            .apply("Parse and Filter CSV", ParDo.of(new ParseAndFilterCsvFn()))
            .apply("Group by Date", GroupByKey.create())
            .apply("Sum Amounts by Date", ParDo.of(new SumAmountsByDateFn()));
    }
}