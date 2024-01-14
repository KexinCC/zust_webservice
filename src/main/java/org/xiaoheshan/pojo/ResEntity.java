package org.xiaoheshan.pojo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResEntity {
    private int code;
    private String msg;

    public ResEntity() {
    }

    public ResEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
