--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2019-02-16 18:30:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE carddtls;
--
-- TOC entry 1942 (class 1262 OID 37195)
-- Name: carddtls; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE carddtls WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE carddtls OWNER TO postgres;


SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 1943 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 172 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1945 (class 0 OID 0)
-- Dependencies: 172
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 37198)
-- Name: tbl_card_info; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "tbl_card_info" (
    id bigint NOT NULL,
    "cardno" character varying,
    "card_nickname" character varying,
    "card_type" character varying(10),
    "card_subtype" character varying(15),
    "card_holder_name" character varying(150)
);


ALTER TABLE public."tbl_card_info" OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 37196)
-- Name: tbl_card_info_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "tbl_card_info_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."tbl_card_info_id_seq" OWNER TO postgres;

--
-- TOC entry 1946 (class 0 OID 0)
-- Dependencies: 170
-- Name: tbl_card_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "tbl_card_info_id_seq" OWNED BY "tbl_card_info".id;


--
-- TOC entry 1824 (class 2604 OID 37201)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "tbl_card_info" ALTER COLUMN id SET DEFAULT nextval('"tbl_card_info_id_seq"'::regclass);


--
-- TOC entry 1937 (class 0 OID 37198)
-- Dependencies: 171
-- Data for Name: tbl_card_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (1, '455561', 'TEST1', 'VISA', 'DEBIT', 'TEST1');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (2, '387765', 'AMEX-TEST1', 'AMEX', 'CREDIT', 'AMEX-TEST1');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (3, '454545', 'TEST2', 'VISA', 'CREDIT', 'TEST2');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (4, '546626', 'MC-TEST1', 'MC', 'CREDIT', 'MC-TEST1');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (5, '444433333 ', 'TEST3', 'VISA', 'PREMIUM CREDIT', 'TEST3');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (6, '444433332', 'TEST4', 'VISA', 'PREMIUM CREDIT', 'TEST4');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (7, '512176622 ', 'MC1', 'MC', 'GOLD CREDIT', 'MC1');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (8, '512189239', 'MC2', 'MC', 'GOLD CREDIT', 'MC2');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (9, '546626193 ', 'MC3', 'MC', 'BUSINESS', 'MC3');
INSERT INTO "tbl_card_info" (id, "CARDNO", "CARD_NICKNAME", "CARD_TYPE", "CARD_SUBTYPE", "CARD_HOLDER_NAME") VALUES (10, '546691237', 'MC4', 'MC', 'BUSINESS', 'MC4');


--
-- TOC entry 1947 (class 0 OID 0)
-- Dependencies: 170
-- Name: tbl_card_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"tbl_card_info_id_seq"', 10, true);


--
-- TOC entry 1826 (class 2606 OID 37208)
-- Name: tbl_card_info_CARDNO_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "tbl_card_info"
    ADD CONSTRAINT "tbl_card_info_CARDNO_key" UNIQUE ("CARDNO");


--
-- TOC entry 1828 (class 2606 OID 37206)
-- Name: tbl_card_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "tbl_card_info"
    ADD CONSTRAINT "tbl_card_info_pkey" PRIMARY KEY (id);


--
-- TOC entry 1944 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-02-16 18:30:08

--
-- PostgreSQL database dump complete
--

