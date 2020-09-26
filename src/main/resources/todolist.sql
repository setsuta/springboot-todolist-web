create database todolist;

use todolist;

create table tduser
(
	uid int primary key auto_increment,
	username varchar(50) not null unique,
	password varchar(50) not null,
	name varchar(50) not null,
	coin int default 0
)default charset=utf8;

create table tdarchive
(
	uid 		 int not null,
	literature 		 varchar(50),
	math		 varchar(50),
	english 	 varchar(50),
	other 		 varchar(50),
	date date not null
)default charset=utf8;

alter table tdarchive add constraint FK_uid_archive foreign key (uid)
      references tduser (uid) on update restrict;
     

create table taskhistory
(
	uid int not null,
	tid int not null,
	status char(1),
	date date not null
)default charset=utf8;

create table tdtask
(
	tid int primary key auto_increment,
	name varchar(50) not null,
	describe varchar(50) not null,
	coin int not null
)default charset=utf8;

alter table taskhistory add constraint FK_uid_taskhistory foreign key (uid)
      references tduser (uid) on update restrict;
alter table taskhistory add constraint FK_tid_taskhistory foreign key (tid)
      references tdtask (tid) on update restrict;

     
create table tdgrade
(
	uid int not null,
	mid int,
	midstatus char(1),
	cid int,
	date date not null
)default charset=utf8;


create table tdachievement
(
	cid int primary key auto_increment,
	name varchar(50) not null,
	describe varchar(50),
	image varchar(50)
)default charset=utf8;


create table tdmall
(
	mid int primary key auto_increment,
	name varchar(50) not null,
	describe varchar(50) not null,
	image varchar(50),
	price int not null
)default charset=utf8;


alter table tdgrade add constraint FK_uid_grade foreign key (uid)
      references tduser (uid) on update restrict;
alter table tdgrade add constraint FK_mid_grade foreign key (mid)
      references tdmall (mid) on update restrict;
alter table tdgrade add constraint FK_cid_grade foreign key (cid)
      references tdachievement (cid) on update restrict;



