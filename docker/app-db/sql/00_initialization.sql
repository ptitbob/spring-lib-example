drop table if exists person;
drop sequence if exists person_sequence;

create sequence person_sequence start 100 cache 10;

create table person (
  id bigint not null default nextval('person_sequence'),
  login varchar(100) not null,
  firstname varchar(100),
  lastname varchar(100),
  creator varchar(100) ,
  created timestamp ,
  modificator varchar(100),
  modified timestamp
);

drop table if exists adm_message;
drop sequence if exists adm_message_sequence;

create sequence adm_message_sequence start 100 cache 10;

create table adm_message (
  adm_message_id bigint not null default nextval('adm_message_sequence') primary key ,
  code varchar(10) not null,
  message varchar(100)
);

INSERT INTO person (login, firstname, lastname, creator, created)
  VALUES ('turing-a', 'Alan', 'Turing', 'lui', now());
INSERT INTO adm_message (code, message) VALUES ('TOT', 'la tête a toto');
