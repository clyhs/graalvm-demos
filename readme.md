graalvm

## install graalvm
* download java11-darwin-amd64-22.0.0.2.tar.gz
* native-image-installable-svm-java11-darwin-amd64-22.0.0.2.jar

安装 java11-darwin-amd64-22.0.0.2.tar.gz
```
cd /opt/local
tar -Zvxf java11-darwin-amd64-22.0.0.2.tar.gz
```
配置环境变量
```
cd ~
vi .bash_profile
JAVA_HOME=/opt/local/graalvm-ce-java11-22.0.0.2/Contents/Home
PATH=$JAVA_HOME/bin:$PATH:.
```
安装native-image
```
gu install -L /opt/local/native-image-installable-svm-java11-darwin-amd64-22.0.0.2.jar
```

编译hello 项目 hellworld
```
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String str = "Native Image is awesome";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String str) {
        if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

}
```
javac HelloWorld.java
native-image HelloWorld
```
================================================================================
GraalVM Native Image: Generating 'helloworld'...
================================================================================
[1/7] Initializing...                                           (11.3s @ 0.20GB)
 Version info: 'GraalVM 22.0.0.2 Java 11 CE'
Produced artifacts:
 /Users/chenliyu/clyhs/java/hello/src/helloworld (executable)
 /Users/chenliyu/clyhs/java/hello/src/helloworld.build_artifacts.txt
================================================================================
Finished generating 'helloworld' in 1m 11s.

```
chenliyudeMacBook-Pro:src chenliyu$ ./helloworld 
The reversed string is: emosewa si egamI evitaN

