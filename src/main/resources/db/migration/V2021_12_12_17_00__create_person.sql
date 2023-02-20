create table person
(
    id   bigint not null
        constraint person_pkey
            primary key,
    name varchar(255)
);

insert into person (id, name)
values (1, 'Jörgen')
