# 프로젝트 상세 명세서: VibeApp

## 1. 프로젝트 개요
- **프로젝트 명:** VibeApp
- **설명:** 최소한의 기능으로 구성된 스프링부트 애플리케이션 생성 프로젝트.
- **주요 목표:** 최신 기술 스택을 적용한 스프링부트 애플리케이션의 기본 구조를 제공함.

## 2. 기술 스택
- **언어 (Language):** Java
- **JDK 버전:** JDK 25 이상
- **프레임워크:** Spring Boot 4.0.1 이상
- **빌드 도구 (Build Tool):** Gradle 9.3.0 이상
- **DSL:** Groovy DSL 사용
- **설정 파일 형식:** YAML (`application.yml`)

## 3. 프로젝트 메타데이터
- **그룹 (Group ID):** `com.example`
- **아티팩트 (Artifact ID):** `vibeapp`
- **버전 (Version):** `0.0.1-SNAPSHOT`
- **패키지 명:** `com.example.vibeapp`
- **메인 클래스 명:** `VibeApp`
- **설명:** 최소 기능 스프링부트 애플리케이션을 생성하는 프로젝트다.

## 4. 빌드 구성 (Build Configuration)
### 플러그인 (Plugins)
- `org.springframework.boot`: Spring Boot 플러그인 (버전 4.0.1+)
- `io.spring.dependency-management`: Spring Boot 버전에 맞춘 의존성 관리 플러그인
- `java`: Java 지원 플러그인

### 의존성 (Dependencies)
- **핵심:** 최소 기능 구현 프로젝트로, 초기 추가 의존성 없음 (최소 구성)

## 5. 권장 디렉토리 구조
```text
vibeapp/
├── gradle/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/vibeapp/
│   │   │       └── VibeApp.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/
│           └── com/example/vibeapp/
│               └── VibeAppTests.java
├── build.gradle
├── settings.gradle
└── gradlew
```

## 6. 설정 세부사항
- **위치:** `src/main/resources/application.yml`
- **내용:** 애플리케이션 구동을 위한 최소 설정 값 포함
