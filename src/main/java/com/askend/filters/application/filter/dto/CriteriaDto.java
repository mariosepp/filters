package com.askend.filters.application.filter.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CriteriaDto {

    private Integer id;
    @NotBlank
    private String criterion;
    @NotBlank
    private String comparator;
    @NotBlank
    private String condition;
}
