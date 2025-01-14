package com.askend.filters.application.filter.mapper;

import com.askend.filters.application.filter.dto.FilterDto;
import com.askend.filters.domain.filter.Filter;
import org.mapstruct.Mapper;

@Mapper(uses = CriteriaDtoMapper.class, componentModel = "spring")
public interface FilterDtoMapper {
    FilterDto toDto(Filter filter);
    Filter toDomain(FilterDto filterDto);
}
