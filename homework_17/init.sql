create table "Homework" (
  "id" int generated always as identity primary key,
  "name" varchar(20),
  "description" text);
  
create table "Lesson" (
  "id" int generated always as identity,
  "name" varchar(45),
  "updatedAt" date,
  "homework_id" int,
  primary key ("id"),
  unique ("homework_id"),
  constraint "fk_Lesson_1" foreign key ("homework_id") references "Homework" ("id"));

create table "Schedule" (
  "id" int generated always as identity,
  "name" varchar(45),
  "updatedAt" date,
  "lessons" int,
  primary key ("id"),
  constraint "fk_Schedule_1" foreign key("lessons") references "Lesson"("id"));