DROP TABLE IF EXISTS NaughtyNice, CurrentToys, ToyHistory, ElvenWorkers CASCADE;

CREATE TABLE IF NOT EXISTS NaughtyNice (
	childID SERIAL PRIMARY KEY,
	childName varchar(100) NOT NULL,
	childAge smallint,
	naughty BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS ElvenWorkers (
	elvenID SERIAL PRIMARY KEY,
	elvenName varchar(100) NOT NULL,
	elvenAge smallint,
	positionName varchar(100) NOT NULL,
	shiftNumber smallint NOT NULL,
	numProducedToys smallint NOT NULL,
	CHECK (0 < shiftNumber AND 4 > shiftNumber)
);

CREATE TABLE IF NOT EXISTS CurrentToys (
	toyID SERIAL PRIMARY KEY,
	toyName varchar(100) NOT NULL,
	toyColor varchar(25),
	workTime real NOT NULL,
	childID smallint,
	elvenID smallint,
	FOREIGN KEY (childID) REFERENCES NaughtyNice (childID),
	FOREIGN KEY (elvenID) REFERENCES ElvenWorkers (elvenID)
);

CREATE TABLE IF NOT EXISTS ToyHistory (
	historyID SERIAL PRIMARY KEY,
	toyName varchar(100) NOT NULL,
	toyColor varchar(25),
	workTime real NOT NULL,
	childID smallint,
	elvenID smallint,
	yearProduced smallint NOT NULL,
	delivered BOOLEAN NOT NULL,
	FOREIGN KEY (childID) REFERENCES NaughtyNice (childID),
	FOREIGN KEY (elvenID) REFERENCES ElvenWorkers (elvenID)
);