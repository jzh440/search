package com.demo.service;

import com.demo.dao.WapsMapper;
import com.demo.model.Waps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jzh on 2017/2/23.
 */
@Service
@Transactional
public class WapsServiceImpl implements WapsService {

    @Autowired
    private WapsMapper mapper ;

    @Override
    public List<Waps> query(String keyswords, int current, int limit) {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("keyswords",keyswords);
        objectMap.put("begin",current*limit);
        objectMap.put("end",(current+1)*limit);
        return mapper.query(objectMap);
    }
}
