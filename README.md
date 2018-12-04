# TRABALHO 01 : Título do trabalho
Trabalho desenvolvido durante a disciplina de BD

    O referido projeto poderá ser:
        a) Um novo sistema/projeto 
        b) Uma expansão de sistema/projeto previamente desenvolvido em disciplinas anteriores 
        (ex: Expansão dos módulos do sistema desenvolvidos em BD1 - incremento mínimo de 50% nos 
        requisitos/complexidade)
        c) Nas avaliações parciais do professor, o grupo deverá anotar todas as observaçoes que forem feitas pelo professor 
        e pelo proprio grupo, enviar uma cópia das atividades por e-mail para o grupo e postar imediatamente estas observaçõe
        como tarefas a serem realizadas como tarefas por meio do gerenciador de projetos do git.
        d) Todas as tarefas devem ser realizadas e deve-se atentar para distribuição igualitária de atividades levando-se 
        em consideração o peso destas.
        e) Os tópicos numerados para cada atividade no devem ser removidos do trabalho. Entretanto, os conteúdos de exemplo 
        em cada tópico devem ser substituídos pelo conteúdo do trabalho em desenvolvimento.
        f) sprints de entrega serão quinzenais ou mensais definidos em aula juntamente com o professor
    
    OBS Importantes: 
        a) Os projetos/sistemas propostos serão validados pelo professor e pela turma
        b) Se possível é interessante que os novos sistemas estejam correlacionados com alguma área 
        previamente estudada pelo aluno
        c) Caso dependa de alguma instituição/parceiro externo, a base de dados e informações pertinentes 
        a esta devem ser obtidas no prazo de até 15 dias apos aprovação da proposta do trabalho 
        (caso contrário, nova proposta deverá ser apresentada a turma implicando logicamente em um prazo 
        mais curto para realização das atividades e conclusão do trabalho)
    
DICA: 
    O kickstart normalmente lança inovaçôes em termos de Sofwares e Apps, portanto pode ser interessante 
    olhar os lançamentos recentes para incrementar as possibilidades e aguçar a criatividade, o que pode 
    auxiliar o grupo com novas ideias na solução proposta. Acesse os links abaixo do para explorar sobre apps e softwares no Kickstarter.
    <br>
    https://www.kickstarter.com/discover/categories/technology/software
    <br>
    https://www.kickstarter.com/discover/categories/technology/apps
# Sumário

### 1	COMPONENTES<br>
Integrantes do grupo<br>
Vitor Soares Salzman - vitor-salzman96@hotmail.com<br>
Luiz Antonio Roque Guzzo - luizguzzo@gmail.com<br>
Serenna Ferrari Lima - serennaferrari@gmail.com<br>
Hellesandro Gonzaga - hellesandro123@gmail.com<br>
<br>
### 2	INTRODUÇÃO E MOTIVAÇAO<br>
    
S-organizer é uma projeto criado em 2018, visando a satisfação da demanda de praticidade e rapidez na serventia dos serviços contratados. Através da combinação de tecnologias inovadoras e conhecimento do setor tratado, o S-Organizer traz aos contratantes aumento na eficiência e na rentabilidade do negócio. A cultura do S-Organizer pauta-se na interação bidirecional com o cliente para tratar as particularidades dos pedidos e nas boas relações com nossos colaboradores, visando maior credibilidade e confiabilidade no trabalho feito. 
     
### 3	MINI-MUNDO<br>

S-Organizer é uma aplicação web que busca simplificar a prestação de serviços contratados formais e não formais. Assim sendo, a ferramenta oferece controle de serviços a prestar, visando organizar a agenda diária do prestador. <br>
Usuários administrativos criam e controlam agendas de serviços a prestar para para os prestadores. Serviços são criados após solicitação de um cliente, calculando horário para realização, tendo em vista a disponibilidade do cliente. Serviços criados geram protocolo que pode ser utilizado pelo cliente para consultar os detalhes do mesmo. Os serviços já contratados e pendentes devem aparecer na agenda do funcionário, que poderá consultar protocolo, endereço, descrição, horário estimado e valor do serviço. O prestador de serviço pode editar a agenda pessoal conforme necessário.<br>
Cliente não possui cadastro no sistema, mas pode consultar o serviço contratado através de um campo de pesquisa de protocolo. Avisos, como atrasos, serão registrados no serviço pelo funcionário. Tais notas podem ser visualizadas pelo cliente.
<br>

