package com.fangzheng.wxaapi.provider;

import com.fangzheng.common.aop.In;
import com.fangzheng.common.enums.SecurityConstants;
import com.fangzheng.wxaapi.pojo.WxaCustomerAuthInfo;
import com.fangzheng.wxaapi.request.WxaAuthRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 微信用户授权
 */
@FeignClient(value = "wxa-provider", path = "/wxa", contextId = "wxa-customer-auth")
public interface WxaCustomerAuthProvider {

    @In
    @PostMapping("/customer/auth/info")
    WxaCustomerAuthInfo wxaCustomerAuth(@RequestBody WxaAuthRequest wxaAuthRequest, @RequestHeader(SecurityConstants.FROM_KEY) String from);
}
