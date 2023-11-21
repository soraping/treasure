package com.fangzheng.wxaapi.request;

import lombok.Data;

@Data
public class WxaAuthRequest extends BaseRequest{
    private String code;
}
