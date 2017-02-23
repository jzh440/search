package com.demo.test;

import java.util.List;

import javax.annotation.Resource;

import com.demo.dao.WapsMapper;
import com.demo.model.Waps;
import org.junit.Test;




public class WapsTest extends SpringJunitTest {


    @Test
    public void testQuery(){
        WapsMapper wapsMapper =  acx.getBean(WapsMapper.class);
        Waps waps = new Waps();
        waps.setWapKeyWord("haha");
        wapsMapper.query(waps);
    }
}
