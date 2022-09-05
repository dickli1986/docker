package com.dickli.controller;

import com.dickli.service.WelcomeService;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("welcome")
public class WelcomeController {
    @DubboReference
    private WelcomeService welcomeService;

    @RequestMapping("")
    public String welcome(String userName) {
        if(StringUtils.isBlank(userName)){
            userName = "stranger";
        }
        return welcomeService.welcome(userName);
    }
}
