create database bibliotecaVip
default character set = utf8
default collate = utf8_general_ci;

create table acervo(
id int not null auto_increment primary key,
titulo varchar(40),
autor varchar(50),
ano year
)default charset = utf8;

create table pessoas(
id int not null auto_increment primary key,
nome varchar(50)
)default charset = utf8;

create table alugado(
id int not null auto_increment primary key,
id_livro int,
id_pessoa int
)default charset = utf8;

alter table alugado
add foreign key (id_pessoa)
references pessoas(id);