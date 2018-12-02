CREATE TABLE agenda
(
    id bigint NOT NULL,
    data date,
    horafim time without time zone,
    horainicio time without time zone,
    empresa_idusuario bigint,
    prestador_idusuario bigint,
	
    CONSTRAINT agenda_pkey PRIMARY KEY (id),
    CONSTRAINT fk_agenda_empresa_idusuario FOREIGN KEY (empresa_idusuario)
        REFERENCES empresa (idusuario) MATCH SIMPLE,   
    CONSTRAINT fk_agenda_prestador_idusuario FOREIGN KEY (prestador_idusuario)
        REFERENCES prestador (idusuario) MATCH SIMPLE,
        
)

CREATE TABLE agenda_solicitacao
(
    agenda_id bigint NOT NULL,
    solicitacaododia_protocolo bigint NOT NULL,
	
    CONSTRAINT agenda_solicitacao_pkey PRIMARY KEY (agenda_id, solicitacaododia_protocolo),
    CONSTRAINT fk_agenda_solicitacao_agenda_id FOREIGN KEY (agenda_id)
        REFERENCES agenda (id) MATCH SIMPLE,
       
    CONSTRAINT fk_agenda_solicitacao_solicitacaododia_protocolo FOREIGN KEY (solicitacaododia_protocolo)
        REFERENCES solicitacao (protocolo) MATCH SIMPLE
)

CREATE TABLE atendimento
(
    id bigint NOT NULL,
    concluido boolean,
    dataatendimento date,
    horariofim time without time zone,
    horarioinicio time without time zone,
    prestador_idusuario bigint,
	
    CONSTRAINT atendimento_pkey PRIMARY KEY (id),
    CONSTRAINT fk_atendimento_prestador_idusuario FOREIGN KEY (prestador_idusuario)
        REFERENCES prestador (idusuario) MATCH SIMPLE
        
)

CREATE TABLE bairro
(
    id bigint NOT NULL,
    bairro character varying(255),
    cidade_id bigint,
	
    CONSTRAINT bairro_pkey PRIMARY KEY (id),
    CONSTRAINT fk_bairro_cidade_id FOREIGN KEY (cidade_id)
        REFERENCES cidade (id) MATCH SIMPLE
)

CREATE TABLE categoriaservico
(
    id bigint NOT NULL,
    tipo character varying(50),
    duracao time without time zone,
	
    CONSTRAINT categoriaservico_pkey PRIMARY KEY (id)
)

CREATE TABLE cidade
(
    id bigint NOT NULL,
    cidade character varying(255),
    estado_id bigint,
	
    CONSTRAINT cidade_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cidade_estado_id FOREIGN KEY (estado_id)
        REFERENCES estado (id) MATCH SIMPLE
)

CREATE TABLE cliente
(
    idusuario bigint NOT NULL,
    cpf character varying(20),
    nome character varying(50),
    telefone character varying(20),
    CONSTRAINT cliente_pkey PRIMARY KEY (idusuario)
)

CREATE TABLE cliente_solicitacao
(
    cliente_idusuario bigint NOT NULL,
    solicitacao_protocolo bigint NOT NULL,
	
    CONSTRAINT cliente_solicitacao_pkey PRIMARY KEY (cliente_idusuario, solicitacao_protocolo),
    CONSTRAINT fk_cliente_solicitacao_cliente_idusuario FOREIGN KEY (cliente_idusuario)
        REFERENCES cliente (idusuario) MATCH SIMPLE,
    CONSTRAINT fk_cliente_solicitacao_solicitacao_protocolo FOREIGN KEY (solicitacao_protocolo)
        REFERENCES solicitacao (protocolo) MATCH SIMPLE    
)

CREATE TABLE empresa
(
    idusuario bigint NOT NULL,
    cnpj character varying(20),
    login character varying(255),
    nome character varying(50),
    senha character varying(255),
    telefone character varying(20),
	
    CONSTRAINT empresa_pkey PRIMARY KEY (idusuario)
)

CREATE TABLE empresa_prestador
(
    empresa_idusuario bigint NOT NULL,
    prestadores_idusuario bigint NOT NULL,
	
    CONSTRAINT empresa_prestador_pkey PRIMARY KEY (empresa_idusuario, prestadores_idusuario),
    CONSTRAINT fk_empresa_prestador_empresa_idusuario FOREIGN KEY (empresa_idusuario)
        REFERENCES empresa (idusuario) MATCH SIMPLE,
    CONSTRAINT fk_empresa_prestador_prestadores_idusuario FOREIGN KEY (prestadores_idusuario)
        REFERENCES prestador (idusuario) MATCH SIMPLE
)

