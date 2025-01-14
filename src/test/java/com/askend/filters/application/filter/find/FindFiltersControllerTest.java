package com.askend.filters.application.filter.find;

import com.askend.filters.application.filter.dto.FilterDto;
import com.askend.filters.application.filter.mapper.FilterDtoMapper;
import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.find.FindFiltersUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindFiltersControllerTest {

    @InjectMocks
    private FindFiltersController controller;

    @Mock
    private FindFiltersUseCase findFiltersUseCase;

    @Mock
    private FilterDtoMapper filterDtoMapper;

    @Test
    void shouldGetFilters() {
        List<Filter> filters = Arrays.asList(new Filter());
        var filterDto = new FilterDto();
        when(findFiltersUseCase.findFilters()).thenReturn(filters);
        when(filterDtoMapper.toDto(filters.getFirst())).thenReturn(filterDto);

        var result = controller.getFilters();
        assertThat(result, notNullValue());
        assertThat(result.size(), is(1));
        assertThat(result.getFirst(), is(filterDto));
    }
}