FROM maven

COPY pom.xml /tmp
RUN mvn -B -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve

COPY src /tmp/src
RUN mvn -B -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml compile
