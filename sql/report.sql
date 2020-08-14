SELECT * FROM Students WHERE fk_classId = 1;

SELECT Students.* 
FROM Students
INNER JOIN Classes on Classes.classId = Students.fk_classId
WHERE Classes.className = "1a";