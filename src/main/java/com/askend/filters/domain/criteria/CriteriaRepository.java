package com.askend.filters.domain.criteria;

import java.util.List;

public interface CriteriaRepository {
    List<Criteria> save(List<Criteria> criteria);
}
