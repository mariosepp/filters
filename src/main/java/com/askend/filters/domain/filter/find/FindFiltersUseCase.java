package com.askend.filters.domain.filter.find;

import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindFiltersUseCase {
    private final FilterRepository filterRepository;

    public List<Filter> findFilters() {
        return filterRepository.findFilters();
    }
}