### 4	RASCUNHOS BÁSICOS DA INTERFACE (MOCKUPS)<br>
neste ponto a codificação não e necessária, somente as ideias de telas devem ser criadas, o princípio aqui é pensar na criação da interface para identificar possíveis informações a serem armazenadas ou descartadas <br>

link: https://drive.google.com/open?id=1YiBFnkmDrE9pQYeFxZ4xkmHXPP7uN1ptkk2Ud681vIs<br>

![Alt text](https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_Modelos/Prototipo_telas.png "Protótipo de Telas")


### 5	MODELO CONCEITUAL<br>
#### 5.1 NOTACAO ENTIDADE RELACIONAMENTO
![Alt text](https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_Modelos/diagrama%20conceitual.png "Modelo Conceitual")
    
     5.2 NOTACAO UML (Caso esteja fazendo a disciplina de Projeto)
## Data de Entrega: (23/08/2018) 
(Apresentação para o professor em sala de aula)

#### 5.3 DECISÕES DE PROJETO
    [atributo]: [descrição da decisão]
    
    
    a) Mapeamento Herança - Para o nosso projeto, optamos pelo modelo de mapeamento de herança como
    uma tabela para cada classe filha.

   
    b) Campo CPF em "Prestador" e "Cliente": Na estrutura de usuários de nosso sistema, 
    nota-se que há CLIENTE, PRESTADOR, EMPRESA, cada um destes com suas particularidades. 
    CLIENTE e PRESTADOR possuem CPF, porém, EMPRESA não. Para resolver a situação e não impactar
    na normalização, tivemos 2 opções: Criar uma tabela PESSOA com o campo CPF ou Criar o campo
    CPF em CLIENTE e PRESTADOR e, ao inserir o campo em PRESTADOR, haverá uma busca em  CLIENTE 
    pelo campo(Caso o dado já exista, os dados deste serão aproveitados no novo registro, 
    evitando inconsistencia de dados). Optamos pela segunda escolha, pois se enquadra melhor
    ao nosso sistema.

    c) Ligações 1/N - Em nosso projeto, optamos por criar entidades de relacionamento entre 
    tabelas, para assim garantir a normalização.
    
    
