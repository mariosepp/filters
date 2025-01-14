package com.askend.filters.application.filter.mapper;

import com.askend.filters.application.filter.dto.CriteriaDto;
import com.askend.filters.domain.criteria.Criteria;
import com.askend.filters.domain.criteria.CriteriaComparator;
import com.askend.filters.domain.criteria.CriteriaType;
import com.askend.filters.domain.filter.Filter;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CriteriaDtoMapperTest {

    private final CriteriaDtoMapper mapper = Mappers.getMapper(CriteriaDtoMapper.class);

    @Test
    void shouldMapToDto() {
        var criteria = getCriteria();
        var result = mapper.toDto(criteria);
        assertThat(result.getId(), is(1));
        assertThat(result.getCriterion(), is("AMOUNT"));
        assertThat(result.getComparator(), is("MORE"));
        assertThat(result.getCondition(), is("5"));
    }

    @Test
    void shouldMapToDomain() {
        var criteriaDto = getCriteriaDto();
        var result = mapper.toDomain(criteriaDto);
        assertThat(result.getId(), is(1));
        assertThat(result.getCriterion(), is(CriteriaType.DATE));
        assertThat(result.getComparator(), is(CriteriaComparator.FROM));
        assertThat(result.getCondition(), is("2022-01-01"));
    }

    private Criteria getCriteria() {
        var criteria = new Criteria();
        criteria.setId(1);
        criteria.setFilter(new Filter());
        criteria.getFilter().setId(2);
        criteria.setCriterion(CriteriaType.AMOUNT);
        criteria.setComparator(CriteriaComparator.MORE);
        criteria.setCondition("5");
        return criteria;
    }

    private CriteriaDto getCriteriaDto() {
        var criteriaDto = new CriteriaDto();
        criteriaDto.setId(1);
        criteriaDto.setCriterion("DATE");
        criteriaDto.setComparator("FROM");
        criteriaDto.setCondition("2022-01-01");
        return criteriaDto;
    }
}
