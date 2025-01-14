package com.askend.filters.application.filter.create;

import com.askend.filters.application.filter.dto.FilterDto;
import com.askend.filters.application.filter.mapper.FilterDtoMapper;
import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.create.CreateFilterUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateFilterControllerTest {

    @InjectMocks
    private CreateFilterController createFilterController;

    @Mock
    private CreateFilterUseCase createFilterUseCase;

    @Mock
    private FilterDtoMapper filterDtoMapper;

    @Test
    void shouldCreateFilter() {
        var filterDto = new FilterDto();
        var filter = new Filter();
        var savedFilter = new Filter();
        var savedFilterDto = new FilterDto();
        when(filterDtoMapper.toDomain(filterDto)).thenReturn(filter);
        when(createFilterUseCase.createFilter(filter)).thenReturn(savedFilter);
        when(filterDtoMapper.toDto(filter)).thenReturn(savedFilterDto);

        var result = createFilterController.createFilter(filterDto);
        assertThat(result, is(savedFilterDto));
    }
}