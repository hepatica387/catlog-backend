-- Representative SQL for the current repository/service methods.
-- Set these session variables to existing IDs when running examples manually.
SET @user_id = 'example-user';
SET @cat_id = 'example-cat';

-- MemberRepository: duplicate checks, login, and profile lookup.
SELECT EXISTS(SELECT 1 FROM users WHERE user_id = @user_id) AS user_id_exists;
SELECT EXISTS(SELECT 1 FROM users WHERE email = 'example@example.com') AS email_exists;
SELECT * FROM users WHERE user_id = @user_id;
-- Password comparison is performed in Java against the stored encoded user_pw.

-- CatRepository: all cats, seven most recently created, and ID existence.
SELECT * FROM cats;
SELECT * FROM cats ORDER BY created_at DESC LIMIT 7;
SELECT EXISTS(SELECT 1 FROM cats WHERE cat_id = @cat_id) AS cat_id_exists;

-- DiaryPostRepository: public posts and a member's posts.
SELECT * FROM diary_posts
WHERE is_public = 1
ORDER BY created_at DESC, post_id DESC;

SELECT * FROM diary_posts
WHERE user_id = @user_id
ORDER BY created_at DESC;

-- ReservationRepository: the application sorts by time only, across all dates.
SELECT * FROM reservations
WHERE user_id = @user_id
ORDER BY reservation_time DESC;

-- ReservationService: new reservations start with status PENDING.
-- The application checks that user_id/cat_id exist and the requested time is in the future.
-- INSERT INTO reservations
--     (user_id, branch_id, cat_id, reservation_date, reservation_time, purpose, status, memo)
-- VALUES
--     (@user_id, 'branch-1', @cat_id, '2026-12-01', '14:00:00', 'VISIT', 'PENDING', NULL);
