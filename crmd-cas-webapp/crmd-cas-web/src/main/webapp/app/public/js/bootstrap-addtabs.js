var topHeight4pageIframe = 70;
$(function () {

    $('body').on('click', '[addtabs]', function () {
        addTabs({
            id: $(this).attr("addtabs"),
            title: $(this).attr('title')?$(this).attr('title'):$(this).html(),
            content: $(this).attr('content'),
            url: $(this).attr('url'),
            close: true
        });
    });

    $(window).resize(function () {
        $('body').find('iframe').attr('height', $(document).height() - topHeight4pageIframe);
        tabsdrop($('.nav-tabs'));
    });

    $(".nav-tabs").on("click", ".close-tab", function () {
        id = $(this).parent("a").attr("aria-controls");
        closeTab(id);
    });
    
    $(".nav-tabs").on("click", "#tab_closeAllBtn", function () {
    	closeAllTab();
    });
});

var addTabs = function (obj) {
    id = "tab_" + obj.id;
    
    if(obj.url == null || obj.url == '#' ){
    	return ;
    }
    
    $(".active").removeClass("active");

    //如果TAB不存在，创建一个新的TAB
    if (!$("#" + id)[0]) {
        //固定TAB中IFRAME高度,根据需要自己修改
        mainHeight = $(document).height() - topHeight4pageIframe;
        //创建新TAB的title
        title = $('<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab"><span class="left"></span><span class="mid">' + obj.title + '</span><span class="close-tab close1"><span></span></span><span class="right"></span></a></li>');
        //是否允许关闭
        if (obj.close) {
            //title.append(' <i class="close-tab glyphicon glyphicon-remove"></i>');
        }
        //创建新TAB的内容
        content = $('<div role="tabpanel" class="tab-pane" id="' + id + '"></div>');
        //是否指定TAB内容
        if (obj.content && obj.content != undefined) {
            content.append(obj.content);
        } else {//没有内容，使用IFRAME打开链接
        	$(content).html('<iframe class="page-iframe" src="' + obj.url + '" width="100%" height="' + mainHeight +
                '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling-x="no" scrolling-y="auto" allowtransparency="yes"></iframe></div>');
        }
        
        //加入TABS
        $(".nav-tabs").append(title);
        $(".tab-content").append(content);
    }
    
    
//    $(".menutabs li").removeClass('sel');
//    $(".menutabs li").addClass('unsel');
//    //激活TAB
//    $("#tab_" + id).removeClass('unsel');
//    $("#tab_" + id).addClass('sel');
    $("#tab_" + id).addClass('active');
    $("#" + id).addClass("active");
    
    // 清楚检索框内容
    $("#menuName").val("");
    // 触发变更事件
    $("#menuName").change();
    
    //检查是否需要创建下拉
    tabsdrop($('.nav-tabs'));
};

var tabsdrop = function (element) {
    //创建下拉标签
    var dropdown = $('<li class="dropdown  hide tabdrop"><a class="dropdown-toggle menu-down-a"  style="background-color:#006ce0;border:0;" data-toggle="dropdown" href="#">' +
        '<span class="menu-down-left"></span><span class="menu-down-mid"><span></span></span><span class="menu-down-right"></span>' +
        '</a><ul class="dropdown-menu sub2-dropdown-menu"></ul></li>');
    
    
    
    
    //检测是否已增加
    if (!$('.tabdrop').html()) {
        dropdown.prependTo(element);
    } else {
        dropdown = element.find('.tabdrop');
    }
    // 标签至于第一个
    dropdown.prependTo(element);
    //检测是否有下拉样式
    if (element.parent().is('.tabs-below')) {
        dropdown.addClass('dropup');
    }
    var collection = 0;
    
//    var homeOffsetTop = $("#li-home").offsetTop;

    // 将下拉框至成可见，避免后  检查超过一行的标签页 出错
    dropdown.removeClass('hide');
    
    //检查超过一行的标签页
    element.append(dropdown.find('li'))
        .find('>li')
        .not('.tabdrop')
        .not('.closeAll')
        .each(function () {
            if ( this.offsetTop > 0) {
                dropdown.find('ul').append($(this));
                collection++;
            }
        });
    
    element.append(dropdown);
    
    var closeAll =  $('<li role="presentation" class="closeAll" id="tab_closeAllBtn"><a href="#"><span></span>一键清空</a></li>');
    if($('#tab_closeAllBtn').html()){
    	closeAll = $('#tab_closeAllBtn');
    }
    
    $( $(dropdown).find('ul.sub2-dropdown-menu')).remove('#tab_closeAllBtn');
    
    $( $(dropdown).find('ul.sub2-dropdown-menu')).append(closeAll);
    
    //如果有超出的，显示下拉标签
    if (collection > 0) {
        dropdown.removeClass('hide');
        if (dropdown.find('.active').length == 1) {
            dropdown.addClass('active');
        } else {
            dropdown.removeClass('active');
        }
    } else {
        dropdown.addClass('hide');
    }
    
    
    // 页面大小变更 嵌套的页面也跟着边
    var mainHeight = $(document).height() - 55;
    $(".page-iframe").attr("height",mainHeight);
}

var closeTab = function (id) {
    //如果关闭的是当前激活的TAB，激活他的前一个TAB
    if ($("li.active").not('.tabdrop').eq(0).attr('id') == "tab_" + id) {
    	$("#li-home").addClass('active');
    	$("#home").addClass('active');
    }
    //关闭TAB
    $("#tab_" + id).remove();
    $("#" + id).remove();
    
    if($("li.active").length<=0){
    	$("#li-home").addClass('active');
    	$("#home").addClass('active');
    }
    
    tabsdrop($('.nav-tabs'));

};

var closeAllTab = function() {

	if (confirm("确认要关闭全部窗口？")) {
		$(".nav-tabs .close-tab").each(function() {
			id = $(this).parent("a").attr("aria-controls");
			//关闭TAB
			$("#tab_" + id).remove();
			$("#" + id).remove();
		});
		
		tabsdrop($('.nav-tabs'));
		$("#li-home").addClass('active');
    	$("#home").addClass('active');
	}
}

