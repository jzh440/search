package com.demo.Exception;

import com.demo.util.CommonUtil;


/**
 * @Author 
 * @date 2016/9/19 15:28
 */
public class ParameterException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ParameterException() {
        super();
    }
    public ParameterException(String code) {
        super(CommonUtil.getTipMsg(code));
    }
    public ParameterException(String code, String msg ) {
        super(CommonUtil.getTipMsg(code, msg));
    }
}
