package com.askend.filters.domain.filter.create;

import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateFilterUseCase {
    private final FilterRepository filterRepository;
    private final CreateFilterUseCaseSteps steps;

    @Transactional
    public Filter createFilter(Filter filter) {
        steps.validate(filter);
        var savedFilter = filterRepository.save(filter);
        var criteriaList = filter.getCriteria();
        steps.saveFilterCriteria(savedFilter, criteriaList);
        return savedFilter;
    }
}
