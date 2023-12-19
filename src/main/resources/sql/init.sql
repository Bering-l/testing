CREATE TYPE department_enum AS ENUM ('ADMINISTRATION', 'ACCOUNTING_DEPARTMENT',
    'HR', 'IT', 'FINANCIAL_DEPARTMENT', 'SERVICE_DEPARTMENT');

CREATE TABLE department
(
    department_id   smallserial NOT NULL,
    department_name department_enum,
    PRIMARY KEY (department_id)
);

CREATE TABLE author
(
    author_id     smallserial           NOT NULL,
    department_id smallint              NOT NULL,
    first_name    varchar(50),
    last_name     varchar(50),
    test_id       int                   NOT NULL,
    description   character varying(50) NOT NULL,
    PRIMARY KEY (author_id),
    FOREIGN KEY (department_id) REFERENCES department (department_id)
);
/*
CREATE TABLE users
(
    users_id serial,
    password varchar(255) NOT NULL,
    email    varchar(64) UNIQUE,
    PRIMARY KEY (users_id)
);

create table roles
(
    id   serial,
    name varchar(50) NOT NULL ,
    PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    user_id int NOT NULL,
    role_id int NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) references users (users_id),
    FOREIGN KEY (role_id) references roles (id)
);*/

CREATE TABLE candidate
(
    id           serial NOT NULL,
    first_name   varchar(50),
    last_name    varchar(50),
    create_date  timestamptz,
    last_session timestamptz,
    PRIMARY KEY (id)
);

CREATE TABLE vacancy
(
    id           serial NOT NULL,
    vacancy_name varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE test
(
    id          smallserial NOT NULL,
    author_id   smallint    NOT NULL,
    last_update timestamptz,
    vacancy_id  int         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES author (author_id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancy (id)
);

CREATE TYPE question_enum AS ENUM ('MULTIPLE_CHOICE', 'MULTIPLE_RESPONSE',
    'TRUE_OR_FALSE', 'LIKERT_SCALE', 'TASK', 'SEQUENCE', 'SHORT_ANSWER');

CREATE TABLE question_type
(
    id   serial NOT NULL,
    type question_enum,
    PRIMARY KEY (id)
);

CREATE TABLE answer
(
    id          serial NOT NULL,
    answer      varchar(128),
    question_id int    NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES answer (id)
);

CREATE TABLE correct_answer
(
    max_point smallint
) INHERITS (answer);

CREATE TABLE question
(
    id                serial NOT NULL,
    description       varchar(255),
    file              varchar(128),
    last_update       timestamptz,
    correct_answer_id int    NOT NULL,
    question_type_id  int    NOT NULL,
    test_id           int    NOT NULL,
    answer_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (question_type_id) REFERENCES question_type (id),
    FOREIGN KEY (answer_id) REFERENCES answer (id),
    FOREIGN KEY (test_id) REFERENCES test (id)
);

CREATE TABLE candidate_answers
(
    id           bigserial,
    question_id  int NOT NULL,
    point        SMALLINT,
    candidate_id int NOT NULL,
    answer_id    int NOT NULL,
    answer_date  timestamptz,
    answer       varchar(128),
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES question (id),
    FOREIGN KEY (answer_id) REFERENCES answer (id),
    FOREIGN KEY (candidate_id) REFERENCES candidate (id)
);

CREATE TABLE candidate_choose_vacancy
(
    candidate_id int NOT NULL,
    vacancy_id   int NOT NULL,
    PRIMARY KEY (candidate_id, vacancy_id),
    FOREIGN KEY (candidate_id) REFERENCES candidate (id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancy (id)
);

/*INSERT INTO roles (name)
VALUES ('ROLE_CANDIDATE'),
       ('ROLE_AUTHOR');

INSERT INTO users (users_id, password, email)
VALUES (1, '$2a$12$CUd.MIAsLehVoDUmjKVM8O/vRegmaJQ4P6wE0ymr.o.bsI6fTM4Hq',
        'example@gmail.com'),
       (2, '$2a$12$PH3FZLzTgNyXESp.jDkVRuHi.WElGxygeLkJxxOhxlTMJLwIwIhde',
        'author@gmail.com');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2);*/