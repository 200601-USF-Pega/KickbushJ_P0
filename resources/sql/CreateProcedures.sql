CREATE OR REPLACE PROCEDURE insertChild(VARCHAR, INT, BOOLEAN)
LANGUAGE plpgsql
AS $$
BEGIN
	INSERT INTO NaughtyNice
	(childName, childage, naughty)
	VALUES ($1, $2, $3);
	
	COMMIT;
END;
$$;

CREATE OR REPLACE PROCEDURE changeChildNaughty(INT, BOOLEAN)
LANGUAGE plpgsql
AS $$
BEGIN
	UPDATE NaughtyNice
	SET naughty = $2
	WHERE childID = $1;
	
	COMMIT;
END;
$$;

CREATE OR REPLACE PROCEDURE addToy(VARCHAR, VARCHAR, REAL, INT, INT)
LANGUAGE plpgsql
AS $$
BEGIN
	INSERT INTO CurrentToys
	(toyName, toyColor, workTime, childID, elvenID)
	VALUES ($1, $2, $3, $4, $5);
	
	COMMIT;
END;
$$;

CREATE OR REPLACE PROCEDURE removeToy(INT)
LANGUAGE plpgsql
AS $$
BEGIN
	DELETE FROM CurrentToys
	WHERE toyID = $1;
	
	COMMIT;
END;
$$;

CREATE OR REPLACE PROCEDURE addElf(VARCHAR, INT, VARCHAR, INT, INT)
LANGUAGE plpgsql
AS $$
BEGIN
	INSERT INTO ElvenWorkers
	(elvenName, elvenAge, positionName, shiftNumber, numProducedToys)
	VALUES ($1, $2, $3, $4, $5);
	
	COMMIT;
END;
$$;

CREATE OR REPLACE PROCEDURE removeElf(INT)
LANGUAGE plpgsql
AS $$
BEGIN
	DELETE FROM ElvenWorkers
	WHERE elvenID = $1;
	
	COMMIT;
END;
$$;

CREATE OR REPLACE PROCEDURE addToyToHistory(VARCHAR, VARCHAR, REAL, INT, INT, INT, BOOLEAN)
LANGUAGE plpgsql
AS $$
BEGIN
	INSERT INTO ToyHistory
	(toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered)
	VALUES ($1, $2, $3, $4, $5, $6, $7);
	
	COMMIT;
END;
$$;