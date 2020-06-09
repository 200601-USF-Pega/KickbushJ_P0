SELECT * FROM NaughtyNice, ElvenWorkers, CurrentToys 
	WHERE NaughtyNice.childID = CurrentToys.childID
	AND ElvenWorkers.elvenID = CurrentToys.elvenID;
	

-- SELECT * FROM NaughtyNice, ElvenWorkers, ToyHistory 
-- 	WHERE NaughtyNice.childID = ToyHistory.childID
-- 	AND ElvenWorkers.elvenID = ToyHistory.elvenID;