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