show tables

show columns from tour_comment_tb

select * from record_travelPrice_tb

select * from record_schedulememo_tb;

select * from record_location_tb

delete
  from record_travelPrice_tb

alter table record_schedulememo_tb add LOCATION_NO int

delete from record_travelPrice_tb

alter table record_travelPrice_tb  add LOCATION_NO int

select sum(price) from record_travelPrice_tb where record_no = 92;

SELECT *, COALESCE((SELECT SUM(PRICE) FROM RECORD_TRAVELPRICE_TB RT WHERE RT.RECORD_NO = R.RECORD_NO AND RECORD_NO = 92),0) AS BUDGET
  FROM RECORD_TB R
 WHERE R.RECORD_NO = 92;

 alter table record_tb add BUDGET int default 0
 
delete
  from record_travelPrice_tb

select * from record_location_liked_tb
SELECT COUNT(*)
		  FROM RECORD_SCHEDULEMEMO_TB
		 WHERE CONTENTID = 692908

create table record_location_comment_tb (
	COMMENT_NO int primary key auto_increment,
	CONTENT_ID int not null,
	USER_UID varchar(100) not null,
	CONTENT varchar(1000) not null,
	REG_DATE TIMESTAMP default now()
);		 

drop table record_location_comment_tb
		 
select * from record_location_tb;
select * from record_schedulememo_tb
select * from record_location_liked_tb where USER_UID = #{userUid}

select * from public_code_tb where group_code_no = 'chat_areacode'

select * from record_tb

select * from record_comment_tb order by comment_no desc

delete
  from record_scheduleMemo_like_tb
  
select *,COALESCE((select count(*) from record_schedulememo_tb rs where rs.contentId = rl.content_Code),0) post_cnt,
		 COALESCE((select count(*) from record_location_liked_tb rll where rl.content_code = rll.content_code),0) like_cnt
  from record_location_liked_tb rl
create table record_comment_tb (
	COMMENT_NO int primary key auto_increment,
	RECORD_NO int not null,
	USER_UID varchar(100) not null,
	CONTENT varchar(1000) not null,
	REG_DATE TIMESTAMP default now()
);

select *,(select title from record_location_tb rl where rl.content_code = rs.contentid) location_Title,
         (select title from record_tb r where r.record_no = rs.record_no) record_title
  from record_scheduleMemo_tb rs;
  
  
select * from record_scheduleMemo_like_tb

update record_scheduleMemo_tb
   set memo_type = 1;
   
select * from record_location_tb;
create table record_scheduleMemo_tb (
	SCHEDULEMEMO_NO int primary key auto_increment,
	RECORD_NO int,
	USER_UID varchar(100),
	TITLE varchar(1000),
	CONTENT mediumtext,
	REG_DATE TIMESTAMP default now()
);

create table record_scheduleMemo_like_tb (
	like_no int primary key auto_increment,
	SCHEDULEMEMO_NO int not null,
	USER_UID varchar(100) not null
);

alter table record_scheduleMemo_tb add CONTENTID int;

select *  from board_bookmark_tb where target_type = 3

select * from record_tb

select * from record_schedule_tb

delete  from record_cover_tb;
delete  from record_like_tb;
delete  from record_location_like_tb;

select *, COALESCE((select PHOTO_URL from user_tb u where u.user_uid = c.user_uid), 0) PHOTOURL,
          COALESCE((select DISPLAY_NAME from user_tb u where u.user_uid = c.user_uid), 0) DISPLAYNAME
  from record_comment_tb c

select * from record_customizing_tb

select *, COALESCE((SELECT COUNT(*) FROM RECORD_LIKE_TB RL WHERE RL.RECORD_NO = R.RECORD_NO), 0) LIKE_CNT,
		  COALESCE((SELECT COUNT(*) FROM RECORD_COMMENT_TB RC WHERE RC.RECORD_NO = R.RECORD_NO), 0) COMMENT_CNT
          from user_tb u, record_tb r
         where ISOPEN = 1
           and u.user_uid = r.user_uid

alter table record_customizing_tb add AFTER_RECORD_NO int;           
           
create table record_customizing_tb (
	user_uid varchar(100),
	record_no int,
	reg_date TIMESTAMP default now()
);

select * from board_like_tb
select * from public_data_list_tb

select * from record_tb

select *
  from user_tb u, record_tb r
 where ISOPEN = 1
   and u.user_uid = r.user_uid

select count(record_no) from record_tb

select * from emoticon_tb

update user_tb
   set photo_url = 'http://14.32.66.104:8081/images?path=upload/images/profile/profile-65992d6d-3709-4392-b115-ba0b32ddfc86.jpg'
 
 

select * from user_photo_tb


 http://14.32.66.104:8081/images?path=upload/images/profile/profile-d5563be7-e2b2-49ab-8cb5-689875403b84.jpg 

select * from record_location_tb
create table record_location_tb(
	LOCATION_NO int(11) primary key auto_increment,
	RECORD_NO int(11) not null,	
	TITLE varchar(500),
	CONTENT_CODE int(11),
	IMAGE_URL varchar(1000),
	REG_DATE TIMESTAMP
);

create table record_location_liked_tb (
	CONTENT_CODE int(11),
	USER_UID varchar(100)
);

select *
  from record_location_liked_tb

  select * from record_tb;
select * from record_location_tb


select * from record_cover_tb

