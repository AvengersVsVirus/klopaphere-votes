mvn package
mkdir -p oc_deploy/lib
cp -r config/kafka.cert oc_deploy
cp -r target/lib/* oc_deploy/lib
cp target/klopaphere-votes-1.0-SNAPSHOT-runner.jar oc_deploy/klopaphere-votes.jar
cp src/main/docker/Dockerfile.deprecated oc_deploy/
oc project klopaphere
helm template ./src/main/ocp -f ./src/main/ocp/values.yaml | oc apply -f -
oc start-build klopaphere-votes --follow --wait --from-dir=oc_deploy
rm -rf oc_deploy
