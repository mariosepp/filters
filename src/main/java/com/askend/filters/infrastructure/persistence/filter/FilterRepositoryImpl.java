package com.askend.filters.infrastructure.persistence.filter;

import com.askend.filters.domain.filter.Filter;
import com.askend.filters.domain.filter.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilterRepositoryImpl implements FilterRepository {

    private final FilterJpaRepository filterJpaRepository;
    private final FilterJpaEntityMapper filterJpaEntityMapper;

    @Override
    public List<Filter> findFilters() {
        return filterJpaRepository.findAll().stream()
                .map(filterJpaEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Filter save(Filter filter) {
        var filterJpaEntity = filterJpaEntityMapper.toJpaEntity(filter);
        var savedFilterJpaEntity = filterJpaRepository.save(filterJpaEntity);
        return filterJpaEntityMapper.toDomain(savedFilterJpaEntity);
    }
}
