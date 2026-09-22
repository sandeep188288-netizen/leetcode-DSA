-- delete from Person
-- where id not in (select min(id) from Person group by email);
DELETE FROM Person
WHERE id IN (
    SELECT id
    FROM (
        SELECT p1.id
        FROM Person p1
        JOIN Person p2
        ON p1.email = p2.email
        AND p1.id > p2.id
    ) AS temp
);