package com.lcw.base.service;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.base.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class CrudService<D extends BaseRepositoryImpl, T, ID extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected D dao;

    public D getDao() {
        return dao;
    }

    @Transactional
    public T save(T entity) {
        entity = (T) dao.save(entity);
        return entity;
    }

    @Transactional
    public List<T> save(List<T> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        dao.saveAll(entityList);
        return entityList;
    }

    @Transactional
    public T update(T entity) {
        entity = (T) dao.save(entity);
        return entity;
    }

    @Transactional
    public List<T> update(List<T> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        dao.saveAll(entityList);
        return entityList;
    }

    @Transactional
    public void delete(ID id) {
        dao.deleteById(id);
    }

    @Transactional
    public void delete(ID... ids) {
        dao.deleteInBatch(Arrays.asList(ids));
    }

    public T get(ID id) {
        T t = null;
        Optional<T> optional = dao.findById(id);
        if (optional.isPresent()) {
            t = optional.get();
        }
        return t;
    }

    public T findById(ID id) {
        return (T) dao.findById(id).get();
    }

    public T getOne(ID id) {
        T t = (T) dao.getOne(id);
        return t;
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public long count () {
        return dao.count();
    }

    public void flush() {
        dao.flush();
    }

}