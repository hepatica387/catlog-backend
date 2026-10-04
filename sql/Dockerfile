FROM mysql:8.0

# MySQL runs initialization scripts when the data directory is empty.
COPY schema.sql /docker-entrypoint-initdb.d/01-schema.sql
