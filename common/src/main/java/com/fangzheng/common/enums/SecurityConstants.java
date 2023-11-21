package com.fangzheng.common.enums;

public class SecurityConstants {

    /**
     * header 字段名
     * 用来验证是否微服务之间本地调用字段
     * {@link FromEnum}
     */
    public static final String FROM_KEY = "FROM";

    // 内部调用
    public static final String FROM_IN = FromEnum.IN.name();

    // 外部调用
    public static final String FROM_OUT = FromEnum.OUT.name();

}
