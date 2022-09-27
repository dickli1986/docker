package com.dickli.welcome.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dickli.welcome.service.WelcomeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
@Slf4j
public class WelcomeServiceImpl implements WelcomeService {
    @NacosValue(value = "${welcome:welcome}", autoRefreshed = true)
    private String welcome;

    @Override
    public String welcome(String userName) {
        log.info("welcome:{},userName:{}",welcome,userName);
        return welcome + " " + userName;
    }
}
