select * from "Homework";

select l."id", l."name", l."updatedAt", h.name as "homework_name" from "Lesson" as l 
join "Homework" as h on h."id" = l."homework_id";

select l.*, h.name as "homework_name" from "Lesson" as l
join "Homework" as h on h."id" = l."homework_id" 
order by "updatedAt" asc;

select s.*, l.name as "lesson_name" from "Schedule" as s 
join "Lesson_Schedule" as ls on ls."schedule_id" = s."id" 
join "Lesson" as l on l."id" = ls."lesson_id";

select s.name, count(l.name) as "lesson_count" from "Schedule" as s 
join "Lesson_Schedule" as ls on ls."schedule_id" = s."id" 
join "Lesson" as l on l."id" = ls."lesson_id" 
group by s.name;