-- call next value for hibernate_sequence; --> 아이디 자동 생성 전략 변경으로 생성해주면안됨.
insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'taeil', 'taeil@naver.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'capo', 'capo@naver.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@fastcampus.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@fastcampus.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'taeil', 'taeil@fastcampus.com', now(), now());

insert into publisher(`id`, `name`, `created_at`, `updated_at`) values (1, '책 출판사', now(), now());

insert into book(`id`, `name`, `publisher_id`, `deleted`, `created_at`, `updated_at`, `category`, `status`) values (1, 'JPA 111', 1, false, now(), now(), '개발IT', 100);
insert into book(`id`, `name`, `publisher_id`, `deleted`, `created_at`, `updated_at`, `category`, `status`) values (2, 'JPA 222', 1, false, now(), now(), '개발IT', 200);
insert into book(`id`, `name`, `publisher_id`, `deleted`, `created_at`, `updated_at`, `category`, `status`) values (3, 'JPA 333', 1, true, now(), now(), '개발IT', 100);

insert into review(`id`, `title`, `content`, `score`, `member_id`, `book_id`, `created_at`, `updated_at`) values (1, '리뷰의 테스트', '짱 좋음 ~ ', 5.0, 1, 1, now(), now());
insert into review(`id`, `title`, `content`, `score`, `member_id`, `book_id`, `created_at`, `updated_at`) values (2, '두번째 리뷰의 테스트', '짱 싫음', 3.0, 2, 2, now(), now());

insert into comment(`id`, `comment`, `review_id`, `created_at`, `updated_at`) values (1, '나는 1번 리뷰의 댓글 1', 1, now(), now());
insert into comment(`id`, `comment`, `review_id`, `created_at`, `updated_at`) values (2, '나는 1번 리뷰의 댓글 2', 1, now(), now());

insert into comment(`id`, `comment`, `review_id`, `created_at`, `updated_at`) values (3, '나는 2번 리뷰의 댓글 1', 2, now(), now());

