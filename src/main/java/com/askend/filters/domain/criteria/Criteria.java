package com.askend.filters.domain.criteria;

import com.askend.filters.domain.filter.Filter;
import lombok.Data;

@Data
public class Criteria {
    private Integer id;
    private Filter filter;
    private CriteriaType criterion;
    private CriteriaComparator comparator;
    private String condition;
}
