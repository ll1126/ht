$layui_body_container = null;
layui.config({
    base: '/js/modules/'
}).use(['element', 'layer'], function() {
    var element = layui.element(),
        $layui_elem_quote = $('.layui-elem-quote'),
        $layui_body_container = $('.layui-tab-content').children("div:last-child");
		
	
    //监听导航事件,获取导航数据
    element.on('nav(nav)', function(element) {
        var $element = $(element),
		navtitle = $element.text(),
		url = $element.children().data('url');
        $("#new").load(url);
    });
    function ajaxhtml(url) {
        //$layui_body_container.html("");

        if (url === "" || undefined) return;
        //显示加载loading动画
        layer.load(2);
        //请求成功，关闭loading动画
//        var divs = $(".layui-tab-content").children();
//        for(var i=0;i<divs.length;i++){
//        	console.log($(divs[i]));
//        	$(divs[i]).hide();
//        }

        $layui_body_container.load(url, function(response, status, xhr) {
        	console.log($layui_body_container);
            if (status === "success") {
            	// $('.layui-tab-content div').removeClass('layui-show');
            	 //$layui_body_container.addClass('layui-show');
                layer.closeAll('loading');
                //$layui_body_container.show();
            } else if (status === "error") {
                layer.closeAll('loading');
                layer.msg("加载失败，请检查网络链接是否正常！");
            }
        });
    }
});
