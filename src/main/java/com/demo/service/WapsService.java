package com.demo.service;

import com.demo.model.Waps;

import java.util.List;

/**
 * Created by jzh on 2017/2/23.
 */
public interface WapsService {

    public List<Waps> query(String keyswords,int current,int limit);
    public boolean insert(Waps waps);
}
