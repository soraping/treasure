package com.fangzheng.gateway.filter.security;

import lombok.Data;

import java.util.List;

/**
 * 登录用户信息
 *
 */
@Data
public class LoginUser {

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户类型
     */
    private String userType;
}
