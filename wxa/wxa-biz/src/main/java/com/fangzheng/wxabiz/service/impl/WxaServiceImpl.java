package com.fangzheng.wxabiz.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.fangzheng.common.util.RedisUtils;
import com.fangzheng.wxaapi.pojo.WxaCustomerAuthInfo;
import com.fangzheng.wxaapi.request.WxaAuthRequest;
import com.fangzheng.wxabiz.service.IWxaAuthService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class WxaServiceImpl implements IWxaAuthService {

    private static final String SESSION_KEY = "session:key:%s";

    @Resource
    private WxMaService wxMaService;

    @Override
    public WxaCustomerAuthInfo getWxaInfo(WxaAuthRequest wxaAuthRequest){
        try{
            WxMaJscode2SessionResult wxMaJscode2SessionResult = wxMaService.jsCode2SessionInfo(wxaAuthRequest.getCode());
            WxaCustomerAuthInfo wxaCustomerAuthInfo = new WxaCustomerAuthInfo();
            wxaCustomerAuthInfo.setOpenId(wxMaJscode2SessionResult.getOpenid());
            wxaCustomerAuthInfo.setUnionId(wxaCustomerAuthInfo.getUnionId());
            RedisUtils.set(String.format(SESSION_KEY, wxaAuthRequest.getAppId()),
                    wxMaJscode2SessionResult.getSessionKey(), 11 * 60 * 60);
            return wxaCustomerAuthInfo;
        }catch (WxErrorException e){
            log.error("微信客户授权失败 => " + e.getMessage());
        }
        return null;
    }
}
