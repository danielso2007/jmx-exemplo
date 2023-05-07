FROM adoptopenjdk/openjdk11
COPY demo.jar /opt/demo.jar
CMD java -XX:+UseG1GC -Xms64m -Xmx128m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m -Dcom.sun.management.jmxremote.port=9999 -Dcom.sun.management.jmxremote.rmi.port=9999 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -jar /opt/demo.jar
EXPOSE 9999
EXPOSE 8080