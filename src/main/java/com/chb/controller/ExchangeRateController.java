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
@RequestMapping("/exchangeRate")
public class ExchangeRateController {
    //controller 调 service 层
    @Autowired
    @Qualifier("ExchangeRateServiceImpl")
    private ExchangeRateService exchangeRateService;
    //添加汇率
    @RequestMapping("/addER")
    public String addER(ExchangeRate er){
        exchangeRateService.addExchangeRate(er);
    return "redirect:/exchangeRate/queryER";
    }
    //删除汇率
    @RequestMapping("/deleteER")
    public String deleteER(int id){
        exchangeRateService.deleteExchangeRateById(id);
        return "redirect:/exchangeRate/queryER";
    }
    //更新汇率
    @RequestMapping("/updateER")
    public String updateER(ExchangeRate er){
        exchangeRateService.updateExchangeRate(er);
        return "redirect:/exchangeRate/queryER";
    }
    //利率类型为1，汇率为2 查汇率
    @RequestMapping("/queryER")
    public String queryER(Model model){
        List<ExchangeRate> list=exchangeRateService.queryByType("2");
        model.addAttribute("list",list);
        return "/ER/edit";
    }
    //到添加汇率页面  加汇率
    @RequestMapping("/toAddERPage")
    public String toAddERPage(){
        return "/ER/add";
    }
    //到汇率更新界面
    @RequestMapping("/toERUpdate")
    public String toERUpdatePage(int id,Model model){
        ExchangeRate er=exchangeRateService.queryExchangeRateById(id);
        model.addAttribute("Qer",er);
        return "/ER/update";
    }
    //查利率
    @RequestMapping("/queryIR")
    public String queryIR(Model model){
        List<ExchangeRate> list=exchangeRateService.queryByType("1");
        model.addAttribute("list",list);
        return "/IR/edit";
    }

}
