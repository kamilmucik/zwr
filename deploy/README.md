
```bash
cd ..
mvn -pl :return-parcel-docker-server install -PdockerBuild,docker-registry
cd deploy
```

```bash
rm report_env_162.19.227.81_node1.txt
rm ./artifacts/images/rp-server.tar
rm ./artifacts/images/rp-textextractor.tar
docker save -o ./artifacts/images/rp-server.tar registry.hub.docker.com/kamilmucik/return-parcel-server:2.6.0
docker save -o ./artifacts/images/rp-textextractor.tar registry.hub.docker.com/kamilmucik/textextractor:0.0.1-SNAPSHOT
```

```bash
ansible-playbook rp_server_deploy.yml -i hosts.yml 
```


