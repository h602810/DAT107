-- SQL for frivillig oving (Komme i gang med JPA) --
DROP SCHEMA IF EXISTS oving_jpa CASCADE;
CREATE SCHEMA oving_jpa;
SET search_path TO oving_jpa;
   
-- Lager tabell Ansatt -- 
CREATE TABLE Ansatt
(
	brukernavn CHAR(4) NOT NULL,
	fornavn CHAR(15) NOT NULL,
	etternavn CHAR(30) NOT NULL,
	ansattdato DATE NOT NULL,
	stilling CHAR(20) NOT NULL,
	maanedslonn INTEGER NOT NULL,
	
	CONSTRAINT brukernavnPK PRIMARY KEY (brukernavn),
	CONSTRAINT brukernavnUnique UNIQUE (brukernavn)
);


INSERT INTO
	Ansatt(brukernavn, fornavn, etternavn, ansattdato, stilling, maanedslonn)
VALUES
    ('OLNO', 'Ola', 'Nordmann', '2019-05-15', 'Lagermedarbeider', 27000),
    ('DAOT', 'Dag', 'Otto', '2018-02-10', 'Lagersjef', 62000),
    ('PEPA', 'Petter', 'Pan', '2019-06-27', 'Lagermedarbeider', 23000);