#### 5.4 DESCRIÇÃO DOS DADOS 
<b>Tabela AGENDA</b>: Tabela que armazena as informações referentes às atividades do prestador para um dia específico: <br> 
<li>ID: Campo que armazena o código identificador da agenda; </li>        
<li>DATA: Campo que armazena a data da agenda do prestador; </li>          
<li>HORAFIM: Campo que armazena o horário limite de dados da agenda;  </li>        
<li>HORAINICIO: Campo que armazena o horário inicial de dados da agenda; </li>           
<li>EMPRESA_ID_USUARIO: Campo que armazena o código identificador da empresa referente ao prestador cadastrado na agenda; </li>
<li>PRESTADOR_ID_USUARIO: Campo que armazena o código identificador do prestador cadastrado na agenda. </li>                 
<br>
<b>Tabela AGENDA_SOLICITACAO</b>: Tabela que armazena as ligações entre agenda e suas solicitações:<br>
<li>AGENDA_ID: Campo que armazena o código identificador da agenda;</li>
<li>solicitacaododia_protocolo: Campo que armazena o código identificador da solicitação vinculada à agenda. <\li>
<br>
<b>Tabela ATENDIMENTO</b>: Tabela que armazena os registros dos atendimentos realizados e não realizados: <br>
<li>ID: Campo que armazena o código identificador do atendimento; </li>
<li>CONCLUIDO: Campo booleano que armazena o registro do atendimento referente à completude do atendimento; </li>
<li>DATAATENDIMENTO: Campo que armazena a data do atendimento; </li>
<li>HORARIOFIM: Campo que armazena o horário final do atendimento; </li>
<li>HORARIOINICIO: Campo que armazena o horário inicial do atendimento; </li>
<li>PRESTADOR_ID_USUARIO: Campo que armazena o código identificador do prestador vinculado ao atendimento. </li>
<br>
<b>Tabela BAIRRO</b>: Tabela que armazena os bairros cadastrados no sistema: <br>
<li>ID: Campo que armazena o código identificador do bairro; </li>
<li>BAIRRO: Campo que armazena o nome do bairro cadastrado no sistema; </li>
<li>CIDADE_ID: Campo que armazena o código identificador da cidade vinculada ao bairro em questão. </li>
<br>
<b>Tabela CATEGORIASERVICO</b>: Tabela que armazena as categorias dos servicos cadastrados: <br>
<li>ID: Campo que armazena o código identificador da categoria do serviço; </li>
<li>TIPO: Campo que armazena a descrição da categoria em si; </li>
<li>DURACAO: Campo que armazena o tempo estimado de um serviço com essa categoria. </li>
<br>
<b>Tabela CIDADE</b>: Tabela que armazena as cidades cadastradas no sistema: <br>
<li>ID: Campo que armazena o código identificador da cidade; </li>
<li>CIDADE: Campo que armazena o nome da cidade; </li>
<li>ESTADO_ID: Campo que armazena o código identificador do estado ao qual pertence a cidade. </li>
<br>
<b>Tabela CLIENTE</b>: Tabela que armazena os clientes que utilizam o sistema: <br>
<li>ID_USUARIO: Campo que armazena o código identificador do cliente; </li>
<li>CPF: Campo que armazena o cadastro de pessoa física do cliente; </li>
<li>NOME: Campo que armazena o nome do cliente; </li>
<li>TELEFONE: Campo que armazena o telefone de contato do cliente; </li>
<br>
<b>Tabela CLIENTE_SOLICITACAO</b>: Tabela que armazena as ligações entre clientes e suas respectivas solicitações: <br>
<li>CLIENTE_ID_USUARIO: Campo que armazena o código identificador do cliente; </li>
<li>SOLICITACAO_PROTOCOLO: Campo que armazena o protocolo da solicitação vinculada ao cliente. </li>
<br>
<b>Tabela EMPRESA</b>: Tabela que armazena as clientes que utilizam o sistema: <br>
<li>ID_USUARIO: Campo que armazena o código identificador da empresa; </li>
<li>CNPJ: Campo que armazena o cadastro de pessoa jurídica da empresa; </li>
<li>LOGIN: Campo que armazena o login de acesso da empresa no sistema; </li>
<li>NOME: Campo que armazena o nome da empresa; </li>
<li>SENHA: Campo que armazena a senha de acesso da empresa ao sistema; </li>
<li>TELEFONE: Campo que armazena o telefone de contato da empresa. </li>
<br>
<b>Tabela EMPRESA_PRESTADOR</b>: Tabela que armazena as ligações entre empresas e seus prestadores: <br>
<li>EMPRESA_ID_USUARIO: Campo que armazena o código identificador da empresa; </li>
<li>PRESTADORES_ID_USUARIO: Campo que armazena o código identificador do prestador vinculado à empresa. </li>
<br>
<b>Tabela EMPRESA_SOLICITACAO</b>: Tabela que armazena as ligações entre empresas e solicitações criadas pelas mesmas: <br>
<li>EMPRESA_ID_USUARIO: Campo que armazena o código identificador da empresa; </li>
<li>SOLICITACOES_PROTOCOLO: Campo que armazena o protocolo da solicitação criado pela empresa. </li>
<br>
<b>Tabela ENDERECO</b>: Tabela que armazena os endereços cadastrados no sistema: <br>
<li>ID: Campo que armazena o código identificador do endereço; </li>
<li>CEP: Campo que armazena o código de endereçamento postal do endereço; </li>
<li>COMPLEMENTO: Campo que armazena informações adicionais do endereço; </li>
<li>LOGRADOURO_ID: Campo que armazena o código identificador do logradouro referente ao endereço; </li>
<br>
<b>Tabela ESTADO</b>: Tabela que armazena os estados cadastrados no sistema: <br>
<li>ID: Campo que armazena o código identificador do estado; </li>
<li>ESTADO: Campo que armazena o nome do estado. </li>
<br>
<b>Tabela LOGRADOURO</b>: Tabela que armazena os logradouros cadastrados no sistema: <br>
<li>ID: Campo que armazena o código identificador do logradouro; </li>
<li>LOGRADOURO: Campo que armazena a descrição do logradouro; </li>
<li>BAIRRO_ID: Campo que armazena o código identificador do bairro vinculado ao logradouro. </li>
<br>
<b>Tabela PRESTADOR</b>: Tabela que armazena os prestadores cadastrados no sistema: <br>
<li>ID_USUARIO: Campo que armazena o código identificador do prestador; </li>
<li>CARGAHORARIA: Campo que armazena a carga horária de serviço do prestador; </li>
<li>CPF: Campo que armazena o código de pessoa física do prestador; </li>
<li>DISPONIBILIDADE: Campo booleano que informa a disponibilidade do prestador; </li>
<li>HORARIOFIM: Campo que armazena o horário limite da carga horária do prestador; </li>
<li>HORARIOINICIO: Campo que armazena o horário inicial da carga horária do prestador; </li>
<li>LOGIN: Campo que armazena o login de acesso do prestador ao sistema; </li>
<li>NOME: Campo que armazena o nome do prestador; </li>
<li>SENHA: Campo que armazena a senha de acesso do prestador ao sistema; </li>
<li>TELEFONE: Campo que armazena o telefone de contato dp prestador. </li>
<br>
<b>Tabela PRESTADOR_AGENDA</b>: Tabela que armazena as ligações entre prestadores e suas respectivas agendas: <br>
<li>PRESTADOR_ID_USUARIO: Campo que armazena o código identificador do prestador; </li>
<li>AGENDA_ID: Campo que armazena o código identificador da empresa vinculada ao prestador. </li>
<br>
<b>Tabela SERVICO</b>: Tabela que armazena os serviços registrados no sistema: <br>
<li>ID: Campo que armazena o código identificador do serviço; </li>
<li>DESCRICAO: Campo que registra a descrição detalhada do serviço cadastrado; </li>
<li>ESTADOATENDIDO: Campo booleano que registra informação referente ao estado do serviço(atendido ou não); </li>
<li>HORARIOMARCADO: Campo que armazena o horário marcado do serviço cadastrado; </li>
<li>MULTA: Campo que armazena a multa gerada(se existe) do serviço; </li>
<li>VALOR: Campo que armazena o custo total do serviço; </li>
<li>CATEGORIA_ID: Campo que armazena o código identificador da categoria do serviço; </li>
<br>
<b>Tabela SERVICO_ATENDIMENTO</b>: Tabela que armazena as ligações entre serviços e seus respectivos atendimentos: <br>
<li>SERVICO_ID: Campo que armazena o código identificador do serviço; </li>
<li>ATENDIMENTO_ID: Campo que armazena o código identificador do atendimento vinculado ao serviço. </li>
<br>
<b>Tabela SOLICITACAO</b>: Tabela que armazena as solicitações registradas no sistema: <br>
<li>PROTOCOLO: Campo que armazena o protocolo da solicitação; </li>
<li>DATASOLICITACAO: Campo que registra a data da solicitação; </li>
<li>DISPCLIFIM: Campo que armazena o horário limite da disponibilidade do cliente para receber o atendimento referente 
    à solicitação; </li>
