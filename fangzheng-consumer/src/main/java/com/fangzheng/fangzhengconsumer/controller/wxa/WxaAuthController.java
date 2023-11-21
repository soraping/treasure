package com.fangzheng.fangzhengconsumer.controller.wxa;

import com.fangzheng.common.enums.SecurityConstants;
import com.fangzheng.common.pojo.CommonResult;
import com.fangzheng.wxaapi.pojo.WxaCustomerAuthInfo;
import com.fangzheng.wxaapi.provider.WxaCustomerAuthProvider;
import com.fangzheng.wxaapi.request.WxaAuthRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class WxaAuthController {

    @Resource
    private WxaCustomerAuthProvider wxaCustomerAuthProvider;

    @GetMapping("/info/{code}")
    public CommonResult<WxaCustomerAuthInfo> getUserInfo(@PathVariable("code") String code){
        WxaAuthRequest wxaAuthRequest = new WxaAuthRequest();
        wxaAuthRequest.setCode(code);
        return CommonResult.success(wxaCustomerAuthProvider.wxaCustomerAuth(wxaAuthRequest, SecurityConstants.FROM_IN));
    }


}
