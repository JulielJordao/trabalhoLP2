create database if not exists lanchonete;

use lanchonete;

create table if not exists lanche (
cod_lanche int (11) not null auto_increment primary key
, cod_promocao int (2) 
, nom_lanche varchar (50) not null
, val_lanche decimal (3,2)
);

create table if not exists promocao(
cod_promocao int (2) not null auto_increment primary key
, val_desconto int (2) 
);

create table if not exists acompanhamento(
cod_acomp int (11) not null auto_increment primary key
, cod_promocao int (2) 
, nom_acomp varchar(50) not null
, val_acomp decimal(3,2) );

create table if not exists bebida(
cod_bebida int (11) not null auto_increment primary key
, cod_promocao int (2)
, nom_bebida varchar (50) not null
, val_bebida decimal(3,2)
);

create table if not exists itemPedido(
cod_itemPedido int (11) not null auto_increment primary key
, tipo varchar(15)
, cod_pedido int (11) not null 
, cod_item int (11)
, val_item decimal (3,2)
);

create table if not exists pedido(
cod_pedido int (11) not null primary key
, val_pedido decimal(5,2) 
, dat_pedido datetime
, cod_desconto int (2) null
);

alter table lanche
add foreign key (cod_promocao)
references promocao(cod_promocao); 

alter table bebida
add foreign key (cod_promocao)
references promocao(cod_promocao);

alter table acompanhamento
add foreign key (cod_promocao)
references promocao(cod_promocao);

alter table pedido
add foreign key (cod_desconto)
references promocao(cod_promocao);

insert into promocao(cod_promocao, val_desconto)
values (1, 20);

insert into promocao (cod_promocao, val_desconto)
values (2, 15);

insert into promocao (cod_promocao, val_desconto)
values (3, 0);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('Torrada', null, 2.00);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values  ('Misto Quente', null, 2.5);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('X Burger', 1, 3.50);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('X Egg', 1, 4.50);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('Pizza calabresa pequena', 2, 13.00);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('Pizza calabresa média', 2, 17.00);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('Pizza moda da casa pequena', 2, 15.00);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('Pizza moda da casa média', 2, 18.00);

insert into lanche(nom_lanche, cod_promocao, val_lanche)
values ('X Tudo', null, 7.0);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Água mineral 1 l', null, 3.20);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Refrigerante coca-cola 250 ml', 1, 2.50);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Refrigerante coca-cola 1l', 2, 3.40);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Refrigerante coca-cola 2l', 2, 4.50);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Suco pessego 250 ml', null, 1.70);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Suco mangá 250 ml', null, 1.60);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Refrigerante guaraná 250 ml', 1, 2.50);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Refrigerante guaraná 1l', 2, 3.40);

insert into bebida(nom_bebida, cod_promocao, val_bebida)
values ('Refrigerante guaraná 2l', 2, 4.50);

insert into acompanhamento(nom_acomp, cod_promocao, val_acomp)
values ('Batata frita', 1, 3.40);

insert into acompanhamento(nom_acomp, cod_promocao, val_acomp)
values ('Beijinho', 2, 5.00);

insert into acompanhamento(nom_acomp, cod_promocao, val_acomp)
values ('Aipim frito', 1, 6.00);

insert into acompanhamento(nom_acomp, cod_promocao, val_acomp)
values ('Frutas com chocolate', 2, 8.00);

insert into acompanhamento(nom_acomp, cod_promocao, val_acomp)
values ('Porção de frios', null, 9.00);

insert into pedido(val_pedido, dat_pedido)
values(0,now());



 




