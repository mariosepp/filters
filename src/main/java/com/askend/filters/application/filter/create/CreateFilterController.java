package com.askend.filters.application.filter.create;

import com.askend.filters.application.filter.dto.FilterDto;
import com.askend.filters.application.filter.mapper.FilterDtoMapper;
import com.askend.filters.domain.filter.create.CreateFilterUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateFilterController {

    private final CreateFilterUseCase createFilterUseCase;
    private final FilterDtoMapper filterDtoMapper;

    @PostMapping("/filter")
    public FilterDto createFilter(@Valid @RequestBody FilterDto filterDto) {
        var filter = filterDtoMapper.toDomain(filterDto);
        var savedFilter = createFilterUseCase.createFilter(filter);
        return filterDtoMapper.toDto(savedFilter);
    }
}
