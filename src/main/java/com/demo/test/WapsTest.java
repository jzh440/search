package com.demo.test;

import java.util.*;

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

    @Test
    public void testAdd(){
        WapsMapper wapsMapper =  acx.getBean(WapsMapper.class);
        Waps waps = new Waps();
        waps.setWapId(1);
        waps.setWapKeyWord("haha");
        waps.setIsPop(true);
        waps.setUserId(123);
        waps.setWapDesc("haha");
        waps.setWapMoney(100);
        waps.setWapTitle("haha");
        waps.setWapUrl("https://zhidao.baidu.com");
        wapsMapper.insert(waps);
    }

    @Test
    public void testEdit(){
        WapsMapper wapsMapper =  acx.getBean(WapsMapper.class);
        Waps waps = new Waps();
        waps.setWapId(1);
        waps.setWapKeyWord("haha");
        waps.setIsPop(true);
        waps.setUserId(123);
        waps.setWapDesc("haha");
        waps.setWapMoney(100);
        waps.setWapTitle("haha");
        waps.setWapUrl("https://zhidao.baidu.com11");
        wapsMapper.edit(waps);
    }

    @Test
    public void testDel(){
        WapsMapper wapsMapper =  acx.getBean(WapsMapper.class);
        Waps waps = new Waps();
        int[] ids = {1,2};
        wapsMapper.delete(ids);
    }
}