<li>DISPCLIINI: Campo que armazena o horário inicial da disponibilidade do cliente para receber o atendimento referente 
    à solicitação; </li>    
<li>ESTADO: Campo que armazena o código identificador do estado da solicitação; </li>
<li>MULTATOTAL: Campo que armazena a multa total gerada pela soma de todos os serviços vinculados à solicitação; </li>
<li>OBSERVACAO: Campo que armazena observações referentes à solicitação; </li>
<li>ENDERECO_ID: Campo que armazena o código identificador do endereço ao qual será realizado o atendimento da solicitação; </li>
<br>
<b>Tabela SOLICITACAO_SERVICO</b>: Tabela que armazena as ligações entre solicitações e seus respectivos serviços: <br>
<li>SOLICITACAO_PROTOCOLO: Campo que armazena o protocolo da solicitação; </li>
<li>SERVICO_ID: Campo que armazena o código identificador do serviço vinculado à solicitação. </li>
<br>
    
    
### 6	MODELO LÓGICO<br>
![Alt text](https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_Modelos/diagrama%20logico.png "Modelo Lógico")
### 7	MODELO FÍSICO<br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/Modelo%20F%C3%ADsico.sql">Modelo Físico</a>
### 8	INSERT APLICADO NAS TABELAS DO BANCO DE DADOS<br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/INSERTS.sql">Script de Inserts SQL</a>
#### 8.1 DETALHAMENTO DAS INFORMAÇÕES
        Detalhamento sobre as informações e processo de obtenção ou geração dos dados.
        Referenciar todas as fontes referentes a:
        a) obtenção dos dados
            Os dados foram obtidos através da geração de dados no Pentaho e alterado através da plataforma Java;
        b) obtenção de códigos reutilizados
            Foi utilizado a API JPA Controller;
        c) fontes de estudo para desenvolvimento do projeto
            Utilizamos slides vistos em sala de aula, além de vídeos sobre o JPA.
        
