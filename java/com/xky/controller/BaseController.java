package com.xky.controller;

import com.github.pagehelper.PageInfo;
import com.xky.po.Notice;
import com.xky.service.BookInfoService;
import com.xky.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private BookInfoService bookInfoService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 欢迎页面转换
     */
    @GetMapping("/welcome")
    public void welcome(Model model) {
        //提供公告信息
        PageInfo<Notice> pageInfo = noticeService.queryNoticeAll(null, 1, 1);
        if (pageInfo != null) {
            if (pageInfo.getList().size() > 0) {
                Notice notice = pageInfo.getList().get(0);
                model.addAttribute("info", notice);
            }
        }


    }

}
