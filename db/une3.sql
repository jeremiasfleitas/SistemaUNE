--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: alumnos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumnos (
    id_alumno integer NOT NULL,
    nombre_alumno character varying(250),
    documento_alumno character varying(50),
    contacto_alumno character varying(50)
);


ALTER TABLE public.alumnos OWNER TO postgres;

--
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alumnos_id_alumno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alumnos_id_alumno_seq OWNER TO postgres;

--
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumnos_id_alumno_seq OWNED BY public.alumnos.id_alumno;


--
-- Name: alumnos_materias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumnos_materias (
    id_alumno_materia integer NOT NULL,
    id_alumno integer,
    id_materia integer,
    nota_materia integer
);


ALTER TABLE public.alumnos_materias OWNER TO postgres;

--
-- Name: alumnos_materias_id_alumno_materia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alumnos_materias_id_alumno_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alumnos_materias_id_alumno_materia_seq OWNER TO postgres;

--
-- Name: alumnos_materias_id_alumno_materia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumnos_materias_id_alumno_materia_seq OWNED BY public.alumnos_materias.id_alumno_materia;


--
-- Name: asistencias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asistencias (
    id_asistencia integer NOT NULL,
    id_alumno_materia integer,
    fecha_asistencia date,
    presencia_asistencia character(20)
);


ALTER TABLE public.asistencias OWNER TO postgres;

--
-- Name: asistencias_id_asistencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asistencias_id_asistencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asistencias_id_asistencia_seq OWNER TO postgres;

--
-- Name: asistencias_id_asistencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asistencias_id_asistencia_seq OWNED BY public.asistencias.id_asistencia;


--
-- Name: carreras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carreras (
    id_carrera integer NOT NULL,
    nombre_carrera character(255),
    detalles_carrera character(255)
);


ALTER TABLE public.carreras OWNER TO postgres;

--
-- Name: carreras_id_carrera_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carreras_id_carrera_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carreras_id_carrera_seq OWNER TO postgres;

--
-- Name: carreras_id_carrera_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carreras_id_carrera_seq OWNED BY public.carreras.id_carrera;


--
-- Name: inventario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventario (
    id_inventario integer NOT NULL,
    nombre_inventario character(60),
    cantidad_inventario integer,
    especificacion_inventario character(255)
);


ALTER TABLE public.inventario OWNER TO postgres;

--
-- Name: inventario_id_inventario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inventario_id_inventario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inventario_id_inventario_seq OWNER TO postgres;

--
-- Name: inventario_id_inventario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventario_id_inventario_seq OWNED BY public.inventario.id_inventario;


--
-- Name: materias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materias (
    id_materia integer NOT NULL,
    nombre_materia character(20),
    anho_materia integer,
    id_carrera integer
);


ALTER TABLE public.materias OWNER TO postgres;

--
-- Name: materias_id_materia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.materias_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.materias_id_materia_seq OWNER TO postgres;

--
-- Name: materias_id_materia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.materias_id_materia_seq OWNED BY public.materias.id_materia;


--
-- Name: profesores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesores (
    id_profesor integer NOT NULL,
    nombre_profesor character(60),
    documento_profesor character(60)
);


ALTER TABLE public.profesores OWNER TO postgres;

--
-- Name: profesores_id_profesor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesores_id_profesor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesores_id_profesor_seq OWNER TO postgres;

--
-- Name: profesores_id_profesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesores_id_profesor_seq OWNED BY public.profesores.id_profesor;


--
-- Name: alumnos id_alumno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos ALTER COLUMN id_alumno SET DEFAULT nextval('public.alumnos_id_alumno_seq'::regclass);


--
-- Name: alumnos_materias id_alumno_materia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos_materias ALTER COLUMN id_alumno_materia SET DEFAULT nextval('public.alumnos_materias_id_alumno_materia_seq'::regclass);


--
-- Name: asistencias id_asistencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias ALTER COLUMN id_asistencia SET DEFAULT nextval('public.asistencias_id_asistencia_seq'::regclass);


--
-- Name: carreras id_carrera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carreras ALTER COLUMN id_carrera SET DEFAULT nextval('public.carreras_id_carrera_seq'::regclass);


--
-- Name: inventario id_inventario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario ALTER COLUMN id_inventario SET DEFAULT nextval('public.inventario_id_inventario_seq'::regclass);


--
-- Name: materias id_materia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materias ALTER COLUMN id_materia SET DEFAULT nextval('public.materias_id_materia_seq'::regclass);


--
-- Name: profesores id_profesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesores ALTER COLUMN id_profesor SET DEFAULT nextval('public.profesores_id_profesor_seq'::regclass);


