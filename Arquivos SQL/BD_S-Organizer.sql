CREATE TABLE agenda
(
    id bigint NOT NULL,
    data date,
    horafim time without time zone,
    horainicio time without time zone,
    empresa_id_usuario bigint,
    prestador_id_usuario bigint,
	
    CONSTRAINT agenda_pkey PRIMARY KEY (id),
    CONSTRAINT fk_agenda_empresa_id_usuario FOREIGN KEY (empresa_id_usuario)
        REFERENCES empresa (id_usuario) MATCH SIMPLE,   
    CONSTRAINT fk_agenda_prestador_id_usuario FOREIGN KEY (prestador_id_usuario)
        REFERENCES prestador (id_usuario) MATCH SIMPLE
        
);

CREATE TABLE agenda_solicitacao
(
    agenda_id bigint NOT NULL,
    solicitacaododia_protocolo bigint NOT NULL,
	
    CONSTRAINT agenda_solicitacao_pkey PRIMARY KEY (agenda_id, solicitacaododia_protocolo),
    CONSTRAINT fk_agenda_solicitacao_agenda_id FOREIGN KEY (agenda_id)
        REFERENCES agenda (id) MATCH SIMPLE,
       
    CONSTRAINT fk_agenda_solicitacao_solicitacaododia_protocolo FOREIGN KEY (solicitacaododia_protocolo)
        REFERENCES solicitacao (protocolo) MATCH SIMPLE
);

CREATE TABLE atendimento
(
    id bigint NOT NULL,
    concluido boolean,
    dataatendimento date,
    horariofim time without time zone,
    horarioinicio time without time zone,
    prestador_id_usuario bigint,
	
    CONSTRAINT atendimento_pkey PRIMARY KEY (id),
    CONSTRAINT fk_atendimento_prestador_id_usuario FOREIGN KEY (prestador_id_usuario)
        REFERENCES prestador (id_usuario) MATCH SIMPLE
        
);

CREATE TABLE bairro
(
    id bigint NOT NULL,
    bairro character varying(255),
    cidade_id bigint,
	
    CONSTRAINT bairro_pkey PRIMARY KEY (id),
    CONSTRAINT fk_bairro_cidade_id FOREIGN KEY (cidade_id)
        REFERENCES cidade (id) MATCH SIMPLE
);

CREATE TABLE categoriaservico
(
    id bigint NOT NULL,
    tipo character varying(50),
    duracao time without time zone,
	
    CONSTRAINT categoriaservico_pkey PRIMARY KEY (id)
);

CREATE TABLE cidade
(
    id bigint NOT NULL,
    cidade character varying(255),
    estado_id bigint,
	
    CONSTRAINT cidade_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cidade_estado_id FOREIGN KEY (estado_id)
        REFERENCES estado (id) MATCH SIMPLE
);

CREATE TABLE cliente
(
    id_usuario bigint NOT NULL,
    cpf character varying(20),
    nome character varying(50),
    telefone character varying(20),
    CONSTRAINT cliente_pkey PRIMARY KEY (id_usuario)
);

CREATE TABLE cliente_solicitacao
(
    cliente_id_usuario bigint NOT NULL,
    solicitacao_protocolo bigint NOT NULL,
	
    CONSTRAINT cliente_solicitacao_pkey PRIMARY KEY (cliente_id_usuario, solicitacao_protocolo),
      
);

CREATE TABLE empresa
(
    id_usuario bigint NOT NULL,
    cnpj character varying(20),
    login character varying(255),
    nome character varying(50),
    senha character varying(255),
    telefone character varying(20),
	
    CONSTRAINT empresa_pkey PRIMARY KEY (id_usuario)
);

CREATE TABLE empresa_prestador
(
    empresa_id_usuario bigint NOT NULL,
    prestadores_id_usuario bigint NOT NULL,
	
    CONSTRAINT empresa_prestador_pkey PRIMARY KEY (empresa_id_usuario, prestadores_id_usuario),
    
);

CREATE TABLE empresa_solicitacao
(
    empresa_id_usuario bigint NOT NULL,
    solicitacaoes_protocolo bigint NOT NULL,
	
    CONSTRAINT empresa_solicitacao_pkey PRIMARY KEY (empresa_id_usuario, solicitacaoes_protocolo),
   
);

CREATE TABLE endereco
(
    id bigint NOT NULL,
    cep character varying(20),
    complemento character varying(255),
    logradouro_id bigint,
	
    CONSTRAINT endereco_pkey PRIMARY KEY (id),
    CONSTRAINT fk_endereco_logradouro_id FOREIGN KEY (logradouro_id)
        REFERENCES logradouro (id) MATCH SIMPLE
);

