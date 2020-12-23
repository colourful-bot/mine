package com.xky.dao;

import com.xky.po.BookInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bookinfoDao")
public interface BookInfoMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeyWithBLOBs(BookInfo record);


    /**
     * 查询所有的图书信息
     */
    List<BookInfo> queryBookInfoAll(BookInfo info);

    /**
     * 根据图书的类型获取图书的数量
     */
}