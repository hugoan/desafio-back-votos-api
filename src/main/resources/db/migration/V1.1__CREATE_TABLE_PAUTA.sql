-------------------------------------------------------------------------
----------------- DESAFIO_BACK_VOTOS_API.PAUTA ----------------------
-------------------------------------------------------------------------


-- CREATE SEQUENCE --
CREATE SEQUENCE DESAFIO_BACK_VOTOS_API.PAUTA_SEQ INCREMENT BY 1 MINVALUE 1 START WITH 1;

-- CREATE TABLE --
CREATE TABLE DESAFIO_BACK_VOTOS_API.PAUTA
(
    ID_PAUTA BIGINT DEFAULT nextval('DESAFIO_BACK_VOTOS_API.PAUTA_SEQ') PRIMARY KEY NOT NULL,
    DESCRICAO TEXT NOT NULL
);

-- COMMENTS --
COMMENT ON TABLE  DESAFIO_BACK_VOTOS_API.PAUTA IS 'Tabela responsável por armarzenar as pautas da assembleia.';
COMMENT ON COLUMN DESAFIO_BACK_VOTOS_API.PAUTA.ID_PAUTA IS 'ID sequencial da tabela. Sequence: DESAFIO_BACK_VOTOS_API.PAUTA_SEQ';
COMMENT ON COLUMN DESAFIO_BACK_VOTOS_API.PAUTA.DESCRICAO IS 'Descrição da pauta.';

-- GRANTS --
GRANT SELECT, UPDATE ON SEQUENCE DESAFIO_BACK_VOTOS_API.PAUTA_SEQ TO EUBHSZZJKBFZLK;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE DESAFIO_BACK_VOTOS_API.PAUTA TO EUBHSZZJKBFZLK;
