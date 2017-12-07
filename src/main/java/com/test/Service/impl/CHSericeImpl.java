package com.test.Service.impl;

import com.test.Mapper.CHDao;
import com.test.Service.CHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CHSericeImpl implements CHService{
    @Autowired
    private CHDao cdao;

    public List<Map> findCH(String xinghao,Integer fahuo) {
        List<Map> list = cdao.findCH(xinghao);
        if(fahuo!=null && fahuo==1){
            cdao.del();
            System.out.println("清空发货清单");
        }
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

    public List<Map> bc(String spmc,String spdj,String spxh,Integer bc) {
        //保存记录
        int a = cdao.bc(spmc,spdj,spxh);

        //读取全部记录
        List<Map> list = cdao.findQD();
        return list;
    }


    public List<Map> xg(String field, String b, String id) {
        //根据id查询清单
        Map map = cdao.cxqd(id);
        //修改数据
        map.put(field,b);
        String spdj = null;//商品单价
        String spsl = null;//商品数量
        Double spzj = null;//商品总价
        if(map!=null && map.get("spdj")!=null){
            spdj = map.get("spdj").toString();
        }
        if(map!=null && map.get("spsl")!=null){
            spsl = map.get("spsl").toString();
        }
        if(spdj!=null && spsl!=null){
            spzj = Double.parseDouble(spdj) * Integer.parseInt(spsl);
        }
        int a = cdao.xg(spdj,spsl,spzj.toString(),id);
        //返回新数据
        List<Map> list = cdao.findQD();
        return list;
    }


    public int zztg() {
        //生成出库记录
        List<Map> list = cdao.findQD();//全部记录
        if(list.size()<1){
            return 0;
        }
        String zqd = "";
        for(Map a :list){
            String spmc = null;
            String spxh = null;
            String spsl = null;
            if(a!=null && a.get("spmc")!=null){
                spmc = a.get("spmc").toString();
            }
            if(a!=null && a.get("spxh")!=null){
                spxh = a.get("spxh").toString();
            }
            if(a!=null && a.get("spsl")!=null){
                spsl = a.get("spsl").toString();
            }
            zqd = zqd+spmc+"("+spxh+")"+" * "+spsl+" ，";

        }
        System.out.println(zqd);

        String zj = cdao.zj();//总价
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        /*
            买家还没加
         */
        String maijia = "*****";
         /*
            买家还没加
         */
        int a = cdao.scck(time,maijia,zj,zqd);

        //生成EXCEL文件

        return 1;
    }
}