#### 8.2 INCLUSÃO DO SCRIPT PARA CRIAÇÃO DE TABELAS E INSERÇÃO DOS DADOS (ARQUIVO ÚNICO COM):
        a) inclusão das instruções para criação das tabelas e estruturas de amazenamento do BD
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/Modelo%20F%C3%ADsico.sql">Link para Modelo Físico</a>        
        b) inclusão das instruções de inserção dos dados nas referidas tabelas.
            Dados randomicos criados através do Pentaho.
<a href="https://www.hitachivantara.com/en-us/products/big-data-integration-analytics/pentaho-trial-download.html">Link para download</a>
            
        c) inclusão das instruções para execução de outros procedimentos necessários
            Somente instruções descritas acima foram utilizadas.

### 9	TABELAS E PRINCIPAIS CONSULTAS<br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/BD_S-Organizer.sql">Link para todo o banco de dados</a> <br>
https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/BD_S-Organizer.sql

#### 9.1	GERACAO DE DADOS (MÍNIMO DE 10 REGISTROS PARA CADA TABELA NO BANCO DE DADOS)<br>


## Data de Entrega: (06/09/2018)

<br>
OBS: Incluir para os tópicos 9.2 e 9.3 as instruções SQL + imagens (print da tela) mostrando os resultados.<br>

#### 9.2	SELECT DAS TABELAS COM PRIMEIROS 10 REGISTROS INSERIDOS <br> 
SELECT * FROM AGENDA LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_select_all_agenda.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_select_all_agenda.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM AGENDA_SOLICITACAO LIMIT 10<br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_agenda_solicitacao.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_agenda_solicitacao.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM ATENDIMENTO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_atendimento.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_atendimento.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM BAIRRO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_bairro.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_bairro.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM CATEGORIASERVICO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_categoriaservico.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_categoriaservico.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM CIDADE LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_cidade.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_cidade.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM CLIENTE LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_cliente.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_cliente.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM CLIENTE_SOLICITACAO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_cliente_solicitacao.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_cliente_solicitacao.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM EMPRESA LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_empresa.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_empresa.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM EMPRESA_PRESTADOR LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_empresa_prestador.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_empresa_prestador.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM EMPRESA_SOLICITACAO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_empresa_solicitacao.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_empresa_solicitacao.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM ENDERECO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_endereco.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_endereco.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM ESTADO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_estado.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_estado.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM LOGRADOURO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_logradouro.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_logradouro.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM PRESTADOR LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_prestador.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_prestador.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM PRESTADOR_AGENDA LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_prestador_agenda.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_prestador_agenda.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM SERVICO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_servico.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_servico.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM SERVICO_ATENDIMENTO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_servico_atendimento.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_servico_atendimento.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM SOLICITACAO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_solicitacao.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_solicitacao.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

