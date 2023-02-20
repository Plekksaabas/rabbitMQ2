create table classifier
(
    id         bigint       not null
        constraint classifier_pkey
            primary key,
    parent_id  bigint,
    name       varchar(255) not null,
    selectable boolean
);
create table sub_types
(
    id       bigint,
    sub_type bigint,
    FOREIGN KEY (id) REFERENCES classifier
);

insert into classifier (id, name, parent_id, selectable)
values (1, 'Manufacturing', null, false),
       (2, 'Construction materials', 1, false),
       (3, 'Electronics and Optics', 1, false),
       (4, 'Food and Beverage', 1, false),
       (5, 'Bakery confectionery products', 4, true),
       (6, 'Beverages', 4, true),
       (7, 'Fish fish products', 4, true),
       (8, 'Meat meat products', 4, true),
       (9, 'Other(Food and Beverage)', 4, true),
       (10, 'Sweets & snack food', 4, true),
       (11, 'Furniture', 1, false ),
       (12, 'Bathroom/sauna', 11, true),
       (13, 'Bedroom', 11, true),
       (14, 'Children''s room', 11, true),
       (15, 'Kitchen', 11, true),
       (16, 'Living room', 11, true),
       (17, 'Office', 11, true),
       (18, 'Other (Furniture)', 11, true),
       (19, 'Outdoor', 11, true),
       (20, 'Project furniture', 11, true),
       (21, 'Machinery', 1, false),
       (22, 'Machinery components', 21, false),
       (23, 'Machinery equipment/tools', 21, false),
       (24, 'Manufacture of machinery', 21, false),
       (25, 'Maritime', 21, false),
       (26, 'Aluminium and steel workboats', 25, true),
       (27, 'Boat/Yacht building', 25, true),
       (28, 'Ship repair and conversion', 25, true),
       (29, 'Metal structures', 21, false),
       (30, 'Other', 21, false),
       (31, 'Repair and maintenance service', 21, false);




insert into sub_types (id, sub_type)
values (1, 2),
       (1, 3),
       (1, 4),
       (4, 5),
       (4, 6),
       (4, 7),
       (4, 8),
       (4, 9),
       (4, 10),
       (1, 11),
       (11,12),
       (11,13),
       (11,14),
       (11,15),
       (11,16),
       (11,17),
       (11,18),
       (11,19),
       (11,20),
       (1, 21),
       (21,22),
       (21,23),
       (21,24),
       (21,25),
       (25,26),
       (25,27),
       (25,28),
       (21,29),
       (21,30),
       (31,31);

