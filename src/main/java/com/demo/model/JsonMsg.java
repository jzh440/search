package com.demo.model;


public class JsonMsg {

	/** 返回信息**/
	private String msg;
	
	/** 返回状态**/
	private boolean status;

	private String boxMac;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBoxMac() {
        return boxMac;
    }

    public void setBoxMac(String boxMac) {
        this.boxMac = boxMac;
    }
}