alter table record_location_tb add DDATE varchar(50);
alter table record_location_tb change MAPX MAPX double(13,10);
alter table record_location_tb change DEPARTUREDATE DEPARTURE_DATE varchar(50)
alter table record_location_tb change DETAIL_DEPARTUREDATE DETAIL_DEPARTURE_DATE varchar(50)

alter table record_tb add TARGET_TYPE varchar(3) default '3';
select *
  from record_tb;
update record_tb
  set picture = 0;
show columns from board_bookmark_tb

SET FOREIGN_KEY_CHECKS=0

select *
  from record_schedule_tb

select *
  from record_tb
alter table record_tb add PERIOD varchar(100);
insert into record_tb(USER_UID,DEPARTURE_DATE,ARRIVE_DATE,TITLE)
values ("3SeiZsCViyRVLbjMmnXuVEslLHk1",sysdate(),sysdate(),"asd");

insert into record_picture_tb(REALPATH)
values ("3SeiZsCViyRVLbjMmnXuVEslLHk1");

alter table record_tb drop BACKGROUND_NO;

alter table record_tb change FILE_NO int(11) default 0;

alter table record_tb add STRAPLINE varchar(300) default "";
alter table record_tb add INTRODUCE varchar(500) default "";

alter table record_schedule_tb add contentCode int(10) default 0;
delete  from record_tb

alter table record_cover_tb change FILE_PATH FILE_PATH varchar(20000);

select * 
		  from record_tb
		 where USER_UID = '3SeiZsCViyRVLbjMmnXuVEslLHk1';
		 
select * from record_cover_tb;

delete from record_cover_tb;
		 
create table record_cover_tb(
	COVER_NO int(11) primary key auto_increment,
	RECORD_NO int(11),
	REAL_PATH varchar(200),
	FILE_PATH varchar(20000),
	ORI_NAME varchar(200),
	FILE_NAME varchar(200)
);

select c.USER_UID, c.CHAT_USER_INFO_NO, c.CHAT_ROOM_INFO_NO, u.DISPLAY_NAME, u.PHOTO_URL
  from user_tb u, (select * 
                     from chat_user_info_tb
                    where CHAT_ROOM_INFO_NO = 1) c
 where c.user_uid = u.user_uid
   
 select * from public_code_tb

select * 
  from chat_user_info_tb
 where CHAT_ROOM_INFO_NO = 1
delete from chat_user_info_tb
 delete  from chat_user_info_tb where user_uid = "lacdY77IMXcYfrWNoeBnm0WhTKF2"
select * from user_tb
select * from chat_room_info_tb

delete from chat_user_info_tb
select * from chat_user_info_tb
select * from public_code_tb


select *,(select title from record_location_tb rl where rl.content_code = rs.contentid) LOCATION_TITLE,
                 (select title from record_tb r where r.record_no = rs.record_no) RECORD_TITLE,
                 (select count(*) from record_scheduleMemo_comment_tb rsc where rs.scheduleMemo_no = rsc.scheduleMemo_no) COMMENT_CNT,
                 COALESCE((select PHOTO_URL from user_tb u where u.user_uid = rs.user_uid), 0) PHOTO_URL,
                 COALESCE((select DISPLAY_NAME from user_tb u where u.user_uid = rs.user_uid), 0) DISPLAY_NAME,
                 COALESCE((select count(*) from record_scheduleMemo_like_tb rsl where rsl.SCHEDULEMEMO_NO = rs.SCHEDULEMEMO_NO),0) LIKE_CNT,
                 COALESCE((select count(*) from record_scheduleMemo_like_tb rsl where rsl.SCHEDULEMEMO_NO = rs.SCHEDULEMEMO_NO and rsl.USER_UID = rs.USER_UID),0) ISLIKE
  from record_scheduleMemo_tb rs
  
  
  select *, COALESCE((select count(*) from record_schedulememo_tb rs where rs.contentId = rl.content_Code),0) post_cnt,
		          COALESCE((select count(*) from record_location_liked_tb rll where rl.content_code = rll.content_code),0) like_cnt,
		          COALESCE((select count(*) from RECORD_BACKLOCATIONLIKE_TB rb where rl.content_code = rb.content_code),0) BACK_LIKE_CNT
          from record_location_liked_tb rl
          
  
  select r.record_no,r.user_uid,r.departure_date,r.arrive_date,r.title,r.budget,r.picture,r.period,r.strapline,r.introduce,r.reg_date,r.isopen,u.photo_url,u.display_name, COALESCE((SELECT COUNT(*) FROM RECORD_LIKE_TB RL WHERE RL.RECORD_NO = r.RECORD_NO), 0) LIKE_CNT,
		          COALESCE((SELECT COUNT(*) FROM RECORD_COMMENT_TB RC WHERE RC.RECORD_NO = R.RECORD_NO), 0) COMMENT_CNT
          from user_tb u, record_tb r
         where ISOPEN = 1
           and u.user_uid = r.user_uid
           and date(r.reg_date) >= date(subdate(now(), INTERVAL 3 DAY))
           and date(r.reg_date) <= date(now())
         order by r.reg_date desc

         
 create table record_travelPrice_tb (
 	TRAVELPRICE_NO INT PRIMARY KEY AUTO_INCREMENT,
 	RECORD_NO INT,
 	CONTENTID INT,
 	USER_UID VARCHAR(100),
 	CONTENT VARCHAR(1000),
 	TRAVEL_PRICE INT,
 	PRICE_TYPE INT,
 	LOCATION_NO int,
 	SCHEDULEMEMO_NO int
 );
 
 drop table record_travelPrice_tb
 
 show tables
 
 select * from record_schedulememo_tb