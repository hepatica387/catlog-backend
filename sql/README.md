# SQL reference

- `schema.sql`: MySQL 8.x table definitions based on the four classes in `src/main/java/com/felia/catlog/domain`.
- `queries.sql`: representative queries for the repository methods and reservation creation.

Select the database named in `DB_URL`, then run `schema.sql` if you need to create the tables manually. The application currently has `spring.jpa.hibernate.ddl-auto=update`, so Hibernate also creates or updates tables at startup. `CREATE TABLE IF NOT EXISTS` does not modify existing tables; compare existing schema before using this file as a migration.

The entity mappings do not declare relationships or foreign keys. `diary_posts.user_id`, `reservations.user_id`, and `reservations.cat_id` are logical references only. `breed_id` and `branch_id` have no corresponding entities in this project. The column name `commnet_count` is intentionally kept as written in `DiaryPost.java`; changing it only in SQL would break the mapping.

Dates on `users` and `cats` are populated by JPA lifecycle callbacks. `diary_posts` has no such callback or write method in the current application. Passwords are encoded by the application before being stored in `users.user_pw`.

## Docker Compose

Run `docker compose up --build -d` from the repository root. The root `docker-compose.yml` mounts this directory's `schema.sql` into the MySQL container. MySQL executes it only when its data volume is empty. `queries.sql` is for reference and is not executed during initialization.
