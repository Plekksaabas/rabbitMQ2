package com.jorgen.helmes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SubTypes {

    @ManyToOne
    @JoinColumn(name = "id")
    private Classifier classifier;

    @Column(name = "sub_type")
    private Long subType;
}
