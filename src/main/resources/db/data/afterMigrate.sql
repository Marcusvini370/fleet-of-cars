DELETE from tb_funcionario_perfis;
DELETE from tb_viagem;
DELETE from tb_carro;
DELETE from tb_funcionario;
DELETE from tb_perfil;

insert into tb_carro ( data_fabricacao, marca, modelo, status) values ( '2022-08-21T01:49:05.63Z', 'aa', 'a', 'DISPONIVEL');

INSERT INTO tb_perfil(id, nome) VALUES (1, 'ADMINISTRADOR');
INSERT INTO tb_perfil(id, nome) VALUES (2, 'USUÁRIO');

INSERT INTO public.tb_funcionario( login, matricula, nome, password) VALUES ( 'admin', 01, 'Administrador', '$2a$10$4XLkxjb4vx1.pT.oqFPHG.yROuPyD35iuWZZWydhh/sBSEuqIgIfS');

-- INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (1, 1);


