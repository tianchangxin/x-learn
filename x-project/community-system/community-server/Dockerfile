# 使用官方Java 17镜像作为构建环境
FROM openjdk:17-ea-slim
EXPOSE 8080

# 将应用复制到容器中
COPY target/community-server-1.0.0-SNAPSHOT.jar /app.jar
# 指定容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "/app.jar"]