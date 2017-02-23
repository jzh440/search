package com.demo.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Unitv on 2016/8/18.
 */
public class BaseService<T> implements  BaseServiceImpl<T> {

    @Override
    public int deleteByPrimaryKey(int id) {
        return 0;
    }


    @Override
    public int insert(T record) {
        return 0;
    }


    @Override
    public int insertSelective(T record) {
        return 0;
    }

    @Override
    public T selectByPrimaryKey(int id) {
        return null;
    }


    @Override
    public int updateByPrimaryKeySelective(T record) {
        return 0;
    }


    @Override
    public int updateByPrimaryKey(T record) {
        return 0;
    }
}
