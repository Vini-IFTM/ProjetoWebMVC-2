create database dbContatos;

use dbContatos;

create table tb_contato(nome varchar(255), email varchar(255) primary key, senha varchar(50), numero varchar(25));

insert into tb_contato values ('Carlos Eduardo', 'carloseduardodantas@iftm.edu.br', 'Carlos123456', '999999999');

insert into tb_contato values ('angoti@iftm.edu.br','Edson Angoti', 'Edson123456', '999999999');

select nome, email, senha, numero from tb_contato;