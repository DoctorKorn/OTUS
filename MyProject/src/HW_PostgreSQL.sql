-- Создаем таблицу с вопросами
create table questions (
  id   serial primary key,
  text varchar(256) not null unique
);
-- Проверяем наличие таблицы и наличие данных после вставки
select * from questions;
-- Вставляем данные по вопросам
insert into questions (text)
values ('На какой реке стоит город Санкт-Петербург?'),
       ('Виды какого города можно увидеть на российской купюре в 500 рублей?'),
       ('В этой озеро нашей страны впадает множество рек, а вытекает только одна - Ангара.');
-- Проверяем работу уникального ключа (получим ошибку)
insert into questions (text)
values ('На какой реке стоит город Санкт-Петербург?');
-- Создаем таблицу с ответами на вопросы
create table answers (
  id          serial primary key,
  question_id integer references questions (id),
  text        varchar(256) not null,
  ordr        integer not null,
  correct     boolean,
  unique (question_id, text, ordr)
);
-- Проверяем наличие таблицы и наличие данных после вставки
select * from answers;
-- Вставляем ответы на вопросы
insert into answers (question_id, text, ordr, correct)
values (1, 'Енисей', 1, false),
       (1, 'Волга', 2, false),
       (1, 'Нева', 3, true),
       (1, 'Лена', 4, false),
       (2, 'Москва', 1, false),
       (2, 'Красноярск', 2, false),
       (2, 'Ярославль', 3, false),
       (2, 'Архангельск', 4, true),
       (3, 'Байкал', 1, true),
       (3, 'Селигер', 2, false),
       (3, 'Ладожское', 3, false),
       (3, 'Виктория', 4, false);
-- Проверка данных из двух таблиц
select q.text,
	   an.ordr,
	   an.text,
	   an.correct
  from questions q
  join answers an on q.id = an.question_id
 --where q.id = 1
order by q.id, an.ordr;
-- Проверяем работу уникального ключа (получим ошибку)
insert into answers (question_id, text, ordr, correct)
values (1, 'Енисей', 1, false);