package com.test.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CHDao {

    List<Map> findCH(@Param("xinghao")String xinghao);
    List<Map> findCK();
    List<Map> findMJ();
    int del();
    int bc(@Param("spmc")String spmc,@Param("spdj")String spdj,@Param("spxh")String spxh);
    List<Map> findQD();
    Map cxqd(@Param("id")String id);
    int xg(@Param("spdj")String spdj,@Param("spsl")String spsl,@Param("spzj")String spzj,@Param("id")String id);
    String zj();
    int scck(@Param("time")String time,@Param("maijia")String maijia,@Param("money")String money,@Param("qd")String qd);
}