CREATE TABLE estado
(
    id bigint NOT NULL,
    estado character varying(15),
	
    CONSTRAINT estado_pkey PRIMARY KEY (id)
);

CREATE TABLE logradouro
(
    id bigint NOT NULL,
    logradouro character varying(20),
    bairro_id bigint,
	
    CONSTRAINT logradouro_pkey PRIMARY KEY (id),
    CONSTRAINT fk_logradouro_bairro_id FOREIGN KEY (bairro_id)
        REFERENCES bairro (id) MATCH SIMPLE
);

CREATE TABLE prestador
(
    id_usuario bigint NOT NULL,
    cargahoraria integer,
    cpf character varying(20),
    disponibilidade boolean,
    horariofim time without time zone,
    horarioinicio time without time zone,
    login character varying(255),
    nome character varying(50),
    senha character varying(255),
    telefone character varying(20),
	
    CONSTRAINT prestador_pkey PRIMARY KEY (id_usuario)
    
);


CREATE TABLE prestador_agenda
(
    prestador_id_usuario bigint NOT NULL,
    agenda_id bigint NOT NULL,
    CONSTRAINT prestador_agenda_pkey PRIMARY KEY (prestador_id_usuario, agenda_id),
    
);

CREATE TABLE servico
(
    id bigint NOT NULL,
    descricao character varying(255),
    estadoatendido boolean,
    horariomarcado time without time zone,
    multa double precision,
    valor double precision,
    categoria_id bigint,
	
    CONSTRAINT servico_pkey PRIMARY KEY (id),
    CONSTRAINT fk_servico_categoria_id FOREIGN KEY (categoria_id)
        REFERENCES categoriaservico (id) MATCH SIMPLE
        
);

CREATE TABLE servico_atendimento
(
    servico_id bigint NOT NULL,
    atendimento_id bigint NOT NULL,
	
    CONSTRAINT servico_atendimento_pkey PRIMARY KEY (servico_id, atendimento_id),
    CONSTRAINT fk_servico_atendimento_atendimento_id FOREIGN KEY (atendimento_id)
        REFERENCES atendimento (id) MATCH SIMPLE,
    CONSTRAINT fk_servico_atendimento_servico_id FOREIGN KEY (servico_id)
        REFERENCES servico (id) MATCH SIMPLE
);

CREATE TABLE solicitacao
(
    protocolo bigint NOT NULL,
    datasolicitacao date,
    dispclifim time without time zone,
    dispcliini time without time zone,
    estado integer,
    multatotal double precision,
    observacao character varying(255),
    endereco_id bigint,
	
    CONSTRAINT solicitacao_pkey PRIMARY KEY (protocolo),
    CONSTRAINT fk_solicitacao_endereco_id FOREIGN KEY (endereco_id)
        REFERENCES endereco (id) MATCH SIMPLE
);

CREATE TABLE solicitacao_servico
(
    solicitacao_protocolo bigint NOT NULL,
    servicos_id bigint NOT NULL,
	
    CONSTRAINT solicitacao_servico_pkey PRIMARY KEY (solicitacao_protocolo, servicos_id),
    CONSTRAINT fk_solicitacao_servico_servicos_id FOREIGN KEY (servicos_id)
        REFERENCES servico (id) MATCH SIMPLE,
    CONSTRAINT fk_solicitacao_servico_solicitacao_protocolo FOREIGN KEY (solicitacao_protocolo)
        REFERENCES solicitacao (protocolo) MATCH SIMPLE
);

INSERT INTO public.agenda(
	id, data, horafim, horainicio, empresa_id_usuario, prestador_id_usuario)
	VALUES (1, '2018-01-15', '18:00:00', '10:00:00', 1, 2),
	(2, '2018-01-14', '18:00:00', '10:00:00', 1, 1),
	(3, '2018-01-14', '16:00:00', '10:00:00', 5, 5),
	(4, '2018-01-15', '18:00:00', '10:00:00', 1, 8),
	(5, '2018-01-13', '16:00:00', '08:00:00', 3, 3),
	(6, '2018-01-13', '18:00:00', '10:00:00', 1, 2),
	(7, '2018-01-13', '18:00:00', '10:00:00', 1, 8),
	(8, '2018-01-12', '18:00:00', '10:00:00', 1, 2),
	(9, '2018-01-12', '18:00:00', '10:00:00', 1, 8),
	(10, '2018-01-12', '16:00:00', '08:00:00', 2,10);
	
