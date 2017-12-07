package com.test.Controller;

import com.test.Service.CHService;
import com.test.Util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
public class Controller1 {
    @Autowired
    private CHService cService;

    @GetMapping(path = "/a")
    public String a(){
        return "index";
    }

    /**
     * 存货列表
     * @param xinghao  型号
     * @return
     */
    @PostMapping(path = "/clist")
    @ResponseBody
    public JsonResult cList(String xinghao,Integer fahuo){
        if(xinghao!=null && xinghao.trim().isEmpty()){
            xinghao=null;
        }
        List<Map> list = cService.findCH(xinghao,fahuo);
        return new JsonResult(list);
    }

    /**
     * 出库记录列表
     * @return
     */
    @PostMapping(path = "/cklist")
    @ResponseBody
    public JsonResult ckList(){
        List<Map> list = cService.findCK();
        return new JsonResult(list);
    }

    /**
     * 买家列表
     * @return
     */
    @PostMapping(path = "/mjlist")
    @ResponseBody
    public JsonResult mjlist(){
        List<Map> list = cService.findMJ();
        return new JsonResult(list);
    }

    /**
     * 保存发货清单
     * @return
     */
    @RequestMapping(path = "/bc")
    @ResponseBody
    public JsonResult bc(String spmc,String spdj,String spxh,Integer bc){
        List<Map> list = cService.bc(spmc,spdj,spxh,bc);
        return new JsonResult(list);
    }

    /**
     *  修改发货清单 （数量或者价格）
     * @param field  改变的列的变量名
     * @param b  修改后的数据
     * @param id  发货清单的行id
     * @return
     */
    @RequestMapping(path = "/xg")
    @ResponseBody
    public JsonResult xg(String field,String b,String id){
        List<Map> list = cService.xg(field,b,id);
        return new JsonResult(list);
    }

    /**
     * 最终通过
     * @return
     */
    @RequestMapping(path = "/zztg")
    @ResponseBody
    public JsonResult zztg(){
        int a = cService.zztg();
        if(a==0){
            return new JsonResult(1,"","请添加商品");
        }
        return new JsonResult();
    }


}
