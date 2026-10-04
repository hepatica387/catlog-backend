# SQL 참고 자료

- `schema.sql`: `src/main/java/com/felia/catlog/domain`의 네 엔티티를 기준으로 작성한 MySQL 8.x 테이블 정의입니다.
- `queries.sql`: 리포지토리 조회와 예약 생성에 관한 예시 쿼리입니다.

테이블을 직접 만들려면 `DB_URL`이 가리키는 데이터베이스를 선택한 뒤 `schema.sql`을 실행하세요. 현재 애플리케이션은 `spring.jpa.hibernate.ddl-auto=update`를 사용하므로 시작할 때 Hibernate도 테이블을 생성하거나 갱신합니다. `CREATE TABLE IF NOT EXISTS`는 기존 테이블을 변경하지 않으므로, 이 파일을 마이그레이션에 사용하기 전에 기존 스키마와 비교하세요.

엔티티 매핑에는 관계나 외래 키가 선언되어 있지 않습니다. `diary_posts.user_id`, `reservations.user_id`, `reservations.cat_id`는 논리적 참조이며, `breed_id`와 `branch_id`에 대응하는 엔티티는 현재 없습니다. `commnet_count`는 `DiaryPost.java`의 열 이름을 그대로 따른 것입니다. SQL에서만 이름을 바꾸면 매핑이 맞지 않게 됩니다.

`users`와 `cats`의 날짜 값은 JPA 생명주기 콜백으로 설정됩니다. 현재 `diary_posts`에는 해당 콜백이나 저장 메서드가 없습니다. 비밀번호는 애플리케이션에서 인코딩한 뒤 `users.user_pw`에 저장합니다.

## Docker 이미지

저장소 루트에서 `docker build -t catlog-mysql -f sql/Dockerfile sql`로 이미지를 빌드합니다. 이 이미지는 `schema.sql`을 MySQL 초기화 디렉터리에 복사합니다. MySQL은 데이터 디렉터리가 비어 있을 때만 이 파일을 실행합니다. 컨테이너 시작 시 `MYSQL_ROOT_PASSWORD`와 `MYSQL_DATABASE`를 설정해야 합니다. `queries.sql`은 참고용이며 초기화 과정에서 실행되지 않습니다.
