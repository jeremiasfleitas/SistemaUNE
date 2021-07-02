--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-07-01 20:52:58

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
-- TOC entry 207 (class 1259 OID 16441)
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
-- TOC entry 206 (class 1259 OID 16439)
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
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 206
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumnos_id_alumno_seq OWNED BY public.alumnos.id_alumno;


--
-- TOC entry 203 (class 1259 OID 16425)
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
-- TOC entry 202 (class 1259 OID 16423)
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
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 202
-- Name: alumnos_materias_id_alumno_materia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumnos_materias_id_alumno_materia_seq OWNED BY public.alumnos_materias.id_alumno_materia;


--
-- TOC entry 205 (class 1259 OID 16433)
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
-- TOC entry 204 (class 1259 OID 16431)
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
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 204
-- Name: asistencias_id_asistencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asistencias_id_asistencia_seq OWNED BY public.asistencias.id_asistencia;


--
-- TOC entry 209 (class 1259 OID 16449)
-- Name: carreras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carreras (
    id_carrera integer NOT NULL,
    nombre_carrera character(255),
    detalles_carrera character(255)
);


ALTER TABLE public.carreras OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16447)
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
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 208
-- Name: carreras_id_carrera_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carreras_id_carrera_seq OWNED BY public.carreras.id_carrera;


--
-- TOC entry 213 (class 1259 OID 16473)
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
-- TOC entry 212 (class 1259 OID 16471)
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
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 212
-- Name: inventario_id_inventario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventario_id_inventario_seq OWNED BY public.inventario.id_inventario;


--
-- TOC entry 201 (class 1259 OID 16417)
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
-- TOC entry 200 (class 1259 OID 16415)
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
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 200
-- Name: materias_id_materia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.materias_id_materia_seq OWNED BY public.materias.id_materia;


--
-- TOC entry 211 (class 1259 OID 16464)
-- Name: profesores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesores (
    id_profesor integer NOT NULL,
    nombre_profesor character(60),
    documento_profesor character(60)
);


ALTER TABLE public.profesores OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16462)
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
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 210
-- Name: profesores_id_profesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesores_id_profesor_seq OWNED BY public.profesores.id_profesor;


--
-- TOC entry 2890 (class 2604 OID 16444)
-- Name: alumnos id_alumno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos ALTER COLUMN id_alumno SET DEFAULT nextval('public.alumnos_id_alumno_seq'::regclass);


--
-- TOC entry 2888 (class 2604 OID 16428)
-- Name: alumnos_materias id_alumno_materia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos_materias ALTER COLUMN id_alumno_materia SET DEFAULT nextval('public.alumnos_materias_id_alumno_materia_seq'::regclass);


--
-- TOC entry 2889 (class 2604 OID 16436)
-- Name: asistencias id_asistencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias ALTER COLUMN id_asistencia SET DEFAULT nextval('public.asistencias_id_asistencia_seq'::regclass);


--
-- TOC entry 2891 (class 2604 OID 16452)
-- Name: carreras id_carrera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carreras ALTER COLUMN id_carrera SET DEFAULT nextval('public.carreras_id_carrera_seq'::regclass);


--
-- TOC entry 2893 (class 2604 OID 16476)
-- Name: inventario id_inventario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario ALTER COLUMN id_inventario SET DEFAULT nextval('public.inventario_id_inventario_seq'::regclass);


--
-- TOC entry 2887 (class 2604 OID 16420)
-- Name: materias id_materia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materias ALTER COLUMN id_materia SET DEFAULT nextval('public.materias_id_materia_seq'::regclass);


--
-- TOC entry 2892 (class 2604 OID 16467)
-- Name: profesores id_profesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesores ALTER COLUMN id_profesor SET DEFAULT nextval('public.profesores_id_profesor_seq'::regclass);


--
-- TOC entry 3045 (class 0 OID 16441)
-- Dependencies: 207
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos (id_alumno, nombre_alumno, documento_alumno, contacto_alumno) FROM stdin;
1	Juan	1111	\N
2	Alberto	2222	\N
3	Jose	3333	\N
4	Joaquin	4444	\N
5	Milagros	5555	\N
6	Marcelo	6666	\N
7	Matias	7777	\N
8	Sofia	8888	\N
9	Margaret	9999	\N
10	Alejandro	1000	\N
\.


--
-- TOC entry 3041 (class 0 OID 16425)
-- Dependencies: 203
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
-- TOC entry 3043 (class 0 OID 16433)
-- Dependencies: 205
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
-- TOC entry 3047 (class 0 OID 16449)
-- Dependencies: 209
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
-- TOC entry 3051 (class 0 OID 16473)
-- Dependencies: 213
-- Data for Name: inventario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventario (id_inventario, nombre_inventario, cantidad_inventario, especificacion_inventario) FROM stdin;
\.


--
-- TOC entry 3039 (class 0 OID 16417)
-- Dependencies: 201
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
-- TOC entry 3049 (class 0 OID 16464)
-- Dependencies: 211
-- Data for Name: profesores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesores (id_profesor, nombre_profesor, documento_profesor) FROM stdin;
\.


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 206
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_id_alumno_seq', 10, true);


--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 202
-- Name: alumnos_materias_id_alumno_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_materias_id_alumno_materia_seq', 12, true);


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 204
-- Name: asistencias_id_asistencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asistencias_id_asistencia_seq', 13, true);


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 208
-- Name: carreras_id_carrera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carreras_id_carrera_seq', 7, true);


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 212
-- Name: inventario_id_inventario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventario_id_inventario_seq', 1, false);


--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 200
-- Name: materias_id_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.materias_id_materia_seq', 139, true);


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 210
-- Name: profesores_id_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesores_id_profesor_seq', 1, false);


--
-- TOC entry 2897 (class 2606 OID 16430)
-- Name: alumnos_materias alumnos_materias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos_materias
    ADD CONSTRAINT alumnos_materias_pkey PRIMARY KEY (id_alumno_materia);


--
-- TOC entry 2901 (class 2606 OID 16446)
-- Name: alumnos alumnos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (id_alumno);


--
-- TOC entry 2899 (class 2606 OID 16438)
-- Name: asistencias asistencias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias
    ADD CONSTRAINT asistencias_pkey PRIMARY KEY (id_asistencia);


--
-- TOC entry 2903 (class 2606 OID 16457)
-- Name: carreras carreras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carreras
    ADD CONSTRAINT carreras_pkey PRIMARY KEY (id_carrera);


--
-- TOC entry 2907 (class 2606 OID 16478)
-- Name: inventario inventario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario
    ADD CONSTRAINT inventario_pkey PRIMARY KEY (id_inventario);


--
-- TOC entry 2895 (class 2606 OID 16422)
-- Name: materias materias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materias
    ADD CONSTRAINT materias_pkey PRIMARY KEY (id_materia);


--
-- TOC entry 2905 (class 2606 OID 16469)
-- Name: profesores profesores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT profesores_pkey PRIMARY KEY (id_profesor);


-- Completed on 2021-07-01 20:52:59

--
-- PostgreSQL database dump complete
--

