package com.test.Service.impl;

import com.test.Mapper.CHDao;
import com.test.Service.CHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class CHSericeImpl implements CHService{
    @Autowired
    private CHDao cdao;

    public List<Map> findCH(String xinghao) {
        List<Map> list = cdao.findCH(xinghao);
        return list;
    }

    public List<Map> findCK() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Map> list = cdao.findCK();
        //时间转换
        for(Map a:list){
            a.put("tChuDate",sdf.format(a.get("tChuDate")));
        }
        return list;
    }

    public List<Map> findMJ() {
        List<Map> list = cdao.findMJ();
        return list;
    }
}
