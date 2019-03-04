create database new_db;

create table users (
	Request_number int primary key,
	login varchar,
	password varchar
);

create table roles (
	id serial primary key,
	role varchar,
	users_request_number int references users(Request_number)
);

create table rules (
	id serial primary key,
	rule varchar,
	roles_id int references roles(id)
);

create table item (
	id int primary key,
	name varchar,
	users_request_number int references users(Request_number)
);

create table category (
	id int primary key,
	category varchar,
	item_id int references item(id)
);

create table state (
	Request_number int primary key,
	state varchar,
	item_id int references item(id)
);

create table attachs (
	Request_number int primary key,
	file varchar,
	item_id int references item(id)
);

create table comments (
	Request_number int primary key,
	comments text,
	item_id int references item(id)
);

insert into users (request_number, login, password) values
(1, 'root', 'root'),
(2, 'root', 'root'),
(3, 'root', 'root');

insert into roles (id, role, users_request_number) values
(1, 'administrator', 1),
(2, 'customer', 2);

insert into rules (id, rule, roles_id) values
(1, 'full access', 1),
(2, 'partial access', 2);

insert into item (id, name, users_request_number) values
(1, 'item1', 1),
(2, 'item1', 2),
(3, 'item2', 3);

insert into state (request_number, state, item_id) values
(1, 'process', 1),
(2, 'finished', 2);

insert into category (id, category, item_id) values
(1, 'One', 1),
(2, 'Two', 2),
(3, 'Three', 3);

insert into comments (request_number, comments, item_id) values
(1, 'comment1', 1),
(2, 'comment2', 2),
(3, 'comment2', 3);

insert into attachs (request_number, file, item_id) values
(1, 'file1', 1),
(2, 'file2', 2);