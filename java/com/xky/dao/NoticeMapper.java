package com.xky.dao;

import com.xky.po.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("noticeDao")
public interface NoticeMapper {

    int insert(Notice record);


    int insertSelective(Notice record);


    /**
     * 查询公告信息
     */
    List<Notice> queryNoticeAll(@Param("content") String content);

    /**
     * 公告删除
     */
    void deleteNoticeByIds(List<Integer> id);

    /**
     * 查询详细根据id查询
     */
    Notice queryNoticeById(Integer id);
}