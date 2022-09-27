DROP TABLE IF EXISTS timetable CASCADE;
DROP TABLE IF EXISTS audience CASCADE;
DROP TABLE IF EXISTS subject CASCADE;
DROP TABLE IF EXISTS teacher CASCADE;
DROP TABLE IF EXISTS study_group CASCADE;
CREATE TABLE audience
(
   id SERIAL PRIMARY KEY,
   name CHARACTER VARYING (10) NOT NULL
);
CREATE TABLE study_group
(
   id INTEGER PRIMARY KEY,
   name CHARACTER VARYING (30) NOT NULL
);
CREATE TABLE teacher
(
   id SERIAL PRIMARY KEY,
   name CHARACTER VARYING (80) NOT NULL,
   rank CHARACTER VARYING (15) NOT NULL
);
CREATE TABLE subject
(
   id SERIAL PRIMARY KEY,
   name CHARACTER VARYING (80) NOT NULL
);
CREATE TABLE timetable
(
   id SERIAL PRIMARY KEY,
   group_id INTEGER NOT NULL,
   audience_id INTEGER NOT NULL,
   teacher_id INTEGER NOT NULL,
   subject_id INTEGER NOT NULL,
   lesson_date DATE NOT NULL,
   day CHARACTER VARYING (10) NOT NULL,
   lesson_number INTEGER NOT NULL,
   CONSTRAINT group_fkey FOREIGN KEY (group_id) REFERENCES study_group (id) ON DELETE CASCADE,
   CONSTRAINT teacher_fkey FOREIGN KEY (teacher_id) REFERENCES teacher (id) ON DELETE CASCADE,
   CONSTRAINT audience_fkey FOREIGN KEY (audience_id) REFERENCES audience (id) ON DELETE CASCADE,
   CONSTRAINT subject_fkey FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);