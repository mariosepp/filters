package com.askend.filters.application.filter.find;

import com.askend.filters.application.filter.dto.FilterDto;
import com.askend.filters.application.filter.mapper.FilterDtoMapper;
import com.askend.filters.domain.filter.find.FindFiltersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindFiltersController {

    private final FindFiltersUseCase findFiltersUseCase;
    private final FilterDtoMapper filterDtoMapper;

    @GetMapping("/filters")
    public List<FilterDto> getFilters() {
        return findFiltersUseCase.findFilters().stream()
                .map(filterDtoMapper::toDto)
                .toList();
    }
}
