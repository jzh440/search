package com.demo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.demo.dao.WapsMapper;
import com.demo.model.Waps;
import org.junit.Test;




public class WapsTest extends SpringJunitTest {


    @Test
    public void testQuery(){
        WapsMapper wapsMapper =  acx.getBean(WapsMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("keywords","haha");
        map.put("begin",0);
        map.put("end",10);
        wapsMapper.query(map);
    }
}
