package com.silence.auth.infrastructure.facade.costant;

/**
 * RedisTypeEnum
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/23
 */
public enum ClientTypeEnum {

    /**
     *
     */
    ADMIN("admin", "管理后台"),
    WEB("web", "网页端");


    private String code;
    private String description;

    ClientTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }

}
