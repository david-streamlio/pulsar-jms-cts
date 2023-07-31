# Pulsar JMS Client Compliance Test Suite
Overview

This a test harness for exercising the Pulsar JMS client against the JMS 1.1 specification. It uses the Java Message 
Service Compliance [Test Suite](https://jmscts.sourceforge.net/).

## Running the Compliance Test Suite
---
Running the test suite against an externally provided broker

```bash
export JAVA_HOME=   # Set this to the desired JDK

./bin/setenv.sh
./bin/jmscts.sh run
```


## Reading the results

Results can be found in:

  - target/jmscts-report/html/coverage.html
  - target/jmscts-selector-report/html/coverage.html
  - target/jmscts-browse-report/html/coverage.html


