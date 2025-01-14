package com.askend.filters.domain.filter.create;

import com.askend.filters.domain.criteria.Criteria;
import com.askend.filters.domain.criteria.CriteriaRepository;
import com.askend.filters.domain.criteria.CriteriaType;
import com.askend.filters.domain.exception.ValidationException;
import com.askend.filters.domain.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateFilterUseCaseSteps {

    private final CriteriaRepository criteriaRepository;

    public void validate(Filter filter) {
        filter.getCriteria().forEach(this::validateCriteriaComparators);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveFilterCriteria(Filter savedFilter, List<Criteria> criteriaList) {
        criteriaList.forEach(criteria ->
                criteria.setFilter(savedFilter));
        var savedCriteriaList = criteriaRepository.save(criteriaList);
        savedFilter.setCriteria(savedCriteriaList);
    }

    private void validateCriteriaComparators(Criteria criteria) {
        var criteriaType = criteria.getCriterion();
        if (criteriaType == null || criteriaType == CriteriaType.UNKNOWN) {
            throw new ValidationException("Criteria type is unknown.");
        }
        if (!criteriaType.isValidComparator(criteria.getComparator())) {
            throw new ValidationException("Criteria comparator and type mismatch.");
        }
    }
}
