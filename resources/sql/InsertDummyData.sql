TRUNCATE NaughtyNice, ElvenWorkers, CurrentToys, ToyHistory, LoginInfo CASCADE;

insert into LoginInfo (empID, pass, manager) 
	values(1, 'pass1', true), (2, 'pass2', false);

insert into NaughtyNice (childName, childAge, naughty) values ('Goldy Bachshell', 6, false);
insert into NaughtyNice (childName, childAge, naughty) values ('Clarabelle Raffeorty', 1, false);
insert into NaughtyNice (childName, childAge, naughty) values ('Currie Chaunce', 4, false);
insert into NaughtyNice (childName, childAge, naughty) values ('Dick Gummery', 9, false);
insert into NaughtyNice (childName, childAge, naughty) values ('Jennifer Brown', 3, false);

insert into ElvenWorkers (elvenName, elvenAge, positionName, shiftNumber, numProducedToys) values ('Ashley Batrick', 42, 'Head Elf', 1, 489);
insert into ElvenWorkers (elvenName, elvenAge, positionName, shiftNumber, numProducedToys) values ('Lesli Alyoshin', 27, 'Senior Toymaker', 3, 81);
insert into ElvenWorkers (elvenName, elvenAge, positionName, shiftNumber, numProducedToys) values ('Winston Lauchlan', 26, 'Junior Toymaker', 2, 67);
insert into ElvenWorkers (elvenName, elvenAge, positionName, shiftNumber, numProducedToys) values ('Robby Danger', 14, 'Intern', 3, 0);

insert into CurrentToys (toyName, toyColor, workTime, childID, elvenID) values ('Firetruck', 'Red', 2.9, 1, 1);
insert into CurrentToys (toyName, toyColor, workTime, childID, elvenID) values ('Doll House', 'Green', 4.5, 2, 2);
insert into CurrentToys (toyName, toyColor, workTime, childID, elvenID) values ('Barbie Doll', 'Tan', 2.0, 3, 3);
insert into CurrentToys (toyName, toyColor, workTime, childID, elvenID) values ('Transformer', 'Turquoise', 3.4, 4, 1);
insert into CurrentToys (toyName, toyColor, workTime, childID, elvenID) values ('Rubiks Cube', 'Pink', 3.0, 5, 2);
insert into CurrentToys (toyName, toyColor, workTime, childID, elvenID) values ('Bionicle', 'Violet', 2.9, 1, 3);

insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Ken doll', 'Tan', 1.9, 1, 1, 2018, true);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Monopoly', 'White', 2.6, 2, 2, 2018, true);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Settlers of Catan', 'Green', 4.6, 3, 3, 2018, true);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Checkers', 'Green', 0.9, 4, 1, 2018, false);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Chess Board', 'Crimson', 4.0, 5, 2, 2018, false);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Army Soldiers', 'Maroon', 3.7, 1, 3, 2019, false);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Toy Lightsaber', 'Gold', 3.3, 2, 3, 2019, true);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Tank Action Figure', null, 1.7, 3, 1, 2019, false);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Pre Cracked Egg', 'Turquoise', 0.8, 4, 2, 2019, true);
insert into ToyHistory (toyName, toyColor, workTime, childID, elvenID, yearProduced, delivered) values ('Fermit the Krog', 'Aquamarine', 4.1, 5, 1, 2019, true);
