package com.askend.filters.domain.criteria;

import java.util.Arrays;

public enum CriteriaComparator {
    MORE,
    LESS,
    EQUALS,
    STARTS,
    CONTAINS,
    UNTIL,
    FROM,
    UNKNOWN;

    public static CriteriaComparator fromValue(String value) {
        return Arrays.stream(CriteriaComparator.values())
                .filter(type -> type.toString().equals(value))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
