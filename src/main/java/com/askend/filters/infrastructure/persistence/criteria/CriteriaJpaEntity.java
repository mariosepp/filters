package com.askend.filters.infrastructure.persistence.criteria;

import com.askend.filters.infrastructure.persistence.filter.FilterJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "criteria")
public class CriteriaJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private FilterJpaEntity filter;

    private String criterion;
    private String comparator;
    private String condition;
}
