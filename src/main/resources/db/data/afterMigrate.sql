DELETE from tb_funcionario_perfis;
DELETE from tb_viagem;
DELETE from tb_carro;
DELETE from tb_funcionario;
DELETE from tb_perfil;

insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (1, '2022-08-21T01:49:05.63Z', 'aa', 'a', 'DISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (2, '2022-01-02T14:56:24Z', 'Land Rover', 'Range Rover', 'DISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (3, '2022-01-28T21:51:43Z', 'Volkswagen', 'Cabriolet', 'DISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (4, '2021-10-31T15:33:46Z', 'Kia', 'Optima', 'INDISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (5, '2022-02-05T12:29:54Z', 'Volkswagen', 'CC', 'DISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (6, '2022-01-20T14:04:46Z', 'Lexus', 'SC', 'DISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (7, '2022-06-08T18:28:41Z', 'Lincoln', 'Mark LT', 'INDISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (8, '2022-06-01T03:31:35Z', 'Chevrolet', 'Malibu', 'INDISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (9, '2021-10-02T04:53:37Z', 'Mazda', 'Mazda5', 'INDISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (10, '2022-03-31T22:14:52Z', 'Volvo', 'C70', 'INDISPONIVEL');
insert into tb_carro (id, data_fabricacao, marca, modelo, status) values (11, '2022-07-03T15:43:40Z', 'Mazda', 'CX-7', 'DISPONIVEL');

INSERT INTO tb_perfil(id, nome) VALUES (1, 'ADMINISTRADOR');
INSERT INTO tb_perfil(id, nome) VALUES (2, 'USUÁRIO');

INSERT INTO public.tb_funcionario(id, login, matricula, nome, password) VALUES (1, 'admin', 01, 'Administrador', '$2a$10$4XLkxjb4vx1.pT.oqFPHG.yROuPyD35iuWZZWydhh/sBSEuqIgIfS');
insert into tb_funcionario (id, login, matricula, nome, password) values (2, 'rgownge0', 11, 'Rayner', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (3, 'edodgshon1', 2, 'Ezequiel', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (4, 'wkorba2', 3, 'Wheeler', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (5, 'jeyres3', 4, 'Jimmy', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (6,'dcarryer4', 5, 'Dukie', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (7, 'jpolk5', 6, 'Jermayne', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (8, 'wjay6', 7, 'Winifield', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (9, 'sbedminster7', 8, 'Sutton', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (10, 'jglasheen8', 9, 'Jacques', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');
insert into tb_funcionario (id, login, matricula, nome, password) values (11, 'cburris9', 10, 'Christophe', '$2a$10$gd9u7A5izHNUEcz4TjlCv.YxtL.9iqXjirsedgVoVXFxKqU2BgIPK');


INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (1, 1);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (2, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (3, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (4, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (5, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (6, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (7, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (8, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (9, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (10, 2);
INSERT INTO public.tb_funcionario_perfis(funcionario_id, perfis_id) VALUES (11, 2);

insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (1, '2021-12-26T21:50:23Z', '2022-08-22T20:17:26Z', 1, 1);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (2, '2021-11-26T20:24:19Z', '2022-08-22T20:17:26Z', 2, 2);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (3, '2021-12-05T01:17:01Z', '2022-02-03T20:17:26Z', 3, 3);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (4, '2022-01-30T22:28:29Z', null, 4, 4);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (5, '2022-02-05T19:37:24Z', '2021-08-30T07:51:06Z', 5, 5);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (6, '2021-08-25T13:46:52Z', '2022-01-04T15:41:57Z', 6, 6);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (7, '2021-11-22T09:21:46Z', '2022-02-23T14:19:21Z', 7, 7);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (8, '2022-01-16T07:43:34Z', null, 8, 8);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (9, '2022-01-23T20:52:17Z', null, 9, 9);
insert into tb_viagem (id, data_retirada, data_entrega, carro_id, funcionario_id) values (10, '2021-10-07T12:19:40Z', null, 10, 10);




