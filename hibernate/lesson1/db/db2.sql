CREATE TABLE IF NOT EXISTS engines(
                                      id serial primary key,
                                      model varchar(25),
                                      power integer not null
);
INSERT INTO engines (model, power) values ('model_test',123);

CREATE TABLE IF NOT EXISTS cars(
                                   id serial primary key ,
                                   mark varchar(25) not null,
                                   model varchar(25) not null,
                                   engine_id integer not null,
                                   FOREIGN KEY (engine_id) references engines (id)
);

insert into cars(mark, model, engine_id) values ('car_test','test_model',1);