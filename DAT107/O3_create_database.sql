-- SQL for oblig 3 --
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
   
-- Lager tabell Ansatt -- 
CREATE TABLE Ansatt
(
	ansattId SERIAL,
	brukernavn CHAR(4) NOT NULL,
	fornavn VARCHAR(15) NOT NULL,
	etternavn VARCHAR(30) NOT NULL,
	ansattdato DATE NOT NULL,
	stilling VARCHAR NOT NULL,
	maanedslonn INTEGER NOT NULL,
	avdelingsId INTEGER NOT NULL, -- en ansatt MÅ jobbe for en avdeling
	
	CONSTRAINT ansattId_PK PRIMARY KEY (ansattId),
	CONSTRAINT ansattId UNIQUE (ansattId),
	CONSTRAINT brukernavn UNIQUE (brukernavn),
	CONSTRAINT avdelingsId_FK FOREIGN KEY (avdelingsId)
		REFERENCES Avdeling(avdelingsId) -- referanse til avdelingsId
-- 	
-- 	CONSTRAINT AvdelingFK FOREIGN KEY (AvdelingsId) 
-- 		REFERENCES Avdeling(AvdelingsId)	
);

-- Lager tabell Avdeling --
CREATE TABLE Avdeling
(
	avdelingsId SERIAL,
	avdelingNavn VARCHAR(15) NOT NULL,
	sjefsId INTEGER NOT NULL, -- en avdeling MÅ ha en sjef
	
	CONSTRAINT avdelingsId_PK PRIMARY KEY (avdelingsId),
	CONSTRAINT sjefsId_FK FOREIGN KEY (sjefsId)
		REFERENCES Ansatt(ansattId)	-- referanse til ansattId
);


-- Legger til verdier --
INSERT INTO
	Ansatt(brukernavn, fornavn, etternavn, ansattdato, stilling, maanedslonn)
VALUES
    ('NOOL', 'Ola', 'Nordmann', '2019-05-15', 'Lagermedarbeider', 23000),
    ('OTDA', 'Dag', 'Otto', '2018-02-10', 'Lagersjef', 57000),
    ('PAPE', 'Petter', 'Pan', '2019-06-27', 'Lagermedarbeider', 24000);

INSERT INTO
	Avdeling(avdelingNavn, sjefsId)
VALUES
	('Administrasjon', 1),
	("Lager", 3);