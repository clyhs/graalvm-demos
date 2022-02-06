# Springboot Native

## 构建原生应用
mvn -Pnative package

运行
```
./target/springboot-demo
```

## 构建docker镜像
mvn clean -U -DskipTests spring-boot:build-image

```
[INFO]     [creator]       BellSoft Liberica NIK 11.0.14: Contributing to layer
[INFO]     [creator]         Downloading from https://download.bell-sw.com/vm/22.0.0.2/bellsoft-liberica-vm-core-openjdk11-22.0.0.2-linux-amd64.tar.gz

到这一步很慢
```

运行 
```
docker run --rm springboot-demo:0.0.1-SNAPSHOT
```