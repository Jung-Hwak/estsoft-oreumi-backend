# Spring Security(2026-01-29)

## 오늘 작성한 코드에서 사용한 주해 설명
| 주해 (Annotation)     | 주요 역할 및 사용 이유            | 설명                         |
| ------------------- | ------------------------ | -------------------------- |
| 분류                  |
| 데이터 검증 (Validation) | @NotBlank                | null, "",  " " 모두 허용 안 함   | "공백만 입력하는 꼼수 방지"            |
| **〃**               | @Size(min, max)          | 문자열/컬렉션의 길이 제한             | "DB 과부하 방지 및 데이터 규격화"       |
| **〃**               | @Pattern(regexp)         | 정규표현식으로 형식 제한              | "영문, 숫자만 쓰게끔 엄격한 규칙 부여"     |
| **〃**               | @Email                   | 이메일 형식 타당성 검사              | "직접 정규식을 짜지 않아도 되는 편리함"     |
| **〃**               | @Valid                   | 검증 로직 실행 트리거               | "이게 없으면 위 주해들은 작동 안 함"      |
| JPA / DB 매핑         | @Entity                  | 클래스를 DB 테이블과 매핑            | "이 객체는 이제 DB 데이터다"          |
| **〃**               | @Column                  | 컬럼 속성(unique, nullable) 설정 | "DB 레벨에서 최종 방어선 구축"         |
| **〃**               | @Enumerated              | Enum 저장 방식 설정 (STRING 권장)  | "숫자 대신 반드시 '문자열'로 저장해라"     |
| **〃**               | @CreationTimestamp       | 생성 시간 자동 기록                | "로그 분석이나 관리에 필수적인 정보"       |
| Lombok / 생산성        | @RequiredArgsConstructor | final 필드 생성자 주입            | "DI(의존성 주입)를 가장 깔끔하게 하는 방법" |
| **〃**               | @Builder                 | 빌더 패턴 구현                   | "가독성 좋고 안전한 객체 생성"          |
| **〃**               | @NullMarked              | 클래스 내 non-null 선언          | "코드를 더 견고하고 안전하게 만듦"        |
| Spring Security     | @EnableWebSecurity       | 시큐리티 설정 활성화                | "필터 체인을 동작시키는 스위치"          |
| **〃**               | @Service                 | 빈(Bean) 등록                 | "비즈니스 로직을 수행하는 계층 명시"       |
| **〃**               | @Configuration             | 설정 클래스임을 선언                 | "이 클래스는 스프링이 기동될 때 설정 정보를 읽어 빈을 생성함"  |

--- 

## Spring Security 인증 흐름
| 단계      | 수행 (클래스/메서드)                                  | 역할 및 설명                          | 비고                             |
| ------- | --------------------------------------------- | -------------------------------- | ------------------------------ |
| 1\. 요청  | login.html                                    | 사용자가 ID/PW를 입력하고 POST 요청         | 필드명(`username`, `password`) 준수 |
| 2\. 가로채 | UsernamePasswordAuthenticationFilter          | 요청을 가로채서 인증 토큰 생성                | 시큐리티 내부 필터                     |
| 3\. 매니저 | AuthenticationManager                         | 등록된 Provider들에게 인증 처리를 위임        | 인증의 총괄 관리자                     |
| 4\. 조회  | CustomUserDetailsService.loadUserByUsername() | **[우리가 구현]** DB에서 사용자 정보 로드      | `UserRepository` 활용            |
| 5\. 변환  | CustomUserDetails.of(userDto)                 | **[우리가 구현]** 일반 객체를 시큐리티 규격으로 변환 | 권한에 `ROLE_` 접두사 추가             |
| 6\. 비교  | BCryptPasswordEncoder.matches()               | 입력값과 DB 해시값을 비교하여 검증             | 평문 vs 암호화 데이터 비교               |
| 7\. 저장  | SecurityContextHolder                         | 인증 성공 시 세션에 유저 정보 저장             | 이후 어디서든 유저 정보 참조 가능            |

