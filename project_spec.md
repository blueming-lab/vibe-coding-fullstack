# 프로젝트 상세 명세서: VibeApp

## 1. 프로젝트 개요
- **프로젝트 명:** VibeApp
- **설명:** 풍부한 디자인과 게시판 기능을 포함한 스프링부트 풀스택 애플리케이션.
- **주요 목표:** 최신 기술 스택(Spring Boot 4, MyBatis, Thymeleaf, Tailwind CSS)을 활용한 프리미엄 UI 기반의 게시판 시스템 구축 및 데이터 무결성 보장.

## 2. 기술 스택
- **언어 (Language):** Java 25
- **프레임워크:** Spring Boot 4.0.1
- **빌드 도구 (Build Tool):** Gradle 9.3.0 (Groovy DSL)
- **템플릿 엔진:** Thymeleaf
- **ORM/Persistence:** MyBatis 4.0.1 (MyBatis SQL Mapper)
- **데이터베이스:** H2 Database (File-based)
- **트랜잭션 관리:** Spring Transaction (@Transactional)
- **스타일링 (UI):** Tailwind CSS (CDN), Vanilla CSS, Material Symbols Outlined
- **설정 파일:** YAML (`application.yml`)

## 3. 주요 기능
- **Home:** 프리미엄 감성의 메인 홈 화면.
- **게시판 (Post):**
  - **CRUD:** MyBatis를 이용한 영속성 처리 (게시글 목록, 상세, 작성, 수정, 삭제).
  - **페이징:** 페이지당 5개의 게시글 출력 및 서버 사이드 페이징 처리.
  - **디자인:** Glassmorphism 디자인 및 애니메이션 효과 적용.
- **태그 (Tag):**
  - **태그 관리:** 게시글 작성 및 수정 시 쉼표(,)로 구분된 태그 입력 및 관리.
  - **태그 표시:** 상세 페이지에서 제목 아래 배지(#태그) 형태로 태그 출력.
  - **데이터 연동:** `POSTS`와 `POST_TAGS` 테이블 간의 일대다 관계 처리.
- **트랜잭션:** 게시글 및 태그 관련 CUD 작업 시 `@Transactional`을 통한 데이터 정합성 보장.

## 4. 빌드 구성 (Build Configuration)
### 의존성 (Dependencies)
- `spring-boot-starter-web`: 웹 애플리케이션 구축을 위한 핵심 의존성.
- `spring-boot-starter-thymeleaf`: 서버 사이드 템플릿 엔진.
- `spring-boot-starter-validation`: 데이터 유효성 검증.
- `mybatis-spring-boot-starter:4.0.1`: MyBatis 프레임워크 연동.
- `com.h2database:h2`: 인메모리 및 파일 기반 데이터베이스.
- `spring-boot-starter-test`: 단위 및 통합 테스트 지원.

## 5. 프로젝트 구조 (Feature-based)
```text
vibeapp/
├── src/
│   ├── main/
│   │   ├── java/com/example/vibeapp/
│   │   │   ├── VibeApp.java            # 메인 클래스
│   │   │   ├── home/
│   │   │   │   └── HomeController.java
│   │   │   └── post/
│   │   │       ├── Post.java            # 엔티티 (Post)
│   │   │       ├── PostTag.java         # 엔티티 (Tag)
│   │   │       ├── PostController.java
│   │   │       ├── PostRepository.java  # MyBatis Mapper Interface
│   │   │       ├── PostTagRepository.java # MyBatis Mapper Interface
│   │   │       ├── PostService.java     # Business Logic & Transactions
│   │   │       └── dto/                 # Data Transfer Objects
│   │   │           ├── PostCreateDto.java
│   │   │           ├── PostUpdateDto.java
│   │   │           ├── PostListDto.java
│   │   │           └── PostResponseDto.java
│   │   └── resources/
│   │       ├── mapper/                  # MyBatis XML Mappers
│   │       │   └── post/
│   │       │       ├── PostMapper.xml
│   │       │       └── PostTagMapper.xml
│   │       ├── templates/
│   │       │   ├── home/
│   │       │   │   └── home.html
│   │       │   └── post/
│   │       │       ├── posts.html
│   │       │       ├── post_detail.html
│   │       │       ├── post_new_form.html
│   │       │       └── post_edit_form.html
│   │       ├── application.yml
│   │       ├── schema.sql              # Database Schema
│   │       └── data.sql                # Initial Data
│   ├── test/                           # Unit/Integration Tests
├── build.gradle
└── project_spec.md
```

## 6. 개발 관례
- **패키지 구조:** 기능 단위(Feature-based) 패키지 분리 (`home`, `post`).
- **영속성 계층:** MyBatis SQL Mapper를 이용한 SQL 중심 개발.
- **트랜잭션:** 서비스 레이어에서 `@Transactional`을 사용한 원자성 확보.
- **Git Commit:** Conventional Commits 규격 준수.
