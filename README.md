# CRUD - JDBC (PostgreSQL)

##### Projeto simples para criação de um CRUD em Java utilizando JDBC para comunicação com o banco de dados.
#
##### TABELA SQL:

#
```sql 
CREATE TABLE public.pessoa
(
cpf integer NOT NULL,
nome VARCHAR(100) NOT NULL,
sobrenome varchar(100) not null,
email varchar(100) not null,
senioridade varchar(30) not null,
tecnologia varchar(100) not null,
experiencia text,
PRIMARY KEY (cpf)
)
