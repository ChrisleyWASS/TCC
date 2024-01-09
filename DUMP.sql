--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2024-01-09 10:07:51

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
-- TOC entry 3311 (class 1262 OID 135179)
-- Name: mysthen_data; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mysthen_data WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE mysthen_data OWNER TO postgres;

\connect mysthen_data

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
-- TOC entry 12 (class 2615 OID 135185)
-- Name: auditoria; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA auditoria;


ALTER SCHEMA auditoria OWNER TO postgres;

--
-- TOC entry 5 (class 2615 OID 135180)
-- Name: cadastro; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cadastro;


ALTER SCHEMA cadastro OWNER TO postgres;

--
-- TOC entry 11 (class 2615 OID 151804)
-- Name: capacidade; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA capacidade;


ALTER SCHEMA capacidade OWNER TO postgres;

--
-- TOC entry 6 (class 2615 OID 135183)
-- Name: game_data; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA game_data;


ALTER SCHEMA game_data OWNER TO postgres;

--
-- TOC entry 7 (class 2615 OID 135181)
-- Name: personagem; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA personagem;


ALTER SCHEMA personagem OWNER TO postgres;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3312 (class 0 OID 0)
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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 143577)
-- Name: capacidades_auditoria; Type: TABLE; Schema: auditoria; Owner: chris
--

CREATE TABLE auditoria.capacidades_auditoria (
    id_capacidade bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    agilidade smallint,
    atencao smallint,
    carisma smallint,
    desenvoltura smallint,
    forca smallint,
    imunidade smallint,
    imposicao smallint,
    mobilidade smallint,
    obstinacao smallint,
    razao smallint,
    resistencia smallint,
    retorica smallint,
    sutileza smallint,
    tenacidade smallint,
    vigor smallint,
    descricao character varying(20)
);


ALTER TABLE auditoria.capacidades_auditoria OWNER TO chris;

--
-- TOC entry 223 (class 1259 OID 151828)
-- Name: capacidades_personagens_auditoria; Type: TABLE; Schema: auditoria; Owner: chris
--

CREATE TABLE auditoria.capacidades_personagens_auditoria (
    id_capacidade bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    agilidade smallint,
    atencao smallint,
    carisma smallint,
    desenvoltura smallint,
    forca smallint,
    imunidade smallint,
    imposicao smallint,
    mobilidade smallint,
    obstinacao smallint,
    razao smallint,
    resistencia smallint,
    retorica smallint,
    sutileza smallint,
    tenacidade smallint,
    vigor smallint,
    descricao character varying(20)
);


ALTER TABLE auditoria.capacidades_personagens_auditoria OWNER TO chris;

--
-- TOC entry 221 (class 1259 OID 143640)
-- Name: personagens_auditoria; Type: TABLE; Schema: auditoria; Owner: chris
--

CREATE TABLE auditoria.personagens_auditoria (
    id_personagem bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    nome_alternativo character varying(20),
    nome_linhagem character varying(20),
    nome character varying(20),
    id_capacidade bigint,
    id_especie bigint,
    id_etnia bigint,
    id_raca bigint
);


ALTER TABLE auditoria.personagens_auditoria OWNER TO chris;

--
-- TOC entry 245 (class 1259 OID 160489)
-- Name: salas_auditoria; Type: TABLE; Schema: auditoria; Owner: chris
--

CREATE TABLE auditoria.salas_auditoria (
    id_sala bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    ativa boolean,
    codigo character varying(15),
    nome character varying(60),
    id_usuario bigint
);


ALTER TABLE auditoria.salas_auditoria OWNER TO chris;

--
-- TOC entry 246 (class 1259 OID 160494)
-- Name: salas_personagens_auditoria; Type: TABLE; Schema: auditoria; Owner: chris
--

CREATE TABLE auditoria.salas_personagens_auditoria (
    id_sala_persongem bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    rdt_cansaco smallint,
    rdt_contaminacao smallint,
    rdt_estresse smallint,
    rdt_ferimento smallint,
    rdt_necessidade smallint,
    rdt_postura smallint,
    nome integer,
    id_personagem bigint,
    id_sala bigint,
    situacao character varying(2),
    acesso character varying(2)
);


ALTER TABLE auditoria.salas_personagens_auditoria OWNER TO chris;

--
-- TOC entry 211 (class 1259 OID 135773)
-- Name: usuarios_auditoria; Type: TABLE; Schema: auditoria; Owner: chris
--

CREATE TABLE auditoria.usuarios_auditoria (
    id_usuario bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    data_atualizacao timestamp without time zone,
    data_criacao timestamp without time zone,
    id_usuario_atualizacao bigint,
    id_usuario_criacao bigint,
    ativo boolean,
    data_nascimento date,
    ds_hash character varying(10),
    login character varying(60),
    nome character varying(60),
    ds_salt character varying(10),
    senha character varying(120)
);


ALTER TABLE auditoria.usuarios_auditoria OWNER TO chris;

--
-- TOC entry 207 (class 1259 OID 135193)
-- Name: usuario_seq; Type: SEQUENCE; Schema: cadastro; Owner: chris
--

CREATE SEQUENCE cadastro.usuario_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cadastro.usuario_seq OWNER TO chris;

--
-- TOC entry 210 (class 1259 OID 135216)
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
-- TOC entry 244 (class 1259 OID 160455)
-- Name: usuarios_personagens; Type: TABLE; Schema: cadastro; Owner: chris
--

CREATE TABLE cadastro.usuarios_personagens (
    id_usuario_personagem bigint NOT NULL,
    id_personagem bigint NOT NULL,
    id_usuario bigint NOT NULL
);


ALTER TABLE cadastro.usuarios_personagens OWNER TO chris;

--
-- TOC entry 224 (class 1259 OID 151833)
-- Name: capacidade_game_data_seq; Type: SEQUENCE; Schema: capacidade; Owner: chris
--

CREATE SEQUENCE capacidade.capacidade_game_data_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE capacidade.capacidade_game_data_seq OWNER TO chris;

--
-- TOC entry 228 (class 1259 OID 151955)
-- Name: capacidades_game_data; Type: TABLE; Schema: capacidade; Owner: postgres
--

CREATE TABLE capacidade.capacidades_game_data (
    id_capacidade bigint NOT NULL,
    descricao character varying NOT NULL,
    agilidade smallint NOT NULL,
    atencao smallint NOT NULL,
    carisma smallint NOT NULL,
    desenvoltura smallint NOT NULL,
    forca smallint NOT NULL,
    imunidade smallint NOT NULL,
    imposicao smallint NOT NULL,
    mobilidade smallint NOT NULL,
    obstinacao smallint NOT NULL,
    razao smallint NOT NULL,
    resistencia smallint NOT NULL,
    retorica smallint NOT NULL,
    sutileza smallint NOT NULL,
    tenacidade smallint NOT NULL,
    vigor smallint NOT NULL
);


ALTER TABLE capacidade.capacidades_game_data OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 151823)
-- Name: capacidades_npcs; Type: TABLE; Schema: capacidade; Owner: postgres
--

CREATE TABLE capacidade.capacidades_npcs (
    id_capacidade bigint NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    id_usuario_atualizacao bigint NOT NULL,
    id_usuario_criacao bigint NOT NULL,
    agilidade smallint NOT NULL,
    atencao smallint NOT NULL,
    carisma smallint NOT NULL,
    desenvoltura smallint NOT NULL,
    forca smallint NOT NULL,
    imunidade smallint NOT NULL,
    imposicao smallint NOT NULL,
    mobilidade smallint NOT NULL,
    obstinacao smallint NOT NULL,
    razao smallint NOT NULL,
    resistencia smallint NOT NULL,
    retorica smallint NOT NULL,
    sutileza smallint NOT NULL,
    tenacidade smallint NOT NULL,
    vigor smallint NOT NULL,
    descricao character varying NOT NULL
);


ALTER TABLE capacidade.capacidades_npcs OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 151835)
-- Name: capacidades_personagens_seq; Type: SEQUENCE; Schema: capacidade; Owner: chris
--

CREATE SEQUENCE capacidade.capacidades_personagens_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE capacidade.capacidades_personagens_seq OWNER TO chris;

--
-- TOC entry 252 (class 1259 OID 160566)
-- Name: arma_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.arma_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.arma_seq OWNER TO chris;

--
-- TOC entry 255 (class 1259 OID 160586)
-- Name: armas; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.armas (
    id_arma bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    nome character varying(20) NOT NULL,
    peso numeric(10,2) DEFAULT 0.00 NOT NULL,
    reqagl smallint NOT NULL,
    reqatn smallint NOT NULL,
    reqfrc smallint NOT NULL,
    tipo_arma character varying(2) NOT NULL,
    valor numeric(15,2) DEFAULT 0.00 NOT NULL
);


ALTER TABLE game_data.armas OWNER TO chris;

--
-- TOC entry 212 (class 1259 OID 135799)
-- Name: capacidade_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.capacidade_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.capacidade_seq OWNER TO chris;

--
-- TOC entry 216 (class 1259 OID 143540)
-- Name: caracteristica_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.caracteristica_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.caracteristica_seq OWNER TO chris;

--
-- TOC entry 226 (class 1259 OID 151837)
-- Name: caracteristicas; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.caracteristicas (
    id_caracteristica bigint NOT NULL,
    descricao character varying(300) NOT NULL,
    nome character varying(20) NOT NULL,
    tipo_qualidade_defeito character varying(1) NOT NULL,
    id_capacidade bigint NOT NULL
);


ALTER TABLE game_data.caracteristicas OWNER TO chris;

--
-- TOC entry 217 (class 1259 OID 143542)
-- Name: conhecimento_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.conhecimento_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.conhecimento_seq OWNER TO chris;

--
-- TOC entry 236 (class 1259 OID 155177)
-- Name: conhecimentos; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.conhecimentos (
    id_conhecimento bigint NOT NULL,
    descricao character varying(300) NOT NULL,
    nome character varying(20) NOT NULL,
    id_tipo_conhecimento bigint
);


ALTER TABLE game_data.conhecimentos OWNER TO chris;

--
-- TOC entry 213 (class 1259 OID 135801)
-- Name: especie_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.especie_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.especie_seq OWNER TO chris;

--
-- TOC entry 229 (class 1259 OID 152102)
-- Name: especies; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.especies (
    id_especie bigint NOT NULL,
    descricao character varying(500) NOT NULL,
    nome character varying(20) NOT NULL,
    id_capacidade bigint NOT NULL
);


ALTER TABLE game_data.especies OWNER TO chris;

--
-- TOC entry 214 (class 1259 OID 135803)
-- Name: etnia_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.etnia_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.etnia_seq OWNER TO chris;

--
-- TOC entry 230 (class 1259 OID 152110)
-- Name: etnias; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.etnias (
    id_etnia bigint NOT NULL,
    descricao character varying(500) NOT NULL,
    nome character varying(20) NOT NULL,
    id_capacidade bigint,
    id_especie bigint NOT NULL,
    id_raca bigint NOT NULL
);


