--
-- PostgreSQL database dump
--

-- Dumped from database version 10.13
-- Dumped by pg_dump version 10.13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cargo (
    nome character varying NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.cargo OWNER TO postgres;

--
-- Name: cargo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cargo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cargo_id_seq OWNER TO postgres;

--
-- Name: cargo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cargo_id_seq OWNED BY public.cargo.id;


--
-- Name: perfil_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.perfil_usuario (
    id integer NOT NULL,
    perfil_nome character varying(70) NOT NULL
);


ALTER TABLE public.perfil_usuario OWNER TO postgres;

--
-- Name: perfilUsuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."perfilUsuario_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."perfilUsuario_id_seq" OWNER TO postgres;

--
-- Name: perfilUsuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."perfilUsuario_id_seq" OWNED BY public.perfil_usuario.id;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    cpf character varying(14) NOT NULL,
    nome character varying NOT NULL,
    sexo character varying(1),
    cargos character varying NOT NULL,
    perfis_usuario character varying,
    data_nascimento character varying NOT NULL,
    data_cadastro character varying NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: cargo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo ALTER COLUMN id SET DEFAULT nextval('public.cargo_id_seq'::regclass);


--
-- Name: perfil_usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil_usuario ALTER COLUMN id SET DEFAULT nextval('public."perfilUsuario_id_seq"'::regclass);


--
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cargo (nome, id) FROM stdin;
RH	8
Admin	3
Desenvolvedor	4
Gerente	12
Estagiário	13
Supervisor	19
\.


--
-- Data for Name: perfil_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.perfil_usuario (id, perfil_nome) FROM stdin;
3	Desenvolvedor jr
11	Gerente P
13	RH P
14	Desenvolvedor P
12	Supervisor P
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (cpf, nome, sexo, cargos, perfis_usuario, data_nascimento, data_cadastro) FROM stdin;
11340359693	Gabriel	M	Estagiário	Desenvolvedor P	25/051998	26/07/2020 15:12:01
\.


--
-- Name: cargo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cargo_id_seq', 19, true);


--
-- Name: perfilUsuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."perfilUsuario_id_seq"', 14, true);


--
-- Name: cargo cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id);


--
-- Name: usuario cargos; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT cargos UNIQUE (cargos);


--
-- Name: cargo nome; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT nome UNIQUE (nome);


--
-- Name: perfil_usuario perfilUsuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil_usuario
    ADD CONSTRAINT "perfilUsuario_pkey" PRIMARY KEY (id);


--
-- Name: perfil_usuario perfil_nome; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil_usuario
    ADD CONSTRAINT perfil_nome UNIQUE (perfil_nome);


--
-- Name: usuario perfis_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT perfis_usuario UNIQUE (perfis_usuario);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (cpf);


--
-- Name: usuario cargo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT cargo FOREIGN KEY (cargos) REFERENCES public.cargo(nome) ON UPDATE CASCADE ON DELETE RESTRICT NOT VALID;


--
-- Name: usuario lista_perfil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT lista_perfil FOREIGN KEY (perfis_usuario) REFERENCES public.perfil_usuario(perfil_nome) ON UPDATE CASCADE ON DELETE RESTRICT NOT VALID;


--
-- PostgreSQL database dump complete
--

