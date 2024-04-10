FROM openjdk:17-slim as build
WORKDIR application


ARG JAR_FILE=build/libs/msa-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar

# Spring Boot Layer Tools를 사용하여 JAR 파일을 여러 레이어로 분해하고 추출
RUN java -Djarmode=layertools -jar application.jar extract && ls -la


# 두 번째 스테이지: 동일한 Java 런타임 베이스 이미지를 사용하여 최종 애플리케이션 이미지를 구성
FROM openjdk:17-slim

# 컨테이너 내에서 애플리케이션 파일이 위치할 작업 디렉토리를 설정
WORKDIR application

# 첫 번째 빌드 스테이지에서 추출된 각 레이어(종속성, 스프링 부트 로더, 스냅샷 종속성, 애플리케이션 파일)를
# 현재 스테이지의 작업 디렉토리에 복사
COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./

# 컨테이너 시작 시 Spring Boot 애플리케이션을 실행하는 EntryPoint 설정
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
