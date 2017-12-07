package com.test.Service;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface CHService {
    /**
     * 存货列表
     */
    List<Map> findCH(String xinghao,Integer fahuo);

    /**
     * 出库记录列表
     */
    List<Map> findCK();

    /**
     * 买家列表
     */
    List<Map> findMJ();

    /**
     * 发货清单保存
     */
    List<Map> bc(String spmc,String spdj,String spxh,Integer bc);

    /**
     * 发货清单修改
     */
    List<Map> xg(String field,String b,String id);

    /**
     * 最终通过
     */
    int zztg();




}
