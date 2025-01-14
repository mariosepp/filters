package com.askend.filters.infrastructure.persistence.criteria;

import com.askend.filters.domain.criteria.Criteria;
import com.askend.filters.domain.criteria.CriteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CriteriaRepositoryImpl implements CriteriaRepository {

    private final CriteriaJpaRepository criteriaJpaRepository;
    private final CriteriaJpaEntityMapper criteriaJpaEntityMapper;

    @Override
    public List<Criteria> save(List<Criteria> criteria) {
        var criteriaJpaEntityList = criteria.stream()
                .map(criteriaJpaEntityMapper::toJpaEntity)
                .toList();
        var savedCriteriaJpaEntityList = criteriaJpaRepository.saveAll(criteriaJpaEntityList);
        return savedCriteriaJpaEntityList.stream()
                .map(criteriaJpaEntityMapper::toDomain)
                .toList();
    }
}
