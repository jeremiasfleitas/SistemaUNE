INSERT INTO alumnos (id_alumno, nombre_alumno, documento_alumno, contacto_alumno) VALUES 
(1,	'Juan',	1111,	'0985347584'),
(2,	'Alberto',	2222,	'0975147852'),
(3,	'Jose',	3333,	'0996854785'),
(4,	'Joaquin',	4444,	'0994578965',
(5,	'Milagros',	5555,	'0993147203',
(6,	'Marcelo',	6666,	'0974145785',
(7,	'Matias',	7777,	'0985258302',
(8,	'Sofia', 8888,	'0974587458'),
(9, 'Margaret', 9999,	'0985632104'),
(10, 'Alejandro', 1000, '0974852074')
\.


INSERT INTO alumnos_materias (id_alumno_materia, id_alumno, id_materia, nota_materia) VALUES
(1,	1,	1,	"\N"),
(2,	1,	2,	"\N"),
(3,	1,	3,	"\N"),
(4,	2,	4,	"\N"),
(5,	2,	5,	"\N"),
(6,	2,	6,	"\N"),
(7,	3,	7,	"\N"),
(8,	3,	8,	"\N"),
(9,	3,	9,	"\N"),
(10,4,	10,	"\N"),
(11,4,	1,	"\N"),
(12,4,	5,	"\N")
 \.



INSERT INTO asistencias (id_asistencia, id_alumno_materia, fecha_asistencia, presencia_asistencia) VALUES
(1,	1,	"2000-01-01", "Presente"),          
(2,	2,	"2000-01-01", "Ausente"),        
(3,	3,	"2000-01-01", "Presente"),          
(4,	4,	"2000-01-01", "Presente"),         
(5,	5,	"2000-01-01", "Presente"),          
(6,	6,	"2000-01-01", "Ausente"),         
(7,	7,	"2000-01-01", "Virtual"),         
(8,	8,	"2000-01-01", "Ausente"),         
(9,	9,	"2000-01-01", "Presente"),         
(10, 10, "2000-01-01", "Presente"),            
(11, 11, "2000-01-01", "Virtual"),          
(12, 12, "2000-01-01", "Presente"),            
(13, 1,	"2000-01-02", "Ausente")          


INSERT INTO carreras (id_carrera, nombre_carrera, detalles_carrera) VALUES
(2,	"Contaduria Pública"),                                                    
(3	"Derecho"),                                               
(4,	"Ingeniería Química"),                                                      
(5,	"Administración de Empresas"),                                               
(1,	"Programación de Compiladores"),                                                   
(7,	"Ingenieria Informática")     
\.


INSERT INTO materias (id_materia, nombre_materia, anho_materia, id_carrera) VALUES
(1, "Matematica",		 1, 1),
(2,	"Ciencias Sociales", 1,	3),
(3,	"Ciencias Naturales",1,	5),
(4,	"Castellano",	  	 1,	2),
(5,	"Guarani",  		 2,	3),
(6,	"Quimica",  		 2,	4),
(7,	"Fisica",  	     	 2,	5),
(8,	"Bases de Datos",  	 2,	1),
(9,	"Filosofia",  		 3,	2),
(10, "Economia",  		 3,	2),
(11, "Sociedad",  		 3,	2),
(139, "Lenguas Indigenas",3,2) 
 \.

