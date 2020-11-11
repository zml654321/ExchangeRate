package com.chb.controller;

import com.chb.pojo.ExchangeRate;
import com.chb.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    public String addER(ExchangeRate er,@RequestParam(value ="page",required = true)String page,Model model){
        exchangeRateService.addExchangeRate(er);
        model.addAttribute("page",page);
    return "redirect:/exchangeRate/queryER";
    }
    //更新汇率
    @RequestMapping("/updateER")
    public String updateER(ExchangeRate er,@RequestParam(value ="page",required = true)String page,Model model){
        exchangeRateService.updateExchangeRate(er);
        model.addAttribute("page",page);
        return "redirect:/exchangeRate/queryER";
    }
    //利率类型为1，汇率为2 查汇率
    @RequestMapping("/queryER")
    public String queryER(Model model, HttpServletRequest request, @RequestParam(value ="page",required = true)String page){
       //获取利率
        if(page.contains("IR")){
            List<ExchangeRate> list=exchangeRateService.queryByType("1");
            model.addAttribute("list",list);
        }
        if(page.contains("ER")){
            List<ExchangeRate> list=exchangeRateService.queryByType("2");
            model.addAttribute("list",list);
        }
        if(page.contains("IT")){
            List<ExchangeRate> list=exchangeRateService.queryAllExchangeRate();
            model.addAttribute("list",list);
        }

        return page;
    }
    //到添加汇利率页面
    @RequestMapping("/toAddERPage")
    public String toAddERPage(HttpServletRequest request,@RequestParam(value ="page",required = true)String page,Model model){
        System.out.println("page:"+page);
        model.addAttribute("page",page);
        return page;
    }
    //到汇利率更新界面
    @RequestMapping("/toERUpdate")
    public String toERUpdatePage(int id,Model model,@RequestParam(value ="page",required = true)String page){
        ExchangeRate er=exchangeRateService.queryExchangeRateById(id);
        model.addAttribute("Qer",er);
        return page;
    }
    //ER汇率放行
    @RequestMapping("/ERReview")
    public String ERReview(int id,@RequestParam(value ="page",required = true)String page,Model model){
        System.out.println("id:"+id);
        model.addAttribute("page",page);
      exchangeRateService.updateERDataById(id);
         return "redirect:/exchangeRate/queryER";
    }
    //根据type及name查询
    @RequestMapping("/queryByName")
    public String queryByNameAndType(HttpServletRequest request,@RequestParam(value ="page",required = true)String page,@RequestParam(value ="name",required = true)String name,Model model){
        if(page.contains("IR")){
            List<ExchangeRate> list=exchangeRateService.queryByName(name,"1");
            model.addAttribute("list",list);
        }
        if(page.contains("ER")){
            List<ExchangeRate> list=exchangeRateService.queryByName(name,"2");
            model.addAttribute("list",list);
        }
        if(page.contains("IT")){
            List<ExchangeRate> list=exchangeRateService.queryExchangeRateByName(name);
            model.addAttribute("list",list);
        }
        return page;
    }
    //根据id删除数据
    @RequestMapping("/deleteById")
    public String deleteById(int id,@RequestParam(value ="page",required = true)String page,Model model){
        model.addAttribute("page",page);
        exchangeRateService.deleteExchangeRateById(id);
        return "redirect:/exchangeRate/queryER";
    }
}
