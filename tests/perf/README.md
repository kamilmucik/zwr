
Performance test scenarios written in jmeter.

----------
New way via maven plugin
----------
1. Read instruction how to run test and make break between execution each test.

2. Invoke all test for one environment. After command finished, you should copy report to not target directory, because 'mvn clean' command will delete report.

Invoke example:
* `mvn clean verify -e -P QA,FindByEAN`

* (Remember to update pom.xml with current snapshot version)

| Profile      | Description                         | More |
|--------------|-------------------------------------|------|
| local-docker | Useful for local perform test       |      |
| QA           | Setting for communication           |      |
| FindByEAN    | Test communication with environment | 60m  |
| UploadImage  | Performance test: scenario 1        | 10m  |

Result report: [PATH]/target/jmeter/
* logs
* reports
* result
* testFiles

2. Prepare report page with
* Statistics table image
* Response Times Over Time
* Hits Per Seconds
* Time Vs Threads
