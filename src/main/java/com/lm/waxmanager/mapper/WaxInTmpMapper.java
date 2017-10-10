package com.lm.waxmanager.mapper;

import com.lm.waxmanager.domain.WaxInTmp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WaxInTmpMapper {

    @Select("select * from waxintmp")
    List<WaxInTmp> queryAll();

    @Insert("insert into waxintmp(pathnum, imgurl, location) values(#{pathnum}, #{imgurl}, #{location})")
    void insertWaxIn(WaxInTmp waxInTmp);

    @Delete("delete from waxintmp")
    Integer deleteAll();

    @Select("select * from waxintmp where waxinid = #{waxinid}")
    WaxInTmp queryByid(int waxinid);

    @Delete("delete from waxintmp where waxinid = #{waxinid}")
    Integer delById(int waxinid);
}
