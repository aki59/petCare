FROM java:8-jre
MAINTAINER Akash Tiwari <akash59tiwari@gmail.com>

ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 5000