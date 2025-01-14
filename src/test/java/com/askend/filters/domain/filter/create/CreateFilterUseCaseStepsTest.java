package com.askend.filters.domain.filter.create;

import com.askend.filters.domain.criteria.Criteria;
import com.askend.filters.domain.criteria.CriteriaComparator;
import com.askend.filters.domain.criteria.CriteriaRepository;
import com.askend.filters.domain.criteria.CriteriaType;
import com.askend.filters.domain.exception.ValidationException;
import com.askend.filters.domain.filter.Filter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateFilterUseCaseStepsTest {

    @InjectMocks
    private CreateFilterUseCaseSteps steps;

    @Mock
    private CriteriaRepository criteriaRepository;

    @Test
    void shouldValidate() {
        var filter = createFilter(CriteriaType.AMOUNT, CriteriaComparator.LESS);
        assertDoesNotThrow(() -> steps.validate(filter));
    }

    @Test
    void shouldNotValidateComparatorAndTypeMismatch() {
        var filter = createFilter(CriteriaType.AMOUNT, CriteriaComparator.CONTAINS);
        var result = assertThrows(ValidationException.class, () -> steps.validate(filter));
        assertThat(result.getMessage(), is("Criteria comparator and type mismatch."));
    }

    @Test
    void shouldNotValidateUnknownType() {
        var filter = createFilter(CriteriaType.UNKNOWN, CriteriaComparator.CONTAINS);
        var result = assertThrows(ValidationException.class, () -> steps.validate(filter));
        assertThat(result.getMessage(), is("Criteria type is unknown."));
    }

    @Test
    void shouldNotValidateNoType() {
        var filter = createFilter(null, CriteriaComparator.CONTAINS);
        var result = assertThrows(ValidationException.class, () -> steps.validate(filter));
        assertThat(result.getMessage(), is("Criteria type is unknown."));
    }

    @Test
    void shouldSaveFilterCriteria() {
        var filter = new Filter();
        var criteria = new Criteria();
        var criteriaList = Arrays.asList(criteria);
        var savedCriteria = new Criteria();
        var savedCriteriaList = Arrays.asList(savedCriteria);
        when(criteriaRepository.save(criteriaList)).thenReturn(savedCriteriaList);

        steps.saveFilterCriteria(filter, criteriaList);
        assertThat(criteriaList.getFirst().getFilter(), is(filter));
        assertThat(filter.getCriteria(), is(savedCriteriaList));
    }

    private Filter createFilter(CriteriaType criteriaType, CriteriaComparator criteriaComparator) {
        var criteria = createCriteria(criteriaType, criteriaComparator);
        var filter = new Filter();
        filter.setCriteria(Arrays.asList(criteria));
        return filter;
    }

    private Criteria createCriteria(CriteriaType criteriaType, CriteriaComparator criteriaComparator) {
        var criteria = new Criteria();
        criteria.setCriterion(criteriaType);
        criteria.setComparator(criteriaComparator);
        return criteria;
    }
}