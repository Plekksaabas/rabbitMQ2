package com.jorgen.helmes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Table(name = "person")
@Entity
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Person {
    @Id
    private long id;

    @Column
    @NotNull
    private String name;
}
