FROM mysql:8.0

# MySQL은 데이터 디렉터리가 비어 있을 때 초기화 스크립트를 실행합니다.
COPY schema.sql /docker-entrypoint-initdb.d/01-schema.sql
