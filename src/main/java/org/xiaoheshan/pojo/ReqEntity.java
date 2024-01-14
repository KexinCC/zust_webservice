package org.xiaoheshan.pojo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReqEntity {
    private String code;
    private String msg;

    public ReqEntity() {
    }

    public ReqEntity(String code, String mes) {
        this.code = code;
        this.msg = mes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
