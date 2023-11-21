package com.fangzheng.common.aop;

import java.lang.annotation.*;

/**
 * 内部服务调用鉴权处理
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface In {

    /**
     * 是否AOP统一处理
     * @return
     */
    boolean value() default true;
}
