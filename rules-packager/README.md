Before running the packager, ensure ICE is [built/installed](../README.ICE).

To run the packager with default arguments (specified in the [pom.xml](pom.xml)): 

```mvn exec:java```

To run and override default arguments:

```
mvn exec:java -Dexec.args="../opencds-ice-service/src/main/resources/ice.properties gov.nyc.cir^ICE^1.0.0 org.cdsframework^ICE^1.0.0"
```