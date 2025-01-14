package com.askend.filters.application.filter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class FilterDto {

    private Integer id;
    @NotEmpty
    private List<CriteriaDto> criteria;
    @NotBlank
    private String name;
}
