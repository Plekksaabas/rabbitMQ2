package com.jorgen.helmes;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClassifierRequest implements Serializable {
    private Long id;
    private String name;
    private Long parentId;
    private List<Long> subTypes;
    private boolean selectable;
}
