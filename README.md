# Dataflow File Processing

## Overview
This dataflow job read the file which is passed in the argument --inputFile, then finds all transactions which is greater than 20, excludes the transactions before 2010 and then aggregates based on the transaction date and find the total transaction amount. The aggregaed data is stored again in csv format into a file `output/results.jsonl.gz`.

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

### 1. Prepare Input File: Create a text file where each line contains a timestamp, a username, and an action ("Start" or "End"). The format should be:
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

### 3. Get into the project after cloning
      cd df-file-job

### 4. Build the java code using maven command
     mvn clean install
### 5. Get into the target direcctory
     cd target

### 5. Run the jar file with the input argument 
      java -jar dataflow-execute.jar --inputFile=<Path to the csv file crated in step1>

##### Example: java -jar dataflow-execute.jar E:\Ananth\Assessments\input\input.txt