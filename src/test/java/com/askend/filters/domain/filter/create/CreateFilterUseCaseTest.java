package com.askend.filters.domain.filter.create;

import com.askend.filters.domain.criteria.Criteria;
import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.FilterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateFilterUseCaseTest {

    @InjectMocks
    private CreateFilterUseCase createFilterUseCase;

    @Mock
    private FilterRepository filterRepository;

    @Mock
    private CreateFilterUseCaseSteps steps;

    @Test
    void shouldCreateFilter() {
        var filter = createFilter();
        var savedFilter = new Filter();
        when(filterRepository.save(filter)).thenReturn(savedFilter);

        var result = createFilterUseCase.createFilter(filter);
        assertThat(result, is(savedFilter));
        verify(steps).saveFilterCriteria(savedFilter, filter.getCriteria());
    }

    private Filter createFilter() {
        var filter = new Filter();
        filter.setCriteria(Arrays.asList(new Criteria()));
        return filter;
    }
}