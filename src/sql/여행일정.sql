show tables

select *
  from record_tb;
update record_tb
  set picture = 0;
show columns from record_picture_tb

SET FOREIGN_KEY_CHECKS=0

alter table record_tb add PERIOD varchar(100);
insert into record_tb(USER_UID,DEPARTURE_DATE,ARRIVE_DATE,TITLE)
values ("3SeiZsCViyRVLbjMmnXuVEslLHk1",sysdate(),sysdate(),"asd");

insert into record_picture_tb(REALPATH)
values ("3SeiZsCViyRVLbjMmnXuVEslLHk1");

alter table record_tb drop BACKGROUND_NO;

alter table record_tb change FILE_NO int(11) default 0;

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


