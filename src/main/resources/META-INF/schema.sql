--create database patrimonio;

--show databases;

--use patrimonio;
create table patrimonio (
     id int not null primary key auto_increment,
     descricao varchar(80),
     localizacao varchar(80)
);

insert into patrimonio(descricao,localizacao)
    values ('Computador IMAC', 'Sala 502 - prédio principal');

select * from patrimonio;