ALTER TABLE game_data.etnias OWNER TO chris;

--
-- TOC entry 218 (class 1259 OID 143544)
-- Name: personalidade_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.personalidade_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.personalidade_seq OWNER TO chris;

--
-- TOC entry 227 (class 1259 OID 151857)
-- Name: personalidades; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.personalidades (
    id_personalidade bigint NOT NULL,
    descricao character varying(300) NOT NULL,
    nome character varying(20) NOT NULL,
    tipo_categoria character varying(3) NOT NULL,
    tipo_grupo character varying(2) NOT NULL
);


ALTER TABLE game_data.personalidades OWNER TO chris;

--
-- TOC entry 215 (class 1259 OID 135805)
-- Name: raca_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.raca_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.raca_seq OWNER TO chris;

--
-- TOC entry 231 (class 1259 OID 152118)
-- Name: racas; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.racas (
    id_raca bigint NOT NULL,
    descricao character varying(500) NOT NULL,
    nome character varying(20) NOT NULL,
    id_capacidade bigint NOT NULL,
    id_especie bigint NOT NULL
);


ALTER TABLE game_data.racas OWNER TO chris;

--
-- TOC entry 234 (class 1259 OID 155160)
-- Name: tipo_conhecimento_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.tipo_conhecimento_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.tipo_conhecimento_seq OWNER TO chris;

--
-- TOC entry 233 (class 1259 OID 155155)
-- Name: tipos_conhecimentos; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.tipos_conhecimentos (
    id_tipo_conhecimento bigint NOT NULL,
    descricao character varying(300) NOT NULL,
    nome character varying(20) NOT NULL
);


ALTER TABLE game_data.tipos_conhecimentos OWNER TO chris;

--
-- TOC entry 232 (class 1259 OID 155143)
-- Name: treinamento_seq; Type: SEQUENCE; Schema: game_data; Owner: chris
--

CREATE SEQUENCE game_data.treinamento_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_data.treinamento_seq OWNER TO chris;

--
-- TOC entry 235 (class 1259 OID 155167)
-- Name: treinamentos; Type: TABLE; Schema: game_data; Owner: chris
--

CREATE TABLE game_data.treinamentos (
    id_treinamento bigint NOT NULL,
    descricao character varying(300) NOT NULL,
    nome character varying(20) NOT NULL,
    id_capacidade bigint NOT NULL
);


ALTER TABLE game_data.treinamentos OWNER TO chris;

--
-- TOC entry 254 (class 1259 OID 160573)
-- Name: id_personagem_arma_seq; Type: SEQUENCE; Schema: personagem; Owner: chris
--

CREATE SEQUENCE personagem.id_personagem_arma_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personagem.id_personagem_arma_seq OWNER TO chris;

--
-- TOC entry 240 (class 1259 OID 160379)
-- Name: id_personagem_caracteristica_seq; Type: SEQUENCE; Schema: personagem; Owner: chris
--

CREATE SEQUENCE personagem.id_personagem_caracteristica_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personagem.id_personagem_caracteristica_seq OWNER TO chris;

--
-- TOC entry 241 (class 1259 OID 160381)
-- Name: id_personagem_treinamento_seq; Type: SEQUENCE; Schema: personagem; Owner: chris
--

CREATE SEQUENCE personagem.id_personagem_treinamento_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personagem.id_personagem_treinamento_seq OWNER TO chris;

--
-- TOC entry 242 (class 1259 OID 160383)
-- Name: personagem_conhecimento_seq; Type: SEQUENCE; Schema: personagem; Owner: chris
--

CREATE SEQUENCE personagem.personagem_conhecimento_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personagem.personagem_conhecimento_seq OWNER TO chris;

--
-- TOC entry 251 (class 1259 OID 160547)
-- Name: personagem_personalidade_seq; Type: SEQUENCE; Schema: personagem; Owner: chris
--

CREATE SEQUENCE personagem.personagem_personalidade_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personagem.personagem_personalidade_seq OWNER TO chris;

--
-- TOC entry 220 (class 1259 OID 143618)
-- Name: personagem_seq; Type: SEQUENCE; Schema: personagem; Owner: chris
--

CREATE SEQUENCE personagem.personagem_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personagem.personagem_seq OWNER TO chris;

--
-- TOC entry 243 (class 1259 OID 160415)
-- Name: personagens; Type: TABLE; Schema: personagem; Owner: chris
--

CREATE TABLE personagem.personagens (
    id_personagem bigint NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    id_usuario_atualizacao bigint NOT NULL,
    id_usuario_criacao bigint NOT NULL,
    nome_alternativo character varying(20),
    nome_linhagem character varying(20),
    nome character varying(20) NOT NULL,
    id_especie bigint NOT NULL,
    id_etnia bigint NOT NULL,
    id_raca bigint NOT NULL
);


ALTER TABLE personagem.personagens OWNER TO chris;

--
-- TOC entry 253 (class 1259 OID 160568)
-- Name: personagens_armas; Type: TABLE; Schema: personagem; Owner: chris
--

CREATE TABLE personagem.personagens_armas (
    id_personagem_arma bigint NOT NULL,
    id_arma bigint NOT NULL,
    id_personagem bigint NOT NULL
);


ALTER TABLE personagem.personagens_armas OWNER TO chris;

--
-- TOC entry 237 (class 1259 OID 160364)
-- Name: personagens_caracteristicas; Type: TABLE; Schema: personagem; Owner: chris
--

CREATE TABLE personagem.personagens_caracteristicas (
    id_personagem_caracteristica bigint NOT NULL,
    id_caracteristica bigint NOT NULL,
    id_personagem bigint NOT NULL
);


ALTER TABLE personagem.personagens_caracteristicas OWNER TO chris;

--
-- TOC entry 238 (class 1259 OID 160369)
-- Name: personagens_conhecimentos; Type: TABLE; Schema: personagem; Owner: chris
--

CREATE TABLE personagem.personagens_conhecimentos (
    id_personagem_conhecimento bigint NOT NULL,
    id_conhecimento bigint NOT NULL,
    id_personagem bigint NOT NULL
);


ALTER TABLE personagem.personagens_conhecimentos OWNER TO chris;

--
-- TOC entry 250 (class 1259 OID 160542)
-- Name: personagens_personalidade; Type: TABLE; Schema: personagem; Owner: chris
--

CREATE TABLE personagem.personagens_personalidade (
    id_personagem_personalidade bigint NOT NULL,
    id_personagem bigint NOT NULL,
    id_personalidade bigint NOT NULL
);


ALTER TABLE personagem.personagens_personalidade OWNER TO chris;

--
-- TOC entry 239 (class 1259 OID 160374)
-- Name: personagens_treinamentos; Type: TABLE; Schema: personagem; Owner: chris
--

CREATE TABLE personagem.personagens_treinamentos (
    id_personagem_treinamento bigint NOT NULL,
    id_personagem bigint NOT NULL,
    id_conhecimento bigint NOT NULL
);


ALTER TABLE personagem.personagens_treinamentos OWNER TO chris;

--
-- TOC entry 209 (class 1259 OID 135200)
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
-- TOC entry 208 (class 1259 OID 135195)
-- Name: revinfo; Type: TABLE; Schema: public; Owner: chris
--

CREATE TABLE public.revinfo (
    rev integer NOT NULL,
    revtstmp bigint
);


ALTER TABLE public.revinfo OWNER TO chris;

--
-- TOC entry 258 (class 1259 OID 160646)
-- Name: sala_log_seq; Type: SEQUENCE; Schema: sala; Owner: chris
--

CREATE SEQUENCE sala.sala_log_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sala.sala_log_seq OWNER TO chris;

--
-- TOC entry 248 (class 1259 OID 160513)
-- Name: sala_personagem_seq; Type: SEQUENCE; Schema: sala; Owner: chris
--

CREATE SEQUENCE sala.sala_personagem_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sala.sala_personagem_seq OWNER TO chris;

--
-- TOC entry 249 (class 1259 OID 160515)
-- Name: sala_seq; Type: SEQUENCE; Schema: sala; Owner: chris
--

CREATE SEQUENCE sala.sala_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sala.sala_seq OWNER TO chris;

--
-- TOC entry 247 (class 1259 OID 160499)
-- Name: salas; Type: TABLE; Schema: sala; Owner: chris
--

CREATE TABLE sala.salas (
    id_sala bigint NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    id_usuario_atualizacao bigint NOT NULL,
    id_usuario_criacao bigint NOT NULL,
    ativa boolean NOT NULL,
    codigo character varying(15) NOT NULL,
    nome character varying(60) NOT NULL,
    id_usuario bigint NOT NULL
);


ALTER TABLE sala.salas OWNER TO chris;

--
-- TOC entry 257 (class 1259 OID 160641)
-- Name: salas_logs; Type: TABLE; Schema: sala; Owner: chris
--

CREATE TABLE sala.salas_logs (
    id_sala_log bigint NOT NULL,
    data_registro timestamp without time zone NOT NULL,
    descricao character varying(255) NOT NULL,
    id_sala bigint NOT NULL
);


ALTER TABLE sala.salas_logs OWNER TO chris;

--
-- TOC entry 256 (class 1259 OID 160620)
-- Name: salas_personagens; Type: TABLE; Schema: sala; Owner: chris
--

CREATE TABLE sala.salas_personagens (
    id_sala_persongem bigint NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    id_usuario_atualizacao bigint NOT NULL,
    id_usuario_criacao bigint NOT NULL,
    acesso character varying(2) NOT NULL,
    rdt_cansaco smallint DEFAULT 0 NOT NULL,
    rdt_contaminacao smallint DEFAULT 0 NOT NULL,
    rdt_estresse smallint DEFAULT 0 NOT NULL,
    rdt_ferimento smallint DEFAULT 0 NOT NULL,
    rdt_necessidade smallint DEFAULT 0 NOT NULL,
    rdt_postura smallint DEFAULT 0 NOT NULL,
    situacao character varying(2) NOT NULL,
    id_personagem bigint NOT NULL,
    id_sala bigint NOT NULL
);


ALTER TABLE sala.salas_personagens OWNER TO chris;

--
-- TOC entry 3266 (class 0 OID 143577)
-- Dependencies: 219
-- Data for Name: capacidades_auditoria; Type: TABLE DATA; Schema: auditoria; Owner: chris
--



--
-- TOC entry 3270 (class 0 OID 151828)
-- Dependencies: 223
-- Data for Name: capacidades_personagens_auditoria; Type: TABLE DATA; Schema: auditoria; Owner: chris
--



--
-- TOC entry 3268 (class 0 OID 143640)
-- Dependencies: 221
-- Data for Name: personagens_auditoria; Type: TABLE DATA; Schema: auditoria; Owner: chris
--

