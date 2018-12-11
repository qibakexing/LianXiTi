package com.lianxi.vo;

public class ResultVo {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultVo(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultVo() {
        super();
    }
    public static ResultVo setOK(String msg){
        return new ResultVo(1000,msg);
    }
    public static ResultVo setERROR(String msg){
        return new ResultVo(2000,msg);
    }
}
