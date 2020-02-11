CREATE TABLE frete (
  id INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  peso DECIMAL(12,2) NOT NULL,
  valor DECIMAL(12,2) NOT NULL,
  cliente_id int NOT NULL,
  cidade_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (cliente_id) REFERENCES cliente (id),
FOREIGN KEY (cidade_id) REFERENCES  cidade (id)
);
