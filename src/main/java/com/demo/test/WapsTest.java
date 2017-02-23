package com.demo.test;

import java.util.List;

import javax.annotation.Resource;

import com.demo.dao.WapsMapper;
import com.demo.model.Waps;
import org.junit.Test;


import com.demo.dao.KeysMapper;
import com.demo.model.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class WapsTest extends SpringJunitTest {


    @Test
    public void testQuery(){
        WapsMapper wapsMapper =  acx.getBean(WapsMapper.class);
        Waps waps = new Waps();
        waps.setWapKeyWord("haha");
        wapsMapper.query(waps);
        /*KeysMapper mapper = acx.getBean(KeysMapper.class);
        Keys key = new Keys();
        key.setKeyWord("haha");
        List<Keys> keys = mapper.query(key);*/
    }
}
