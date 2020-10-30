package com.chb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/toLogin")
    public String toLoginPage(){
        return "/user/login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户的信息存在session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("userLoginInfo",username);
        return "redirect:/exchangeRate/allResults";
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        session.removeAttribute("userLoginInfo");
        return "/user/login";
    }
}
