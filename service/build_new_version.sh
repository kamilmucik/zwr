#!/usr/bin/env bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
RELEASE_VER="2.2.5"
DEPLOY__VER="2.2.6-SNAPSHOT"

echo $SCRIPT_DIR

find . -name "*.tag" -type f
find . -name "*.releaseBackup" -type f
find . -name "release.properties" -type f
find . -name "*.tag" -type f -delete
find . -name "*.releaseBackup" -type f -delete
find . -name "release.properties" -type f -delete

mvn clean

mvn versions:set -DnewVersion=${RELEASE_VER}

#mvn -B -DdevelopmentVersion=${DEPLOY_VER} -DrleaseVersion=${RELEASE_VER} -Dresume=false release:prepare release:perform -DdryRun=true
#mvn -B -DdevelopmentVersion="2.2.1-SNAPSHOT" -DrleaseVersion="2.2.0" -Dresume=false release:prepare release:perform -DdryRun=true -Pmegapack
#paczki megapack
#scp return-parcel-app/target/return-parcel-app.war ubuntu@51.83.132.174:/var/www/e-strix.pl/public_html/megapack/ROOT_MP_2.2.0.war

#docker
#scp return-parcel-app/target/ROOT.war ubuntu@54.38.52.246:/home/ubuntu/docker/docker/tomcat-mock/target/ROOT.war
