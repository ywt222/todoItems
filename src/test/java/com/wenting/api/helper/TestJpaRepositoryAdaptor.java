package com.wenting.api.helper;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public class TestJpaRepositoryAdaptor<T, ID extends Serializable> implements JpaRepository<T, ID> {
    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findAll(final Sort sort) {
        return null;
    }

    @Override
    public Page<T> findAll(final Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(final Iterable<ID> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(final ID id) {

    }

    @Override
    public void delete(final T entity) {

    }

    @Override
    public void delete(final Iterable<? extends T> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends T> S save(final S entity) {
        return null;
    }

    @Override
    public <S extends T> List<S> save(final Iterable<S> entities) {
        return null;
    }

    @Override
    public T findOne(final ID id) {
        return null;
    }

    @Override
    public boolean exists(final ID id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends T> S saveAndFlush(final S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(final Iterable<T> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public T getOne(final ID id) {
        return null;
    }

    @Override
    public <S extends T> S findOne(final Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(final Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(final Example<S> example, final Sort sort) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(final Example<S> example, final Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(final Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(final Example<S> example) {
        return false;
    }
}
