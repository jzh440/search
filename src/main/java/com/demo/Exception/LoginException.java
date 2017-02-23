package com.demo.Exception;


import com.demo.util.CommonUtil;

/**
 * @Author 
 * @date 2016/9/19 15:28
 */
public class LoginException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginException() {
        super();
    }
    public LoginException(String code) {
        super(CommonUtil.getErrorMsg(code));
    }
    public LoginException(String code, String msg ) {
        super(CommonUtil.getErrorMsg(code, msg));
    }
}
