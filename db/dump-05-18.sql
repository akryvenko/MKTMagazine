PGDMP                         n           test1    8.4.3    8.4.3 -    '           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            (           0    0 
   STDSTRINGS 
   STDSTRINGS     )   SET standard_conforming_strings = 'off';
                       false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            )           0    0 
   SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3            *           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    3            �           1259    56647    auth_id_seq    SEQUENCE     m   CREATE SEQUENCE auth_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 "   DROP SEQUENCE public.auth_id_seq;
       public       postgres    false    3            +           0    0    auth_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('auth_id_seq', 23, true);
            public       postgres    false    1514            �           1259    62412    authorities    TABLE     [   CREATE TABLE authorities (
    id bigint NOT NULL,
    authority character varying(255)
);
    DROP TABLE public.authorities;
       public         postgres    false    3            �           1259    56642    cust_id_seq    SEQUENCE     m   CREATE SEQUENCE cust_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 "   DROP SEQUENCE public.cust_id_seq;
       public       postgres    false    3            ,           0    0    cust_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('cust_id_seq', 30, true);
            public       postgres    false    1512            �           1259    64042 	   customers    TABLE     �   CREATE TABLE customers (
    id bigint NOT NULL,
    first_name character varying(255),
    cust_credit numeric(19,2),
    cust_emp bigint,
    last_name character varying(255),
    user_id bigint
);
    DROP TABLE public.customers;
       public         postgres    false    3            �           1259    63981 	   employees    TABLE     �   CREATE TABLE employees (
    emp_id bigint NOT NULL,
    emp_name character varying(255),
    emp_age integer,
    emp_title character varying(255),
    emp_quota numeric(19,2),
    emp_sales numeric(19,2),
    emp_manager bigint,
    emp_off bigint
);
    DROP TABLE public.employees;
       public         postgres    false    3            �           1259    63989    office    TABLE     �   CREATE TABLE office (
    off_id bigint NOT NULL,
    off_target numeric(19,2),
    off_region character varying(255),
    off_city character varying(255),
    off_sales numeric(19,2),
    off_manager bigint
);
    DROP TABLE public.office;
       public         postgres    false    3            �           1259    64065 
   ord_id_seq    SEQUENCE     l   CREATE SEQUENCE ord_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 !   DROP SEQUENCE public.ord_id_seq;
       public       postgres    false    3            -           0    0 
   ord_id_seq    SEQUENCE SET     1   SELECT pg_catalog.setval('ord_id_seq', 3, true);
            public       postgres    false    1523            �           1259    63997    orders    TABLE     �   CREATE TABLE orders (
    ord_id bigint NOT NULL,
    ord_date timestamp without time zone,
    ord_amount numeric(19,2),
    ord_cust bigint,
    ord_employee bigint,
    ord_product bigint
);
    DROP TABLE public.orders;
       public         postgres    false    3            �           1259    63066    prod_id_seq    SEQUENCE     m   CREATE SEQUENCE prod_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 "   DROP SEQUENCE public.prod_id_seq;
       public       postgres    false    3            .           0    0    prod_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('prod_id_seq', 13, true);
            public       postgres    false    1517            �           1259    64002    products    TABLE        CREATE TABLE products (
    prod_id bigint NOT NULL,
    prod_descript character varying(255),
    prod_price numeric(19,2)
);
    DROP TABLE public.products;
       public         postgres    false    3            �           1259    56645    user_id_seq    SEQUENCE     m   CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 "   DROP SEQUENCE public.user_id_seq;
       public       postgres    false    3            /           0    0    user_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('user_id_seq', 24, true);
            public       postgres    false    1513            �           1259    62451    users    TABLE     �   CREATE TABLE users (
    id bigint NOT NULL,
    username character varying(255),
    password character varying(255),
    enabled integer NOT NULL,
    authority_id bigint
);
    DROP TABLE public.users;
       public         postgres    false    3                       0    62412    authorities 
   TABLE DATA               -   COPY authorities (id, authority) FROM stdin;
    public       postgres    false    1515   �0       &          0    64042 	   customers 
   TABLE DATA               W   COPY customers (id, first_name, cust_credit, cust_emp, last_name, user_id) FROM stdin;
    public       postgres    false    1522   �0       "          0    63981 	   employees 
   TABLE DATA               n   COPY employees (emp_id, emp_name, emp_age, emp_title, emp_quota, emp_sales, emp_manager, emp_off) FROM stdin;
    public       postgres    false    1518   1       #          0    63989    office 
   TABLE DATA               [   COPY office (off_id, off_target, off_region, off_city, off_sales, off_manager) FROM stdin;
    public       postgres    false    1519   #1       $          0    63997    orders 
   TABLE DATA               \   COPY orders (ord_id, ord_date, ord_amount, ord_cust, ord_employee, ord_product) FROM stdin;
    public       postgres    false    1520   @1       %          0    64002    products 
   TABLE DATA               ?   COPY products (prod_id, prod_descript, prod_price) FROM stdin;
    public       postgres    false    1521   �1       !          0    62451    users 
   TABLE DATA               G   COPY users (id, username, password, enabled, authority_id) FROM stdin;
    public       postgres    false    1516   �1       
           2606    62416    authorities_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.authorities DROP CONSTRAINT authorities_pkey;
       public         postgres    false    1515    1515                       2606    64049 
   cust_id_pk 
   CONSTRAINT     K   ALTER TABLE ONLY customers
    ADD CONSTRAINT cust_id_pk PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.customers DROP CONSTRAINT cust_id_pk;
       public         postgres    false    1522    1522                       2606    63988    employees_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (emp_id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public         postgres    false    1518    1518                       2606    63996    office_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY office
    ADD CONSTRAINT office_pkey PRIMARY KEY (off_id);
 <   ALTER TABLE ONLY public.office DROP CONSTRAINT office_pkey;
       public         postgres    false    1519    1519                       2606    64001    orders_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (ord_id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public         postgres    false    1520    1520                       2606    64006 
   products_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (prod_id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public         postgres    false    1521    1521                       2606    62458 
   users_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    1516    1516                       2606    64055    fk600e7c5565425057 
   FK CONSTRAINT     m   ALTER TABLE ONLY customers
    ADD CONSTRAINT fk600e7c5565425057 FOREIGN KEY (user_id) REFERENCES users(id);
 F   ALTER TABLE ONLY public.customers DROP CONSTRAINT fk600e7c5565425057;
       public       postgres    false    1522    1803    1516                       2606    64050    fk600e7c55f6c3f394 
   FK CONSTRAINT     v   ALTER TABLE ONLY customers
    ADD CONSTRAINT fk600e7c55f6c3f394 FOREIGN KEY (cust_emp) REFERENCES employees(emp_id);
 F   ALTER TABLE ONLY public.customers DROP CONSTRAINT fk600e7c55f6c3f394;
       public       postgres    false    1805    1522    1518                       2606    62499    fk6a68e087425967d 
   FK CONSTRAINT     s   ALTER TABLE ONLY users
    ADD CONSTRAINT fk6a68e087425967d FOREIGN KEY (authority_id) REFERENCES authorities(id);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT fk6a68e087425967d;
       public       postgres    false    1515    1801    1516                       2606    64017    fk9d39ef853072cdee 
   FK CONSTRAINT     y   ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef853072cdee FOREIGN KEY (emp_manager) REFERENCES employees(emp_id);
 F   ALTER TABLE ONLY public.employees DROP CONSTRAINT fk9d39ef853072cdee;
       public       postgres    false    1805    1518    1518                       2606    64012    fk9d39ef859df0cb71 
   FK CONSTRAINT     r   ALTER TABLE ONLY employees
    ADD CONSTRAINT fk9d39ef859df0cb71 FOREIGN KEY (emp_off) REFERENCES office(off_id);
 F   ALTER TABLE ONLY public.employees DROP CONSTRAINT fk9d39ef859df0cb71;
       public       postgres    false    1518    1807    1519                       2606    64022    fkc3373ebc88b35b95 
   FK CONSTRAINT     v   ALTER TABLE ONLY office
    ADD CONSTRAINT fkc3373ebc88b35b95 FOREIGN KEY (off_manager) REFERENCES employees(emp_id);
 C   ALTER TABLE ONLY public.office DROP CONSTRAINT fkc3373ebc88b35b95;
       public       postgres    false    1518    1519    1805                       2606    64032    fkc3df62e52fc06d04 
   FK CONSTRAINT     w   ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e52fc06d04 FOREIGN KEY (ord_employee) REFERENCES employees(emp_id);
 C   ALTER TABLE ONLY public.orders DROP CONSTRAINT fkc3df62e52fc06d04;
       public       postgres    false    1520    1518    1805                       2606    64037    fkc3df62e5e0511ae3 
   FK CONSTRAINT     v   ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5e0511ae3 FOREIGN KEY (ord_product) REFERENCES products(prod_id);
 C   ALTER TABLE ONLY public.orders DROP CONSTRAINT fkc3df62e5e0511ae3;
       public       postgres    false    1811    1520    1521                       2606    64060    fkc3df62e5f8df64cc 
   FK CONSTRAINT     o   ALTER TABLE ONLY orders
    ADD CONSTRAINT fkc3df62e5f8df64cc FOREIGN KEY (ord_cust) REFERENCES customers(id);
 C   ALTER TABLE ONLY public.orders DROP CONSTRAINT fkc3df62e5f8df64cc;
       public       postgres    false    1813    1520    1522                /   x�32���q�w
��u
�2����]B�C�}�݁�1z\\\ t      &   (   x�3�Ltqvq�466�30����,NL� N#�=... ���      "   
   x������ � �      #   
   x������ � �      $   3   x�3�4204�50�54R00�#NC#=���i�eDX�1B�!%1z\\\ ��      %      x�3�LLI,!N# �30������ Q��      !      x�32�4C#c.C΂\�+F��� ;�     