CREATE TABLE empresa_solicitacao
(
    empresa_id_usuario bigint NOT NULL,
    solicitacaoes_protocolo bigint NOT NULL,
	
    CONSTRAINT empresa_solicitacao_pkey PRIMARY KEY (empresa_id_usuario, solicitacaoes_protocolo),
    CONSTRAINT fk_empresa_solicitacao_empresa_id_usuario FOREIGN KEY (empresa_id_usuario)
        REFERENCES empresa (id_usuario) MATCH SIMPLE,
    CONSTRAINT fk_empresa_solicitacao_solicitacaoes_protocolo FOREIGN KEY (solicitacaoes_protocolo)
        REFERENCES solicitacao (protocolo) MATCH SIMPLE,
)

CREATE TABLE endereco
(
    id bigint NOT NULL,
    cep character varying(20),
    complemento character varying(255),
    logradouro_id bigint,
	
    CONSTRAINT endereco_pkey PRIMARY KEY (id),
    CONSTRAINT fk_endereco_logradouro_id FOREIGN KEY (logradouro_id)
        REFERENCES logradouro (id) MATCH SIMPLE
)

CREATE TABLE estado
(
    id bigint NOT NULL,
    estado character varying(15),
	
    CONSTRAINT estado_pkey PRIMARY KEY (id)
)

CREATE TABLE logradouro
(
    id bigint NOT NULL,
    logradouro character varying(20),
    bairro_id bigint,
	
    CONSTRAINT logradouro_pkey PRIMARY KEY (id),
    CONSTRAINT fk_logradouro_bairro_id FOREIGN KEY (bairro_id)
        REFERENCES bairro (id) MATCH SIMPLE
)

CREATE TABLE prestador
(
    idusuario bigint NOT NULL,
    cargahoraria integer,
    cpf character varying(20),
    disponibilidade boolean,
    horariofim time without time zone,
    horarioinicio time without time zone,
    login character varying(255),
    nome character varying(50),
    senha character varying(255),
    telefone character varying(20),
	
    CONSTRAINT prestador_pkey PRIMARY KEY (idusuario),
    
)


CREATE TABLE prestador_agenda
(
    prestador_id_usuario bigint NOT NULL,
    agenda_id bigint NOT NULL,
    CONSTRAINT prestador_agenda_pkey PRIMARY KEY (prestador_id_usuario, agenda_id),
    CONSTRAINT fk_prestador_agenda_agenda_id FOREIGN KEY (agenda_id)
        REFERENCES agenda (id) MATCH SIMPLE,
    CONSTRAINT fk_prestador_agenda_prestador_id_usuario FOREIGN KEY (prestador_id_usuario)
        REFERENCES prestador (id_usuario) MATCH SIMPLE,
)

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
        
)

CREATE TABLE servico_atendimento
(
    servico_id bigint NOT NULL,
    atendimento_id bigint NOT NULL,
	
    CONSTRAINT servico_atendimento_pkey PRIMARY KEY (servico_id, atendimento_id),
    CONSTRAINT fk_servico_atendimento_atendimento_id FOREIGN KEY (atendimento_id)
        REFERENCES atendimento (id) MATCH SIMPLE,
    CONSTRAINT fk_servico_atendimento_servico_id FOREIGN KEY (servico_id)
        REFERENCES servico (id) MATCH SIMPLE
)

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
)

CREATE TABLE solicitacao_servico
(
    solicitacao_protocolo bigint NOT NULL,
    servicos_id bigint NOT NULL,
	
    CONSTRAINT solicitacao_servico_pkey PRIMARY KEY (solicitacao_protocolo, servicos_id),
    CONSTRAINT fk_solicitacao_servico_servicos_id FOREIGN KEY (servicos_id)
        REFERENCES servico (id) MATCH SIMPLE,
    CONSTRAINT fk_solicitacao_servico_solicitacao_protocolo FOREIGN KEY (solicitacao_protocolo)
        REFERENCES solicitacao (protocolo) MATCH SIMPLE
)