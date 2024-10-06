#!/bin/bash

# Check if the input file argument is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <Path to the CSV file>"
    exit 1
fi

# Capture the input file path
INPUT_FILE=$1

# Step 1: Build the project using Maven
echo "Running Maven clean install..."
mvn clean install -DskipTests

# Step 2: Navigate to the target directory
echo "Navigating to target directory..."
cd target || exit

# Step 3: Execute the JAR file with the inputFile argument
echo "Executing the Dataflow job with input file: $INPUT_FILE"
java -jar dataflow-execute.jar --inputFile="$INPUT_FILE"

echo "Execution completed."
