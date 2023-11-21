package com.fangzheng.wxabiz.controller;

import com.fangzheng.common.pojo.CommonResult;
import com.fangzheng.common.util.RedisUtils;
import com.fangzheng.wxaapi.pojo.WxaCustomerAuthInfo;
import com.fangzheng.wxaapi.provider.WxaCustomerAuthProvider;
import com.fangzheng.wxaapi.request.WxaAuthRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxa")
public class WxaAuthController implements WxaCustomerAuthProvider {

    @Override
    public WxaCustomerAuthInfo wxaCustomerAuth(WxaAuthRequest wxaAuthRequest, String from) {
        WxaCustomerAuthInfo wxaCustomerAuthInfo = new WxaCustomerAuthInfo();
        wxaCustomerAuthInfo.setOpenId("123321");
        RedisUtils.set("name", "hellohello");
        wxaCustomerAuthInfo.setNickname(RedisUtils.get("name").toString());
        return wxaCustomerAuthInfo;
    }
}