INSERT INTO public.agenda_solicitacao(
	agenda_id, solicitacaododia_protocolo)
	VALUES (1, 20181001),
	(2, 20181002),
	(3, 20181003),
	(4, 20181004),
	(5, 20181005),
	(6, 20181006),
	(7, 20181007),
	(8, 20181008),
	(9, 20181009),
	(10,20181010);	
	
INSERT INTO public.atendimento(
	id, concluido, dataatendimento, horariofim, horarioinicio, prestador_id_usuario)
	VALUES (1, true, '2018-01-12', '11:00:00', '10:30:00', 10),
	(2, true, '2018-01-12', '13:00:00', '12:00:00', 1),
	(3, true, '2018-01-13', '13:00:00', '10:30:00', 2),
	(4, true, '2018-01-13', '16:00:00', '14:30:00', 1),
	(5, true, '2018-01-13', '10:30:00', '10:00:00', 3),
	(6, true, '2018-01-14', '15:00:00', '13:00:00', 8),
	(7, true, '2018-01-14', '18:00:00', '10:00:00', 1),
	(8, true, '2018-01-14', '17:00:00', '10:30:00', 7),
	(9, true, '2018-01-14', '16:00:00', '15:00:00', 10),
	(10, true, '2018-01-14', '12:20:00', '11:00:00', 2);
	
INSERT INTO public.bairro(
	id, bairro, cidade_id)
	VALUES (1, 'Morada de Laranjeiras', 1),
	(2, 'Bento Ferreira', 2),
	(3, 'Feu Rosa', 1),
	(4, 'Itapuã', 8),
	(5, 'Praia do Canto', 2),
	(6, 'Terra Vermelha', 8),
	(7, 'Jacaraipe', 1),
	(8, 'Santo Antonio III', 2),
	(9, 'Sao Marcos', 1),
	(10, 'Ibes', 8);



INSERT INTO categoriaservico(
	id, tipo, duracao)
	VALUES (1, 'instalação hidráulica', '1:00:00'),
	(2, 'instalação mecanica', '1:30:00'),
	(3, 'instalação elétrica', '1:30:00'),
	(4, 'limpeza doméstica', '3:00:00'),
	(5, 'reparo hidráulico caixa dagua', '0:40:00'),
	(6, 'limpeza quintal', '0:40:00'),
	(7, 'serviços de jardinagem', '1:30:00'),
	(8, 'entrega de correspondencias', '0:05:00'),
	(9, 'entrega de compras', '0:10:00'),
	(10, 'serviços de marcenaria - Portas', '1:20:00');
	
INSERT INTO public.cidade(
	id, cidade, estado_id)
	VALUES (1, 'serra', 1),
	(2, 'Vitoria', 1),
	(3, 'Rio de Janeiro', 2),
	(4, 'São Paulo', 5),
	(5, 'Viana', 1),
	(6, 'Guarulhos', 5),
	(7, 'Copacabana', 2),
	(8, 'Vila Velha', 1),
	(9, 'Fundão', 1),
	(10, 'Colatina', 1);	

INSERT INTO public.cliente(
	id_usuario, cpf, nome, telefone)
	VALUES (1, 148482457, 'Silas Neto', '2733468484'),
	(2, 348254500, 'Ronaldo Cobra', '2732457077'),
	(3, 148481213, 'Beto Carreiro', '2733408483'),
	(4, 148487356, 'Chico Bento', '2733387542'),
	(5, 148786967, 'Hemerick Silva', '2732368088'),
	(6, 148486861, 'Sandro Silva', '2733400101'),
	(7, 148489134, 'Esmerildo Neto', '2733463560'),
	(8, 148482652, 'Juca Freire', '2733448594'),
	(9, 148457588, 'Amarildo Ferreira', '2732365152'),
	(10, 148486878, 'Silas Junior', '2733468770');

INSERT INTO public.cliente_solicitacao(
	cliente_id_usuario, solicitacao_protocolo)
	VALUES (1, 20181001),
	(1, 20181002),
	(2, 20181003),
	(3, 20181004),
	(4, 20181005),
	(5, 20181006),
	(6, 20181007),
	(7, 20181008),
	(8, 20181009),
	(9, 20181010);	
	
