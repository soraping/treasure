package com.fangzheng.wxabiz.controller;

import com.fangzheng.common.pojo.CommonResult;
import com.fangzheng.common.util.RedisUtils;
import com.fangzheng.wxaapi.pojo.WxaCustomerAuthInfo;
import com.fangzheng.wxaapi.provider.WxaCustomerAuthProvider;
import com.fangzheng.wxaapi.request.WxaAuthRequest;
import com.fangzheng.wxabiz.service.IWxaAuthService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wxa")
public class WxaAuthController implements WxaCustomerAuthProvider {

    @Resource
    private IWxaAuthService wxaAuthService;

    @Override
    public CommonResult<WxaCustomerAuthInfo> wxaCustomerAuth(WxaAuthRequest wxaAuthRequest, String from) {
        WxaCustomerAuthInfo wxaCustomerAuthInfo = wxaAuthService.getWxaInfo(wxaAuthRequest);
        return CommonResult.success(wxaCustomerAuthInfo);
    }
}
