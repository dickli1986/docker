package com.dickli.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dickli.service.WelcomeService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class WelcomeServiceImpl implements WelcomeService {
    @NacosValue(value = "${welcome:welcome}", autoRefreshed = true)
    private String welcome;

    @Override
    public String welcome(String userName) {
        return welcome + " " + userName;
    }
}
