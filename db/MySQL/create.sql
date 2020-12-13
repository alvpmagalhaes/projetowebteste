create database ProjetoWeb1;
show databases;
use ProjetoWeb1;

create table SiteVendaDeIngressos(
    id bigint not null auto_increment,
    nome varchar(256) not null,
    email varchar(64) not null unique,
    senha varchar(64) not null,
    url varchar(64) not null,
    telefone varchar(13),
    primary key (id)
);

insert into SiteVendaDeIngressos(nome, email, senha, url, telefone) values ('Byma', 'byma@byma.com.br', 'byma', 'www.byma.com.br', '(16)4002-8922');

create table SalasDeTeatro(
    id bigint not null auto_increment,
    cnpj varchar(18) not null,
    nome varchar(256) not null,
    email varchar(64) not null unique,
    senha varchar(64) not null,
    cidade varchar(64) not null,
    primary key (id)
);

insert into SalasDeTeatro(cnpj, nome, email, senha, cidade) values ('55.789.390/0008-99', 'Cine São Carlos', 'cinesaocarlos@saocarlos.com.br', 'cinesaocarlos', 'São Carlos');

 create table CadastroPromocoes(
    id bigint not null auto_increment,
    cnpj varchar(18) not null,
    nome_peca varchar(256) not null,
    url varchar(64) not null,
    preco float not null,
    dia varchar(10) not null,
    horario varchar(5) not null,
    primary key (id)
);

show databases;


insert into CadastroPromocoes(cnpj, nome_peca, url, preco, dia, horario) values ('71.150.470/0001-40', 'Cisne Negro', 'www.cinesaocarlos.com.br', 5.00, '13/12/2020', '13:00');