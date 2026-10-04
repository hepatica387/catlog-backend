-- MySQL 8.x용 스키마입니다. 실행 전에 대상 데이터베이스를 선택하세요.
-- 현재 JPA 엔티티 매핑을 따르며, 엔티티에 외래 키가 선언되어 있지 않습니다.

CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    user_pw VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    birth_day DATE NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    PRIMARY KEY (user_id),
    UNIQUE KEY uk_users_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS cats (
    cat_id VARCHAR(50) NOT NULL,
    breed_id INT NOT NULL,
    name VARCHAR(15) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    age_month TINYINT NOT NULL,
    color VARCHAR(30) NOT NULL,
    weight SMALLINT NOT NULL,
    personality TEXT NOT NULL,
    health_status TEXT NULL,
    adoption_status VARCHAR(1) NOT NULL,
    main_img_url VARCHAR(255) NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NULL,
    PRIMARY KEY (cat_id),
    KEY idx_cats_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS diary_posts (
    post_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    title VARCHAR(200) NOT NULL,
    content TEXT NULL,
    category VARCHAR(30) NOT NULL,
    thumbnail_img VARCHAR(255) NOT NULL,
    view_count INT NOT NULL,
    like_count INT NOT NULL,
    commnet_count INT NOT NULL,
    is_public TINYINT(1) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (post_id),
    KEY idx_diary_posts_public_created (is_public, created_at, post_id),
    KEY idx_diary_posts_user_created (user_id, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS reservations (
    reservation_id INT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    branch_id VARCHAR(20) NOT NULL,
    cat_id VARCHAR(50) NULL,
    reservation_date DATE NOT NULL,
    reservation_time TIME(6) NOT NULL,
    purpose VARCHAR(30) NOT NULL,
    status VARCHAR(20) NOT NULL,
    memo VARCHAR(255) NULL,
    PRIMARY KEY (reservation_id),
    KEY idx_reservations_user_time (user_id, reservation_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
