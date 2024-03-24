#!/bin/bash

# Check if the path to the JAR file is provided as an argument
if [ $# -ne 1 ]; then
    echo "Usage: $0 <path_to_jar>"
    exit 1
fi

# Store the path to the JAR file
jar_path="$1"

# Check if the JAR file exists
if [ ! -f "$jar_path" ]; then
    echo "Error: JAR file not found at $jar_path"
    exit 1
fi

# Copy the JAR file into the docker directory
cp "$jar_path" ./

jar_file=$(basename "$jar_path")

# Build the Docker image
docker build --build-arg JAR_FILE="$jar_file" -t auth-api .

rm "$jar_file"