package com.askend.filters.infrastructure.persistence.filter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterJpaRepository extends JpaRepository<FilterJpaEntity, Integer> {
}
