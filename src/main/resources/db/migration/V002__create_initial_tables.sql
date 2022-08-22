CREATE TABLE tb_carro (
	id serial,
	data_fabricacao timestamp NULL,
	marca varchar(255) NULL,
	modelo varchar(255) NULL,
	status varchar(255) NULL,
	CONSTRAINT tb_carro_pkey PRIMARY KEY (id)
);


CREATE TABLE tb_funcionario (
	id serial,
	login varchar(255) NULL,
	matricula int4 NOT NULL,
	nome varchar(255) NULL,
	"password" varchar(255) NULL,
	CONSTRAINT tb_funcionario_pkey PRIMARY KEY (id),
	CONSTRAINT uk_tb_funcionario_matricula UNIQUE (matricula)
);

CREATE TABLE perfil (
	id serial,
	nome varchar(255) NULL,
	CONSTRAINT perfil_pkey PRIMARY KEY (id)
);

CREATE TABLE tb_funcionario_perfis (
	funcionario_id serial,
	perfis_id int8 NOT NULL,
	CONSTRAINT fk_perfil_id FOREIGN KEY (perfis_id) REFERENCES public.perfil(id),
	CONSTRAINT fk_funcionario_id FOREIGN KEY (funcionario_id) REFERENCES public.tb_funcionario(id)
);

CREATE TABLE tb_viagem (
	id serial,
	data_entrega timestamp NULL,
	data_retirada timestamp NOT NULL,
	carro_id int8 NULL,
	funcionario_id int8 NULL,
	CONSTRAINT tb_viagem_pkey PRIMARY KEY (id),
	CONSTRAINT fk_carro_id FOREIGN KEY (carro_id) REFERENCES public.tb_carro(id),
	CONSTRAINT fk_funcionario_id FOREIGN KEY (funcionario_id) REFERENCES public.tb_funcionario(id)
);
