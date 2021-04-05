FROM openjdk:11
VOLUME /tmp
ADD ./target/georreferenciamento-0.0.1-SNAPSHOT.jar georreferenciamento.jar
ENTRYPOINT ["java","-jar","/georreferenciamento.jar"]