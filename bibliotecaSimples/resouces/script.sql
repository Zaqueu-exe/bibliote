create database biblioteca1
default character set utf8
default collate utf8_general_ci;

create table livros(
id int not null auto_increment primary key,
titulo varchar(30),
autor varchar(30)
)default charset = utf8;

create table pessoas(
id int not null auto_increment primary key,
nome varchar(30)
)default charset = utf8;