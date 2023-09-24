package com.alechoskins.RecipeSharingApi.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractService<T> {
    private final JpaRepository<T, Long> repository;
    private final Specification<T> specification;

    public List<T> executeQuery(T entity) {

        Example<T> example = Example.of(entity);
        List<T> result = repository.findAll(example); // Adjust the field name as needed

        return result;
    }
}

