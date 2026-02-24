# 프로젝트 상세 명세서: VibeApp

## 1. 프로젝트 개요
- **프로젝트 명:** VibeApp
- **설명:** 풍부한 디자인과 게시판 기능을 포함한 스프링부트 풀스택 애플리케이션.
- **주요 목표:** 최신 기술 스택(Spring Boot 4, Thymeleaf, Tailwind CSS)을 활용한 프리미엄 UI 기반의 게시판 시스템 구축.

## 2. 기술 스택
- **언어 (Language):** Java 25
- **프레임워크:** Spring Boot 4.0.1
- **빌드 도구 (Build Tool):** Gradle 9.3.0 (Groovy DSL)
- **템플릿 엔진:** Thymeleaf
- **스타일링 (UI):** Tailwind CSS (CDN), Vanilla CSS, Material Symbols Outlined
- **설정 파일:** YAML (`application.yml`)

## 3. 주요 기능
- **Home:** 프리미엄 감성의 메인 홈 화면.
- **게시판 (Post):**
  - CRUD: 게시글 목록 조회, 상세 조회, 작성, 수정, 삭제.
  - 페이징: 페이지당 5개의 게시글 출력 및 네비게이션 처리.
  - 디자인: Glassmorphism 디자인 및 애니메이션 효과 적용.

## 4. 빌드 구성 (Build Configuration)
### 의존성 (Dependencies)
- `spring-boot-starter-web`: 웹 애플리케이션 구축을 위한 핵심 의존성.
- `spring-boot-starter-thymeleaf`: 서버 사이드 템플릿 엔진.
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
│   │   │       ├── Post.java            # 엔티티 (In-memory)
│   │   │       ├── PostController.java
│   │   │       ├── PostRepository.java
│   │   │       └── PostService.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── home/
│   │       │   │   └── home.html
│   │       │   └── post/
│   │       │       ├── posts.html
│   │       │       ├── post_detail.html
│   │       │       ├── post_new_form.html
│   │       │       └── post_edit_form.html
│   │       └── application.yml
├── build.gradle
└── project_spec.md
```

## 6. 개발 관례
- **패키지 구조:** 기능 단위(Feature-based) 패키지 분리 (`home`, `post`).
- **메서드 명명:** 스프링 표준 관례 준수 (`getPosts`, `showCreateForm`, `updatePost` 등).
- **Git Commit:** Conventional Commits 규격 준수.
