-- Database: produtosdb

-- DROP DATABASE IF EXISTS produtosdb;

CREATE DATABASE produtosdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.produtos

-- DROP TABLE IF EXISTS public.produtos;

CREATE TABLE IF NOT EXISTS public.produtos
(
    id integer NOT NULL DEFAULT nextval('produtos_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default",
    preco numeric,
    CONSTRAINT produtos_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.produtos
    OWNER to postgres;