create table if not exists items (
   id varchar primary key,
   name varchar,
   description varchar,
   created double precision,
   comments text
);