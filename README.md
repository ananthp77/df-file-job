# Dataflow File Processing

## Overview
This Dataflow job reads the file passed in the argument --inputFile, finds all transactions greater than 20, excludes transactions before 2010, aggregates them based on the transaction date, and calculates the total transaction amount. The aggregated data is then stored in CSV format in the file `output/results.jsonl.gz`.

For the input
```
2024-01-01,43.2
2024-01-01,100.0
2024-02-01,53.6
2024-05-27,13.2
2013-01-01,433.2
2009-01-01,23.2
```

It gives the output
```
2024-01-01,143.2
2024-02-01,53.6
2013-01-01,433.2
```


## Assumptions
- ** The input file is in the format as shown above without any header. (There is a seperate processsing logic needs to be implemented for file with header which is not considered in this implementation.

## Pre requisites
- ** apache-maven-3.9.6 or higher (If maven is not installed in the machine, Provided the jar file created under target location
- ** Java version: 17.0.9 or higher

## Usage

### 1. Prepare Input File: Create a text file where each line contains The transaction_date and transaction_amount. The format should be:
```
2024-01-01,43.2
2024-01-01,100.0
2024-02-01,53.6
2024-05-27,13.2
2013-01-01,433.2
2009-01-01,23.2
```
### 2. Clone the Github repositiry
      git clone https://github.com/ananthp77/df-file-job.git
### 3. Execute the bash File
		./execute.sh
### 4. Verify the output
	  Navigate to outputs folder and unzip the results.jsonl and view verify the result file.