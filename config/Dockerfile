FROM openjdk:8-jdk-alpine
VOLUME /tmp

ADD target/m2 m2
ADD ./target/config.jar /app/

CMD [ "sh", "-c", "java -jar /app/config.jar --thin.root=/m2" ]


#COPY target/config.jar /thin/wrapper.jar
#COPY pom.xml /thin/pom.xml
#WORKDIR /thin
#RUN jar cvf pom.jar pom.xml
#RUN java -jar wrapper.jar \
#       --thin.archive=/thin/pom.jar \
#	   --thin.dryrun=true \
#	   --thin.debug=true

#FROM openjdk:8-jdk-alpine
#COPY -from=0 /root/.m2 /root/.m2
#COPY target/config-1.0-SNAPSHOT.jar /app.jar
#CMD ["java","-jar","/app.jar"]