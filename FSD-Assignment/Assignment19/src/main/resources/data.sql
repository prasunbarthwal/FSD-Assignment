insert into subject
values(1,'Computers',10);
insert into subject
values(2,'Technology',20);


commit;

insert into book
values(1,'Java 1.8', 10.01,01,CURRENT_TIMESTAMP,1);
insert into book
values(2,'Spring', 100.02,02,CURRENT_TIMESTAMP-1,2);
commit;
