--
-- PostgreSQL database dump
--

-- Started on 2010-05-17 22:09:50

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1512 (class 1259 OID 56647)
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
-- TOC entry 1513 (class 1259 OID 61532)
-- Dependencies: 3
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE authorities (
    id bigint NOT NULL,
    authority character varying(255)
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- TOC entry 1510 (class 1259 OID 56642)
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
-- TOC entry 1515 (class 1259 OID 61690)
-- Dependencies: 3
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customers (
    id bigint NOT NULL,
    first_name character varying(255),
    cust_credit numeric(19,2),
    cust_emp bigint,
    last_name character varying(255),
    user_id bigint
);	


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 1516 (class 1259 OID 61695)
-- Dependencies: 3
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employees (
    emp_id bigint NOT NULL,
    emp_name character varying(255),
    emp_age integer,
    emp_title character varying(255),
    emp_quota numeric(19,2),
    emp_sales numeric(19,2),
    emp_off bigint,
    emp_manager bigint
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 1517 (class 1259 OID 61703)
-- Dependencies: 3
-- Name: office; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE office (
    off_id bigint NOT NULL,
    off_target numeric(19,2),
    off_region character varying(255),
    off_city character varying(255),
    off_sales numeric(19,2),
    off_manager bigint
);


ALTER TABLE public.office OWNER TO postgres;

--
-- TOC entry 1518 (class 1259 OID 61711)
-- Dependencies: 3
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orders (
    ord_id bigint NOT NULL,
    ord_date timestamp without time zone,
    ord_amount numeric(19,2),
    ord_cust bigint,
    ord_product bigint,
    ord_employee bigint
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 1519 (class 1259 OID 61716)
-- Dependencies: 3
-- Name: products; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE products (
    prod_id bigint NOT NULL,
    prod_descript character varying(255),
    prod_price numeric(19,2)
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 1511 (class 1259 OID 56645)
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
-- TOC entry 1514 (class 1259 OID 61571)
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
-- TOC entry 1798 (class 2606 OID 61536)
-- Dependencies: 1513 1513
-- Name: authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);


--
-- TOC entry 1802 (class 2606 OID 61694)
-- Dependencies: 1515 1515
-- Name: customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- TOC entry 1804 (class 2606 OID 61702)
-- Dependencies: 1516 1516
-- Name: employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (emp_id);


--
-- TOC entry 1806 (class 2606 OID 61710)
-- Dependencies: 1517 1517
-- Name: office_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY office
    ADD CONSTRAINT office_pkey PRIMARY KEY (off_id);


--
-- TOC entry 1808 (class 2606 OID 61715)
-- Dependencies: 1518 1518
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (ord_id);


--
-- TOC entry 1810 (class 2606 OID 61720)
-- Dependencies: 1519 1519
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (prod_id);


--
-- TOC entry 1800 (class 2606 OID 61578)
-- Dependencies: 1514 1514
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 1812 (class 2606 OID 61721)
-- Dependencies: 1516 1803 1515
-- Name: fk600e7c55f6c3f394; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT fk600e7c55f6c3f394 FOREIGN KEY (cust_emp) REFERENCES employees(emp_id);


--
-- TOC entry 1811 (class 2606 OID 61619)
-- Dependencies: 1797 1514 1513
-- Name: fk6a68e087425967d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fk6a68e087425967d FOREIGN KEY (authority_id) REFERENCES authorities(id);


--
-- TOC entry 1814 (class 2606 OID 61731)
-- Dependencies: 1516 1516 1803
-- Name: fk9d39ef853072cdee; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef853072cdee FOREIGN KEY (emp_manager) REFERENCES employees(emp_id);


--
-- TOC entry 1813 (class 2606 OID 61726)
-- Dependencies: 1805 1517 1516
-- Name: fk9d39ef859df0cb71; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef859df0cb71 FOREIGN KEY (emp_off) REFERENCES office(off_id);


--
-- TOC entry 1815 (class 2606 OID 61736)
-- Dependencies: 1516 1803 1517
-- Name: fkc3373ebc88b35b95; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office
    ADD CONSTRAINT fkc3373ebc88b35b95 FOREIGN KEY (off_manager) REFERENCES employees(emp_id);


--
-- TOC entry 1817 (class 2606 OID 61746)
-- Dependencies: 1518 1803 1516
-- Name: fkc3df62e52fc06d04; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e52fc06d04 FOREIGN KEY (ord_employee) REFERENCES employees(emp_id);


--
-- TOC entry 1818 (class 2606 OID 61751)
-- Dependencies: 1809 1518 1519
-- Name: fkc3df62e5e0511ae3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5e0511ae3 FOREIGN KEY (ord_product) REFERENCES products(prod_id);


--
-- TOC entry 1816 (class 2606 OID 61741)
-- Dependencies: 1515 1801 1518
-- Name: fkc3df62e5f8df64cc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5f8df64cc FOREIGN KEY (ord_cust) REFERENCES customers(id);


--
-- TOC entry 1822 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-05-17 22:09:51

--
-- PostgreSQL database dump complete
--

