package com.test.Service;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface CHService {
    /**
     * 存货列表
     */
    List<Map> findCH(String xinghao);

    /**
     * 出库记录列表
     */
    List<Map> findCK();

    /**
     * 买家列表
     */
    List<Map> findMJ();
}
