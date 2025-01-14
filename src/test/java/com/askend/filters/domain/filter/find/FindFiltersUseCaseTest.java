package com.askend.filters.domain.filter.find;

import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.FilterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindFiltersUseCaseTest {

    @InjectMocks
    private FindFiltersUseCase findFiltersUseCase;

    @Mock
    private FilterRepository repository;

    @Test
    void shouldFindFilters() {
        var filter = new Filter();
        var filterList = List.of(filter);
        when(repository.findFilters()).thenReturn(filterList);

        var result = findFiltersUseCase.findFilters();
        assertThat(result, is(filterList));
    }

}