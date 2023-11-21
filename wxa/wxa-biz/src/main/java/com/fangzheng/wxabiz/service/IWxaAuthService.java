package com.fangzheng.wxabiz.service;

import com.fangzheng.wxaapi.pojo.WxaCustomerAuthInfo;
import com.fangzheng.wxaapi.request.WxaAuthRequest;
import me.chanjar.weixin.common.error.WxErrorException;

public interface IWxaAuthService {
    WxaCustomerAuthInfo getWxaInfo(WxaAuthRequest wxaAuthRequest);
}
