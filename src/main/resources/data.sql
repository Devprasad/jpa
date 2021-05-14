/*
//Needed for jdbc
create table person (
id integer not null,
name varchar(255) not null,
location varchar(255),
birthdate timestamp,
primary key(id)
);

insert into person values(10001, 'Dan', 'Bangalore', sysdate());
insert into person values(10002, 'Mec haz', 'New York', sysdate());
insert into person values(10003, 'Gillispe', 'Sydney', sysdate());
*/

insert into person (id, name, location, birthdate) values(10001, 'Dan', 'Bangalore', sysdate());
insert into person (id, name, location, birthdate) values(10002, 'Mec haz', 'New York', sysdate());
insert into person (id, name, location, birthdate) values(10003, 'Gillispe', 'Sydney', sysdate());

