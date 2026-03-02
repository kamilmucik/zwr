#!/usr/bin/env bash

HOME="$(dirname)"

cd $PROJECT_DIR

mvn sonar:sonar --define sonar.scm.disabled=true --define sonar.login=admin --define sonar.password='!QAZse4' --define sonar.host.url=http://localhost:9000

mvn sonar:sonar \
    --batch-mode \
    --define sonar.projectName=${ARTIFACT_ID} \
    --define sonar.projectKey=${GROUP_ID}:${ARTIFACT_ID} \
    --define sonar.scm.disabled=true \
    --define sonar.java.coveragePlugin=jacoco \
    --define sonar.dependencyCheck.htmlReportPath="./target/dependency-check-report.html" \
    --define sonar.dependencyCheck.jsonReportPath="./target/dependency-check-report.json" \
    --define sonar.pullrequest.key=${pullRequestId} \
    --define sonar.pullrequest.branch=${sourceBranch} \
    --define sonar.pullrequest.base=${targetBranch} \
    --define sonar.pullrequest.bitbucketserver.project=${destinationRepositoryOwner} \
    --define sonar.pullrequest.bitbucketserver.repository=${destinationRepositoryName} \
    --no-snapshot-updates
