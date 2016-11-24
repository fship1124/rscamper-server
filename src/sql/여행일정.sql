show tables

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
select *
  from record_tb;
update record_tb
  set picture = 0;
show columns from USER_TB

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