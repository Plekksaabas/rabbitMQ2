create table classifier_choice
(
    person_id bigint not null primary key,
    classifier_id bigint not null,
    FOREIGN KEY (classifier_id) REFERENCES classifier,
    FOREIGN KEY (person_id) REFERENCES person
);


