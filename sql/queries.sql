-- 현재 리포지토리와 서비스 메서드에 대응하는 예시 쿼리입니다.
-- 직접 실행할 때는 아래 세션 변수를 실제 존재하는 ID로 바꾸세요.
SET @user_id = 'example-user';
SET @cat_id = 'example-cat';

-- MemberRepository: 중복 확인, 로그인, 회원 정보 조회.
SELECT EXISTS(SELECT 1 FROM users WHERE user_id = @user_id) AS user_id_exists;
SELECT EXISTS(SELECT 1 FROM users WHERE email = 'example@example.com') AS email_exists;
SELECT * FROM users WHERE user_id = @user_id;
-- 비밀번호 비교는 Java에서 저장된 인코딩 비밀번호를 대상으로 수행합니다.

-- CatRepository: 전체 고양이, 최근 등록된 고양이 7마리, ID 존재 여부 조회.
SELECT * FROM cats;
SELECT * FROM cats ORDER BY created_at DESC LIMIT 7;
SELECT EXISTS(SELECT 1 FROM cats WHERE cat_id = @cat_id) AS cat_id_exists;

-- DiaryPostRepository: 공개 게시글과 회원별 게시글 조회.
SELECT * FROM diary_posts
WHERE is_public = 1
ORDER BY created_at DESC, post_id DESC;

SELECT * FROM diary_posts
WHERE user_id = @user_id
ORDER BY created_at DESC;

-- ReservationRepository: 애플리케이션은 날짜와 관계없이 시간만 기준으로 정렬합니다.
SELECT * FROM reservations
WHERE user_id = @user_id
ORDER BY reservation_time DESC;

-- ReservationService: 새 예약의 초기 상태는 PENDING입니다.
-- 애플리케이션은 user_id와 cat_id의 존재 여부 및 예약 시간이 미래인지 확인합니다.
-- INSERT INTO reservations
--     (user_id, branch_id, cat_id, reservation_date, reservation_time, purpose, status, memo)
-- VALUES
--     (@user_id, 'branch-1', @cat_id, '2026-12-01', '14:00:00', 'VISIT', 'PENDING', NULL);
