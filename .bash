#!/bin/bash
clear ; cd "$(dirname "${0}")"

PROJECT=dropwizard-demo

versions() {
	echo "java:"
	java -version ; echo
	echo "javac: $(javac -version)"
}

create() {
	# https://mvnrepository.com/artifact/io.dropwizard.archetypes/dropwizard-archetypes
	mvn --batch-mode archetype:generate \
		-DarchetypeGroupId=io.dropwizard.archetypes \
		-DarchetypeArtifactId=java-simple -DarchetypeVersion=4.0.1 \
		-DgroupId=io.github.crisstanza -DartifactId=dropwizard-demo \
		-Dname=DropwizardDemo -Dversion=1.0-SNAPSHOT
}

install() {
	cd ${PROJECT}/
	mvn clean install
}

run() {
	cd ${PROJECT}/target/
	java -jar dropwizard-demo-1.0-SNAPSHOT.jar server
}

if [ ${#} -eq 0 ] ; then
	echo -e "Usage: ${0} [COMMANDS]\nAvailable commands:"
	cat `basename ${0}` | grep '^[^#]*()\s{' | while read COMMAND ; do echo " - ${COMMAND::-4}" ; done
else
	for COMMAND in "${@}" ; do "${COMMAND}" ; done
fi
