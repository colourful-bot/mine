package com.xky.controller;


import com.xky.po.Admin;
import com.xky.po.ReaderCard;
import com.xky.service.AdminService;
import com.xky.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderService readerService;
    /**
     * 登录页面的转发
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    /**
     * 登录验证方法
     */
    @RequestMapping("/loginIn")
            public String loginIn(HttpServletRequest request, Model model){
                //获取用户名和密码
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                String type=request.getParameter("type");
                //验证登录是否超时
                HttpSession session=request.getSession();
                if(session==null){
                    model.addAttribute("msg","登录超时了...");
                    return "login";
        }


        if(type.equals("1")){//管理员信息
            //用户名和密码是否正确
            Admin user=adminService.queryUserByNameAndPassword(username,password);
            if(user==null){//该用户不存在
                model.addAttribute("msg","用户名或者密码错误...");
                return "login";
            }
            session.setAttribute("user",user);
            session.setAttribute("type","admin");
        }else{//来自读者信息表
            ReaderCard readerCard=readerService.queryUserInfoByNameAndPassword(username,password);
            if(readerCard==null){
                model.addAttribute("msg","用户名或者密码错误...");
                return "login";
            }
            session.setAttribute("user",readerCard);
            session.setAttribute("type","reader");
        }

        return "index";
    }


    /**
     * 退出功能
     */
    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();;
        return "redirect:/login";
    }

}
