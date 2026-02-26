# Spring Security + JWT 인증 구조 정리 (2026-02-26)

---

## 1. 오늘 수업
오늘 구현한 내용 3가지

1. **JWT Utility 클래스 작성**
2. **Access Token / Refresh Token 발급 구조**
3. **JWT 인증 필터(JWTAuthenticationFilter) 구현**

> **Spring Security에서 JWT 기반 인증/인가 구조 완성**

---

## 2. JWT 기반 인증 구조 개요

### 전체 인증 흐름

- ```text
    Client
    → Login
    → Access Token + Refresh Token 발급
    → Authorization Header (Bearer Token)
    → JWTAuthenticationFilter
    → JWT 검증
    → Authentication 객체 생성
    → SecurityContextHolder 저장
    → Controller 접근

## 3. JWT Utility 클래스 역할 정리
- JwtTokenProvider 주요 역할
    | 기능               | 설명                        |
    | ---------------- | ------------------------- |
    | Access Token 생성  | 인증 + 인가 정보 포함             |
    | Refresh Token 생성 | Access Token 재발급용         |
    | Username 추출      | JWT Payload에서 username 읽기 |
    | Authority 추출     | JWT Payload에서 권한 읽기       |
    | 토큰 만료 검증         | expiration 시간 검증          |
    | JWT 파싱           | Secret Key 기반 검증          |
## 4. JWT Payload 설계
- Access Token Payload
    | Claim      | 내용                     |
    | ---------- | ---------------------- |
    | username   | 사용자 ID                 |
    | authority  | ROLE_USER / ROLE_ADMIN |
    | issuedAt   | 발급 시각                  |
    | expiration | 만료 시각                  |
- Refresh Token Payload
    | Claim      | 내용     |
    | ---------- | ------ |
    | username   | 사용자 ID |
    | expiration | 만료 시각  |
**주의** Refresh Token에는 권한(authority)을 넣지 않음
## 5. JWT 유틸리티 핵심 메서드
1. Username 추출
    - ```java
        public String getUsername(String token) {
            return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("username", String.class);
        }
- 2. Authority 추출
    - ```java
        public String getAuthority(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .get("authority", String.class);
        }
- 3. JWT 만료 여부 확인
  - ```java
        public boolean isExpired(String token) {
            Date expiration = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

            return expiration.before(new Date());
        }
- 4. Access Token 발급
  - ```java
        public String issueAccessToken(String username, String authority) {
        return Jwts.builder()
            .claim("username", username)
            .claim("authority", authority)
            .setIssuedAt(new Date())
            .setExpiration(getDateAfterDuration(accessTokenExpireTime))
            .signWith(secretKey)
            .compact();
        }
- 5. Refresh Token 발급
  - ```java
        public String issueRefreshToken(String username) {
        return Jwts.builder()
            .claim("username", username)
            .setIssuedAt(new Date())
            .setExpiration(getDateAfterDuration(refreshTokenExpireTime))
            .signWith(secretKey)
            .compact();
        }

## 6. JWT 인증 처리 개념
- Spring Security는 Authentication 객체를 기준으로 인증/인가 처리한다.
  - JWT → Authentication 객체 변환 → SecurityContext 저장
  - 
## 7. JWTAuthenticationFilter 역할
- 필터에서 수행하는 작업
  1. Authorization 헤더 추출
  2. JWT 존재 여부 검사
  3. JWT 검증
  4. username + authority 추출
  5. Authentication 객체 생성
  6. SecurityContextHolder 저장
  7. 다음 필터로 전달

## 8. JWTAuthenticationFilter 구조
- ```java
    public class JwtAuthenticationFilter extends OncePerRequestFilter {}
- OncePerRequestFilter 특징
  - 요청당 딱 한 번만 실행
  - JWT 인증 처리에 최적

## 9. 필터 메서드 구현
- ```java
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
## 10. JWT 인증 실패 시 처리
| 상황     | 응답        |
| ------ | --------- |
| JWT 없음 | 다음 필터로 전달 |
| JWT 만료 | 401       |
| JWT 변조 | 401       |
| JWT 오류 | 401       |

## 11. JWT 인증 성공 흐름 요약
- ```text
    JWT → username + authority 추출
    → Authentication 객체 생성
    → SecurityContextHolder 저장
    → Controller 정상 접근
# 오늘 구현한 구조 요약
- ```text
    [Login]
    ↓
    [JWT 발급]
    ↓
    [Client Authorization Header 저장]
    ↓
    [JWTAuthenticationFilter]
    ↓
    [JWT 검증]
    ↓
    [Authentication 객체 생성]
    ↓
    [SecurityContext 저장]
    ↓
    [Controller 접근 허용]