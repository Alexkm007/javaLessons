CREATE DATABASE config_lesson ENCODING 'UTF-8';
CREATE TABLE IF NOT EXISTS engines(
    model varchar(25) primary key,
    power integer not null
    );
INSERT INTO engines (model, power) values ('engine_model_01',1250);
INSERT INTO engines (model, power) values ('engine_model_02',2820);