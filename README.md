# Dataflow File Processing

## Overview



## Assumptions


## Features



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