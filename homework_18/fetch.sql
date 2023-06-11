select * from "Homework";
select l."id", l."name", l."updatedAt", h.name as "homework_name" from "Lesson" as l join "Homework" as h on h."id" = l."homework_id";
