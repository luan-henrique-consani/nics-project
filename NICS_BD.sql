create database NICS;

use NICS;


create table endereco(
id_enderecos int auto_increment primary key,
rua varchar(45),
numero int(45),
bairro varchar(45),
estado varchar(45),
cep varchar(9)
);
create table usuario(
id_usuario int auto_increment primary key,
nome varchar(45),
senha varchar(45),
email varchar(45),
cpf varchar(14),
telefone varchar(13),
fk_endereco int,
foreign key (fk_endereco) references endereco (id_enderecos)  
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
foreign key (fk_categoria) references categorias (id_categoria)
);

create table estoque(
id_estoque int auto_increment primary key,
fk_produtos int,
quantidade int,
variacao varchar(45),
foreign key (fk_produtos) references produtos (id_produtos)
);
Insert into categorias(nome_categoria) values('teclado'),('headset'),('earphone'),('microfone'),('smartwatch'),('cellphone');
DELIMITER $$
CREATE PROCEDURE INSERT_DOIS(
IN pr VARCHAR(45),
IN fk_categoria INT,
IN imagem longblob,
IN preco DECIMAL(10,2), 
IN quantidade INT, 
IN variacao VARCHAR(45)
)
BEGIN
INSERT INTO produtos (nome_produtos, fk_categoria, imagem, preco) VALUES (pr, fk_categoria, imagem, preco);

set @id = (SELECT MAX(id_produtos) FROM produtos);

INSERT INTO estoque (fk_produtos, quantidade, variacao) VALUES (@id, quantidade, variacao);


END$$
DELIMITER ;

create table carrinho(
id_carrinho int auto_increment primary key,
fk_produto int,
fk_usuario int,
foreign key (fk_produto) references produtos (id_produtos),
foreign key (fk_usuario) references usuario (id_usuario)
);

create table pedidos(
id_pedidos int auto_increment primary key,
valor decimal(10,2),
fk_produto int,
data_compra date,
foreign key (fk_produto) references produtos (id_produtos)
);

insert into usuario(nome, senha, email, cpf ,telefone) values ('admin','Admin123','admin@gmail.com','123.123.123-12','43 98765-4321');

select * from usuario;

