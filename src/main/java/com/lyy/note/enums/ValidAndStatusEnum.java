package com.lyy.note.enums;

/***
 * 状态与是否有效
 */
public enum ValidAndStatusEnum {

    /**是否有效:无效0*/
    NOT_VALID(0, "无效"),
    /**有效1*/
    IS_VALID(1, "有效"),

    /**状态，0-未处理*/
    NO_HANDLE(0, "未处理"),
    /**状态 1-处理中*/
    IS_HANDLEING(1, "处理中"),
    /**状态，2-处理完成，*/
    HAS_HANDLEED(2, "处理完成"),
    /**状态，3-异常*/
    ABNORMAL(3, "异常"),
    /**状态，4-已删除*/
    IS_DELETE(4, "已删除");

    private Integer code;

    private String desc;


    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }


    private ValidAndStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }



}



