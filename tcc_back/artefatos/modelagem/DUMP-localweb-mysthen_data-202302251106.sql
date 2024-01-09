--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2023-02-25 11:06:26

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
-- TOC entry 14 (class 2615 OID 135185)
-- Name: audit; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA audit;


ALTER SCHEMA audit OWNER TO postgres;

--
-- TOC entry 5 (class 2615 OID 135180)
-- Name: cadastro; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cadastro;


ALTER SCHEMA cadastro OWNER TO postgres;

--
-- TOC entry 13 (class 2615 OID 135202)
-- Name: cadastro_auditoria; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cadastro_auditoria;


ALTER SCHEMA cadastro_auditoria OWNER TO postgres;

--
-- TOC entry 6 (class 2615 OID 135183)
-- Name: game_data; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA game_data;


ALTER SCHEMA game_data OWNER TO postgres;

--
-- TOC entry 11 (class 2615 OID 135205)
-- Name: game_data_auditoria; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA game_data_auditoria;


ALTER SCHEMA game_data_auditoria OWNER TO postgres;

--
-- TOC entry 7 (class 2615 OID 135181)
-- Name: personagem; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA personagem;


ALTER SCHEMA personagem OWNER TO postgres;

--
-- TOC entry 9 (class 2615 OID 135203)
-- Name: personagem_auditoria; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA personagem_auditoria;


ALTER SCHEMA personagem_auditoria OWNER TO postgres;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 4 (class 2615 OID 135182)
-- Name: sala; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA sala;


ALTER SCHEMA sala OWNER TO postgres;

--
-- TOC entry 8 (class 2615 OID 135204)
-- Name: sala_auditoria; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA sala_auditoria;


ALTER SCHEMA sala_auditoria OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 135193)
-- Name: usuario_seq; Type: SEQUENCE; Schema: cadastro; Owner: chris
--

CREATE SEQUENCE cadastro.usuario_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cadastro.usuario_seq OWNER TO chris;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 135216)
-- Name: usuarios; Type: TABLE; Schema: cadastro; Owner: chris
--

CREATE TABLE cadastro.usuarios (
    id_usuario bigint NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    id_usuario_atualizacao bigint NOT NULL,
    id_usuario_criacao bigint NOT NULL,
    ativo boolean NOT NULL,
    data_nascimento timestamp without time zone,
    login character varying(60) NOT NULL,
    nome character varying(60) NOT NULL,
    senha character varying(120) NOT NULL,
    ds_hash character varying(10) NOT NULL,
    ds_salt character varying(10) NOT NULL
);


ALTER TABLE cadastro.usuarios OWNER TO chris;

--
-- TOC entry 213 (class 1259 OID 135223)
-- Name: usuarios_auditoria; Type: TABLE; Schema: cadastro_auditoria; Owner: chris
--

CREATE TABLE cadastro_auditoria.usuarios_auditoria (
    id_usuario bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    ativo boolean,
    data_nascimento timestamp without time zone,
    login character varying(60),
    nome character varying(60),
    senha character varying(120),
    ds_hash character varying(10),
    ds_salt character varying(10)
);


ALTER TABLE cadastro_auditoria.usuarios_auditoria OWNER TO chris;

--
-- TOC entry 211 (class 1259 OID 135200)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: chris
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO chris;

--
-- TOC entry 210 (class 1259 OID 135195)
-- Name: revinfo; Type: TABLE; Schema: public; Owner: chris
--

CREATE TABLE public.revinfo (
    rev integer NOT NULL,
    revtstmp bigint
);


ALTER TABLE public.revinfo OWNER TO chris;

--
-- TOC entry 3011 (class 0 OID 135216)
-- Dependencies: 212
-- Data for Name: usuarios; Type: TABLE DATA; Schema: cadastro; Owner: chris
--



--
-- TOC entry 3012 (class 0 OID 135223)
-- Dependencies: 213
-- Data for Name: usuarios_auditoria; Type: TABLE DATA; Schema: cadastro_auditoria; Owner: chris
--



--
-- TOC entry 3009 (class 0 OID 135195)
-- Dependencies: 210
-- Data for Name: revinfo; Type: TABLE DATA; Schema: public; Owner: chris
--



--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 209
-- Name: usuario_seq; Type: SEQUENCE SET; Schema: cadastro; Owner: chris
--

SELECT pg_catalog.setval('cadastro.usuario_seq', 2, false);


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 211
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: chris
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 2872 (class 2606 OID 135222)
-- Name: usuarios usuario_login_un; Type: CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios
    ADD CONSTRAINT usuario_login_un UNIQUE (login);


--
-- TOC entry 2874 (class 2606 OID 135220)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2876 (class 2606 OID 135227)
-- Name: usuarios_auditoria usuarios_auditoria_pkey; Type: CONSTRAINT; Schema: cadastro_auditoria; Owner: chris
--

ALTER TABLE ONLY cadastro_auditoria.usuarios_auditoria
    ADD CONSTRAINT usuarios_auditoria_pkey PRIMARY KEY (id_usuario, rev);


--
-- TOC entry 2870 (class 2606 OID 135199)
-- Name: revinfo revinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: chris
--

ALTER TABLE ONLY public.revinfo
    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);


--
-- TOC entry 2877 (class 2606 OID 135228)
-- Name: usuarios_auditoria fklsn0nqpm96h6o29br6eirbunl; Type: FK CONSTRAINT; Schema: cadastro_auditoria; Owner: chris
--

ALTER TABLE ONLY cadastro_auditoria.usuarios_auditoria
    ADD CONSTRAINT fklsn0nqpm96h6o29br6eirbunl FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


-- Completed on 2023-02-25 11:06:26

--
-- PostgreSQL database dump complete
--