SELECT * FROM SOLICITACAO_SERVICO LIMIT 10 <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_solicitacao_servico.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.2_solicitacao_servico.png" alt="Alt text" title="..." style="max-width:100%;"></a>
<br>
<br>

#### 9.3	SELECT DAS VISÕES COM PRIMEIROS 10 REGISTROS DA VIEW <br>
        a) Descrição da view sobre que grupos de usuários (operacional/estratégico) <br>
        e necessidade ela contempla.
        b) Descrição das permissões de acesso e usuários correlacionados (após definição <br>
        destas características)
        c) as funcionalidades informadas no minimundo ou nos mockups(protótipos), que representarem 
        views do sistema (relatórios, informações disponíveis para os usuários, etc) devem estar 
        presentes aqui. 
<br>
<li><b> Prestadores disponíveis - </b> 
a) View utilizada para consultar no banco os prestadores disponíveis em tempo real;
b) Usuários EMPRESA possuem permissão para utilizá-la;
c) O relatório é importante para definição e designação de novos serviços para prestadores. <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Views/prestadores_disponiveis_result.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Views/prestadores_disponiveis_result.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

<li><b> Solicitações com Multa - </b>
a) View utilizada para consultar no banco a quantidade de solicitações que geraram multa;
b) Usuários EMPRESA possuem permissão para utilizá-la;
c) O relatório é importante para mapear e identificar possíveis causas para geração de multas.  <br> 
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Views/solicitacoes_com_multa_result.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Views/solicitacoes_com_multa_result.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>    

<li><b> Solicitações Pendentes - </b>
a) View utilizada para consultar no banco a quantidade de solicitações pendentes existentes no momento;
b) Usuários EMPRESA possuem permissão para utilizá-la;
c) O relatório é importante para o reagendamento de solicitações para as próximas agendas de prestadores.<br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Views/solicitacoes_pendentes_result.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Views/solicitacoes_pendentes_result.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>


#### 9.4	LISTA DE CODIGOS DAS FUNÇÕES, ASSERÇOES E TRIGGERS<br>
        Detalhamento sobre funcionalidade de cada código.
        a) Objetivo
        b) Código do objeto (função/trigger/asserção)
        c) exemplo de dados para aplicação
        d) resultados em forma de tabela/imagem
<li><b> Pesquisar solicitações por cidades </b></li>   <br>     
a) Objetivo: 
<b> Função que retorne os protocolos de solicitações para serem atendidas em uma determinada cidade </b><br>
b) Código do objeto (função/trigger/asserção) <br>

<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/pesquisa_solicitacao_cidade_script.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/pesquisa_solicitacao_cidade_script.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

c) exemplo de dados para aplicação<br>

<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/pesquisa_solicitacao_cidade_select.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/pesquisa_solicitacao_cidade_select.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

d) resultados em forma de tabela/imagem <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_result.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_result.png" alt="Alt text" title="..." style="max-width:100%;"></a> 

<br>

<li><b> Serviços não atendidos </b></li>  <br>      
a) Objetivo:
<b> Função que retorna o número de serviços não atendidos em uma solicitação específica </b> <br>
b) Código do objeto (função/trigger/asserção) <br>

<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_script.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_script.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

c) exemplo de dados para aplicação<br>

<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_select.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_select.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

d) resultados em forma de tabela/imagem <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_result.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/servicos_nao_atendidos_result.png" alt="Alt text" title="..." style="max-width:100%;"></a> 

<li><b> Restrição para horário de agendas </b></li>  <br>      
a) Objetivo:
<b> Asserção que não permite que seja inserido uma agenda com a carga horária incompatível ao prestador </b> <br>
b) Código do objeto (função/trigger/asserção) <br>

