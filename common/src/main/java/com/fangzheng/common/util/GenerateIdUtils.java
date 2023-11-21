package com.fangzheng.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * id 生成器
 */
public class GenerateIdUtils {

    private static final String ORDER_ID_CACHE_KEY = "order_id_key_";

    private static final String ORDER_ID_PREFIX = "T";

    private static final Integer MAX_ZERO_SIZE = 6;

    /**
     * 创建订单编号
     * @return
     */
    public static String genOrderId(){
        return ORDER_ID_PREFIX + incrementNum(ORDER_ID_CACHE_KEY, 7, 1);
    }

    /**
     * 补0数ID
     * @return
     */
    private static String incrementNum(String key, Integer size, Integer step){
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long no = RedisUtils.incr(key, step);
        return date + String.format("%0" + size, no);
    }

}
