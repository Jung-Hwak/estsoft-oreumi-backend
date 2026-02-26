# Spring Security + JWT 인증 / 인가 전체 정리 (2026-02-25)

---

# 1. JWT 인증 구조 개요

## JWT 인증 방식의 핵심 개념
- 세션 기반 인증이 아닌 **Stateless 인증 방식**
- 서버는 상태를 저장하지 않음
- 클라이언트가 **매 요청마다 JWT 토큰을 Authorization 헤더에 포함**하여 전송
- 서버는 JWT 검증 후 **SecurityContext에 인증 정보 저장**

---

# 2. JWT 구성 요소

| 구성 | 설명 |
|--------|------|
| Header | 토큰 타입, 해싱 알고리즘 |
| Payload (Claims) | 사용자 정보, 권한, 만료 시간 |
| Signature | 무결성 검증 |

---

# 3. JWT Payload 설계

## Access Token 구성
| Claim | 설명 |
|----------|------|
| username | 인증 정보 |
| authority | 인가 정보 |
| issuedAt | 발급 시각 |
| expiration | 만료 시각 |

## Refresh Token 구성
| Claim | 설명 |
|----------|------|
| username | 사용자 식별 |
| issuedAt | 발급 시각 |
| expiration | 만료 시각 |

> Refresh Token에는 **authority를 포함하지 않는다.**

---

# 4. JWT 유틸리티 클래스 역할

| 기능 | 설명 |
|--------|------|
| Token 발급 | Access / Refresh 생성 |
| Token 파싱 | username, authority 추출 |
| Token 검증 | 서명, 만료 여부 |
| 만료 시간 계산 | Duration → Date 변환 |

---

# 5. JWT 정보 추출 메서드

### 추출
  - username 추출
  
        ```java
            public String getUsername(String token) {
                return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .get("username", String.class);
            }
- Authority 추출
    ```java
    public String getAuthority(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .get("authority", String.class);
    }

# 6. JWT 만료 여부 검사
  - expiration < 현재 시각 → 만료
    ```java
    public boolean isExpired(String token) {
        Date expiration = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();

        return expiration.before(new Date());
    }

# 7. Access Token 생성
  - Access Token 생성
    ``` java
    public String issueAccessToken(String username, String authority) {
    return Jwts.builder()
        .claim("username", username)
        .claim("authority", authority)
        .setIssuedAt(new Date())
        .setExpiration(getDateAfterDuration(accessTokenDuration))
        .signWith(secretKey)
        .compact();
    }

# 8. Refresh Token 생성
- Refresh Token 생성
    ``` java
    public String issueRefreshToken(String username) {
    return Jwts.builder()
        .claim("username", username)
        .setIssuedAt(new Date())
        .setExpiration(getDateAfterDuration(refreshTokenDuration))
        .signWith(secretKey)
        .compact();
    }

# 9. JWT Authentication Filter 역할
| 기능       | 설명                    |
| -------- | --------------------- |
| 헤더 추출    | Authorization         |
| 토큰 검증    | 서명 + 만료               |
| 정보 추출    | username, authority   |
| 인증 객체 생성 | Authentication        |
| 컨텍스트 저장  | SecurityContextHolder |

# 10. 필터 구현 방식
- ```java
    public class JwtAuthenticationFilter extends OncePerRequestFilter
- OncePerRequestFilter 특징
| 항목 | 설명       |
| -- | -------- |
| 실행 | 요청 당 1회  |
| 목적 | 중복 실행 방지 |

# 11. Authorization Header 처리
- ``` java
    String header = request.getHeader("Authorization");
    if (header == null || !header.startsWith("Bearer ")) {
        filterChain.doFilter(request, response);
        return;
    }
