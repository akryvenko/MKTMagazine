--
-- PostgreSQL database dump
--

-- Started on 2010-05-16 09:27:23

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 323 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1521 (class 1259 OID 43104)
-- Dependencies: 3
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- TOC entry 1515 (class 1259 OID 43033)
-- Dependencies: 3
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customers (
    cust_id bigint NOT NULL,
    cust_name character varying(255),
    cust_credit numeric(19,2),
    cust_emp bigint
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 1511 (class 1259 OID 28551)
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
-- TOC entry 1516 (class 1259 OID 43038)
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
    emp_manager bigint,
    emp_off bigint
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 1512 (class 1259 OID 28553)
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
-- TOC entry 1517 (class 1259 OID 43046)
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
-- TOC entry 1513 (class 1259 OID 28555)
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
-- TOC entry 1518 (class 1259 OID 43054)
-- Dependencies: 3
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orders (
    ord_id bigint NOT NULL,
    ord_date timestamp without time zone,
    ord_amount numeric(19,2),
    ord_product bigint,
    ord_employee bigint,
    ord_cust bigint
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 1510 (class 1259 OID 24709)
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
-- TOC entry 1519 (class 1259 OID 43059)
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
-- TOC entry 1514 (class 1259 OID 42536)
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
-- TOC entry 1520 (class 1259 OID 43099)
-- Dependencies: 3
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    enabled bit(1) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 1800 (class 2606 OID 43037)
-- Dependencies: 1515 1515
-- Name: customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (cust_id);


--
-- TOC entry 1802 (class 2606 OID 43045)
-- Dependencies: 1516 1516
-- Name: employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (emp_id);


--
-- TOC entry 1804 (class 2606 OID 43053)
-- Dependencies: 1517 1517
-- Name: office_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY office
    ADD CONSTRAINT office_pkey PRIMARY KEY (off_id);


--
-- TOC entry 1806 (class 2606 OID 43058)
-- Dependencies: 1518 1518
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (ord_id);


--
-- TOC entry 1808 (class 2606 OID 43063)
-- Dependencies: 1519 1519
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (prod_id);


--
-- TOC entry 1810 (class 2606 OID 43103)
-- Dependencies: 1520 1520
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- TOC entry 1811 (class 1259 OID 43107)
-- Dependencies: 1521 1521
-- Name: ix_auth_username; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_auth_username ON authorities USING btree (username, authority);


--
-- TOC entry 1812 (class 2606 OID 43064)
-- Dependencies: 1515 1516 1801
-- Name: fk600e7c55f6c3f394; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT fk600e7c55f6c3f394 FOREIGN KEY (cust_emp) REFERENCES employees(emp_id);


--
-- TOC entry 1814 (class 2606 OID 43074)
-- Dependencies: 1516 1516 1801
-- Name: fk9d39ef853072cdee; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef853072cdee FOREIGN KEY (emp_manager) REFERENCES employees(emp_id);


--
-- TOC entry 1813 (class 2606 OID 43069)
-- Dependencies: 1517 1516 1803
-- Name: fk9d39ef859df0cb71; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef859df0cb71 FOREIGN KEY (emp_off) REFERENCES office(off_id);


--
-- TOC entry 1819 (class 2606 OID 43108)
-- Dependencies: 1809 1520 1521
-- Name: fk_authorities_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username);


--
-- TOC entry 1815 (class 2606 OID 43079)
-- Dependencies: 1516 1517 1801
-- Name: fkc3373ebc88b35b95; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office
    ADD CONSTRAINT fkc3373ebc88b35b95 FOREIGN KEY (off_manager) REFERENCES employees(emp_id);


--
-- TOC entry 1817 (class 2606 OID 43089)
-- Dependencies: 1518 1801 1516
-- Name: fkc3df62e52fc06d04; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e52fc06d04 FOREIGN KEY (ord_employee) REFERENCES employees(emp_id);


--
-- TOC entry 1818 (class 2606 OID 43094)
-- Dependencies: 1519 1518 1807
-- Name: fkc3df62e5e0511ae3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5e0511ae3 FOREIGN KEY (ord_product) REFERENCES products(prod_id);


--
-- TOC entry 1816 (class 2606 OID 43084)
-- Dependencies: 1518 1799 1515
-- Name: fkc3df62e5f8df64cc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5f8df64cc FOREIGN KEY (ord_cust) REFERENCES customers(cust_id);


--
-- TOC entry 1824 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-05-16 09:27:25

--
-- PostgreSQL database dump complete
--

