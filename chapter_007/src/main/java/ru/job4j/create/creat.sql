create database new_db;

create table users (
	id int primary key,
	login varchar,
	password varchar
);

create table roles (
	id serial primary key,
	role varchar,
);

create table rules (
	id serial primary key,
	rule varchar,
);

create table roles_rules (
  id seriat primary key,
  roles_id int references roles(id),
  rules_id int references roles(id)
);

create table item (
	id int primary key,
	name varchar,
	users_id int references users(id)
);

create table category (
	id int primary key,
	category varchar,
	item_id int references item(id)
);

create table state (
	id int primary key,
	state varchar,
	item_id int references item(id)
);

create table attachs (
	id int primary key,
	file varchar,
	item_id int references item(id)
);

create table comments (
	id int primary key,
	comments text,
	item_id int references item(id)
);

insert into users (id, login, password) values
(1, 'root', 'root'),
(2, 'root', 'root'),
(3, 'root', 'root');

insert into roles (id, role) values
(1, 'administrator', 1),
(2, 'customer', 2);

insert into rules (id, rule) values
(1, 'full access', 1),
(2, 'partial access', 2);

insert into roles_rules (roles_id, rules_id) values
(1, 1),
(2, 2);

insert into item (id, name, users_id) values
(1, 'item1', 1),
(2, 'item1', 2),
(3, 'item2', 3);

insert into state (id, state, item_id) values
(1, 'process', 1),
(2, 'finished', 2);

insert into category (id, category, item_id) values
(1, 'One', 1),
(2, 'Two', 2),
(3, 'Three', 3);

insert into comments (id, comments, item_id) values
(1, 'comment1', 1),
(2, 'comment2', 2),
(3, 'comment2', 3);

insert into attachs (id, file, item_id) values
(1, 'file1', 1),
(2, 'file2', 2);