OBS: Asserções não são compatíveis ao postgres, logo, foi utilizado TRIGGER <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/checkHorarioServicoTrigger.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/checkHorarioServicoTrigger.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/checkHorarioServico.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/checkHorarioServico.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

c) exemplo de dados para aplicação<br>

<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/checkHorarioServico_insert.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/Functions/checkHorarioServico_insert.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

d) resultados em forma de tabela/imagem <br>
Resultado mesclado ao item anterior.


## Data de Entrega: (27/09/2018)

#### 9.5	Administração do banco de dados<br>
        Descrição detalhada sobre como serão executadas no banco de dados as <br>
        seguintes atividades.
        a) Segurança e autorização de acesso: especificação básica de configurações de acesso remoto
        b) Estimativas de aquisição de recursos para armazenamento e processamento da informação
        c) Planejamento de rotinas de manutenção e monitoramento do banco
        d) Plano com frequencia de análises visando otimização de performance
<br>

    a) 
	Criados roles  para gerenciar a autorização de acesso na base de dados esses são:
	  -EMPRESA: Acesso total ao banco de produção e autorização para realizar todas as operações
	  -PRESTADOR: Acesso apenas ao Banco Local, podendo somente gerenciar as próprias agendas
	  -CLIENTE: Acesso restrito a consultas com o protocolo que possuir

    b) 
	O fluxo principal do sistema define o fluxo de armazenamento. Logo, há uma estimativa de maior espaço
    reservado para agendas e, consequentemente, para solicitações e serviços.
	
    c) 
	Usuários EMPRESA devem manter a manutenção do sistema de forma a garantir que as agendas criadas e transferidas
    aos prestadores sejam atendidas corretamente.
	
    d)
	Prestadores devem manter a qualidade do serviço e, assim, clientes avaliarão constantemente o sistema. Com
    base nas avaliações dos clientes, usuários EMPRESA mapeiam pontos que podem ser melhorados, adaptados ou até
    mesmo modificados, inserindo novos indices por exemplo.

#### 9.6	GERACAO DE DADOS (MÍNIMO DE 1,5 MILHÃO DE REGISTROS PARA PRINCIPAL RELAÇAO)<br>
        a) principal tabela do sistema deve ter no mínimo 1,5 milhão de registros <br> 
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.6a.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.6a.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>

        b) tabelas diretamente relacionadas a tabela principal 100 mil registros <br> 
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.6b.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Imagens_SELECTS/9.6b.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>      
        c) tabelas auxiliares de relacao multivalorada mínimo de 10 registros <br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/INSERTS.sql">Script de Inserts SQL</a>  <br>       
        d) especificar a quantidade de registros inseridos em cada tabela
<li>AGENDA - 1000000</li><br>
<li>AGENDA_SOLICITACAO - 1000000</li><br>
<li>ATENDIMENTO - 10000</li><br>       
<li>BAIRRO - 10000</li><br>
<li>CATEGORIASERVICO - 50</li><br>
<li>CIDADE - 10000</li><br>
<li>CLIENTE - 100000</li><br>
<li>CLIENTE_SOLICITACAO - 100000</li><br>
<li>EMPRESA - 100000</li><br>
<li>EMPRESA_PRESTADOR - 100000</li><br>
<li>EMPRESA_SOLICITACAO - 100000</li><br>
<li>ENDERECO - 100000</li><br>
<li>ESTADO - 20</li><br>
<li>LOGRADOURO - 1000</li><br>
<li>PRESTADOR - 100000</li><br>
<li>PRESTADOR_AGENDA - 100000</li><br>
<li>SERVICO - 1500000</li><br>
<li>SERVICO_ATENDIMENTO - 100000</li><br>
<li>SOLICITACAO - 1000000</li><br>
<li>SOLICITACAO_SERVICO- 1000000</li><br>


        
## Data de Entrega: (31/10/2018)

