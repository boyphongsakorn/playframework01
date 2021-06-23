# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tbIphone (
  name                      varchar(20) not null,
  scrsize                   varchar(50),
  ram                       varchar(50),
  storsize                  varchar(50),
  price                     integer,
  ramname_ramid             varchar(20),
  constraint pk_tbIphone primary key (name))
;

create table tbRamtype (
  ramid                     varchar(20) not null,
  ramsize                   varchar(50),
  ramby                     varchar(50),
  constraint pk_tbRamtype primary key (ramid))
;

alter table tbIphone add constraint fk_tbIphone_ramname_1 foreign key (ramname_ramid) references tbRamtype (ramid) on delete restrict on update restrict;
create index ix_tbIphone_ramname_1 on tbIphone (ramname_ramid);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table tbIphone;

drop table tbRamtype;

SET FOREIGN_KEY_CHECKS=1;

