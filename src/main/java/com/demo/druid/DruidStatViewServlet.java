package com.demo.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.demo.util.CommonUtil;

import javax.servlet.ServletException;

/**
 * @Author 
 * @date 2016/10/18 11:11
 */
public class DruidStatViewServlet extends StatViewServlet {

    public  DruidStatViewServlet() throws ServletException {
        this.username = CommonUtil.getDruidMsg("username");
        this.password = CommonUtil.getDruidMsg("password");

    }
    public void init() throws ServletException {
        super.init();
    }

}
