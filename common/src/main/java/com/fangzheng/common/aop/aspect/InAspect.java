package com.fangzheng.common.aop.aspect;

import com.fangzheng.common.aop.In;
import com.fangzheng.common.enums.SecurityConstants;
import com.fangzheng.common.exception.ServiceException;
import com.fangzheng.common.exception.enums.GlobalErrorCodeConstants;
import com.fangzheng.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * springcloud 微服务之间内部调用鉴权
 * 可以将参数对撑加密，将密文放在header里
 * 在环绕内再次加密，比对密文
 * 用这个方式鉴权更加安全
 */
@Aspect
@Component
@AllArgsConstructor
public class InAspect {

    private final HttpServletRequest request;

    @SneakyThrows
    @Around("@annotation(inside)")
    public Object around(ProceedingJoinPoint joinPoint, In inside){
        String fromKey = request.getHeader(SecurityConstants.FROM_KEY);
        if(inside.value() && !StringUtils.equals(fromKey, SecurityConstants.FROM_IN)){
            // 注解方法没有该字段，则表示非法访问，直接跑出异常
            throw new ServiceException(GlobalErrorCodeConstants.FORBIDDEN);
        }
        return joinPoint.proceed();
    }

}