--
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos (id_alumno, nombre_alumno, documento_alumno, contacto_alumno) FROM stdin;
1	Juan	1111	0985347584
2	Alberto	2222	0975147852
3	Jose	3333	0996854785
4	Joaquin	4444	0994578965
5	Milagros	5555	0993147203
6	Marcelo	6666	0974145785
7	Matias	7777	0985258302
8	Sofia	8888	0974587458
9	Margaret	9999	0985632104
10	Alejandro	1000	0974852074
\.


--
-- Data for Name: alumnos_materias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos_materias (id_alumno_materia, id_alumno, id_materia, nota_materia) FROM stdin;
1	1	1	\N
2	1	2	\N
3	1	3	\N
4	2	4	\N
5	2	5	\N
6	2	6	\N
7	3	7	\N
8	3	8	\N
9	3	9	\N
10	4	10	\N
11	4	1	\N
12	4	5	\N
\.


--
-- Data for Name: asistencias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asistencias (id_asistencia, id_alumno_materia, fecha_asistencia, presencia_asistencia) FROM stdin;
1	1	2000-01-01	Presente            
2	2	2000-01-01	Ausente             
3	3	2000-01-01	Presente            
4	4	2000-01-01	Presente            
5	5	2000-01-01	Presente            
6	6	2000-01-01	Ausente             
7	7	2000-01-01	Virtual             
8	8	2000-01-01	Ausente             
9	9	2000-01-01	Presente            
10	10	2000-01-01	Presente            
11	11	2000-01-01	Virtual             
12	12	2000-01-01	Presente            
13	1	2000-01-02	Ausente             
\.


--
-- Data for Name: carreras; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carreras (id_carrera, nombre_carrera, detalles_carrera) FROM stdin;
2	Contaduria Pública                                                                                                                                                                                                                                             	                                                                                                                                                                                                                                                               
3	Derecho                                                                                                                                                                                                                                                        	                                                                                                                                                                                                                                                               
4	Ingeniería Química                                                                                                                                                                                                                                             	                                                                                                                                                                                                                                                               
5	Administración de Empresas                                                                                                                                                                                                                                     	                                                                                                                                                                                                                                                               
1	Programación de Compiladores                                                                                                                                                                                                                                   	                                                                                                                                                                                                                                                               
7	Ingenieria Informática                                                                                                                                                                                                                                         	                                                                                                                                                                                                                                                               
\.


--
-- Data for Name: inventario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventario (id_inventario, nombre_inventario, cantidad_inventario, especificacion_inventario) FROM stdin;
\.


--
-- Data for Name: materias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materias (id_materia, nombre_materia, anho_materia, id_carrera) FROM stdin;
1	Matematica          	1	1
2	Ciencias Sociales   	1	3
3	Ciencias Naturales  	1	5
4	Castellano          	1	2
5	Guarani             	2	3
6	Quimica             	2	4
7	Fisica              	2	5
8	Bases de Datos      	2	1
9	Filosofia           	3	2
10	Economia            	3	2
11	Sociedad            	3	2
139	Lenguas Indigenas   	3	2
\.


--
-- Data for Name: profesores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesores (id_profesor, nombre_profesor, documento_profesor) FROM stdin;
\.


--
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_id_alumno_seq', 10, true);


--
-- Name: alumnos_materias_id_alumno_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_materias_id_alumno_materia_seq', 12, true);


--
-- Name: asistencias_id_asistencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asistencias_id_asistencia_seq', 13, true);


--
-- Name: carreras_id_carrera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carreras_id_carrera_seq', 7, true);


--
-- Name: inventario_id_inventario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventario_id_inventario_seq', 1, false);


--
-- Name: materias_id_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.materias_id_materia_seq', 139, true);


--
-- Name: profesores_id_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesores_id_profesor_seq', 1, false);


--
-- Name: alumnos_materias alumnos_materias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos_materias
    ADD CONSTRAINT alumnos_materias_pkey PRIMARY KEY (id_alumno_materia);


--
-- Name: alumnos alumnos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (id_alumno);


--
-- Name: asistencias asistencias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias
    ADD CONSTRAINT asistencias_pkey PRIMARY KEY (id_asistencia);


--
-- Name: carreras carreras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carreras
    ADD CONSTRAINT carreras_pkey PRIMARY KEY (id_carrera);


--
-- Name: inventario inventario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario
    ADD CONSTRAINT inventario_pkey PRIMARY KEY (id_inventario);


--
-- Name: materias materias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materias
    ADD CONSTRAINT materias_pkey PRIMARY KEY (id_materia);


--
-- Name: profesores profesores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT profesores_pkey PRIMARY KEY (id_profesor);


--
-- PostgreSQL database dump complete
--

