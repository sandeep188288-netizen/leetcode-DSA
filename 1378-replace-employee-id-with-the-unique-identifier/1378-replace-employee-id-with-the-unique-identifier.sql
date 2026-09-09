-- select eu.unique_id, e.name from EmployeeUNI eu
-- left join Employees e
-- on eu.id = e.id;

SELECT eu.unique_id, e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON e.id = eu.id;