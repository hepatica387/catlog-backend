# FELIA CATLOG Backend

Java 21과 Spring Boot 3.5 기반 백엔드입니다. 데이터베이스로 MySQL 8을 사용합니다.

## 로컬 실행

MySQL 데이터베이스를 준비하고 아래 환경 변수를 설정합니다.

| 변수 | 예시 |
| --- | --- |
| `DB_URL` | `jdbc:mysql://localhost:3306/catlog` |
| `DB_USER` | `root` |
| `DB_PASSWORD` | MySQL 비밀번호 |

```bash
./gradlew bootRun
```

Windows에서는 `./gradlew` 대신 `gradlew.bat`을 사용합니다. 애플리케이션은 기본적으로 8080 포트에서 실행됩니다. JPA의 `ddl-auto=update` 설정으로 시작 시 테이블을 생성하거나 갱신합니다.

## 테스트

```bash
./gradlew test
```

`contextLoads()` 테스트는 `test` 프로필의 H2 인메모리 데이터베이스를 사용하므로 실행 중인 MySQL이나 `DB_*` 환경 변수가 필요하지 않습니다. GitHub Actions에서도 같은 Gradle 테스트를 실행합니다.

## Docker 이미지

저장소 루트에서 애플리케이션 이미지와 SQL 이미지를 각각 빌드할 수 있습니다.

```bash
docker build -t catlog-backend .
docker build -t catlog-mysql -f sql/Dockerfile sql
```

`catlog-backend` 컨테이너에는 `DB_URL`, `DB_USER`, `DB_PASSWORD`를 전달해야 합니다. `catlog-mysql` 이미지는 비어 있는 MySQL 데이터 디렉터리로 처음 시작할 때 `sql/schema.sql`을 실행합니다. MySQL 컨테이너 시작 시 `MYSQL_ROOT_PASSWORD`와 `MYSQL_DATABASE`도 설정해야 합니다. SQL 파일의 용도는 [sql/README.md](sql/README.md)에 정리되어 있습니다.
