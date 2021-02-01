insert into USR (id, active, password, username)
    values ( 1, true,'$2a$08$/g3pUp1HLlrhlR88/rYNpOsDWFQe0CGrVvzxPzTyq1LZ9K/Yfo5AW','admin');

insert into user_role (user_id, roles)
values (1, 'USER'), (1, 'ADMIN');