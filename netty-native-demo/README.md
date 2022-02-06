# Netty native


```
mvn clean package
```
This will create a jar file with all dependencies embedded.

#### Run Netty on JVM

On the regular JVM you can run as usual using the `java` command:
```
java -jar target/netty-svm-httpserver-full.jar

Open your web browser and navigate to http://127.0.0.1:8080/
```

#### Run Netty with GraalVM Native Image

To build the native image we use the `native-image` tool:
```
native-image -jar target/netty-svm-httpserver-full.jar
```

We can now run the executable:

```
./netty-svm-httpserver-full
Open your web browser and navigate to http://127.0.0.1:8080/
```
