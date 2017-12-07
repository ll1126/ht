//页面加载时运行
$(function(){
    //加载商品名称
    loadSpList();

    //保存按钮单击事件
    $("#bc").on("click",bc);

    //最终通过按钮单击事件
    $("#zztg").on("click",zztg);
});

function loadSpList(){
    var url ="clist";
    var data ={"fahuo":1};
    $.post(url,data,function(result){
        if(result.code==0){
            var data = result.content;
            for(var i=0;i<data.length;i++){
                $('#spList').append('<option id="sp'+data[i].id+'" lable="'+data[i].id+'" value="'+data[i].cXingHao+'">');
                $("#sp"+data[i].id+"").data("neirong",data[i]);
            }
        }
    });
}
//商品型号发生改变，就更新名称和价格
$("#spxh").change(function(){
    var sp = $("#spxh").val();
    if(sp!=""){
        //获取id对应的数据
        var a = $("#spList").find("option[value="+sp+"]").data("neirong");
        if(a==null||a==""){
            layer.msg("没有对应的商品，请重新填写");
            $("#spmc").val("");
            $("#spdj").val("");
            return false;
        }
        $("#spid").val(a.id);

        $("#spmc").val(a.cMingCheng);
        $("#spdj").val(a.fMoney);
    }else{
        //清空名称和价格
        $("#spmc").val("");
        $("#spdj").val("");
    }
});


function bc(){
    var spmc = $("#spmc").val();
    var spxh = $("#spxh").val();
    var spdj = $("#spdj").val();
    var url = "bc";
    var data = {
        "spmc":spmc,
        "spxh":spxh,
        "spdj":spdj
    };
    $.post(url,data,function(result){
        if(result.code==0){
            //加载表格
            $("#addserviceinfo").bootstrapTable("load", result.content);
            //清空输入框数据
            $("#spxh").val("");
            $("#spmc").val("");
            $("#spdj").val("");
        }
    });
}
function qk(){
    var url ="del";
    $.post(url,{},function(){
        //没了
    });
}

function zztg(){
    $.post("zztg",{},function(result){
        if(result.code==0){
            layer.msg("出库记录已生成，EXCEL文件未生成");
        }else{
            layer.msg(result.message);
        }

    });
}