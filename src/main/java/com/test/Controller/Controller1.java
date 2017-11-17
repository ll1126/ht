package com.test.Controller;

import com.test.Service.CHService;
import com.test.Util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public JsonResult cList(String xinghao){
        if(xinghao!=null && xinghao.trim().isEmpty()){
            xinghao=null;
        }
        List<Map> list = cService.findCH(xinghao);
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
}
