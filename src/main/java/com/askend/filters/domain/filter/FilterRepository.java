package com.askend.filters.domain.filter;

import java.util.List;

public interface FilterRepository {
    List<Filter> findFilters();
    Filter save(Filter filter);
}
