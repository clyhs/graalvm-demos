<!--
 * @Author: your name
 * @Date: 2022-02-02 13:35:34
 * @LastEditTime: 2022-02-02 15:03:55
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AEg
 * @FilePath: /undefined/Users/chenliyu/clyhs/java/graalvm/spring-native.md
-->
# spring-native-demo

## 构建镜像
mvn clean -U -DskipTests spring-boot:build-image

```
[INFO]     [creator]       BellSoft Liberica NIK 11.0.14: Contributing to layer
[INFO]     [creator]         Downloading from https://download.bell-sw.com/vm/22.0.0.2/bellsoft-liberica-vm-core-openjdk11-22.0.0.2-linux-amd64.tar.gz

到这一步很慢
```

## 构建原生应用
mvn -Pnative package