#### 9.7	Backup do Banco de Dados<br>
<a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/master/Imagens_SELECTS/backup.png"><img src="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/master/Imagens_SELECTS/backup.png" alt="Alt text" title="..." style="max-width:100%;"></a> <br>
<br>


#### 9.8	APLICAÇAO DE ÍNDICES E TESTES DE PERFORMANCE<br>
   <a href="https://github.com/VitorSalzman/Topicos-Trabalho-BD2/blob/Development/Arquivos%20SQL/JN%20S-Organizer.ipynb">Arquivo Jupyter </a><br> 
   <a href="https://drive.google.com/open?id=1YosR-g_3lhEv2mMetepRt6_9jMioRTpbpE2RO8Ynuxk">Apresentação com Prints - Indices </a><br> 
 
<br>

## Data de Entrega: (22/11/2018)

<br>   

#### 9.9 TRABALHO EM DUPLA - Machine Learning e Data Mining
### Estudar algum dos algoritmos abaixo
### Incluir no trabalho os seguintes tópicos: 
* Explicação/Fundamentação teórica sobre o método, objetivos e restrições! (formato doc/odt ou PDF)
* Onde/quando aplicar 
> ##### Estudar e explicar artigo que aplique o método de mineração de dados/machine learning escolhido
* exemplo de uso/aplicação 
> ##### a) Implementar algoritmo de básico de exemplo obtido na literatura (enviar código executável junto do trabalho com detalhamento de explicação para uso passo a passo)
> #####  b) Aplicar em alguma base de dados aberta (governamental ou sites de datasets disponíveis), registrar e apresentar resultados e algoritmo desenvolvido.

Exemplos de métodos/algoritmos a serem estudados
* "Nearest Neighbors" 
* "Linear SVM" 
* "RBF SVM" 
* "Decision Tree" 
* "Random Forest"
* Pca  
* "Naive Bayes"
<br>
Referência: http://scikit-learn.org/stable/index.html
<br>
Referências adicionais:
Scikit learning Map : http://scikit-learn.org/stable/tutorial/machine_learning_map/index.html
Machine learning in Python with scikit-learn: https://www.youtube.com/playlist?list=PL5-da3qGB5ICeMbQuqbbCOQWcS6OYBr5A



<br>

## Data de Entrega: (06/12/2018)


### 10	ATUALIZAÇÃO DA DOCUMENTAÇÃO/ SLIDES E ENTREGA FINAL<br>
       
### 11  FORMATACAO NO GIT: https://help.github.com/articles/basic-writing-and-formatting-syntax/
<comentario no git>
    
##### About Formatting
    https://help.github.com/articles/about-writing-and-formatting-on-github/
    
##### Basic Formatting in Git
    
    https://help.github.com/articles/basic-writing-and-formatting-syntax/#referencing-issues-and-pull-requests
    
    
##### Working with advanced formatting
    https://help.github.com/articles/working-with-advanced-formatting/
#### Mastering Markdown
    https://guides.github.com/features/mastering-markdown/

### OBSERVAÇÕES IMPORTANTES

#### Todos os arquivos que fazem parte do projeto (Imagens, pdfs, arquivos fonte, etc..), devem estar presentes no GIT. Os arquivos do projeto vigente não devem ser armazenados em quaisquer outras plataformas.
1. Caso existam arquivos com conteúdos sigilosos, comunicar o professor que definirá em conjunto com o grupo a melhor forma de armazenamento do arquivo.

#### Todos os grupos deverão fazer Fork deste repositório e dar permissões administrativas ao usuário deste GIT, para acompanhamento do trabalho.

#### Os usuários criados no GIT devem possuir o nome de identificação do aluno (não serão aceitos nomes como Eu123, meuprojeto, pro456, etc). Em caso de dúvida comunicar o professor.


Link para BrModelo:<br>
http://sis4.com/brModelo/brModelo/download.html
<br>


Link para curso de GIT<br>
![https://www.youtube.com/curso_git](https://www.youtube.com/playlist?list=PLo7sFyCeiGUdIyEmHdfbuD2eR4XPDqnN2?raw=true "Title")



