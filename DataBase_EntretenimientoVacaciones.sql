-- Crear la base de datos
CREATE DATABASE entretenimientovacaciones;

-- Usar la base de datos
USE entretenimientovacaciones;

-- Crear la tabla AsociaciónJuvenil
CREATE TABLE AsociacionJuvenil (
    ID_Asociacion INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Asociacion VARCHAR(10),
    Dirección_Asociacion VARCHAR(25),
    Teléfono_Asociacion VARCHAR(10)
);

-- Crear la tabla ColoniaVacacional
CREATE TABLE ColoniaVacacional (
    Codigo_Colonia INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Colonia VARCHAR(10),
    Ubicacion_Colonia VARCHAR(10),
    ID_Asociacion1 INT,
    FOREIGN KEY (ID_Asociacion1) REFERENCES AsociacionJuvenil(ID_Asociacion)
);

-- Crear la tabla LíderDeGrupo
CREATE TABLE LiderDeGrupo (
    ID_Lider INT PRIMARY KEY AUTO_INCREMENT,
    CI_Lider VARCHAR(10),
    Nombre_Lider VARCHAR(30),
    Teléfono_Lider VARCHAR(10),
    Correo_Lider VARCHAR(20)
);

-- Crear la tabla ColoniaVacacional_LiderDeGrupo
CREATE TABLE ColoniaVacacional_LiderDeGrupo (
    Codigo_Colonia1 INT,
    ID_Lider1 INT,
    FOREIGN KEY (Codigo_Colonia1) REFERENCES ColoniaVacacional(Codigo_Colonia),
    FOREIGN KEY (ID_Lider1) REFERENCES LiderDeGrupo(ID_Lider)
);

-- Crear la tabla Certificación
CREATE TABLE Certificacion (
    ID_Certificacion INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Certificacion DATE,
    Grado_Certificacion VARCHAR(10),
    Asociacion_Emisora VARCHAR(15),
    ID_Lider2 INT,
    FOREIGN KEY (ID_Lider2) REFERENCES LiderDeGrupo(ID_Lider)
);

-- Crear la tabla Cliente
CREATE TABLE Cliente (
    Numero_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Cliente VARCHAR(30),
    CI_Cliente VARCHAR(10),
    Telefono_Cliente VARCHAR(10),
    Edad_Cliente INT
);

-- Crear la tabla ColoniaVacacional_Cliente
CREATE TABLE ColoniaVacacional_Cliente (
    Codigo_Colonia2 INT,
    Numero_Cliente1 INT,
    FOREIGN KEY (Codigo_Colonia2) REFERENCES ColoniaVacacional(Codigo_Colonia),
    FOREIGN KEY (Numero_Cliente1) REFERENCES Cliente(Numero_Cliente)
);

-- Crear la tabla Campamento
CREATE TABLE Campamento (
    ID_Campamento INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion_Campamento VARCHAR(30),
    Ubicacion_Campamento VARCHAR(25),
    Duracion_Dias INT
);

-- Crear la tabla Deporte
CREATE TABLE Deporte (
    ID_Deporte INT PRIMARY KEY AUTO_INCREMENT,
    Tipo_Deporte VARCHAR(10),
    Descripcion_Deporte VARCHAR(30),
    Horas_Semanales INT
);

-- Crear la tabla Deporte_AccesorioNecesario
CREATE TABLE Deporte_AccesorioNecesario (
    ID_Deporte1 INT,
    Accesorio_Necesario VARCHAR(35),
    FOREIGN KEY (ID_Deporte1) REFERENCES Deporte(ID_Deporte)
);

-- Crear la tabla Juego
CREATE TABLE Juego (
    ID_Juego INT PRIMARY KEY AUTO_INCREMENT,
    Tipo_Juego VARCHAR(10),
    Descripcion_Juego VARCHAR(35),
    Cantidad_Participantes INT
);

-- Crear la tabla LíderDeGrupo_Campamento
CREATE TABLE LiderDeGrupo_Campamento (
    ID_Lider3 INT,
    ID_Campamento1 INT,
    FOREIGN KEY (ID_Líder3) REFERENCES LiderDeGrupo(ID_Lider),
    FOREIGN KEY (ID_Campamento1) REFERENCES Campamento(ID_Campamento)
);

-- Crear la tabla LíderDeGrupo_Deporte
CREATE TABLE LiderDeGrupo_Deporte (
    ID_Lider4 INT,
    ID_Deporte2 INT,
    FOREIGN KEY (ID_Lider4) REFERENCES LiderDeGrupo(ID_Lider),
    FOREIGN KEY (ID_Deporte2) REFERENCES Deporte(ID_Deporte)
);

-- Crear la tabla LíderDeGrupo_Juego
CREATE TABLE LiderDeGrupo_Juego (
    ID_Lider5 INT,
    ID_Juego1 INT,
    FOREIGN KEY (ID_Lider5) REFERENCES LiderDeGrupo(ID_Lider),
    FOREIGN KEY (ID_Juego1) REFERENCES Juego(ID_Juego)
);

-- Crear la tabla Cliente_Campamento
CREATE TABLE Cliente_Campamento (
    Numero_Cliente2 INT,
    ID_Campamento2 INT,
    Antiguedad_Campamento INT,
    FOREIGN KEY (Numero_Cliente2) REFERENCES Cliente(Numero_Cliente),
    FOREIGN KEY (ID_Campamento2) REFERENCES Campamento(ID_Campamento)
);

-- Crear la tabla Cliente_Deporte
CREATE TABLE Cliente_Deporte (
    Numero_Cliente3 INT,
    ID_Deporte3 INT,
    Antigüedad_Deporte INT,
    Fecha_Participacion DATE,
    FOREIGN KEY (Numero_Cliente3) REFERENCES Cliente(Numero_Cliente),
    FOREIGN KEY (ID_Deporte3) REFERENCES Deporte(ID_Deporte)
);

-- Crear la tabla Cliente_Juego
CREATE TABLE Cliente_Juego (
    Numero_Cliente4 INT,
    ID_Juego2 INT,
    Antiguedad_Juego INT,
    FOREIGN KEY (Numero_Cliente4) REFERENCES Cliente(Numero_Cliente),
    FOREIGN KEY (ID_Juego2) REFERENCES Juego(ID_Juego)
);