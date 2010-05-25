--
-- PostgreSQL database dump
--

-- Started on 2010-05-26 01:39:04

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1830 (class 1262 OID 56335)
-- Name: test1; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE test1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Ukrainian, Ukraine' LC_CTYPE = 'Ukrainian, Ukraine';


ALTER DATABASE test1 OWNER TO postgres;

\connect test1

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 328 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 1517 (class 1259 OID 56647)
-- Dependencies: 3
-- Name: auth_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE auth_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.auth_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1521 (class 1259 OID 67532)
-- Dependencies: 3
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE authorities (
    id bigint NOT NULL,
    authority character varying(255)
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- TOC entry 1515 (class 1259 OID 56642)
-- Dependencies: 3
-- Name: cust_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cust_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.cust_id_seq OWNER TO postgres;

--
-- TOC entry 1522 (class 1259 OID 67537)
-- Dependencies: 3
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customers (
    id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    cust_credit numeric(19,2),
    user_id bigint
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 1520 (class 1259 OID 65896)
-- Dependencies: 3
-- Name: emp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE emp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.emp_id_seq OWNER TO postgres;

--
-- TOC entry 1523 (class 1259 OID 67545)
-- Dependencies: 3
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employees (
    id bigint NOT NULL,
    name character varying(255),
    age integer,
    title character varying(255),
    quota numeric(19,2),
    sales numeric(19,2),
    office_id bigint,
    manager_id bigint,
    user_id bigint,
    firstname character varying(255),
    lastname character varying(255),
    mail character varying(255),
    phone character varying(255)
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 1528 (class 1259 OID 67614)
-- Dependencies: 3
-- Name: off_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE off_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.off_id_seq OWNER TO postgres;

--
-- TOC entry 1524 (class 1259 OID 67553)
-- Dependencies: 3
-- Name: office; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE office (
    id bigint NOT NULL,
    city character varying(255),
    region character varying(255),
    target numeric(19,2),
    sales numeric(19,2),
    customer_id bigint
);


ALTER TABLE public.office OWNER TO postgres;

--
-- TOC entry 1519 (class 1259 OID 64065)
-- Dependencies: 3
-- Name: ord_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ord_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ord_id_seq OWNER TO postgres;

--
-- TOC entry 1525 (class 1259 OID 67561)
-- Dependencies: 3
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orders (
    id bigint NOT NULL,
    date timestamp without time zone,
    amount numeric(19,2),
    product_id bigint,
    employee_id bigint,
    productcount integer
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 1518 (class 1259 OID 63066)
-- Dependencies: 3
-- Name: prod_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prod_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.prod_id_seq OWNER TO postgres;

--
-- TOC entry 1526 (class 1259 OID 67566)
-- Dependencies: 3
-- Name: products; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE products (
    id bigint NOT NULL,
    description character varying(255),
    price numeric(19,2),
    count integer,
    name character varying(255)
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 1516 (class 1259 OID 56645)
-- Dependencies: 3
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 1527 (class 1259 OID 67571)
-- Dependencies: 3
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id bigint NOT NULL,
    username character varying(255),
    password character varying(255),
    enabled integer NOT NULL,
    authority_id bigint
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 1807 (class 2606 OID 67536)
-- Dependencies: 1521 1521
-- Name: authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);


--
-- TOC entry 1809 (class 2606 OID 67544)
-- Dependencies: 1522 1522
-- Name: customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- TOC entry 1811 (class 2606 OID 67552)
-- Dependencies: 1523 1523
-- Name: employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 1813 (class 2606 OID 67560)
-- Dependencies: 1524 1524
-- Name: office_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY office
    ADD CONSTRAINT office_pkey PRIMARY KEY (id);


--
-- TOC entry 1815 (class 2606 OID 67565)
-- Dependencies: 1525 1525
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 1817 (class 2606 OID 67570)
-- Dependencies: 1526 1526
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 1819 (class 2606 OID 67578)
-- Dependencies: 1527 1527
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 1820 (class 2606 OID 67579)
-- Dependencies: 1522 1527 1818
-- Name: fk600e7c5565425057; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT fk600e7c5565425057 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 1827 (class 2606 OID 67609)
-- Dependencies: 1527 1806 1521
-- Name: fk6a68e087425967d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fk6a68e087425967d FOREIGN KEY (authority_id) REFERENCES authorities(id);


--
-- TOC entry 1821 (class 2606 OID 67617)
-- Dependencies: 1527 1523 1818
-- Name: fk9d39ef8565425057; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef8565425057 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 1823 (class 2606 OID 67589)
-- Dependencies: 1523 1523 1810
-- Name: fk9d39ef8567627da5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef8567627da5 FOREIGN KEY (manager_id) REFERENCES employees(id);


--
-- TOC entry 1822 (class 2606 OID 67584)
-- Dependencies: 1524 1812 1523
-- Name: fk9d39ef8578b2f377; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef8578b2f377 FOREIGN KEY (office_id) REFERENCES office(id);


--
-- TOC entry 1824 (class 2606 OID 67594)
-- Dependencies: 1808 1522 1524
-- Name: fkc3373ebc4608ecf7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office
    ADD CONSTRAINT fkc3373ebc4608ecf7 FOREIGN KEY (customer_id) REFERENCES customers(id);


--
-- TOC entry 1826 (class 2606 OID 67604)
-- Dependencies: 1816 1526 1525
-- Name: fkc3df62e58c1733bd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e58c1733bd FOREIGN KEY (product_id) REFERENCES products(id);


--
-- TOC entry 1825 (class 2606 OID 67599)
-- Dependencies: 1523 1810 1525
-- Name: fkc3df62e5925bb04; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5925bb04 FOREIGN KEY (employee_id) REFERENCES employees(id);


--
-- TOC entry 1832 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-05-26 01:39:05

--
-- PostgreSQL database dump complete
--

