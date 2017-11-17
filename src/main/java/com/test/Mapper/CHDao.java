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
}
