CREATE TABLE usuarios(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(50) NOT NULL
);

INSERT INTO usuarios(nome, email, senha) VALUES
('Ana Silva', 'ana@gmail.com', '123'),
('Paulo Souza', 'paulo@gmail,com','123');

CREATE TABLE product(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	nome varchar(100) NOT NULL,
	descricao varchar(255),
	preco double NOT NULL,
	inserido_em TIMESTAMP NOT NULL,
	categoria ENUM('ELETRONICO', 'ROUPA', 'ESCRITORIO', 'MOVEIS') NOT NULL,
	id_usuario INTEGER DEFAULT 1
);

INSERT INTO product (nome, descricao, preco,inserido_em,categoria,id_usuario) VALUES
('Smart TV 50"','Smart TV 50" 4K',2799.99, CURRENT_TIMESTAMP(), 'ELETRONICO',1),
('Camiseta Polo', 'Camiseta Polo Azul Marinho', 89.90,CURRENT_TIMESTAMP(), 'ROUPA',1),
('Livro Arquitetura Limpa', 'Livro: Arquitetura Limpa - Robert C. Martin', 159.90,CURRENT_TIMESTAMP(), 'ESCRITORIO',1);