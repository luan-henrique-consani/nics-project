create database NICS;

use NICS;

create table usuario(
id_usuario int auto_increment primary key,
nome varchar(45),
senha varchar(45),
email varchar(45),
cpf varchar(14),
telefone varchar(14)
);

create table endereco(
id_enderecos int auto_increment primary key,
rua varchar(45),
numero int(45),
bairro varchar(45),
estado varchar(45),
cep varchar(9),
fk_usuario int,
foreign key (fk_usuario) references usuario (id_usuario)  
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
    data_compra DATETIME,
    FOREIGN KEY (fk_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (fk_produtos) REFERENCES produtos (id_produtos)
);

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
    
DELIMITER $$
CREATE PROCEDURE DELETE_QUATRO(
IN id INT
)
BEGIN
delete from produtos where id_produtos = id;
delete from estoque where fk_produtos = id;
delete from carrinho where fk_produto = id;
delete from pedidos where fk_produtos = id;
END$$
DELIMITER ;


DELIMITER $$

CREATE PROCEDURE InsertEnderecoEPedido (
    IN p_rua VARCHAR(45),
    IN p_numero INT,
    IN p_bairro VARCHAR(45),
    IN p_estado VARCHAR(45),
    IN p_cep VARCHAR(9),
    IN p_fk_usuario INT
)
BEGIN

    INSERT INTO endereco (rua, numero, bairro, estado, cep, fk_usuario)
    VALUES (p_rua, p_numero, p_bairro, p_estado, p_cep, p_fk_usuario);


    INSERT INTO pedidos (
        valor,
        fk_usuario,
        fk_produtos,
        data_compra
    )
    SELECT
        c.preco * c.quantidade,
        c.fk_usuario,
        c.fk_produto,
        NOW()
    FROM
        carrinho c
    WHERE
        c.fk_usuario = p_fk_usuario;

    -- Remover itens do carrinho após a inserção no pedidos
    DELETE FROM carrinho WHERE fk_usuario = p_fk_usuario;
END $$

DELIMITER ;


select * from pedidos;
drop trigger compras;
DELETE FROM carrinho WHERE id_carrinho = 10;
