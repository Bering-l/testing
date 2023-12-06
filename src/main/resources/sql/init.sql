CREATE SCHEMA test;

CREATE TABLE author
(
    author_id     smallint              NOT NULL,
    department_id smallint              NOT NULL,
    first_name    varchar(50),
    last_name     varchar(50),
    email         varchar(64),
    test_id       int                   NOT NULL,
    PRIMARY KEY (author_id),
    FOREIGN KEY (department_id) REFERENCES department (department_id)
);

CREATE TYPE department_enum AS ENUM ('ADMINISTRATION', 'ACCOUNTING_DEPARTMENT',
    'HR', 'IT', 'FINANCIAL_DEPARTMENT', 'SERVICE_DEPARTMENT');

CREATE TABLE department
(
    department_id   smallint NOT NULL,
    department_name department_enum,
    PRIMARY KEY (department_id)
);

CREATE TABLE test
(
    test_id              int      NOT NULL,
    author_id            smallint NOT NULL,
    candidate_answers_id int      NOT NULL,
    last_update          timestamp,
    PRIMARY KEY (test_id),
    FOREIGN KEY (author_id) REFERENCES author (author_id)
);

CREATE TABLE test_question
(
    test_question_id int NOT NULL,
    question_id      int NOT NULL,
    test_id          int NOT NULL,
    PRIMARY KEY (test_question_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id),
    FOREIGN KEY (test_id) REFERENCES test (test_id)
);

CREATE TABLE question
(
    question_id       int NOT NULL,
    max_point         SMALLINT,
    description       text,
    file              varchar(128),
    last_update       timestamp,
    correct_answer_id int NOT NULL,
    PRIMARY KEY (question_id),
    FOREIGN KEY (correct_answer_id) REFERENCES correct_answer (correct_answer_id)
);

CREATE TYPE question_enum AS ENUM ('MULTIPLE_CHOICE', 'MULTIPLE_RESPONSE',
    'TRUE_OR_FALSE', 'LIKERT_SCALE', 'TASK', 'SEQUENCE', 'SHORT_ANSWER');

CREATE TABLE question_type
(
    question_type_id int NOT NULL,
    type             question_enum,
    question_id      int NOT NULL,
    PRIMARY KEY (question_type_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id)
);


CREATE TABLE correct_answer
(
    correct_answer_id int NOT NULL,
    answer            varchar(128),
    PRIMARY KEY (correct_answer_id)
);

CREATE TABLE candidate_answers
(
    candidate_answers_id int NOT NULL,
    question_id          int NOT NULL,
    point                SMALLINT,
    candidate_id         int NOT NULL,
    answer_date          timestamp,
    answer               varchar(128),
    PRIMARY KEY (candidate_answers_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id),
    FOREIGN KEY (candidate_id) REFERENCES candidate (candidate_id)
);

CREATE TABLE candidate
(
    candidate_id int NOT NULL,
    email        varchar(64) NOT NULL,
    first_name   varchar(50) NOT NULL,
    last_name    varchar(50) NOT NULL,
    create_date  timestamp,
    last_session timestamp,
    PRIMARY KEY (candidate_id)
);

CREATE TABLE vacancy
(
    vacancy_id   int NOT NULL,
    test_id      int NOT NULL,
    vacancy_name varchar(50),
    PRIMARY KEY (vacancy_id),
    FOREIGN KEY (test_id) REFERENCES test (test_id)
);

CREATE TABLE candidate_choose_vacancy
(
    candidate_choose_vacancy_id int NOT NULL,
    candidate_id                int NOT NULL,
    vacancy_id                  int NOT NULL,
    PRIMARY KEY (candidate_choose_vacancy_id),
    FOREIGN KEY (candidate_id) REFERENCES candidate (candidate_id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancy (vacancy_id)
);