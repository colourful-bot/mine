package com.xky.dao;

import com.xky.po.ReaderCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("readerDao")
public interface ReaderCardMapper {

    int deleteByPrimaryKey(Integer id);


    int insertSelective(ReaderCard record);


    ReaderCard selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(ReaderCard record);

    /**
     * 查询所有的记录信息
     */
    List<ReaderCard> queryReaderListAll(ReaderCard readerCard);

    /**
     * 根据用户名和密码判断用户是否存在
     */
    ReaderCard queryUserInfoByNameAndPassword(@Param("username") String username, @Param("password")String password);
}