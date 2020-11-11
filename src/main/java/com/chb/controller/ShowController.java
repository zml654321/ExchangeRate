package com.chb.controller;

import com.chb.pojo.ExchangeRate;
import com.chb.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowController {
    //controller 调 service 层
    @Autowired
    @Qualifier("ExchangeRateServiceImpl")
    private ExchangeRateService exchangeRateService;
    //根据提交请求返回不同的显示信息
    @RequestMapping("/show")
    public String USD(Model model,String currency,String type){
        List<ExchangeRate> list=exchangeRateService.queryByCurrency(type,currency);
        model.addAttribute("currency",currency);
        model.addAttribute("list",list);
        return "show";
    }
}
