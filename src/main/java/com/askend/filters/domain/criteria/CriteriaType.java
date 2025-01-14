package com.askend.filters.domain.criteria;

import java.util.Arrays;
import java.util.List;

import static com.askend.filters.domain.criteria.CriteriaComparator.CONTAINS;
import static com.askend.filters.domain.criteria.CriteriaComparator.EQUALS;
import static com.askend.filters.domain.criteria.CriteriaComparator.FROM;
import static com.askend.filters.domain.criteria.CriteriaComparator.LESS;
import static com.askend.filters.domain.criteria.CriteriaComparator.MORE;
import static com.askend.filters.domain.criteria.CriteriaComparator.STARTS;
import static com.askend.filters.domain.criteria.CriteriaComparator.UNTIL;

public enum CriteriaType {
    AMOUNT(Arrays.asList(EQUALS, LESS, MORE)),
    TITLE(Arrays.asList(EQUALS, CONTAINS, STARTS)),
    DATE(Arrays.asList(EQUALS, UNTIL, FROM)),
    UNKNOWN(null);

    private List<CriteriaComparator> comparators;

    CriteriaType(List<CriteriaComparator> comparators) {
        this.comparators = comparators;
    }

    public static CriteriaType fromValue(String value) {
        return Arrays.stream(CriteriaType.values())
                .filter(type -> type.toString().equals(value))
                .findFirst()
                .orElse(UNKNOWN);
    }

    public boolean isValidComparator(CriteriaComparator comparator) {
        return comparators.contains(comparator);
    }
}
