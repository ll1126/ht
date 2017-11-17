//页面加载时调用
$(function(){
    //显示存货列表
    loadList();

    //查询按钮
    $("#cx").on("click",loadList);
});


function loadList(){
    var xinghao = $("#xinghao").val();
    var url="clist";
    var data={"xinghao":xinghao};
    $.post(url,data,function(result){
        if(result.code==0){
            //加载表格
            $("#channel-application").bootstrapTable("load",result.content);
        }

    });
}