INSERT INTO public.empresa(
	id_usuario, cnpj, login, nome, senha, telefone)
	VALUES (1, 15488, 'usere', 'soll', 'senha', '33572780'),
		   (2, 15489, 'useremp', 'solla', 'senha', '33572779'),
		   (3, 15490, 'userempre', 'solle', 'senha', '33572776'),
		   (4, 15491, 'userempres', 'solli', 'senha', '33572775'),
		   (5, 15492, 'userempresa', 'sollo', 'senha', '33572774'),
		   (6, 15493, 'emp', 'terra ltda', 'senha', '33572773'),
		   (7, 15494, 'empr', 'fogo ltda', 'senha', '33572772'),
		   (8, 15495, 'empre', 'ar ltda', 'senha', '33572771'),
		   (9, 15496, 'empres', 'mar ltda', 'senha', '33572770'),
		   (10, 15497, 'empresa', 'gelo ltda', 'senha', '33572777');
		   
INSERT INTO public.empresa_prestador(
	empresa_id_usuario, prestadores_id_usuario)
	VALUES (1, 2),
	(1, 1),
	(5, 5),
	(1, 8),
	(3, 3),
	(2, 10),
	(7, 7),
	(1, 4),
	(9, 9),
	(2, 6);		

INSERT INTO public.empresa_solicitacao(
	empresa_id_usuario, solicitacaoes_protocolo)
	VALUES (1, 20181001),
	(1, 20181002),
	(1, 20181003),
	(1, 20181004),
	(2, 20181005),
	(3, 20181006),
	(4, 20181007),
	(5, 20181008),
	(5, 20181009),
	(10, 20181010);	

INSERT INTO public.endereco(
	id, cep, complemento, logradouro_id)
	VALUES (1, '29166487', 'casa', 1),
	(2, '29166485', 'apartamento 454', 2),
	(3, '29166484', 'casa', 3),
	(4, '29166483', 'casa', 4),
	(5, '29166482', 'casa', 5),
	(6, '29166481', 'casa', 6),
	(7, '29166480', 'casa', 7),
	(8, '29166479', 'casa', 8),
	(9, '29166478', 'apartamento', 9),
	(10, '29166477', 'casa', 9);	
	
INSERT INTO public.estado(
	id, estado)
	VALUES (1, 'ES'),
	(2, 'RJ'),
	(3, 'MS'),
	(4, 'BA'),
	(5, 'SP'),
	(6, 'PR'),
	(7, 'CE'),
	(8, 'PA'),
	(9, 'RR'),
	(10, 'RS');
	
INSERT INTO public.logradouro(
	id, logradouro, bairro_id)
	VALUES (1, 'rua A', 1),
	(2, 'rua B', 6),
	(3, 'rua C', 5),
	(4, 'rua D', 4),
	(5, 'rua E', 1),
	(6, 'rua F', 2),
	(7, 'rua G', 3),
	(8, 'rua H', 3),
	(9, 'rua I', 2),
	(10, 'rua K', 1);	
	
INSERT INTO public.prestador(
	id_usuario, cargahoraria, cpf, disponibilidade, horariofim, horarioinicio, login, nome, senha, telefone)
	VALUES (1, 8, '017985264', true, '18:00:00', '10:00:00', 'ze43', 'Jose Gama', 'p@ssw()rd', '27998563562'),
	(2, 8, '817985264', true, '18:00:00', '10:00:00', 'hudsilva', 'Hudson Silva', 'hd500', '2798574897'),
	(3, 8, '147563298', false, '16:00:00', '08:00:00', 'ferreiranderson', 'Anderson Ferreira', '1503', '27998563564'),
	(4, 8, '014523636', false, '18:00:00', '10:00:00', 'crispepe', 'Cristiano Perez', 'senha', '27997443562'),
	(5, 6, '145628978', false, '16:00:00', '10:00:00', 'araujo020', 'Sergio Araujo', 'mybete', '27998563562'),
	(6, 6, '179852647', true, '18:00:00', '10:00:00', 'ze43', 'Jose Gama', 'p@ssw()rd', '27998563562'),
	(7, 6, '179878090', true, '18:00:00', '12:00:00', 'damaruth', 'Ruth Damasceno', 'dama15', '27995850515'),
	(8, 8, '090655748', true, '18:00:00', '10:00:00', 'mariamoreno', 'Maria Moreno', '081522', '27997789665'),
	(9, 6, '017875635', true, '16:00:00', '10:00:00', 'jorgeara', 'Jorge Aragão', '78685', '2799585244'),
	(10, 8, '076575323', false, '16:00:00', '08:00:00', 'andersonson', 'Anderson Freire', 'godofwar', '27998563662');	

INSERT INTO public.prestador_agenda(
	prestador_id_usuario, agenda_id)
	VALUES (2, 1),
	(1, 2),
	(5, 3),
	(8, 4),
	(3, 5),
	(2, 6),
	(8, 7),
	(2, 8),
	(8, 9),
	(10, 10);
	
