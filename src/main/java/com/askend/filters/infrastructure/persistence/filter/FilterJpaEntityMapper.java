package com.askend.filters.infrastructure.persistence.filter;

import com.askend.filters.domain.filter.Filter;
import com.askend.filters.infrastructure.persistence.criteria.CriteriaJpaEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = CriteriaJpaEntityMapper.class, componentModel = "spring")
public interface FilterJpaEntityMapper {

    FilterJpaEntity toJpaEntity(Filter filter);
    Filter toDomain(FilterJpaEntity filterJpaEntity);

}
