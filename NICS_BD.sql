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
Insert into categorias(nome_categoria) values('teclado'),('headset'),('earphone'),('microfone'),('smartwatch'),('cellphone'),('mouse');
insert into usuario(nome, senha, email, cpf ,telefone) values ('admin','Admin123','admin@gmail.com','123.123.123-12','43 98765-4321');
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

CREATE TABLE carrinho (
    id_carrinho INT AUTO_INCREMENT PRIMARY KEY,
    fk_produto INT,
    fk_usuario INT,
    quantidade INT,
    preco DECIMAL(10,2),
    FOREIGN KEY (fk_produto) REFERENCES produtos (id_produtos),
    FOREIGN KEY (fk_usuario) REFERENCES usuario (id_usuario)
);


CREATE TABLE pedidos (
    id_pedidos INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2),
    fk_usuario INT,
    fk_produtos INT,
    fk_enderecos INT,
    data_compra DATETIME,
    FOREIGN KEY (fk_enderecos) REFERENCES endereco (id_enderecos),
    FOREIGN KEY (fk_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (fk_produtos) REFERENCES produtos (id_produtos)
);

INSERT INTO carrinho (fk_produto, fk_usuario, quantidade, preco) VALUES (2, 3, 2, 400);
INSERT INTO pedidos (valor, fk_usuario, fk_produtos,data_compra) VALUES (400, 3, 2, now());

SELECT
    c.id_carrinho,
    u.nome AS usuario_nome,
    p.nome_produtos AS produto_nome,
    p.imagem,
    c.quantidade,
    c.preco
FROM
    carrinho c
    INNER JOIN usuario u ON c.fk_usuario = u.id_usuario
    INNER JOIN produtos p ON c.fk_produto = p.id_produtos where u.id_usuario = 2;


SELECT
    pe.id_pedidos,
    u.nome AS usuario_nome,
	p.imagem,
    pe.valor,
    pe.data_compra,
    e.rua,
    e.numero
FROM
    pedidos pe
    INNER JOIN usuario u ON pe.fk_usuario = u.id_usuario
    INNER JOIN endereco e ON pe.fk_enderecos = e.id_enderecos
	INNER JOIN produtos p ON pe.fk_produto = p.id_produtos  where u.id_usuario = 2;


SELECT SUM(p.preco * c.quantidade) AS total FROM produtos p INNER JOIN carrinho c ON p.id_produtos = c.fk_produto INNER JOIN usuario u ON c.fk_usuario = u.id_usuario where u.id_usuario = 2;
select * from usuario;

select * from produtos;

select * from estoque;

SELECT * FROM usuario WHERE id_usuario = 2;
select * from carrinho;

drop table pedidos;
drop database nics;