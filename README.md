CREATE TABLE alumno (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    fechanac DATE
);

INSERT INTO alumno (nombre, apellido, fechanac) VALUES ('Juan', 'Perez', '2000-01-01');
