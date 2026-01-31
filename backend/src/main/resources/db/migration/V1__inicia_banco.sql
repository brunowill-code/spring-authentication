CREATE TABLE product(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) NOT NULL,
	description varchar(255),
	price double NOT NULL,
	inserted_on TIMESTAMP NOT NULL,
	category ENUM('ELETRONICO', 'ROUPA', 'ESCRITORIO', 'MOVEIS') NOT NULL,
	id_usuario INTEGER DEFAULT 1
);

INSERT INTO product (name, description, price,inserted_on,category) VALUES
('Smart TV 50"','Smart TV 50" 4K',2799.99, CURRENT_TIMESTAMP(), 'ELETRONICO'),
('Camiseta Polo', 'Camiseta Polo Azul Marinho', 89.90,CURRENT_TIMESTAMP(), 'ROUPA'),
('Livro Arquitetura Limpa', 'Livro: Arquitetura Limpa - Robert C. Martin', 159.90,CURRENT_TIMESTAMP(), 'ESCRITORIO');