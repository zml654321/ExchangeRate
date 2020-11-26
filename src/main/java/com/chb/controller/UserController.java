package com.chb.controller;

import com.chb.tools.ADLogin;
import com.chb.tools.constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/toLogin")
    public String toLoginPage(){
        return "/user/login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) throws NamingException {
        //身份验证,密码正确true，错误false
        boolean IV =ADLogin.IV(username,password);
        if(IV){
            //权限验证，0没有权限，1利率编辑权限，2利率审核权限，3汇率编辑权限，4汇率审核权限
            int AV = 0;
            //判断登录用户具有哪一权限
            //利率录入权限
            if(ADLogin.AV(username, constant.GROUP_IR_EDIT)){
                AV=1;
            }
            //利率审核权限
            if(ADLogin.AV(username, constant.GROUP_IR_REVIEW)){
                AV=2;
            }
            //汇率录入权限
            if(ADLogin.AV(username, constant.GROUP_ER_EDIT)){
                AV=3;
            }
            //汇率审核权限
            if(ADLogin.AV(username, constant.GROUP_ER_REVIEW)){
                AV=4;
            }
            //IT权限
            if(ADLogin.AV(username,constant.GROUP_IT)){
                AV=5;
            }
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
                    model.addAttribute("page","/IR/edit");
                    return "redirect:/exchangeRate/queryER";
                }
                //利率审核权限，加入session中，返回跳转页面
                case 2: {
                    model.addAttribute("message","用户具有利率审核权限");
                    session.setAttribute("IRReview",username);
                    model.addAttribute("IRReview",username);
                    model.addAttribute("page","IR/review");
                    return "redirect:/exchangeRate/queryER";}
                //汇率编辑权限，加入session中，返回跳转页面
                case 3: {
                    model.addAttribute("message","用户具有汇率编辑权限");
                    session.setAttribute("EREdit",username);
                    model.addAttribute("EREdit",username);
                    model.addAttribute("page","/ER/edit");
                    return "redirect:/exchangeRate/queryER";}
                //汇率审核权限，加入session中，返回跳转页面
                case 4: {
                    model.addAttribute("message","用户具有汇率审核权限");
                    session.setAttribute("ERReview",username);
                    model.addAttribute("ERReview",username);
                    model.addAttribute("page","ER/review");
                    return "redirect:/exchangeRate/queryER";}
                case 5:{
                    model.addAttribute("message","用户具有IT权限");
                    session.setAttribute("IT",username);
                    model.addAttribute("IT",username);
                    model.addAttribute("page","IT/edit");
                    return "redirect:/exchangeRate/queryER";
                }
            }
        }else {
            model.addAttribute("message","用户名或密码错误！");
            return "/user/login";
        }
        return "/user/login";
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session,String name){
        session.removeAttribute(name);
        return "/user/login";
    }
}