INSERT INTO auditoria.personagens_auditoria VALUES (11, 3, 0, '2023-05-09 10:26:41.126', '2023-05-09 10:26:41.126', 2, 2, 'Char teste', 'Halin', 'Clarin', NULL, 5, 106, 21);
INSERT INTO auditoria.personagens_auditoria VALUES (12, 4, 0, '2023-05-09 10:41:05.288', '2023-05-09 10:41:05.288', 2, 2, 'The Keeper', NULL, 'Myrian', NULL, 5, 106, 21);
INSERT INTO auditoria.personagens_auditoria VALUES (13, 5, 0, '2023-05-10 11:01:29.998', '2023-05-10 11:01:29.998', 2, 2, 'The Sage', '''Ymesh', 'Hakar', NULL, 1, 1, 1);


--
-- TOC entry 3292 (class 0 OID 160489)
-- Dependencies: 245
-- Data for Name: salas_auditoria; Type: TABLE DATA; Schema: auditoria; Owner: chris
--

INSERT INTO auditoria.salas_auditoria VALUES (2, 6, 0, '2023-05-25 14:51:55.049', '2023-05-25 14:51:55.049', 2, 2, true, 'TESTE', 'A guerra da rosa', 2);
INSERT INTO auditoria.salas_auditoria VALUES (3, 58, 0, '2023-06-17 11:26:16.226', '2023-06-17 11:26:16.226', 2, 2, true, 'DIAMANTE', 'O diamante de Evergleen', 2);
INSERT INTO auditoria.salas_auditoria VALUES (4, 59, 0, '2023-06-17 11:27:33.504', '2023-06-17 11:27:33.504', 2, 2, true, 'ROCHANEGRA', 'Cerco ao Forte Rocha Negra', 2);
INSERT INTO auditoria.salas_auditoria VALUES (5, 60, 0, '2023-06-17 11:28:14.786', '2023-06-17 11:28:14.786', 2, 2, true, 'MISTPANTANO', 'O mistério do pantano', 2);
INSERT INTO auditoria.salas_auditoria VALUES (6, 61, 0, '2023-06-17 11:28:56.222', '2023-06-17 11:28:56.222', 2, 2, true, 'NEVESANGUE', 'Neve e sangue', 2);


--
-- TOC entry 3293 (class 0 OID 160494)
-- Dependencies: 246
-- Data for Name: salas_personagens_auditoria; Type: TABLE DATA; Schema: auditoria; Owner: chris
--

INSERT INTO auditoria.salas_personagens_auditoria VALUES (2, 7, 0, '2023-05-26 13:40:48.725', '2023-05-26 13:40:48.725', 2, 2, 0, 0, 0, 0, 0, 0, 0, 12, 2, NULL, NULL);
INSERT INTO auditoria.salas_personagens_auditoria VALUES (3, 8, 0, '2023-05-29 08:45:59.7', '2023-05-29 08:45:59.7', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'SO', NULL);
INSERT INTO auditoria.salas_personagens_auditoria VALUES (4, 9, 0, '2023-05-29 10:01:59.97', '2023-05-29 10:01:59.97', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'SO', NULL);
INSERT INTO auditoria.salas_personagens_auditoria VALUES (5, 10, 0, '2023-05-29 10:43:33.879', '2023-05-29 10:43:33.879', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (6, 11, 0, '2023-05-29 11:18:37.242', '2023-05-29 11:18:37.242', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (6, 12, 1, '2023-05-29 14:33:10.323', '2023-05-29 11:18:37.242', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (7, 13, 0, '2023-05-29 14:34:50.971', '2023-05-29 14:34:50.971', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (7, 14, 1, '2023-05-29 14:35:02.858', '2023-05-29 14:34:50.971', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (8, 15, 0, '2023-05-29 15:14:36.106', '2023-05-29 15:14:36.106', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (9, 16, 0, '2023-05-29 15:56:00.069', '2023-05-29 15:56:00.069', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (9, 17, 1, '2023-05-29 16:27:35.129', '2023-05-29 15:56:00.069', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (10, 18, 0, '2023-05-29 16:29:52.978', '2023-05-29 16:29:52.978', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (10, 19, 1, '2023-05-29 16:30:07.432', '2023-05-29 16:29:52.978', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (11, 20, 0, '2023-05-29 16:32:45.495', '2023-05-29 16:32:45.495', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (11, 21, 1, '2023-05-29 16:32:52.781', '2023-05-29 16:32:45.495', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (12, 22, 0, '2023-05-29 17:46:40.871', '2023-05-29 17:46:40.871', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (13, 23, 0, '2023-05-29 17:46:48.562', '2023-05-29 17:46:48.562', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (12, 24, 1, '2023-05-29 17:46:57.601', '2023-05-29 17:46:40.871', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (13, 25, 1, '2023-05-29 17:47:01.179', '2023-05-29 17:46:48.562', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 12, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (14, 26, 0, '2023-06-02 11:47:50.607', '2023-06-02 11:47:50.607', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (15, 27, 0, '2023-06-02 11:56:05.582', '2023-06-02 11:56:05.582', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (15, 28, 1, '2023-06-02 14:44:40.87', '2023-06-02 11:56:05.582', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (16, 29, 0, '2023-06-05 10:48:13.758', '2023-06-05 10:48:13.758', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (16, 30, 1, '2023-06-05 10:51:03.375', '2023-06-05 10:48:13.758', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'NG');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (17, 31, 0, '2023-06-05 10:54:35.595', '2023-06-05 10:54:35.595', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (18, 32, 0, '2023-06-05 11:37:20.055', '2023-06-05 11:37:20.055', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (19, 32, 0, '2023-06-05 11:37:20.055', '2023-06-05 11:37:20.055', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (20, 33, 0, '2023-06-06 13:00:56.503', '2023-06-06 13:00:56.503', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (21, 33, 0, '2023-06-06 13:00:56.503', '2023-06-06 13:00:56.503', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (22, 34, 0, '2023-06-06 13:02:55.779', '2023-06-06 13:02:55.779', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (23, 34, 0, '2023-06-06 13:02:55.779', '2023-06-06 13:02:55.779', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (24, 35, 0, '2023-06-06 13:08:24.414', '2023-06-06 13:08:24.414', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (25, 36, 0, '2023-06-06 13:10:21.977', '2023-06-06 13:10:21.977', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (25, 37, 1, '2023-06-06 13:15:51.278', '2023-06-06 13:10:21.977', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (26, 38, 0, '2023-06-06 13:20:07.213', '2023-06-06 13:20:07.213', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (27, 39, 0, '2023-06-06 13:21:15.708', '2023-06-06 13:21:15.708', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (28, 40, 0, '2023-06-06 13:22:43.132', '2023-06-06 13:22:43.132', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (29, 41, 0, '2023-06-06 13:23:30.436', '2023-06-06 13:23:30.436', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (30, 42, 0, '2023-06-06 13:24:41.466', '2023-06-06 13:24:41.466', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (31, 43, 0, '2023-06-06 13:26:21.84', '2023-06-06 13:26:21.84', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (32, 44, 0, '2023-06-06 13:32:25.484', '2023-06-06 13:32:25.484', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (32, 45, 1, '2023-06-06 13:32:35.634', '2023-06-06 13:32:25.484', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (33, 46, 0, '2023-06-06 13:35:57.488', '2023-06-06 13:35:57.488', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (33, 47, 1, '2023-06-06 13:36:05.174', '2023-06-06 13:35:57.488', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (34, 48, 0, '2023-06-06 13:41:50.675', '2023-06-06 13:41:50.675', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (34, 49, 1, '2023-06-06 13:41:59.671', '2023-06-06 13:41:50.675', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 11, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (35, 50, 0, '2023-06-06 13:42:35.876', '2023-06-06 13:42:35.876', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (35, 51, 1, '2023-06-06 13:42:41.211', '2023-06-06 13:42:35.876', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'AP');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (36, 52, 0, '2023-06-06 13:49:07.823', '2023-06-06 13:49:07.823', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'SO');
INSERT INTO auditoria.salas_personagens_auditoria VALUES (36, 53, 1, '2023-06-06 13:53:34.118', '2023-06-06 13:49:07.823', 2, 2, 0, 0, 0, 0, 0, 0, NULL, 13, 2, 'OF', 'AP');


--
-- TOC entry 3258 (class 0 OID 135773)
-- Dependencies: 211
-- Data for Name: usuarios_auditoria; Type: TABLE DATA; Schema: auditoria; Owner: chris
--

INSERT INTO auditoria.usuarios_auditoria VALUES (2, 1, 0, '2023-03-24 15:31:27.543', '2023-03-24 15:31:27.543', 0, 0, true, NULL, 'Jf6WbcZM9q', 'chrisley619@gmail.com', 'chris', 'PWf58hFbjT', '9f9BXvwsE1K0Ird0B3mZWYwpBhgGu2h06hPrrq4OBx4=');
INSERT INTO auditoria.usuarios_auditoria VALUES (7, 2, 0, '2023-03-24 16:48:16.038', '2023-03-24 16:48:16.038', 0, 0, true, NULL, 'UJapHGktZn', 'teste1@gmail.com', 'teste1', 'TqHdnG7Fd1', 'yJ3Tu4ujkHXmaKXIdQzuhA9PRd6JAzqjYpya0JoeFjw=');
INSERT INTO auditoria.usuarios_auditoria VALUES (16, 54, 0, '2023-06-16 13:21:11.33', '2023-06-16 13:21:11.33', 0, 0, true, NULL, 'XhUhOraMAI', 'userteste@gmail.com', 'teste2', 'ejpAK4xdSS', 'jHTvbTA0C97Ac+PQPmrzV+gCfoAUFFHcIN5a48FtMdw=');
INSERT INTO auditoria.usuarios_auditoria VALUES (17, 55, 0, '2023-06-16 13:22:09.829', '2023-06-16 13:22:09.829', 0, 0, true, NULL, 'igsNVEn744', 'mari4567@gmail.com', 'Mariana', '8MkFY7kDGT', '8dXJWb4x2nY9gvH0rcZID23TVhRfLdpGoMlj33YyEno=');
INSERT INTO auditoria.usuarios_auditoria VALUES (18, 56, 0, '2023-06-16 13:22:38.04', '2023-06-16 13:22:38.04', 0, 0, true, NULL, '6JbhYYJhhx', 'marikaTheEternal@hotmail.com', 'Marika', 'h2DzrI2M1K', '0zdtErSvN95HJurkFxDuZcR6+R41RBXOFJAJUU36O5g=');
INSERT INTO auditoria.usuarios_auditoria VALUES (19, 57, 0, '2023-06-16 13:23:04.4', '2023-06-16 13:23:04.4', 0, 0, true, NULL, 'ninnTKfbeD', 'cleiarodriguesdossantos@hotmail.com', 'Cleia Rodrigues', 'ow0yHROgb3', 'r28E9gtocIzLDjfuheGvwjBVwkkM5bIK4cXtfReDzbc=');


--
-- TOC entry 3257 (class 0 OID 135216)
-- Dependencies: 210
-- Data for Name: usuarios; Type: TABLE DATA; Schema: cadastro; Owner: chris
--

INSERT INTO cadastro.usuarios VALUES (2, '2023-03-24 15:31:27.543', '2023-03-24 15:31:27.543', 0, 0, true, NULL, 'chrisley619@gmail.com', 'chris', '9f9BXvwsE1K0Ird0B3mZWYwpBhgGu2h06hPrrq4OBx4=', 'Jf6WbcZM9q', 'PWf58hFbjT');
INSERT INTO cadastro.usuarios VALUES (7, '2023-03-24 16:48:16.038', '2023-03-24 16:48:16.038', 0, 0, true, NULL, 'teste1@gmail.com', 'teste1', 'yJ3Tu4ujkHXmaKXIdQzuhA9PRd6JAzqjYpya0JoeFjw=', 'UJapHGktZn', 'TqHdnG7Fd1');
INSERT INTO cadastro.usuarios VALUES (16, '2023-06-16 13:21:11.33', '2023-06-16 13:21:11.33', 0, 0, true, NULL, 'userteste@gmail.com', 'teste2', 'jHTvbTA0C97Ac+PQPmrzV+gCfoAUFFHcIN5a48FtMdw=', 'XhUhOraMAI', 'ejpAK4xdSS');
INSERT INTO cadastro.usuarios VALUES (17, '2023-06-16 13:22:09.829', '2023-06-16 13:22:09.829', 0, 0, true, NULL, 'mari4567@gmail.com', 'Mariana', '8dXJWb4x2nY9gvH0rcZID23TVhRfLdpGoMlj33YyEno=', 'igsNVEn744', '8MkFY7kDGT');
INSERT INTO cadastro.usuarios VALUES (18, '2023-06-16 13:22:38.04', '2023-06-16 13:22:38.04', 0, 0, true, NULL, 'marikaTheEternal@hotmail.com', 'Marika', '0zdtErSvN95HJurkFxDuZcR6+R41RBXOFJAJUU36O5g=', '6JbhYYJhhx', 'h2DzrI2M1K');
INSERT INTO cadastro.usuarios VALUES (19, '2023-06-16 13:23:04.4', '2023-06-16 13:23:04.4', 0, 0, true, NULL, 'cleiarodriguesdossantos@hotmail.com', 'Cleia Rodrigues', 'r28E9gtocIzLDjfuheGvwjBVwkkM5bIK4cXtfReDzbc=', 'ninnTKfbeD', 'ow0yHROgb3');


--
-- TOC entry 3291 (class 0 OID 160455)
-- Dependencies: 244
-- Data for Name: usuarios_personagens; Type: TABLE DATA; Schema: cadastro; Owner: chris
--

INSERT INTO cadastro.usuarios_personagens VALUES (13, 11, 2);
INSERT INTO cadastro.usuarios_personagens VALUES (14, 12, 2);
INSERT INTO cadastro.usuarios_personagens VALUES (15, 13, 2);


--
-- TOC entry 3275 (class 0 OID 151955)
-- Dependencies: 228
-- Data for Name: capacidades_game_data; Type: TABLE DATA; Schema: capacidade; Owner: postgres
--

INSERT INTO capacidade.capacidades_game_data VALUES (104, 'Disposição', 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1);
INSERT INTO capacidade.capacidades_game_data VALUES (105, 'Furtividade', 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (107, 'Persuasão', 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (108, 'Simpatia', 0, 0, 2, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (109, 'Irreverência', 0, 0, 1, 0, 0, 0, 2, 0, 1, 0, 0, 1, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (110, 'Eloquência ', 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (111, 'Sagacidade', 0, 2, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (112, 'Astúcia', 0, 1, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (113, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (114, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (2, 'Esp Igneray', 1, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1);
INSERT INTO capacidade.capacidades_game_data VALUES (3, 'Esp Andrano', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (4, 'Esp Azhad', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (5, 'Esp Humano', 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1);
INSERT INTO capacidade.capacidades_game_data VALUES (6, 'Esp Wanari', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (7, 'Esp Yharin', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (8, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (9, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (10, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (11, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (12, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (13, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (14, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (15, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (16, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (17, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (18, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (19, 'Esp OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (22, 'Esp Kyrath Raca Syemenur', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (23, 'Esp Kyrath Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (24, 'Esp Kyrath Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (25, 'Esp Kyrath Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (26, 'Esp Igneray Raca Azerak', 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (27, 'Esp Igneray Raca Sarok', 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (28, 'Esp Igneray Raca Imorak', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (29, 'Esp Igneray Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (30, 'Esp Igneray Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (31, 'Esp Andrano Raca Mukhrani', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (33, 'Esp Andrano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (34, 'Esp Andrano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (35, 'Esp Andrano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (36, 'Esp Azhad Raca Morthrax', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (37, 'Esp Azhad Raca Vemyr', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (38, 'Esp Azhad Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (39, 'Esp Azhad Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (40, 'Esp Azhad Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (41, 'Esp Humano Raca Ehleni', 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (42, 'Esp Humano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (44, 'Esp Humano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (45, 'Esp Humano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (102, 'Robustez', 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (103, 'Fortitude', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 2);
INSERT INTO capacidade.capacidades_game_data VALUES (115, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (116, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (117, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (118, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (119, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (120, 'Qualidade OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (121, 'Fragilidade', 0, 0, 0, 0, -2, 0, -1, 0, 0, 0, -2, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (122, 'Indisposição', 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -2, 0, 0, 0, -2);
INSERT INTO capacidade.capacidades_game_data VALUES (123, 'Morbidez', -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -2, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (124, 'Desajeito', -1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (125, 'Descoordenação', -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (126, 'Brusquidão', 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (127, 'Antipatia', 0, -1, -3, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (128, 'Insegurança', 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, -3, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (129, 'Passividade', 0, -1, 0, 0, 0, 0, -3, 0, -1, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (130, 'Desatenção', 0, -2, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (131, 'Impulsividade', 0, -1, 0, 0, 0, 0, 0, 0, -1, -2, 0, 0, -1, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (132, 'Vulnerabilidade', 0, 0, 0, 0, -1, -2, 0, 0, 0, 0, -1, 0, 0, 0, -1);
INSERT INTO capacidade.capacidades_game_data VALUES (133, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (134, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (135, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (136, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (138, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (139, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (140, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (141, 'Investida', 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (142, 'Defesa', 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (143, 'Evasão', 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (144, 'Resiliência', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1);
INSERT INTO capacidade.capacidades_game_data VALUES (145, 'Corrida', 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
INSERT INTO capacidade.capacidades_game_data VALUES (146, 'Mira', 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (147, 'Discrição', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (148, 'Acrobacia', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (150, 'Negociação', 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (151, 'Intimidação', 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (149, 'Cognição', 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (152, 'Cortesia', 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (1, 'Esp Kyrath', 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (21, 'Esp Kyrath Raca Yoriiz', 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (32, 'Esp Andrano Raca Vhendruvio', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (43, 'Esp Humano Raca OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (101, 'Condicionamento', 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1);
INSERT INTO capacidade.capacidades_game_data VALUES (106, 'Destreza', 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (137, 'Defeito OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (153, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (154, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (155, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (156, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (157, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (158, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (159, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (160, 'Treinamento OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (200, 'Skill OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO capacidade.capacidades_game_data VALUES (1000, 'OPEN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);


--
-- TOC entry 3269 (class 0 OID 151823)
-- Dependencies: 222
-- Data for Name: capacidades_npcs; Type: TABLE DATA; Schema: capacidade; Owner: postgres
--



--
-- TOC entry 3302 (class 0 OID 160586)
-- Dependencies: 255
-- Data for Name: armas; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.armas VALUES (1, 'Ataques desarmados, socos e chutes', 'Desarmado', 0.00, 3, 0, 4, 'CM', 0.00);


--
-- TOC entry 3273 (class 0 OID 151837)
-- Dependencies: 226
-- Data for Name: caracteristicas; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.caracteristicas VALUES (30, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Desatenção', 'D', 130);
INSERT INTO game_data.caracteristicas VALUES (31, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Impulsividade', 'D', 131);
INSERT INTO game_data.caracteristicas VALUES (32, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Vulnerabilidade', 'D', 132);
INSERT INTO game_data.caracteristicas VALUES (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Robustez', 'Q', 102);
INSERT INTO game_data.caracteristicas VALUES (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Fortitude', 'Q', 103);
INSERT INTO game_data.caracteristicas VALUES (4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Velocidade', 'Q', 104);
INSERT INTO game_data.caracteristicas VALUES (5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Furtividade', 'Q', 105);
INSERT INTO game_data.caracteristicas VALUES (6, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Habilidade', 'Q', 106);
INSERT INTO game_data.caracteristicas VALUES (7, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Persuasão', 'Q', 107);
INSERT INTO game_data.caracteristicas VALUES (8, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Simpatia', 'Q', 108);
INSERT INTO game_data.caracteristicas VALUES (9, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Irreverência', 'Q', 109);
INSERT INTO game_data.caracteristicas VALUES (10, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Eloquência', 'Q', 110);
INSERT INTO game_data.caracteristicas VALUES (11, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Sagacidade', 'Q', 111);
INSERT INTO game_data.caracteristicas VALUES (12, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Astúcia', 'Q', 112);
INSERT INTO game_data.caracteristicas VALUES (21, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Fragilidade', 'D', 121);
INSERT INTO game_data.caracteristicas VALUES (22, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Sedentarismo', 'D', 122);
INSERT INTO game_data.caracteristicas VALUES (23, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Debilidade', 'D', 123);
INSERT INTO game_data.caracteristicas VALUES (24, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Desajeito', 'D', 124);
INSERT INTO game_data.caracteristicas VALUES (25, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Imprecisão', 'D', 125);
INSERT INTO game_data.caracteristicas VALUES (26, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Brusquidão', 'D', 126);
INSERT INTO game_data.caracteristicas VALUES (27, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Antipatia', 'D', 127);
INSERT INTO game_data.caracteristicas VALUES (28, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Insegurança', 'D', 128);
INSERT INTO game_data.caracteristicas VALUES (29, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Passividade', 'D', 129);
INSERT INTO game_data.caracteristicas VALUES (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porttitor a ipsum id fringilla.', 'Condicionamento', 'Q', 101);


--
-- TOC entry 3283 (class 0 OID 155177)
-- Dependencies: 236
-- Data for Name: conhecimentos; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.conhecimentos VALUES (1, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Viajante', 1);
INSERT INTO game_data.conhecimentos VALUES (2, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Investigador', 1);
INSERT INTO game_data.conhecimentos VALUES (3, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Criminoso', 1);
INSERT INTO game_data.conhecimentos VALUES (4, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Músico', 1);
INSERT INTO game_data.conhecimentos VALUES (5, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Navegador', 1);
INSERT INTO game_data.conhecimentos VALUES (6, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Militar', 1);
INSERT INTO game_data.conhecimentos VALUES (7, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Nobre', 1);
INSERT INTO game_data.conhecimentos VALUES (8, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Meretriz', 1);
INSERT INTO game_data.conhecimentos VALUES (9, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Performista', 1);
INSERT INTO game_data.conhecimentos VALUES (10, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Escrivão', 1);
INSERT INTO game_data.conhecimentos VALUES (21, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Ferraria', 2);
INSERT INTO game_data.conhecimentos VALUES (22, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Joalheria', 2);
INSERT INTO game_data.conhecimentos VALUES (23, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Carpintaria', 2);
INSERT INTO game_data.conhecimentos VALUES (24, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Tecelagem', 2);
INSERT INTO game_data.conhecimentos VALUES (25, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Alfaiararia ', 2);
INSERT INTO game_data.conhecimentos VALUES (26, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Herbalismo', 2);
INSERT INTO game_data.conhecimentos VALUES (41, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'História', 3);
INSERT INTO game_data.conhecimentos VALUES (42, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Política', 3);
INSERT INTO game_data.conhecimentos VALUES (43, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Geografia', 3);
INSERT INTO game_data.conhecimentos VALUES (44, 'Os conhecimentos de xxxx incluem xxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxx, xxxxxxxxxxxxxxxxxxxxxxxxxx, entre outras atribuições relacionadas a xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx. Esse conhecimento é comum para xxxxxx, xxxxxx, xxxxx, xxxx etc.', 'Botânica', 3);


--
-- TOC entry 3276 (class 0 OID 152102)
-- Dependencies: 229
-- Data for Name: especies; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.especies VALUES (5, 'A espécie humana... Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vestibulum, dolor eget luctus volutpat, massa neque suscipit ligula, quis luctus lectus ligula ac velit. Integer ultricies quis lacus facilisis ultrices. Etiam vel consectetur eros. Ut id aliquam dui, vel pulvinar enim. Proin id semper massa, eu accumsan elit.', 'Humano', 5);
INSERT INTO game_data.especies VALUES (1, 'Os Kyraths são... Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vestibulum, dolor eget luctus volutpat, massa neque suscipit ligula, quis luctus lectus ligula ac velit. Integer ultricies quis lacus facilisis ultrices. Etiam vel consectetur eros. Ut id aliquam dui, vel pulvinar enim. Proin id semper massa, eu accumsan elit.', 'Kyrath', 1);
INSERT INTO game_data.especies VALUES (1000, 'Linha final', 'final', 1);
INSERT INTO game_data.especies VALUES (2, 'Os Igneray habitam... Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vestibulum, dolor eget luctus volutpat, massa neque suscipit ligula, quis luctus lectus ligula ac velit. Integer ultricies quis lacus facilisis ultrices. Etiam vel consectetur eros. Ut id aliquam dui, vel pulvinar enim. Proin id semper massa, eu accumsan elit.', 'Igneray', 2);


--
-- TOC entry 3277 (class 0 OID 152110)
-- Dependencies: 230
-- Data for Name: etnias; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.etnias VALUES (1000, 'Linha final', 'final', NULL, 1000, 1000);
INSERT INTO game_data.etnias VALUES (1, 'Os Avynir são parte dos Kyrath Yoriiz, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Avynir', NULL, 1, 1);
INSERT INTO game_data.etnias VALUES (26, 'Os Azeruth são parte dos Igneray Azerak, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Azeruth', NULL, 2, 6);
INSERT INTO game_data.etnias VALUES (27, 'Os Iralik são parte dos Igneray Azerak, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Iralik', NULL, 2, 6);
INSERT INTO game_data.etnias VALUES (106, 'Os Akroy são um povo dentre os Humanos Ehleni, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Akroy', NULL, 5, 21);
INSERT INTO game_data.etnias VALUES (107, 'Os Hendrixo são um povo dentre os Humanos Ehleni, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Hendrixo', NULL, 5, 21);
INSERT INTO game_data.etnias VALUES (108, 'Os Jaremita são um povo dentre os Humanos Ehleni, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Jaremita', NULL, 5, 21);
INSERT INTO game_data.etnias VALUES (31, 'Os Tharyn são parte dos Igneray Saroks, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Tharyn', NULL, 2, 7);
INSERT INTO game_data.etnias VALUES (32, 'Os Venazari são parte dos Igneray Saroks, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Venazari', NULL, 2, 7);


--
-- TOC entry 3274 (class 0 OID 151857)
-- Dependencies: 227
-- Data for Name: personalidades; Type: TABLE DATA; Schema: game_data; Owner: chris
--



--
-- TOC entry 3278 (class 0 OID 152118)
-- Dependencies: 231
-- Data for Name: racas; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.racas VALUES (1000, 'Linha final', 'final', 1, 1000);
INSERT INTO game_data.racas VALUES (1, 'Os Yoriiz são uma raça de Kyrath....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Yoriiz', 21, 1);
INSERT INTO game_data.racas VALUES (6, 'Os Azeraks são uma raça de Igneray.. Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Azerak', 26, 2);
INSERT INTO game_data.racas VALUES (7, 'Os Saroks são uma raça de Igneray.... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Sarok', 27, 2);
INSERT INTO game_data.racas VALUES (21, 'Os Ehleni são uma raça de Humano... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.', 'Ehleni', 41, 5);


--
-- TOC entry 3280 (class 0 OID 155155)
-- Dependencies: 233
-- Data for Name: tipos_conhecimentos; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.tipos_conhecimentos VALUES (1, 'Os conhecimentos por antecedente são...', 'Antecedentes');
INSERT INTO game_data.tipos_conhecimentos VALUES (2, 'Os conhecimentos de ofício são...', 'Ofício');
INSERT INTO game_data.tipos_conhecimentos VALUES (3, 'Os conhecimentos teóricos...', 'Teórico');


--
-- TOC entry 3282 (class 0 OID 155167)
-- Dependencies: 235
-- Data for Name: treinamentos; Type: TABLE DATA; Schema: game_data; Owner: chris
--

INSERT INTO game_data.treinamentos VALUES (11, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Intimidação', 151);
INSERT INTO game_data.treinamentos VALUES (12, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Empatia', 152);
INSERT INTO game_data.treinamentos VALUES (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Investida', 141);
INSERT INTO game_data.treinamentos VALUES (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Defesa', 142);
INSERT INTO game_data.treinamentos VALUES (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Evasão', 143);
INSERT INTO game_data.treinamentos VALUES (4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Resiliência', 144);
INSERT INTO game_data.treinamentos VALUES (5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Velocidade', 145);
INSERT INTO game_data.treinamentos VALUES (6, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Mira', 146);
INSERT INTO game_data.treinamentos VALUES (7, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Furtividade', 147);
INSERT INTO game_data.treinamentos VALUES (8, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Acrobacia', 148);
INSERT INTO game_data.treinamentos VALUES (9, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Cognição', 149);
INSERT INTO game_data.treinamentos VALUES (10, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu tempus lectus, eget auctor leo. Proin ut magna ipsum. Nulla ultricies lectus eget ante dapibus,', 'Negociação', 150);


--
-- TOC entry 3290 (class 0 OID 160415)
-- Dependencies: 243
-- Data for Name: personagens; Type: TABLE DATA; Schema: personagem; Owner: chris
--

INSERT INTO personagem.personagens VALUES (11, '2023-05-09 10:26:41.126', '2023-05-09 10:26:41.126', 2, 2, 'Char teste', 'Halin', 'Clarin', 5, 106, 21);
INSERT INTO personagem.personagens VALUES (13, '2023-05-10 11:01:29.998', '2023-05-10 11:01:29.998', 2, 2, 'The Sage', '''Ymesh', 'Hakar', 1, 1, 1);
INSERT INTO personagem.personagens VALUES (12, '2023-05-09 10:41:05.288', '2023-05-09 10:41:05.288', 2, 2, 'The Keeper', ' ', 'Myrian', 5, 106, 21);


--
-- TOC entry 3300 (class 0 OID 160568)
-- Dependencies: 253
-- Data for Name: personagens_armas; Type: TABLE DATA; Schema: personagem; Owner: chris
--

INSERT INTO personagem.personagens_armas VALUES (1, 1, 11);
INSERT INTO personagem.personagens_armas VALUES (2, 1, 12);
INSERT INTO personagem.personagens_armas VALUES (3, 1, 13);


--
-- TOC entry 3284 (class 0 OID 160364)
-- Dependencies: 237
-- Data for Name: personagens_caracteristicas; Type: TABLE DATA; Schema: personagem; Owner: chris
--

INSERT INTO personagem.personagens_caracteristicas VALUES (10, 1, 11);
INSERT INTO personagem.personagens_caracteristicas VALUES (11, 23, 11);
INSERT INTO personagem.personagens_caracteristicas VALUES (12, 1, 12);
INSERT INTO personagem.personagens_caracteristicas VALUES (13, 21, 12);
INSERT INTO personagem.personagens_caracteristicas VALUES (14, 10, 13);
INSERT INTO personagem.personagens_caracteristicas VALUES (15, 32, 13);


--
-- TOC entry 3285 (class 0 OID 160369)
-- Dependencies: 238
-- Data for Name: personagens_conhecimentos; Type: TABLE DATA; Schema: personagem; Owner: chris
--

INSERT INTO personagem.personagens_conhecimentos VALUES (26, 1, 11);
INSERT INTO personagem.personagens_conhecimentos VALUES (27, 2, 11);
INSERT INTO personagem.personagens_conhecimentos VALUES (28, 1, 11);
INSERT INTO personagem.personagens_conhecimentos VALUES (29, 2, 11);
INSERT INTO personagem.personagens_conhecimentos VALUES (30, 1, 11);
INSERT INTO personagem.personagens_conhecimentos VALUES (31, 2, 11);
INSERT INTO personagem.personagens_conhecimentos VALUES (32, 1, 12);
INSERT INTO personagem.personagens_conhecimentos VALUES (33, 2, 12);
INSERT INTO personagem.personagens_conhecimentos VALUES (34, 1, 12);
INSERT INTO personagem.personagens_conhecimentos VALUES (35, 2, 12);
INSERT INTO personagem.personagens_conhecimentos VALUES (36, 1, 12);
INSERT INTO personagem.personagens_conhecimentos VALUES (37, 2, 12);
INSERT INTO personagem.personagens_conhecimentos VALUES (38, 41, 13);
INSERT INTO personagem.personagens_conhecimentos VALUES (39, 42, 13);
INSERT INTO personagem.personagens_conhecimentos VALUES (40, 41, 13);
INSERT INTO personagem.personagens_conhecimentos VALUES (41, 42, 13);
INSERT INTO personagem.personagens_conhecimentos VALUES (42, 41, 13);
INSERT INTO personagem.personagens_conhecimentos VALUES (43, 42, 13);


--
-- TOC entry 3297 (class 0 OID 160542)
-- Dependencies: 250
-- Data for Name: personagens_personalidade; Type: TABLE DATA; Schema: personagem; Owner: chris
--



--
-- TOC entry 3286 (class 0 OID 160374)
-- Dependencies: 239
-- Data for Name: personagens_treinamentos; Type: TABLE DATA; Schema: personagem; Owner: chris
--

INSERT INTO personagem.personagens_treinamentos VALUES (14, 11, 2);
INSERT INTO personagem.personagens_treinamentos VALUES (15, 11, 3);
INSERT INTO personagem.personagens_treinamentos VALUES (16, 11, 6);
INSERT INTO personagem.personagens_treinamentos VALUES (17, 12, 1);
INSERT INTO personagem.personagens_treinamentos VALUES (18, 12, 2);
INSERT INTO personagem.personagens_treinamentos VALUES (19, 12, 3);
INSERT INTO personagem.personagens_treinamentos VALUES (20, 13, 3);
INSERT INTO personagem.personagens_treinamentos VALUES (21, 13, 6);
INSERT INTO personagem.personagens_treinamentos VALUES (22, 13, 9);


--
-- TOC entry 3255 (class 0 OID 135195)
-- Dependencies: 208
-- Data for Name: revinfo; Type: TABLE DATA; Schema: public; Owner: chris
--

INSERT INTO public.revinfo VALUES (1, 1679682687631);
INSERT INTO public.revinfo VALUES (2, 1679687296102);
INSERT INTO public.revinfo VALUES (3, 1683638801206);
INSERT INTO public.revinfo VALUES (4, 1683639665308);
INSERT INTO public.revinfo VALUES (5, 1683727290105);
INSERT INTO public.revinfo VALUES (6, 1685037119362);
INSERT INTO public.revinfo VALUES (7, 1685119252379);
INSERT INTO public.revinfo VALUES (8, 1685360763336);
INSERT INTO public.revinfo VALUES (9, 1685365319980);
INSERT INTO public.revinfo VALUES (10, 1685367813927);
INSERT INTO public.revinfo VALUES (11, 1685369917249);
INSERT INTO public.revinfo VALUES (12, 1685381593704);
INSERT INTO public.revinfo VALUES (13, 1685381690980);
INSERT INTO public.revinfo VALUES (14, 1685381702861);
INSERT INTO public.revinfo VALUES (15, 1685384076111);
INSERT INTO public.revinfo VALUES (16, 1685386560112);
INSERT INTO public.revinfo VALUES (17, 1685388455169);
INSERT INTO public.revinfo VALUES (18, 1685388592987);
INSERT INTO public.revinfo VALUES (19, 1685388607435);
INSERT INTO public.revinfo VALUES (20, 1685388765500);
INSERT INTO public.revinfo VALUES (21, 1685388772785);
INSERT INTO public.revinfo VALUES (22, 1685393200886);
INSERT INTO public.revinfo VALUES (23, 1685393208566);
INSERT INTO public.revinfo VALUES (24, 1685393217605);
INSERT INTO public.revinfo VALUES (25, 1685393221182);
INSERT INTO public.revinfo VALUES (26, 1685717270664);
INSERT INTO public.revinfo VALUES (27, 1685717765587);
INSERT INTO public.revinfo VALUES (28, 1685727880905);
INSERT INTO public.revinfo VALUES (29, 1685972896623);
INSERT INTO public.revinfo VALUES (30, 1685973063417);
INSERT INTO public.revinfo VALUES (31, 1685973275602);
INSERT INTO public.revinfo VALUES (32, 1685975840110);
INSERT INTO public.revinfo VALUES (33, 1686067256568);
INSERT INTO public.revinfo VALUES (34, 1686067375790);
INSERT INTO public.revinfo VALUES (35, 1686067704475);
INSERT INTO public.revinfo VALUES (36, 1686067821983);
INSERT INTO public.revinfo VALUES (37, 1686068151324);
INSERT INTO public.revinfo VALUES (38, 1686068407225);
INSERT INTO public.revinfo VALUES (39, 1686068475713);
INSERT INTO public.revinfo VALUES (40, 1686068563137);
INSERT INTO public.revinfo VALUES (41, 1686068610441);
INSERT INTO public.revinfo VALUES (42, 1686068681471);
INSERT INTO public.revinfo VALUES (43, 1686068781847);
INSERT INTO public.revinfo VALUES (44, 1686069145489);
INSERT INTO public.revinfo VALUES (45, 1686069155638);
INSERT INTO public.revinfo VALUES (46, 1686069357496);
INSERT INTO public.revinfo VALUES (47, 1686069365179);
INSERT INTO public.revinfo VALUES (48, 1686069710681);
INSERT INTO public.revinfo VALUES (49, 1686069719675);
INSERT INTO public.revinfo VALUES (50, 1686069755881);
INSERT INTO public.revinfo VALUES (51, 1686069761215);
INSERT INTO public.revinfo VALUES (52, 1686070147828);
INSERT INTO public.revinfo VALUES (53, 1686070414123);
INSERT INTO public.revinfo VALUES (54, 1686932471423);
INSERT INTO public.revinfo VALUES (55, 1686932529836);
INSERT INTO public.revinfo VALUES (56, 1686932558047);
INSERT INTO public.revinfo VALUES (57, 1686932584407);
INSERT INTO public.revinfo VALUES (58, 1687011976276);
INSERT INTO public.revinfo VALUES (59, 1687012053510);
INSERT INTO public.revinfo VALUES (60, 1687012094790);
INSERT INTO public.revinfo VALUES (61, 1687012136226);


--
-- TOC entry 3294 (class 0 OID 160499)
-- Dependencies: 247
-- Data for Name: salas; Type: TABLE DATA; Schema: sala; Owner: chris
--

INSERT INTO sala.salas VALUES (2, '2023-05-25 14:51:55.049', '2023-05-25 14:51:55.049', 2, 2, true, 'TESTE', 'A guerra da rosa', 2);
INSERT INTO sala.salas VALUES (3, '2023-06-17 11:26:16.226', '2023-06-17 11:26:16.226', 2, 2, true, 'DIAMANTE', 'O diamante de Evergleen', 2);
INSERT INTO sala.salas VALUES (4, '2023-06-17 11:27:33.504', '2023-06-17 11:27:33.504', 2, 2, true, 'ROCHANEGRA', 'Cerco ao Forte Rocha Negra', 2);
INSERT INTO sala.salas VALUES (5, '2023-06-17 11:28:14.786', '2023-06-17 11:28:14.786', 2, 2, true, 'MISTPANTANO', 'O mistério do pantano', 2);
INSERT INTO sala.salas VALUES (6, '2023-06-17 11:28:56.222', '2023-06-17 11:28:56.222', 2, 2, true, 'NEVESANGUE', 'Neve e sangue', 2);


--
-- TOC entry 3304 (class 0 OID 160641)
-- Dependencies: 257
-- Data for Name: salas_logs; Type: TABLE DATA; Schema: sala; Owner: chris
--

INSERT INTO sala.salas_logs VALUES (73, '2023-06-06 13:49:07.824', 'SOLICITAÇÃO DE ACESSO -Hakar ''Ymesh The Sage (chris)', 2);
INSERT INTO sala.salas_logs VALUES (74, '2023-06-06 13:53:34.118', 'ACEITO - Hakar ''Ymesh The Sage (chris) entrou na campanha', 2);
INSERT INTO sala.salas_logs VALUES (75, '2023-06-06 13:53:48.936', 'AGL 3 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (76, '2023-06-06 13:53:51.885', 'MOB 5 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (77, '2023-06-06 13:53:55.034', 'ATN 18 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (78, '2023-06-06 13:54:15.584', 'DSV 6 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (79, '2023-06-06 13:54:32.076', 'CRÍTICO DSV 20 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (80, '2023-06-06 13:54:55.428', 'STZ 9 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (81, '2023-06-06 13:55:37.509', 'DSV 9 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (82, '2023-06-06 13:55:50.611', 'STZ 7 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (83, '2023-06-06 13:56:20.268', 'MOB 9 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (84, '2023-06-06 13:56:31.198', 'ERRO CRÍTICO TNA 3 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (85, '2023-06-06 13:56:50.841', 'CRÍTICO AGL 21 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (86, '2023-06-06 13:58:53.844', 'DSV 5 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (87, '2023-06-06 13:59:29.315', 'STZ 6 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (88, '2023-06-06 14:02:15.6', 'DSV 18 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (89, '2023-06-06 14:02:22.976', 'TNA 9 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (90, '2023-06-06 14:02:33.035', 'MOB 16 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (91, '2023-06-06 14:05:38.881', 'STZ 20 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (92, '2023-06-06 14:05:55.453', 'RES 12 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (93, '2023-06-06 14:06:05.837', 'MOB 16 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (94, '2023-06-06 14:07:00.396', 'DSV 7 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (95, '2023-06-06 14:07:07.142', 'MOB 15 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (96, '2023-06-06 14:09:17.698', 'DSV 4 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (97, '2023-06-06 14:09:42.787', 'DSV 2 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (98, '2023-06-06 14:13:17.024', 'MOB 16 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (99, '2023-06-06 14:19:19.016', 'DSV 10 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (100, '2023-06-06 14:19:48.76', 'MOB 7 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (101, '2023-06-06 14:20:18.568', 'FRC 18 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (102, '2023-06-06 14:23:31.847', 'MOB 14 - Hakar ''Ymesh', 2);
INSERT INTO sala.salas_logs VALUES (103, '2023-06-06 14:25:09.929', 'MOB 4 - Hakar ''Ymesh', 2);


--
-- TOC entry 3303 (class 0 OID 160620)
-- Dependencies: 256
-- Data for Name: salas_personagens; Type: TABLE DATA; Schema: sala; Owner: chris
--

INSERT INTO sala.salas_personagens VALUES (36, '2023-06-06 13:53:34.118', '2023-06-06 13:49:07.823', 2, 2, 'AP', 0, 0, 0, 0, 0, 0, 'OF', 13, 2);


--
-- TOC entry 3313 (class 0 OID 0)
-- Dependencies: 207
-- Name: usuario_seq; Type: SEQUENCE SET; Schema: cadastro; Owner: chris
--

SELECT pg_catalog.setval('cadastro.usuario_seq', 19, true);


--
-- TOC entry 3314 (class 0 OID 0)
-- Dependencies: 224
-- Name: capacidade_game_data_seq; Type: SEQUENCE SET; Schema: capacidade; Owner: chris
--

SELECT pg_catalog.setval('capacidade.capacidade_game_data_seq', 2, false);


--
-- TOC entry 3315 (class 0 OID 0)
-- Dependencies: 225
-- Name: capacidades_personagens_seq; Type: SEQUENCE SET; Schema: capacidade; Owner: chris
--

SELECT pg_catalog.setval('capacidade.capacidades_personagens_seq', 2, false);


--
-- TOC entry 3316 (class 0 OID 0)
-- Dependencies: 252
-- Name: arma_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.arma_seq', 2, false);


--
-- TOC entry 3317 (class 0 OID 0)
-- Dependencies: 212
-- Name: capacidade_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.capacidade_seq', 2, false);


--
-- TOC entry 3318 (class 0 OID 0)
-- Dependencies: 216
-- Name: caracteristica_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.caracteristica_seq', 2, false);


--
-- TOC entry 3319 (class 0 OID 0)
-- Dependencies: 217
-- Name: conhecimento_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.conhecimento_seq', 2, false);


--
-- TOC entry 3320 (class 0 OID 0)
-- Dependencies: 213
-- Name: especie_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.especie_seq', 2, false);


--
-- TOC entry 3321 (class 0 OID 0)
-- Dependencies: 214
-- Name: etnia_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.etnia_seq', 2, false);


--
-- TOC entry 3322 (class 0 OID 0)
-- Dependencies: 218
-- Name: personalidade_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.personalidade_seq', 2, false);


--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 215
-- Name: raca_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.raca_seq', 2, false);


--
-- TOC entry 3324 (class 0 OID 0)
-- Dependencies: 234
-- Name: tipo_conhecimento_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.tipo_conhecimento_seq', 2, false);


--
-- TOC entry 3325 (class 0 OID 0)
-- Dependencies: 232
-- Name: treinamento_seq; Type: SEQUENCE SET; Schema: game_data; Owner: chris
--

SELECT pg_catalog.setval('game_data.treinamento_seq', 2, false);


--
-- TOC entry 3326 (class 0 OID 0)
-- Dependencies: 254
-- Name: id_personagem_arma_seq; Type: SEQUENCE SET; Schema: personagem; Owner: chris
--

SELECT pg_catalog.setval('personagem.id_personagem_arma_seq', 2, false);


--
-- TOC entry 3327 (class 0 OID 0)
-- Dependencies: 240
-- Name: id_personagem_caracteristica_seq; Type: SEQUENCE SET; Schema: personagem; Owner: chris
--

SELECT pg_catalog.setval('personagem.id_personagem_caracteristica_seq', 15, true);


--
-- TOC entry 3328 (class 0 OID 0)
-- Dependencies: 241
-- Name: id_personagem_treinamento_seq; Type: SEQUENCE SET; Schema: personagem; Owner: chris
--

SELECT pg_catalog.setval('personagem.id_personagem_treinamento_seq', 22, true);


--
-- TOC entry 3329 (class 0 OID 0)
-- Dependencies: 242
-- Name: personagem_conhecimento_seq; Type: SEQUENCE SET; Schema: personagem; Owner: chris
--

SELECT pg_catalog.setval('personagem.personagem_conhecimento_seq', 43, true);


--
-- TOC entry 3330 (class 0 OID 0)
-- Dependencies: 251
-- Name: personagem_personalidade_seq; Type: SEQUENCE SET; Schema: personagem; Owner: chris
--

SELECT pg_catalog.setval('personagem.personagem_personalidade_seq', 2, false);


--
-- TOC entry 3331 (class 0 OID 0)
-- Dependencies: 220
-- Name: personagem_seq; Type: SEQUENCE SET; Schema: personagem; Owner: chris
--

SELECT pg_catalog.setval('personagem.personagem_seq', 13, true);


--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 209
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: chris
--

SELECT pg_catalog.setval('public.hibernate_sequence', 61, true);


--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 258
-- Name: sala_log_seq; Type: SEQUENCE SET; Schema: sala; Owner: chris
--

SELECT pg_catalog.setval('sala.sala_log_seq', 103, true);


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 248
-- Name: sala_personagem_seq; Type: SEQUENCE SET; Schema: sala; Owner: chris
--

SELECT pg_catalog.setval('sala.sala_personagem_seq', 36, true);


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 249
-- Name: sala_seq; Type: SEQUENCE SET; Schema: sala; Owner: chris
--

SELECT pg_catalog.setval('sala.sala_seq', 6, true);


--
-- TOC entry 3035 (class 2606 OID 143581)
-- Name: capacidades_auditoria capacidades_auditoria_pkey; Type: CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.capacidades_auditoria
    ADD CONSTRAINT capacidades_auditoria_pkey PRIMARY KEY (id_capacidade, rev);


--
-- TOC entry 3041 (class 2606 OID 151832)
-- Name: capacidades_personagens_auditoria capacidades_personagens_auditoria_pkey; Type: CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.capacidades_personagens_auditoria
    ADD CONSTRAINT capacidades_personagens_auditoria_pkey PRIMARY KEY (id_capacidade, rev);


--
-- TOC entry 3037 (class 2606 OID 143644)
-- Name: personagens_auditoria personagens_auditoria_pkey; Type: CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.personagens_auditoria
    ADD CONSTRAINT personagens_auditoria_pkey PRIMARY KEY (id_personagem, rev);


--
-- TOC entry 3073 (class 2606 OID 160493)
-- Name: salas_auditoria salas_auditoria_pkey; Type: CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.salas_auditoria
    ADD CONSTRAINT salas_auditoria_pkey PRIMARY KEY (id_sala, rev);


--
-- TOC entry 3075 (class 2606 OID 160498)
-- Name: salas_personagens_auditoria salas_personagens_auditoria_pkey; Type: CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.salas_personagens_auditoria
    ADD CONSTRAINT salas_personagens_auditoria_pkey PRIMARY KEY (id_sala_persongem, rev);


--
-- TOC entry 3033 (class 2606 OID 135777)
-- Name: usuarios_auditoria usuarios_auditoria_pkey; Type: CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.usuarios_auditoria
    ADD CONSTRAINT usuarios_auditoria_pkey PRIMARY KEY (id_usuario, rev);


--
-- TOC entry 3029 (class 2606 OID 135222)
-- Name: usuarios usuario_login_un; Type: CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios
    ADD CONSTRAINT usuario_login_un UNIQUE (login);


--
-- TOC entry 3069 (class 2606 OID 160461)
-- Name: usuarios_personagens usuario_personagem_un; Type: CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios_personagens
    ADD CONSTRAINT usuario_personagem_un UNIQUE (id_usuario, id_personagem);


--
-- TOC entry 3071 (class 2606 OID 160459)
-- Name: usuarios_personagens usuarios_personagens_pkey; Type: CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios_personagens
    ADD CONSTRAINT usuarios_personagens_pkey PRIMARY KEY (id_usuario_personagem);


--
-- TOC entry 3031 (class 2606 OID 135220)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 3047 (class 2606 OID 151962)
-- Name: capacidades_game_data capacidades_game_data_pkey; Type: CONSTRAINT; Schema: capacidade; Owner: postgres
--

ALTER TABLE ONLY capacidade.capacidades_game_data
    ADD CONSTRAINT capacidades_game_data_pkey PRIMARY KEY (id_capacidade);


--
-- TOC entry 3039 (class 2606 OID 151827)
-- Name: capacidades_npcs capacidades_npcs_pkey; Type: CONSTRAINT; Schema: capacidade; Owner: postgres
--

ALTER TABLE ONLY capacidade.capacidades_npcs
    ADD CONSTRAINT capacidades_npcs_pkey PRIMARY KEY (id_capacidade);


--
-- TOC entry 3085 (class 2606 OID 160592)
-- Name: armas armas_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.armas
    ADD CONSTRAINT armas_pkey PRIMARY KEY (id_arma);


--
-- TOC entry 3043 (class 2606 OID 151841)
-- Name: caracteristicas caracteristicas_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.caracteristicas
    ADD CONSTRAINT caracteristicas_pkey PRIMARY KEY (id_caracteristica);


--
-- TOC entry 3059 (class 2606 OID 155181)
-- Name: conhecimentos conhecimentos_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.conhecimentos
    ADD CONSTRAINT conhecimentos_pkey PRIMARY KEY (id_conhecimento);


--
-- TOC entry 3049 (class 2606 OID 152109)
-- Name: especies especies_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.especies
    ADD CONSTRAINT especies_pkey PRIMARY KEY (id_especie);


--
-- TOC entry 3051 (class 2606 OID 152117)
-- Name: etnias etnias_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.etnias
    ADD CONSTRAINT etnias_pkey PRIMARY KEY (id_etnia);


--
-- TOC entry 3045 (class 2606 OID 151861)
-- Name: personalidades personalidades_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.personalidades
    ADD CONSTRAINT personalidades_pkey PRIMARY KEY (id_personalidade);


--
-- TOC entry 3053 (class 2606 OID 152125)
-- Name: racas racas_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.racas
    ADD CONSTRAINT racas_pkey PRIMARY KEY (id_raca);


--
-- TOC entry 3055 (class 2606 OID 155159)
-- Name: tipos_conhecimentos tipos_conhecimentos_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.tipos_conhecimentos
    ADD CONSTRAINT tipos_conhecimentos_pkey PRIMARY KEY (id_tipo_conhecimento);


--
-- TOC entry 3057 (class 2606 OID 155171)
-- Name: treinamentos treinamentos_pkey; Type: CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.treinamentos
    ADD CONSTRAINT treinamentos_pkey PRIMARY KEY (id_treinamento);


--
-- TOC entry 3083 (class 2606 OID 160572)
-- Name: personagens_armas personagens_armas_pkey; Type: CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_armas
    ADD CONSTRAINT personagens_armas_pkey PRIMARY KEY (id_personagem_arma);


--
-- TOC entry 3061 (class 2606 OID 160368)
-- Name: personagens_caracteristicas personagens_caracteristicas_pkey; Type: CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_caracteristicas
    ADD CONSTRAINT personagens_caracteristicas_pkey PRIMARY KEY (id_personagem_caracteristica);


--
-- TOC entry 3063 (class 2606 OID 160373)
-- Name: personagens_conhecimentos personagens_conhecimentos_pkey; Type: CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_conhecimentos
    ADD CONSTRAINT personagens_conhecimentos_pkey PRIMARY KEY (id_personagem_conhecimento);


--
-- TOC entry 3081 (class 2606 OID 160546)
-- Name: personagens_personalidade personagens_personalidade_pkey; Type: CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_personalidade
    ADD CONSTRAINT personagens_personalidade_pkey PRIMARY KEY (id_personagem_personalidade);


--
-- TOC entry 3067 (class 2606 OID 160419)
-- Name: personagens personagens_pkey; Type: CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens
    ADD CONSTRAINT personagens_pkey PRIMARY KEY (id_personagem);


--
-- TOC entry 3065 (class 2606 OID 160378)
-- Name: personagens_treinamentos personagens_treinamentos_pkey; Type: CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_treinamentos
    ADD CONSTRAINT personagens_treinamentos_pkey PRIMARY KEY (id_personagem_treinamento);


--
-- TOC entry 3027 (class 2606 OID 135199)
-- Name: revinfo revinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: chris
--

ALTER TABLE ONLY public.revinfo
    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);


--
-- TOC entry 3089 (class 2606 OID 160645)
-- Name: salas_logs salas_logs_pkey; Type: CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas_logs
    ADD CONSTRAINT salas_logs_pkey PRIMARY KEY (id_sala_log);


--
-- TOC entry 3087 (class 2606 OID 160630)
-- Name: salas_personagens salas_personagens_pkey; Type: CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas_personagens
    ADD CONSTRAINT salas_personagens_pkey PRIMARY KEY (id_sala_persongem);


--
-- TOC entry 3077 (class 2606 OID 160503)
-- Name: salas salas_pkey; Type: CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas
    ADD CONSTRAINT salas_pkey PRIMARY KEY (id_sala);


--
-- TOC entry 3079 (class 2606 OID 160510)
-- Name: salas usuario_sala_un; Type: CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas
    ADD CONSTRAINT usuario_sala_un UNIQUE (id_usuario, id_sala);


--
-- TOC entry 3114 (class 2606 OID 160517)
-- Name: salas_auditoria fk5pyoclcqp7vgivgh0c2kb364g; Type: FK CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.salas_auditoria
    ADD CONSTRAINT fk5pyoclcqp7vgivgh0c2kb364g FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


--
-- TOC entry 3115 (class 2606 OID 160522)
-- Name: salas_personagens_auditoria fk98u3pnpu3fvlfcej8kdmgsjh7; Type: FK CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.salas_personagens_auditoria
    ADD CONSTRAINT fk98u3pnpu3fvlfcej8kdmgsjh7 FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


--
-- TOC entry 3092 (class 2606 OID 143650)
-- Name: personagens_auditoria fkau446lp6d86dmom3sqprovrr1; Type: FK CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.personagens_auditoria
    ADD CONSTRAINT fkau446lp6d86dmom3sqprovrr1 FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


--
-- TOC entry 3093 (class 2606 OID 151872)
-- Name: capacidades_personagens_auditoria fkfkpoyl4oivjh5h4p68hjhvo0p; Type: FK CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.capacidades_personagens_auditoria
    ADD CONSTRAINT fkfkpoyl4oivjh5h4p68hjhvo0p FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


--
-- TOC entry 3090 (class 2606 OID 135778)
-- Name: usuarios_auditoria fklsn0nqpm96h6o29br6eirbunl; Type: FK CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.usuarios_auditoria
    ADD CONSTRAINT fklsn0nqpm96h6o29br6eirbunl FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


--
-- TOC entry 3091 (class 2606 OID 143582)
-- Name: capacidades_auditoria fkssp7650khegyak99dxlp143ww; Type: FK CONSTRAINT; Schema: auditoria; Owner: chris
--

ALTER TABLE ONLY auditoria.capacidades_auditoria
    ADD CONSTRAINT fkssp7650khegyak99dxlp143ww FOREIGN KEY (rev) REFERENCES public.revinfo(rev);


--
-- TOC entry 3112 (class 2606 OID 160462)
-- Name: usuarios_personagens personagem_usuario_personagem_fk; Type: FK CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios_personagens
    ADD CONSTRAINT personagem_usuario_personagem_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3113 (class 2606 OID 160467)
-- Name: usuarios_personagens usuario_usuario_personagem_fk; Type: FK CONSTRAINT; Schema: cadastro; Owner: chris
--

ALTER TABLE ONLY cadastro.usuarios_personagens
    ADD CONSTRAINT usuario_usuario_personagem_fk FOREIGN KEY (id_usuario) REFERENCES cadastro.usuarios(id_usuario);


--
-- TOC entry 3094 (class 2606 OID 151978)
-- Name: caracteristicas capacidade_caracteristica_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.caracteristicas
    ADD CONSTRAINT capacidade_caracteristica_fk FOREIGN KEY (id_capacidade) REFERENCES capacidade.capacidades_game_data(id_capacidade);


--
-- TOC entry 3095 (class 2606 OID 152126)
-- Name: especies capacidade_especie_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.especies
    ADD CONSTRAINT capacidade_especie_fk FOREIGN KEY (id_capacidade) REFERENCES capacidade.capacidades_game_data(id_capacidade);


--
-- TOC entry 3096 (class 2606 OID 152131)
-- Name: etnias capacidade_etnia_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.etnias
    ADD CONSTRAINT capacidade_etnia_fk FOREIGN KEY (id_capacidade) REFERENCES capacidade.capacidades_game_data(id_capacidade);


--
-- TOC entry 3099 (class 2606 OID 152146)
-- Name: racas capacidade_raca_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.racas
    ADD CONSTRAINT capacidade_raca_fk FOREIGN KEY (id_capacidade) REFERENCES capacidade.capacidades_game_data(id_capacidade);


--
-- TOC entry 3101 (class 2606 OID 155172)
-- Name: treinamentos capacidade_treinamento_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.treinamentos
    ADD CONSTRAINT capacidade_treinamento_fk FOREIGN KEY (id_capacidade) REFERENCES capacidade.capacidades_game_data(id_capacidade);


--
-- TOC entry 3097 (class 2606 OID 152136)
-- Name: etnias especie_etnia_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.etnias
    ADD CONSTRAINT especie_etnia_fk FOREIGN KEY (id_especie) REFERENCES game_data.especies(id_especie);


--
-- TOC entry 3100 (class 2606 OID 152151)
-- Name: racas especie_raca_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.racas
    ADD CONSTRAINT especie_raca_fk FOREIGN KEY (id_especie) REFERENCES game_data.especies(id_especie);


--
-- TOC entry 3098 (class 2606 OID 152141)
-- Name: etnias raca_etnia_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.etnias
    ADD CONSTRAINT raca_etnia_fk FOREIGN KEY (id_raca) REFERENCES game_data.racas(id_raca);


--
-- TOC entry 3102 (class 2606 OID 155182)
-- Name: conhecimentos tipo_conhecimento_conhecimento_fk; Type: FK CONSTRAINT; Schema: game_data; Owner: chris
--

ALTER TABLE ONLY game_data.conhecimentos
    ADD CONSTRAINT tipo_conhecimento_conhecimento_fk FOREIGN KEY (id_tipo_conhecimento) REFERENCES game_data.tipos_conhecimentos(id_tipo_conhecimento);


--
-- TOC entry 3120 (class 2606 OID 160593)
-- Name: personagens_armas arma_personagem_arma_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_armas
    ADD CONSTRAINT arma_personagem_arma_fk FOREIGN KEY (id_arma) REFERENCES game_data.armas(id_arma);


--
-- TOC entry 3104 (class 2606 OID 160385)
-- Name: personagens_caracteristicas caracteristica_personagem_caracteristica_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_caracteristicas
    ADD CONSTRAINT caracteristica_personagem_caracteristica_fk FOREIGN KEY (id_caracteristica) REFERENCES game_data.caracteristicas(id_caracteristica);


--
-- TOC entry 3106 (class 2606 OID 160395)
-- Name: personagens_conhecimentos conhecimento_personagem_conhecimento_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_conhecimentos
    ADD CONSTRAINT conhecimento_personagem_conhecimento_fk FOREIGN KEY (id_conhecimento) REFERENCES game_data.conhecimentos(id_conhecimento);


--
-- TOC entry 3108 (class 2606 OID 160410)
-- Name: personagens_treinamentos conhecimento_personagem_conhecimento_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_treinamentos
    ADD CONSTRAINT conhecimento_personagem_conhecimento_fk FOREIGN KEY (id_conhecimento) REFERENCES game_data.treinamentos(id_treinamento);


--
-- TOC entry 3109 (class 2606 OID 160425)
-- Name: personagens especie_personagem_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens
    ADD CONSTRAINT especie_personagem_fk FOREIGN KEY (id_especie) REFERENCES game_data.especies(id_especie);


--
-- TOC entry 3110 (class 2606 OID 160430)
-- Name: personagens etnia_personagem_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens
    ADD CONSTRAINT etnia_personagem_fk FOREIGN KEY (id_etnia) REFERENCES game_data.etnias(id_etnia);


--
-- TOC entry 3119 (class 2606 OID 160580)
-- Name: personagens_armas personagem_personagem_arma_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_armas
    ADD CONSTRAINT personagem_personagem_arma_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3103 (class 2606 OID 160440)
-- Name: personagens_caracteristicas personagem_personagem_caracteristica_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_caracteristicas
    ADD CONSTRAINT personagem_personagem_caracteristica_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3105 (class 2606 OID 160445)
-- Name: personagens_conhecimentos personagem_personagem_conhecimento_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_conhecimentos
    ADD CONSTRAINT personagem_personagem_conhecimento_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3107 (class 2606 OID 160450)
-- Name: personagens_treinamentos personagem_personagem_conhecimento_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_treinamentos
    ADD CONSTRAINT personagem_personagem_conhecimento_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3117 (class 2606 OID 160549)
-- Name: personagens_personalidade personagem_personagem_personalidade_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_personalidade
    ADD CONSTRAINT personagem_personagem_personalidade_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3118 (class 2606 OID 160554)
-- Name: personagens_personalidade personalidade_personagem_personalidade_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens_personalidade
    ADD CONSTRAINT personalidade_personagem_personalidade_fk FOREIGN KEY (id_personalidade) REFERENCES game_data.personalidades(id_personalidade);


--
-- TOC entry 3111 (class 2606 OID 160435)
-- Name: personagens raca_personagem_fk; Type: FK CONSTRAINT; Schema: personagem; Owner: chris
--

ALTER TABLE ONLY personagem.personagens
    ADD CONSTRAINT raca_personagem_fk FOREIGN KEY (id_raca) REFERENCES game_data.racas(id_raca);


--
-- TOC entry 3116 (class 2606 OID 160527)
-- Name: salas mestre_sala_fk; Type: FK CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas
    ADD CONSTRAINT mestre_sala_fk FOREIGN KEY (id_usuario) REFERENCES cadastro.usuarios(id_usuario);


--
-- TOC entry 3121 (class 2606 OID 160631)
-- Name: salas_personagens personagem_sala_personagem_fk; Type: FK CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas_personagens
    ADD CONSTRAINT personagem_sala_personagem_fk FOREIGN KEY (id_personagem) REFERENCES personagem.personagens(id_personagem);


--
-- TOC entry 3123 (class 2606 OID 160648)
-- Name: salas_logs sala_sala_log_fk; Type: FK CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas_logs
    ADD CONSTRAINT sala_sala_log_fk FOREIGN KEY (id_sala) REFERENCES sala.salas(id_sala);


--
-- TOC entry 3122 (class 2606 OID 160636)
-- Name: salas_personagens sala_sala_personagem_fk; Type: FK CONSTRAINT; Schema: sala; Owner: chris
--

ALTER TABLE ONLY sala.salas_personagens
    ADD CONSTRAINT sala_sala_personagem_fk FOREIGN KEY (id_sala) REFERENCES sala.salas(id_sala);


-- Completed on 2024-01-09 10:07:52

--
-- PostgreSQL database dump complete
--

