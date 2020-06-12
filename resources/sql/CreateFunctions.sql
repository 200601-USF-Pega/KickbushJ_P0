CREATE OR REPLACE FUNCTION getDelivered()
RETURNS integer[] as $results$

DECLARE
	results int[2];
	delivered int;
	notDelivered int;
BEGIN select count(nullif(ToyHistory.delivered, false)) into delivered FROM ToyHistory; 
	select count(nullif(ToyHistory.delivered, true)) into notDelivered FROM ToyHistory;
	select ARRAY[delivered, notDelivered] into results;
	return results;
END;
$results$ LANGUAGE plpgsql;