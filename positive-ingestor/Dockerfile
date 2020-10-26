FROM maven:latest

ADD pom.xml /opt
ADD src /opt/src
WORKDIR /opt
RUN mvn package
RUN cp target/positive* /opt

WORKDIR /opt

CMD java -jar positive*

