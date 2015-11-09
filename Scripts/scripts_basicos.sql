--Sintaxis para un insert
--CAMPOS y VALORES deben coincidir 
--en el orden y tipo de dato
INSERT INTO TABLE (CAMPOS)
VALUES (VALORES);


INSERT INTO tbl_invitados (
	nombre_invitado, 
	telefono, 
	correo, 
	direccion, 
	genero)
VALUES (
	'Luisa Martinez', 
	'111111111', 
	'luisa@gmail.com', 
	'Col el Hogar', 
	'F'
);

--Actualizar un registro
UPDATE NOMBRE_TABLE
SET CAMPO1 = NUEVO_VALOR1,
 	CAMPO2 = NUEVO_VALOR2,
 	...
 	CAMPON = NUEVO_VALORN
WHERE CONDICION;


UPDATE tbl_invitados 
SET nombre_invitado = 'Maria Rodriguez', 
	telefono = '7894564444', 
	correo = 'maria.rodriguez@gmail.com', 
	direccion = 'Col Miraflores' 
WHERE codigo_invitado = 2;

--Eliminar un registro
DELETE FROM NOMBRE_TABLA
WHERE CONDICION;


DELETE FROM tbl_invitados
WHERE codigo_invitado = 4;

--Investigacion
--Gestion de transacciones (Commit, Rollback)

--Consultar informacion
SELECT CAMPOS 
FROM NOMBRE_TABLA
WHERE CONDICION;
--Con * significa que consulta todos los campos
SELECT * 
FROM tbl_eventos;

SELECT codigo_evento,
    nombre_evento,
    descripcion,
    direccion,
    fecha,
    cantidad_invitados,
    codigo_tipo_evento,
    codigo_estado,
    codigo_municipio
FROM tbl_eventos;


SELECT codigo_evento,
    nombre_evento,
    descripcion,
    direccion,
    fecha,
    cantidad_invitados,
    codigo_tipo_evento,
    codigo_estado,
    codigo_municipio
FROM tbl_eventos
WHERE codigo_evento = 4;



