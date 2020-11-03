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
    @RequestMapping("/show")
    public String Show(){
        return "show";
    }
    @RequestMapping("/showDetail")
    public String ShowDetail(Model model){
        List<ExchangeRate> list=exchangeRateService.queryAllExchangeRate();
        model.addAttribute("list",list);
        return "show";
    }
}
