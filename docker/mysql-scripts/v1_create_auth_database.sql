create database if not exists sync_auth;

use sync_auth;

create table if not exists _user(
    id bigint auto_increment not null,
    first_name varchar(100),
    last_name varchar(100),
    email varchar(100),
    password varchar(100),

    primary key (id)
);
