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
        //session.setAttribute("userLoginInfo",username);
        //model.addAttribute("userLoginInfo",username);
        //身份验证,密码正确true，错误false
        boolean IV = true;
        //权限验证，0没有权限，1利率编辑权限，2利率审核权限，3汇率编辑权限，4汇率审核权限
        int AV = 3;
        if(IV){
            switch(AV)
            {   //没有权限，返回登录
                case 0: {
                    model.addAttribute("message","用户没有相关权限");
                    return "/user/login";}
                //利率编辑权限，加入session中，返回跳转页面
                case 1: {
                    model.addAttribute("message","用户具有利率编辑权限");
                    session.setAttribute("IREdit",username);
                    model.addAttribute("IREdit",username);
                    return "/IR/edit";
                }
                //利率审核权限，加入session中，返回跳转页面
                case 2: {
                    model.addAttribute("message","用户具有利率审核权限");
                    session.setAttribute("IRReview",username);
                    model.addAttribute("IRReview",username);
                    return "/IR/review";}
                //汇率编辑权限，加入session中，返回跳转页面
                case 3: {
                    model.addAttribute("message","用户具有汇率编辑权限");
                    session.setAttribute("EREdit",username);
                    model.addAttribute("EREdit",username);
                    return "redirect:/exchangeRate/queryER";}
                //汇率审核权限，加入session中，返回跳转页面
                case 4: {
                    model.addAttribute("message","用户具有汇率审核权限");
                    session.setAttribute("ERReview",username);
                    model.addAttribute("ERReview",username);
                    return "/ER/review";}
            }
        }else {
            model.addAttribute("message","用户名或密码错误！");
            return "/user/login";
        }
        return "/user/login";
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        session.removeAttribute("userLoginInfo");
        return "/user/login";
    }
}
