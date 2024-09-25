-- We want some data in this file
-- We gotta only mention sql query

insert into Student (id, name, marks) values(2, 'studentTwo', 90);
--marks in H2 is 95 and postgres it is 75 for id =2
-- For adding postgres only chaqnge pom.xml to connect to postgres to switch DMS from H2 to postgres.
insert into Student (id, name, marks) values(3,'studentThree', 95);
-- insert into Student (id, name, marks) values(4, 'studentFour', 90);
-- - added 4 as the first element in JdcbEgApplication setIdetc.
insert into Student (id, name, marks) values(1,'studentFour', 96);

