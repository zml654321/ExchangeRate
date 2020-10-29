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

    //查询全部记录，返回到展示页面
    @RequestMapping("/allResults")
    public String list(Model model){
        List<ExchangeRate> list=exchangeRateService.queryAllExchangeRate();
        model.addAttribute("list",list);
        return "allResults";
    }
    @RequestMapping("/toAddPage")
    public String toAddPage(){
        return "addPage";
    }

    //添加汇利率的请求
    @RequestMapping("/addER")
    public String addER(ExchangeRate er){
        System.out.println("addBook=>"+er);
        exchangeRateService.addExchangeRate(er);
        return "redirect:/exchangeRate/allResults";
    }
    //跳转到更新汇利率界面
    @RequestMapping("/toUpdate")
    public String toUpdatePage(int id,Model model){
        ExchangeRate er=exchangeRateService.queryExchangeRateById(id);
        model.addAttribute("Qer",er);
        return "updatePage";
    }
    //修改汇利率
    @RequestMapping("/updateER")
    public String updateER(ExchangeRate er){
        exchangeRateService.updateExchangeRate(er);
        return "redirect:/exchangeRate/allResults";
    }
    //删除汇利率记录
    @RequestMapping("/deleteER")
    public String deleteER(int id){
        exchangeRateService.deleteExchangeRateById(id);
        return "redirect:/exchangeRate/allResults";
    }
    //根据Name查询结果
    @RequestMapping("/queryByName")
    public String queryByName(String name,Model model){
        List<ExchangeRate> list=exchangeRateService.queryExchangeRateByName(name);
        model.addAttribute("list",list);
        return "allResults";
    }
}
