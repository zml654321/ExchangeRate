package com.chb.controller;

import com.chb.pojo.ExchangeRate;
import com.chb.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
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

        return page;
    }
    //到添加汇率页面  加汇率
    @RequestMapping("/toAddERPage")
    public String toAddERPage(HttpServletRequest request,@RequestParam(value ="page",required = true)String page,Model model){
        System.out.println("page:"+page);
        model.addAttribute("page",page);
        return page;
    }
    //到汇率更新界面
    @RequestMapping("/toERUpdate")
    public String toERUpdatePage(int id,Model model,@RequestParam(value ="page",required = true)String page){
        ExchangeRate er=exchangeRateService.queryExchangeRateById(id);
        model.addAttribute("Qer",er);
        return page;
    }
    //ER汇率放行
    @RequestMapping("/ERReview")
    public String ERReview(int id,String status,@RequestParam(value ="page",required = true)String page,Model model){
        System.out.println("id:"+id);
        System.out.println("status:"+status);
        model.addAttribute("page",page);
        //根据status判断数据状态，2为新增，3为修改，二者做更新操作，4为删除，做删除操作
      if(status.equals("4")){
          //删除
          exchangeRateService.deleteExchangeRateById(id);

          return "redirect:/exchangeRate/queryER";
      }else{
          //更新状态
            exchangeRateService.updateERStatusById(id,"1");
      }
         return "redirect:/exchangeRate/queryER";
    }
}
