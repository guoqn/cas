// JavaScript Document

$(document).ready(function(){
	
	   
	
		/*小于1300屏幕时调用*/
		if($(window).width()<1300 ){
			$('head').append('<link rel="stylesheet" href="css/css1300.css" type="text/css" />');
		}
		$("#sch").click(function(){
			 if($("#condition").val() === "18965885936"){
			  $(".tbCustom.Tb1").css("display","none");
			  $(".tbCustom.Tb2").css("display","");
			  }
		  }); 
		
		/*menu 导航*/
		 $(".navmore").hover(function(){
			$(this).addClass("navmore-hover");
		    $(this).find(".navMoreUL").show();
		  },function(){
			$(this).removeClass("navmore-hover");
		    $(this).find(".navMoreUL").hide();	  
	 		}); 
		
		
		/*Tab 选项卡 */
		    var $li = $('#outer #tab li');
			var $ul = $('#outer  #content >ul');					
			$li.click(function(){
				var $this = $(this);
				var $t = $this.index();
				$li.removeClass();
				$this.addClass('current');
				$ul.css('display','none');
				$ul.eq($t).css('display','block');
			})
		
		 
	   

		
		/*select下拉样式*/
		$(".ui-select").selectWidget({
			change       : function (changes) {
				return changes;
			},
			effect       : "slide",
			keyControl   : true,
			speed        : 200,
			scrollHeight : 250
		});
		
		 /*tree生成*/
		 $('.tree').treegrid();  
		   
		/*table 斑马线
		 $("table  tr:even").css("background-color","#fbfbfb"); 
		 $("table  tr:odd").css("background-color","#ffffff"); */ 
		 /*table tr 经过颜色*/
		 $("table tr").bind("mouseover",function(){ 
		     $(this).css("background-color","#f1f9ff");
			 $(this).css("cursor","pointer");  
		  }) 
		 $("table tr").bind("mouseout",function(){ 
		      $("table  tr:even").css("background-color","#ffffff"); 
		 	  $("table  tr:odd").css("background-color","#ffffff"); 
		  }) 
		
		
		/*input进入焦点时触发*/
         $("input#condition").focus(function(){
              varoldValue = $(this).val();
              if(varoldValue == this.defaultValue){
                  $(this).val("");
				  $(this).css("color","#333");
              }
         });  
         /*input失去焦点时触发*/
         $("input#condition").blur(function(){
              varoldValue = $(this).val();
              if(varoldValue == ""){
                   $(this).val(this.defaultValue);
				   $(this).css("color","#bdbdbd");
              }
         });
		 $("#Tb1").find("tr:not(:first)").bind("click",function(){    
			 $("#Tb1").find("tr:not(:first)").children("td").removeClass("hoverss"); 
			 $(this).children("td").addClass("hoverss"); 
         });
		   /*  
		   
		 $("#Tbl").find("tr:not(:first)").bind("click",function(){
				$("#Tbl").find("tr:not(:first)").hide();
				$("#Tbl").find("tr:not(:first)").children("td").removeClass("hoverss");
				$(this).show(20);
				$(this).children("td").addClass("hoverss");
		});
		
		展开更多信息*/
		$("li.open").hide();
		$(".baseopen a.blue").click(function(){
			$(".formTxtList ul li.open").toggle("");
		})
		$(".probaseopen a.blue").click(function(){			
			$(".probaseopen").hide();
			$(".probaseopen").next().nextAll("li.open").slideToggle("slow");
		})
		$("tr.open").hide();
		$(".tbCustom a.morehide").hide();
		$(".tbCustom a.moreshow,.tbCustom a.morehide").click(function(){	
			$(".tbCustom a.moreshow").toggle();
			$(".tbCustom a.morehide").toggle();
			$("tr.open").toggle("slow");
			
		})
		/*弹出窗口*/
		var settings = {
						trigger:'click',
						title:'',
						content:'<div class=conMondule><div class=formTxtList><ul style=display:block;padding:0><li><span>类型：</span>3G号码</li><li><span>号码：</span>18965885936</li><li><span>号码状态：</span>占用</li><li><span>类型：</span>3G机身码</li><li><span>编码：</span>460030404721706</li><li><span>号码状态：</span>占用</li></ul></div></div>',
						width:800,						
						multi:true,						
						closeable:true,
						style:'',
						padding:true
				};
				
				$('a.show-pop').webuiPopover('destroy').webuiPopover(settings);	
				
		var record = {
			trigger:'click',
				title:'',
				content:'<table class=tbCustom width=100% border=0  cellspacing=0 cellpadding=0><tr><th width=50>操作</th><th>信息项</th><th>新值</th><th>旧值</th></tr><tr><td>新增</td><td>产品平级关系A端</td><td>普通电话:2820266与移动语音:18965885936新增主副关系</td><td></td></tr><tr><td>新增</td><td>销售员所属经营主体</td><td>J35030211508</td><td></td></tr><tr><td>删除</td><td>可受理一卡双号功能</td><td></td><td>1</td></tr><tr><td>新增</td><td>营销资源关系</td><td>社会渠道自进机－华为Y635-CL00:A000005518A079(46946199)</td><td></td></tr><tr><td>新增</td><td>终端占用类型</td><td>占用设备</td><td></td></tr><tr><td>新增</td><td>拆项付费生效方式</td><td>立即生效</td><td></td></tr></table>',
				width:800,						
				multi:true,						
				closeable:true,
				style:'',
				padding:true
			};
		$('a.show-pop1').webuiPopover('destroy').webuiPopover(record);
	

		var flowc= "<table class=tbCustom width=100% border=0  cellspacing=0 cellpadding=0>"+
"<tr><th>环节名称</th><th>开始时间</th><th>结束时间</th><th>工号</th><th>团队</th></tr>"+
"<tr><td>缴费判断</td><td>2015-08-13 11:16:20</td><td>2015-08-13 11:16:20</td><td>吴国暖（38479030）<td>客户经营中心外呼团队</td></tr>"+
"<tr><td>4G融合判断</td><td>2015-08-13 11:16:20</td><td>2015-08-13 11:16:20</td><td>吴国暖（38479030）</td><td>客户经营中心外呼团队</td></tr>"+
"<tr><td>客户申请订单撤销或缓装</td><td>2015-08-13 11:16:20</td><td>2015-08-13 11:16:20</td><td>吴国暖（38479030）</td><td>客户经营中心外呼团队</td></tr>"+
"<tr><td>订单分解</td><td>2015-08-13 11:16:20</td><td>2015-08-13 11:16:20</td><td>吴国暖（38479030）</td><td>客户经营中心外呼团队</td></tr>"+
"<tr><td>等待报竣</td><td>2015-08-13 11:16:20</td><td>2015-08-13 11:16:20</td><td>吴国暖（38479030）</td><td>客户经营中心外呼团队</td></tr>"+
"<tr><td>竣工处理</td><td>2015-08-13 11:16:20</td><td>2015-08-13 11:16:20</td><td>吴国暖（38479030）</td><td>客户经营中心外呼团队</td></tr></table>";
		var spa = {
			trigger:'click',
				title:'',
				content:flowc,
				width:900,						
				multi:true,						
				closeable:true,
				style:'',
				padding:true
			};
		$('a.show-pop2').webuiPopover('destroy').webuiPopover(spa);
		var spb = {
			trigger:'click',
				title:'',
				content:'<div class=step><ul><li><div class=blueBg stepStar s><span class=num>1</span><i class=lineDouble></i><span>订单提交</span><i class=arrowBlueRight></i></div><div class=time>20150505 20:00:00 <font>已缴费</font></div></li><li><div class=grayBg><span class=num>3</span><i class=lineDouble></i>订单施工<i class=arrowGrayRight></i></div></li><li><div class=grayBg stepEnd><span class=num>4</span><i class=lineDouble></i>订单竣工</div></li></ul> </div><table class=tbCustom width=100% border=0  cellspacing=0 cellpadding=0><tr><th>环节</th><th>时间</th><th>状态</th><th>责任/值班人</th><th>联系号码</th><th>班组</th></tr><tr><td>安装完成</td><td>2015-05-06 21：13：21</td><td>竣工</td><td>张三</td><td>18908776746</td><td>客户经营中心外呼团队</td></tr><tr><td>撤销</td><td>2015-05-06 21：13：21</td><td>已撤销</td><td>张三</td><td>18908776746</td><td>客户经营中心外呼团队</td></tr><tr><td>订单提交</td><td>2015-05-06 20：11：36</td><td>订单提交</td><td>张三</td><td>18908776746</td><td>客户经营中心外呼团队</td></tr></table>',
				width:800,
				height:'auto',						
				multi:true,						
				closeable:true,
				style:'',
				padding:true
			};
		$('a.show-pop3').webuiPopover('destroy').webuiPopover(spb);
		
		
		/*右侧*/
		
		var _baseUrl = '';
		var baseJSUrl = 'skin/default/js/';
		var baseCSSUrl = 'skin/default/css/';
		var account_url="";
		var refreshCartUrl="";//购物车
		var recentlyViewedUrl=""; //最近浏览
		var saveMessageUrl="";//提交留言
		var checkout_Url="";//去购物车并结算
		var go_buy="";//购买
		var place_url="skin/default/images/place.png";//loading图片
		var validateCode_url="";//获取验证码
		var delCart_url="";
		var account_order_url="";
		var account_return_url="";
		var account_address_url="";
		var account_giftcard_url="";
		var account_cashcard_url="";
		var account_jf_url="";
		var account_comment_url = "#";
		var account_consult_url = "#";
		var account_message_url = "#";
		var account_arrival_url = "";
		var account_reduce_url = "";
		var unreadNewMsgUrl = "";
		//Dialog icon base path
		ds.Dialog.defaults.iconBasePath = 'skin/default/images/';
		function showInfoTip(content, type, onhide){
			var icons = {success:'success.png', info: 'info.png'};
			var icon = icons[type] || 'error.png';
			return ds.dialog({
				title: '消息提示',
				content: content,
				onhide: onhide,
				onyes: true,
				icon: icon,
				timeout: 3,
				width: 200
			});
		}
		ds.loadScript(baseJSUrl+'quick_links.js');
		
	});
	
	
function showTb1Info() {
		$("#Tbl").find("tr:not(:first)").show(1000);
		}