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
	public boolean insert(Waps waps) {
		// TODO Auto-generated method stub
		return mapper.insert(waps)>0;
	}

	@Override
    public List<Waps> query(String keyswords, int current, int limit) {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("keyswords",keyswords);
        objectMap.put("begin",current*limit);
        objectMap.put("end",(current+1)*limit);
        return mapper.query(objectMap);
    }

    @Override
    public int count(String keyswords) {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("keyswords",keyswords);
        return mapper.count(objectMap);
    }

    @Override
    public boolean edit(Waps waps) {
        return mapper.edit(waps) > 0;
    }

    @Override
    public boolean delete(int[] ids) {
        if(ids == null&& ids.length < 1){
            return false;
        }
        return mapper.delete(ids) > 0;
    }
}
