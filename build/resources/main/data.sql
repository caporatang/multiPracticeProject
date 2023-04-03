-- call next value for hibernate_sequence; --> 아이디 자동 생성 전략 변경으로 생성해주면안됨.
insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'taeil', 'taeil@naver.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'capo', 'capo@naver.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@fastcampus.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@fastcampus.com', now(), now());

insert into member(`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'taeil', 'taeil@fastcampus.com', now(), now());

insert into publisher(`id`, `name`) values (1, '책 출판사');

insert into book(`id`, `name`, `publisher_id`, `deleted`) values (1, 'JPA 111', 1, false);

insert into book(`id`, `name`, `publisher_id`, `deleted`) values (2, 'JPA 222', 1, false);

insert into book(`id`, `name`, `publisher_id`, `deleted`) values (3, 'JPA 333', 1, true);