---

## 비밀번호 암호화 및 유저 생성, 시큐리티 권한 설정
* **UserServiceImpl**
    1. 중복 검사 (비즈니스 예외 발생)
    checkUsernameAvailability(userDto.getUsername());
        
    2. 비밀번호 암호화 (BCrypt)
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

    3. 엔티티 변환 및 저장
    userRepository.save(UserEntity.from(userDto));

---

* **SecurityConfiguration**
    1. 누구나 가능
    .requestMatchers("/", "/login", "/signup").permitAll()
    2. 관리자만 가능
    .requestMatchers("/admin/**").hasRole("ADMIN")
    3. 나머지는 로그인 필수
    .anyRequest().authenticated()
## 시큐리티 권한 설정

## 1. 도메인 모델과 유효성 검사 (Validation)
1. Entity 설정
    ```java
    // UserEntity.java
    @Data
    @Builder
    public class UserDto {
        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 50)
        @Pattern(regexp = "^[a-zA-Z0-9_]+$")
        private String username;
    -----------------------------------------------------------------------
        @Email(regexp = "^[a-zA-Z0-9._%+-]+@[...]")
        private String email;
    -----------------------------------------------------------------------
        @Builder.Default
        private UserRole role = UserRole.USER;
    }
2. DTO와 유효성 검사
    ```java
    //UserDto.java
    @Data
    @Builder
    public class UserDto {
        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 50)
        @Pattern(regexp = "^[a-zA-Z0-9_]+$")
        private String username;
    -----------------------------------------------------------------------
        @Email(regexp = "^[a-zA-Z0-9._%+-]+@[...]")
        private String email;
    -----------------------------------------------------------------------
        @Builder.Default
        private UserRole role = UserRole.USER;
    }
## 2. 비즈니스 로직과 예외 처리
* **서비스 계층**
- 비밀번호 암호화와 중복 체크가 이루어지는 핵심 코드
    ```java
    // UserServiceImpl.java
    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
    -----------------------------------------------------------------------
        @Override
        public void create(@NotNull UserDto userDto) {
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            userDto.setPassword(encodedPassword);

            userRepository.save(UserEntity.from(userDto));
        }
    }
- 컨트롤러 예외 핸들러
    ```java
    // UserController.java
    @PostMapping("/signup")
    public String signup(@Valid UserDto userDto) {
        userService.create(userDto);
        return "redirect:/login";
    }
    -----------------------------------------------------------------------
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleArgumentException(IllegalArgumentException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "redirect:/signup";
    }
## 3. Spring Security 인증 매커니즘
- **"인증의 흐름"**을 구현한 코드
- 시큐리티 전용 유저 객체
    ```java
    // CustomUserDetails
    @NullMarked
    @RequiredArgsConstructor
    public class CustomUserDetails implements UserDetails {
        private final UserDto user;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
        }
- 시큐리티 설정
    ```java
    // SecurityConfiguration
    /**
     * SecurityFilterChain의 구성을 설정
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Credential 기반 인증(username과 password로 인증)에 대한 설정
        httpSecurity
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                );

        // 인가(authorization)에 대한 설정
        httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/", "/login", "/signup").permitAll()
                        .requestMatchers("/board/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/error/**").permitAll()
                        .anyRequest().authenticated()
                );

        // AccessDeniedException 예외를 처리할 핸들러 등록
        httpSecurity
                .exceptionHandling(handler -> handler
                        .accessDeniedHandler(accessDeniedHandler())
                );

        // CustomUserDetailsService를 UserDetailsService 등록
        httpSecurity
                .userDetailsService(customUserDetailsService);

        return httpSecurity.build();
    }
    -----------------------------------------------------------------------
        /**
         * 사용자가 입력한 비밀번호를 암호화할 PasswordEncoder를 빈(bean)으로 등록
         */
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }