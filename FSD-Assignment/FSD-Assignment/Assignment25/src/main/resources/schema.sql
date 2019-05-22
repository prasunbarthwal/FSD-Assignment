
create table subject
(
   subject_id long not null,
   sub_title varchar(255) not null,
   duration_in_hrs integer not null,
   primary key(subject_id),


);
create table book
(
   book_id long not null,
   title varchar(255) not null,
   price double not null,
   volume integer not null,
   pub_date timestamp not null,
   subject_id long not null,
   primary key(book_id),
   FOREIGN KEY(subject_id) REFERENCES subject(subject_id)
);
