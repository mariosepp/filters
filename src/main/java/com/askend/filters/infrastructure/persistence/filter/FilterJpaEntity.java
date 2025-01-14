package com.askend.filters.infrastructure.persistence.filter;

import com.askend.filters.infrastructure.persistence.criteria.CriteriaJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "filter")
public class FilterJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "filter")
    private List<CriteriaJpaEntity> criteria;

    private String name;
}
