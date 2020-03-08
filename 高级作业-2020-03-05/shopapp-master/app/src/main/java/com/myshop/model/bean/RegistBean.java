package com.myshop.model.bean;

public class RegistBean {

    /**
     * errno : 1000
     * errmsg : 用户名已注册
     */

    private int errno;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
