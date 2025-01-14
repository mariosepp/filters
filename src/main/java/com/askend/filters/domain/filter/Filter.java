package com.askend.filters.domain.filter;

import com.askend.filters.domain.criteria.Criteria;
import lombok.Data;

import java.util.List;

@Data
public class Filter {
    private Integer id;
    private List<Criteria> criteria;
    private String name;
}
