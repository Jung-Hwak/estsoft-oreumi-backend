# Spring Boot JPA 연관관계 매핑 및 댓글 서비스 구현(2026-01-27)

JPA의 @ManyToOne과 @OneToMany를 이용한 게시물-댓글 간의 양방향 연관관계 설정법을 익히고, DTO와 Entity 간의 변환 로직 및 이를 검증하는 서비스 계층 테스트 방법을 배움

---

## 1. 양방향 연관관계 매핑: `Entity` 설계
- 게시물(Post)과 댓글(Comment)의 1:N 관계를 JPA 어노테이션으로 설정
- CommentEntity (다측, 주인): 외래키(post_id)를 가지며 관계의 주인 역할을 함.
- PostEntity (일측): mappedBy를 통해 주인이 아님을 설정하고, cascade = CascadeType.REMOVE로 게시물 삭제 시 댓글도 함께 삭제되도록 처리함.
    ```java
    // CommentEntity.java (관계의 주인)
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private PostEntity postEntity;

    // PostEntity.java (참조 측)
    @ToString.Exclude 
    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.REMOVE)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

---

## 2. 계층 간 데이터 전달: `CommentDto`와 변환 로직
- 엔티티 객체를 직접 노출하지 않고 DTO를 통해 데이터를 전달하며, 상호 변환 메서드를 포함함
- 정적 팩토리 메서드 (from): 엔티티를 받아 DTO로 변환하여 반환함.
- 엔티티 변환 메서드 (toEntity): DTO 데이터를 기반으로 엔티티 객체를 생성하되, 연관된 PostEntity를 인자로 받아 설정함.
    ```java
    // CommentDto.java
    // 정적 팩토리 메서드(static factory method)
    public static CommentDto from(CommentEntity commentEntity) {
        return CommentDto.builder()
                .id(commentEntity.getId())
                .postId(commentEntity.getPostEntity().getId())
                .content(commentEntity.getContent())
                .writer(commentEntity.getWriter())
                .createdAt(commentEntity.getCreatedAt())
                .updatedAt(commentEntity.getUpdatedAt())
                .build();
    }

    /**
     * CommentDto 인스턴스를 CommentEntity 인스턴스로 변환
     *
     * @param postEntity CommentEntity 인스턴스가 참조하는 PostEntity 인스턴스
     * @return CommentEntity 인스턴스
     */
    public CommentEntity toEntity(PostEntity postEntity) {
        return CommentEntity.builder()
                .postEntity(postEntity)
                .content(content)
                .writer(writer)
                .build();
    }

---

## 3. 서비스 로직 구현: `CommentServiceImpl`
- Optional과 Stream API를 활용하여 가독성 높고 안전한 비즈니스 로직을 구현함
- Create: 부모 게시물 존재 여부를 먼저 확인한 후 댓글을 저장함.
- Update/Delete: findById()와 map()을 활용하여 데이터가 존재할 때만 로직이 실행되도록 작성함.
- GetList: 쿼리 메서드(findByPostEntityId)로 조회한 엔티티 리스트를 스트림을 통해 DTO 리스트로 변환함.
    ```java
    // CommentServiceImpl.java
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class CommentServiceImpl implements CommentService {
        private final PostRepository postRepository;
        private final CommentRepository commentRepository;

        @Override
        public Optional<CommentDto> create(CommentDto commentDto) {
            log.info("create = {}", commentDto);

            Optional<CommentDto> result = Optional.empty();

            Optional<PostEntity> postEntityOptional = postRepository.findById(commentDto.getPostId());

            if (postEntityOptional.isPresent()) {
                PostEntity postEntity = postEntityOptional.get();
                CommentEntity savedEntity = commentRepository.save(commentDto.toEntity(postEntity));

                result = Optional.of(CommentDto.from(savedEntity));
            }

            return result;
        }

        @Override
        public Optional<CommentDto> read(Long id) {
            log.info("read = {}", id);

            return commentRepository.findById(id).map(CommentDto::from);
        }

        @Override
        public Optional<CommentDto> update(CommentDto commentDto) {
            log.info("update = {}", commentDto);

            Optional<CommentDto> result = Optional.empty();

            Optional<CommentEntity> commentEntityOptional = commentRepository.findById(commentDto.getId());

            if (commentEntityOptional.isPresent()) {
                CommentEntity commentEntity = commentEntityOptional.get()
                        .updateContent(commentDto.getContent())
                        .updateWriter(commentDto.getWriter());

                CommentEntity savedEntity = commentRepository.save(commentEntity);

                result = Optional.of(CommentDto.from(savedEntity));
            }

            return result;
        }

        @Override
        public boolean delete(Long id) {
            log.info("delete = {}", id);

            return commentRepository.findById(id).map(commentEntity -> {
                commentRepository.delete(commentEntity);
                return true;
            }).orElse(false);
        }

        @Override
        public List<CommentDto> getList(Long postId) {
            log.info("getList = {}", postId);

            return commentRepository.findByPostEntityId(postId).stream()
                    .map(CommentDto::from)
                    .collect(Collectors.toList());
        }
    }

--- 

## 4. 검증 및 테스트: `AssertJ` 활용
- JUnit 5와 AssertJ 라이브러리를 사용하여 구현된 로직이 의도대로 동작하는지 확인함
- hasValueSatisfying: Optional 내부의 객체를 꺼내어 특정 필드값이 일치하는지 정교하게 검증함.
- @Transactional: 테스트 코드에서 DB 연산을 수행한 후 자동으로 롤백하여 테스트 환경을 깨끗하게 유지함.
    ```java
    // CommentServiceTest.java
    @Test
    public void testCreate() {
        CommentDto commentDto = CommentDto.builder()
                .postId(POST_ID)
                .content("[TEST] CommentServiceTest#testCreate()")
                .writer("JUnit")
                .build();

        Optional<CommentDto> commentDtoOptional = commentService.create(commentDto);

        assertThat(commentDtoOptional).isNotEmpty().hasValueSatisfying(savedDto -> {
            assertThat(savedDto).hasFieldOrPropertyWithValue("postId", POST_ID);
            log.info("savedDto = {}", savedDto);
        });
    }