create table "Homework" (
  "id" int,
  "name" varchar(20),
  "description" varchar(50),
  primary key ("id"));
  
create table "Lesson" (
  "id" int,
  "name" varchar(45),
  "updatedAt" date,
  "homework_id" int,
  primary key ("id"),
  unique ("homework_id"),
  constraint "fk_Lesson_1" foreign key ("homework_id") references "Homework" ("id"));

create table "Schedule" (
  "id" int,
  "name" varchar(45),
  "updatedAt" date,
  "lessons" int,
  primary key ("id"));


create table "Lesson_Schedule" (
  "lesson_id" int,
  "schedule_id" int,
  constraint "fk_LS_1" foreign key ("homework_id") references "Homework" ("id"),
  constraint "fk_LS_2" foreign key ("schedule_id") references "Schedule" ("id"));
