package com.jorgen.helmes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "classifier", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Classifier implements Serializable {
    @Id
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    private Long parentId;

    @Column(name = "sub_type")
    @ElementCollection
    @CollectionTable(name = "sub_types", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Long> subTypes;

    @Column
    @NotNull
    private boolean selectable;
}
