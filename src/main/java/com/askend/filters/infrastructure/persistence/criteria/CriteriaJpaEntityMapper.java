package com.askend.filters.infrastructure.persistence.criteria;

import com.askend.filters.domain.criteria.Criteria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CriteriaJpaEntityMapper {

    CriteriaJpaEntity toJpaEntity(Criteria criteria);

    @Mapping(target = "filter", ignore = true)
    Criteria toDomain(CriteriaJpaEntity criteriaJpaEntity);

}
