INSERT INTO cozinha (nome) VALUES ('Tailandesa');
INSERT INTO cozinha (nome) VALUES ('Indiana');
INSERT INTO cozinha (nome) VALUES ('Brasileira');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (descricao) values ('Boleto');

insert into permissao (nome, descricao) values ('administrador', 'permissão total no sistema');

insert into estado (nome) values ('Amapá');
insert into estado (nome) values ('Pará');
insert into estado (nome) values ('Amazonas');

insert into cidade (nome, estado_id) values ('Macapá', 1);
insert into cidade (nome, estado_id) values ('Santana', 1);
