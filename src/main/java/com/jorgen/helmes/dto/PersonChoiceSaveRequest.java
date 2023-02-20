package com.jorgen.helmes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonChoiceSaveRequest {

    private long personId;

    private long classifierId;
}
