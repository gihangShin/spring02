select * from all_all_tables;

drop table sns_user;
drop table sns_feeds;
create table sns_user(
	user_id varchar(20) primary key,
	user_pw varchar(20),
	user_realname varchar(20),
	user_nickname varchar(20) unique,
	user_profile_img_route varchar(50),
	user_profile_contents varchar(50),
	user_email varchar(40),
	user_block varchar(10) default 'false'
);

create table sns_feeds(
	feed_num int primary key,
	feed_nickname varchar(20),
	feed_img_route varchar(50),
	feed_contents varchar(200),
	feed_fav int default 0,
	feed_visit int default 0,
	feed_date date,
	constraint feeds_fk1 foreign key(feed_nickname) references sns_user(user_nickname) on delete cascade
);














---------------------------------------------------------
create table message(
	mid int primary key,
	writer varchar(30),
	content varchar(100)
);
select * from message;

create table members(
	id varchar(20) primary key,
	password varchar(20),
	role varchar(30)	
);