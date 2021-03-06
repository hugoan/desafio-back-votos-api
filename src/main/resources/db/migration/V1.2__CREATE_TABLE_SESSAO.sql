-------------------------------------------------------------------------
----------------- DESAFIO_BACK_VOTOS_API.SESSAO -------------------------
-------------------------------------------------------------------------


-- CREATE SEQUENCE --
CREATE SEQUENCE DESAFIO_BACK_VOTOS_API.SESSAO_SEQ INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- CREATE TABLE --
CREATE TABLE DESAFIO_BACK_VOTOS_API.SESSAO
(
    ID_SESSAO BIGINT DEFAULT nextval('DESAFIO_BACK_VOTOS_API.SESSAO_SEQ') PRIMARY KEY NOT NULL,
    DATA_HORA_INICIO TIMESTAMP NOT NULL,
    DATA_HORA_FIM TIMESTAMP NOT NULL,
    ID_PAUTA BIGINT NOT NULL,
    CONSTRAINT UK_SESSAO_PAUTA UNIQUE (ID_PAUTA),
    CONSTRAINT FK_SESSAO_PAUTA FOREIGN KEY (ID_PAUTA) REFERENCES DESAFIO_BACK_VOTOS_API.PAUTA(ID_PAUTA)

);

-- COMMENTS --
COMMENT ON TABLE  DESAFIO_BACK_VOTOS_API.SESSAO IS 'Tabela responsável por armarzenar as sessões.';
COMMENT ON COLUMN DESAFIO_BACK_VOTOS_API.SESSAO.ID_SESSAO IS 'ID sequencial da tabela. Sequence: DESAFIO_BACK_VOTOS_API.PAUTA_SEQ';
COMMENT ON COLUMN DESAFIO_BACK_VOTOS_API.SESSAO.DATA_HORA_INICIO IS 'Data e hora do início da sessão de votação.';
COMMENT ON COLUMN DESAFIO_BACK_VOTOS_API.SESSAO.DATA_HORA_FIM IS 'Data e hora do fim da sessão de votação.';
COMMENT ON COLUMN DESAFIO_BACK_VOTOS_API.SESSAO.ID_PAUTA IS 'Id da pauta a ser votada na sessão de votação.';

-- GRANTS --
GRANT SELECT, UPDATE ON SEQUENCE DESAFIO_BACK_VOTOS_API.SESSAO_SEQ TO EUBHSZZJKBFZLK;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE DESAFIO_BACK_VOTOS_API.SESSAO TO EUBHSZZJKBFZLK;

