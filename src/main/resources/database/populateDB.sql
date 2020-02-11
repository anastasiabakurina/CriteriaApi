insert into gender ( gender)
VALUES ('male'),
       ('female');

insert into candidates (surname, name, middlename, birthday, genderid)
VALUES ('Петров', 'Петр', 'Петрович', '1986-12-12', 1),
       ('Иванов', 'Иван', 'Иванович', '1997-04-04', 1),
       ('Морская', 'Мария', 'Васильевна', '1999-07-07', 2);

insert into contacts (contact, candidatesid)
VALUES ('+375(29)123-45-67', 1),
       ('http://github.com/petya', 1),
       ('petrovich@gmail.com', 1),
       ('+375(29)87-65-43', 2),
       ('http://github.com/vanya', 2),
       ('skype:ivanko', 2),
       ('+375(29)999-99-99, ', 3),
       ('https://www.linkedin.com/in/mariya/', 3);

insert into technologies (technologies, candidatesid)
VALUES ('Git', 1),
       ('Spring Boot', 1),
       ('HTML', 1),
       ('Git', 2),
       ('JavaEE', 2),
       ('Java Core', 2),
       ('Maven', 3),
       ('REST', 3),
       ('Spring', 3);

-- truncate table candidates;
