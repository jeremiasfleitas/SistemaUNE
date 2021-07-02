--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-07-01 21:18:12

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
-- TOC entry 3045 (class 0 OID 16441)
-- Dependencies: 207
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--
INSERT INTO alumnos (id_alumno, nombre_alumno, documento_alumno, contacto_alumno) VALUES 
(1,	'Juan',	'1111',	'0985347584'),
(2,	Alberto	2222	0975147852)
3	Jose	3333	0996854785,
4	Joaquin	4444	0994578965
5	Milagros	5555	0993147203
6	Marcelo	6666	0974145785
7	Matias	7777	0985258302
8	Sofia	8888	0974587458
9	Margaret	9999	0985632104
10	Alejandro	1000	0974852074
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
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 206
-- Name: alumnos_id_alumno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_id_alumno_seq', 10, true);


--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 202
-- Name: alumnos_materias_id_alumno_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_materias_id_alumno_materia_seq', 12, true);


--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 204
-- Name: asistencias_id_asistencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asistencias_id_asistencia_seq', 13, true);


--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 208
-- Name: carreras_id_carrera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carreras_id_carrera_seq', 7, true);


--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 212
-- Name: inventario_id_inventario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventario_id_inventario_seq', 1, false);


--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 200
-- Name: materias_id_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.materias_id_materia_seq', 139, true);


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 210
-- Name: profesores_id_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesores_id_profesor_seq', 1, false);


-- Completed on 2021-07-01 21:18:12

--
-- PostgreSQL database dump complete
--

