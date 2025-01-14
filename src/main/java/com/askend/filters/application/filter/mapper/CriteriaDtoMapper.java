package com.askend.filters.application.filter.mapper;

import com.askend.filters.application.filter.dto.CriteriaDto;
import com.askend.filters.domain.criteria.Criteria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriteriaDtoMapper {
    CriteriaDto toDto(Criteria criteria);
    Criteria toDomain(CriteriaDto criteriaDto);
}
