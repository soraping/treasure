package com.fangzheng.wxabiz.util;

import com.fangzheng.common.config.GlobalConfig;
import com.fangzheng.common.util.RedisUtils;

public class WxaHelper {
    public static final String WXA_TOKEN_CACHE_KEY = "wxa:token:%s";

    String accessToken(String appId){
        String cacheKey = String.format(WXA_TOKEN_CACHE_KEY, appId);
        if(RedisUtils.exists(cacheKey)){
            return (String) RedisUtils.get(cacheKey);
        }
        return null;
    }

    void setAccessToken(String appId, String token){
        String cacheKey = String.format(WXA_TOKEN_CACHE_KEY, appId);
        // 提前10分钟过期
        RedisUtils.set(cacheKey, token, 2 * 55 * 60);
    }
}
