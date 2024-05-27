create database NICS;

use NICS;

create table usuario(
id_usuario int auto_increment primary key,
nome varchar(45),
senha varchar(45),
email varchar(45),
cpf varchar(14),
telefone varchar(13)
);

create table categorias(
id_categoria int auto_increment primary key,
nome_categoria varchar(45)
);

create table produtos(
id_produtos int auto_increment primary key,
nome_produtos varchar(45),
fk_categoria int,
imagem longblob,
preco decimal(10,2),
quantidade int,
foreign key (fk_categoria) references categorias (id_categoria)
);

create table estoque(
id_estoque int auto_increment primary key,
fk_produtos int,
fk_usuario int,
quantidade int,
variacao varchar(45),
foreign key (fk_produtos) references produtos (id_produtos)
);
Insert into categorias(nome_categoria) values ('teclado'),('tenis');
DELIMITER $$
CREATE PROCEDURE INSERT_DOIS(IN nome_produtos VARCHAR(45),IN fk_categoria INT, IN preco DECIMAL, 
IN quantidade INT, IN variacao VARCHAR(45))
BEGIN
INSERT INTO produtos (nome_produtos, fk_categoria, preco) VALUES ('tenis', 2, 444.99);

set @id = (SELECT MAX(id_produtos) FROM produtos);

INSERT INTO estoque (fk_produtos, quantidade, variacao) VALUES (@id, 45, 'azul');


END$$
DELIMITER ;
drop procedure insert_dois;
select * from produtos;
select * from estoque;






