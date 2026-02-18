#!/bin/sh


# rp_server_deploy.sh rp-server.tar return-parcel-server 2.5.5 2.5.5
export RP_SERVER_MODULE="return-parcel-server"
export RP_TEXTEXTRACTOR_MODULE="textextractor"

export RP_SERVER_IMAGE=$(docker ps -a --filter="name=return-parcel-server" --format="{{.Image}}")
export RP_TEXTEXTRACTOR_IMAGE=$(docker ps -a --filter="name=textextractor" --format="{{.Image}}")
export SOURCE_DIR=/tmp/rp
export DESTINATION_DIR=/home/ubuntu/return-parcel

echo "\n1. Docker Deploy Front "${FILENAME}" "${MODULE}" "${VERSION}
#mkdir -p ${SOURCE_DIR}
cd ${SOURCE_DIR}

# Clean
docker stop ${RP_SERVER_MODULE}
docker rm ${RP_SERVER_MODULE}
docker rmi ${RP_SERVER_IMAGE}

docker stop ${RP_TEXTEXTRACTOR_MODULE}
docker rm ${RP_TEXTEXTRACTOR_MODULE}
docker rmi ${RP_TEXTEXTRACTOR_IMAGE}

#rm -rf ${DESTINATION_DIR}/config
cp -ar ${SOURCE_DIR}/artifacts/* ${DESTINATION_DIR}
cd ${DESTINATION_DIR}

for entry in "${DESTINATION_DIR}/images/"/*
do
  echo "$entry"
  docker load -i $entry
done

#docker load -i ${SOURCE_DIR}/artifacts/images/${FILENAME}
#docker load -i ${SOURCE_DIR}/artifacts/images/${FILENAME}



docker-compose up -d --build flyway
#sleep 15
#
#docker-compose up -d --build ${MODULE}
docker-compose up -d --build ${RP_TEXTEXTRACTOR_MODULE}
docker-compose up -d --build ${RP_SERVER_MODULE}

echo "\n3. Docker images"
docker images
#sleep 60

docker ps

