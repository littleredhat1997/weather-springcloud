package com.example.demo.enums;

public enum PositionEnum implements CodeEnum {

    QQ(0, "QQ"),
    WECHAT(1, "微信"),
    MEDIA(2, "腾讯新闻、腾讯视频"),
    OTHER(3, "其它"),
    ;

    private Integer code;
    private String msg;

    PositionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
