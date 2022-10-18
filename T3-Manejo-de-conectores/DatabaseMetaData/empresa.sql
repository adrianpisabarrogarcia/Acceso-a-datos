CREATE TABLE departamento
(
    id     int AUTO_INCREMENT,
    nombre varchar(255),
    ciudad varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE empleado
(
    id              int AUTO_INCREMENT,
    apellido        varchar(255),
    oficio          varchar(255),
    dir             int,
    fecha_alt       date,
    salario         int,
    comision        int,
    id_departamento int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_departamento) REFERENCES departamento (id),
    FOREIGN KEY (dir) REFERENCES empleado (id)
);

INSERT INTO departamento
VALUES (1, 'Ventas', 'Madrid');
INSERT INTO departamento
VALUES (2, 'Compras', 'Barcelona');
INSERT INTO departamento
VALUES (3, 'Informatica', 'Valencia');
INSERT INTO departamento
VALUES (4, 'RRHH', 'Sevilla');
INSERT INTO departamento
VALUES (5, 'Marketing', 'Bilbao');


INSERT INTO empleado
VALUES (1, 'Juan', 'Informático', null, '2010-01-01', 1000, 0, 3);
INSERT INTO empleado
VALUES (2, 'Ana', 'Secretaria', 1, '2010-01-01', 1000, 0, 3);
INSERT INTO empleado
VALUES (3, 'Luis', 'Jefe de proyecto', 2, '2010-01-01', 1000, 0, 3);
INSERT INTO empleado
VALUES (4, 'María', 'Diseñadora', 1, '2010-01-01', 1000, 0, 3);
INSERT INTO empleado
VALUES (5, 'Pedro', 'Programador', 1, '2010-01-01', 1000, 0, 3);
INSERT INTO empleado
VALUES (6, 'Laura', 'Programador', 1, '2010-01-01', 1000, 0, 3);
INSERT INTO empleado
VALUES (7, 'Antonio', 'Programador', 1, '2010-01-01', 1000, 0, 3);