INSERT INTO public.servico(
	id, descricao, estadoatendido, horariomarcado, multa, valor, categoria_id)
	VALUES (1, 'Caixa dagua furou, realizar reparo', false, '15:00:00', 0, 60, 5),
	(2, 'Cavar buraco para piscina, necessário cavadeira e pá', false, '11:00:00', 15, 150, 6),
	(3, 'Grama muito alta, necessário levar aparador', false, '09:00:00', 0, 50, 7),
	(4, 'Recolher entulho de obra', true, '15:00:00', 0, 100.00, 6),
	(5, 'Limpar cozinha e sala', false, '10:00:00', 5, 70, 4),
	(6, 'Entregar pacote do Walmart', true, '16:00:00', 0, 30, 8),
	(7, 'Entregar 2 kg de frango e 3 cebolinhas', false, '15:30:00', 0, 10, 9),
	(8, 'Instalar porta, necessário levar furadeira e caixa de parafusos', true, '12:00:00', 0, 100, 10),
	(9, 'Instalar caixa dagua', true, '08:30:00', 10, 80, 1),
	(10, 'Entregar uma antena + cabo coaxial', false, '09:20:00', 0, 20, 9);	
	
INSERT INTO public.servico_atendimento(
	servico_id, atendimento_id)
	VALUES (1, 1),
	(2, 2),
	(3, 3),
	(4, 4),
	(5, 5),
	(6, 6),
	(7, 7),
	(8, 8),
	(9, 9),
	(10, 10);

INSERT INTO public.solicitacao(
	protocolo, datasolicitacao, dispclifim, dispcliini, estado, multatotal, observacao, endereco_id)
	VALUES (20181001, '2018-01-12', '18:00:00', '10:00:00', 1, 0, 'Casa Amarela', 1),
	(20181002, '2018-01-12', '18:00:00', '10:00:00', 2, 0, 'Cliente tem cachorros soltos no quintal', 2),
	(20181003, '2018-01-13', '18:00:00', '11:00:00', 3, 10, 'Quarta tentativa com sucesso', 3),
	(20181004, '2018-01-13', '18:00:00', '10:00:00', 1, 0, 'Casa Azul', 4),
	(20181005, '2018-01-13', '18:00:00', '10:00:00', 4, 0, 'Apartamento 605', 5),
	(20181006, '2018-01-13', '18:00:00', '10:00:00', 2, 0, 'Condominio A', 6),
	(20181007, '2018-01-13', '17:00:00', '10:30:00', 5, 20, 'Casa do pé de manga', 7),
	(20181008, '2018-01-14', '18:00:00', '10:00:00', 3, 0, 'Cliente informa que problema é reincidente', 8),
	(20181009, '2018-01-14', '18:00:00', '10:00:00', 1, 0, 'Local perigoso', 9),
	(20181010, '2018-01-14', '17:00:00', '10:00:00', 4, 0, 'Greve de onibus pode impactar', 10);	
	
INSERT INTO public.solicitacao_servico(
	solicitacao_protocolo, servicos_id)
	VALUES (20181001, 1),
	(20181002, 2),
	(20181003, 3),
	(20181004, 4),
	(20181005, 5),
	(20181006, 6),
	(20181007, 7),
	(20181008, 8),
	(20181009, 9),
	(20181010, 10);	
	
SELECT * FROM AGENDA LIMIT 10;
SELECT * FROM AGENDA_SOLICITACAO LIMIT 10;
SELECT * FROM AGENDA_ATENDIMENTO LIMIT 10;
SELECT * FROM BAIRRO LIMIT 10;
SELECT * FROM CATEGORIASERVICO LIMIT 10;
SELECT * FROM CIDADE LIMIT 10;
SELECT * FROM CLIENTE LIMIT 10;
SELECT * FROM CLIENTE_SOLICITACAO LIMIT 10;
SELECT * FROM EMPRESA LIMIT 10;
SELECT * FROM EMPRESA_PRESTADOR LIMIT 10;
SELECT * FROM EMPRESA_SOLICITACAO LIMIT 10;
SELECT * FROM ENDERECO LIMIT 10;
SELECT * FROM ESTADO LIMIT 10;
SELECT * FROM LOGRADOURO LIMIT 10;
SELECT * FROM PRESTADOR LIMIT 10;
SELECT * FROM PRESTADOR_AGENDA LIMIT 10;
SELECT * FROM SERVICO LIMIT 10;
SELECT * FROM SERVICO_ATENDIMENTO LIMIT 10;
SELECT * FROM SOLICITACAO LIMIT 10;
SELECT * FROM SOLICITACAO_SERVICO LIMIT 10;	