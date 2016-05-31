<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=JspUtil.path(request)%>/app/public/css/main.css?<%=JspUtil.version()%>">
<link rel="stylesheet" href="<%=JspUtil.path(request)%>/app/public/css/home.css?<%=JspUtil.version()%>">
<link rel="stylesheet" href="<%=JspUtil.path(request)%>/app/public/css/bootstrap-addtabs.css?<%=JspUtil.version()%>">
<title>中国电信IT架构互联网化福建试点项目</title>
</head>
<body class="mainbg" ng-app="mainIndexApp" ng-controller="mainIndexAppCtrl">
	<div class="top">
		<div class="navmore float-left" >
			<ul class="nav navbar-nav">
                  <li class="dropdown dropdowni8">
                      <span data-toggle="dropdown" class="mytopnav">
                      	<i class="menulogo"></i>全部菜单
                      </span>
					  <ul class="dropdown-menu menu-top mymenu-top">
						<li ng-class="dropdown-submenu" class="search-li">
								<input id="menuName" class="search-key text" type="text" ng-model="menuName" ng-change="queryFocus()"  placeholder="搜索" >
								<div ng-show="showQuery" class="search" id="search-menu" >
									<ul style="width:95%">
									  <li ng-repeat="x in allPrivileges | filter:{searchKey:menuName}">
									  	<a ng-if="!x.child.length >0"  addtabs="{{x.privilegeCode}}"  url="<%=JspUtil.path(request)%>{{x.path}}"  title="{{x.privilegeName}}"  href="#" style="margin:0 2px 0 2px;display:inline-block"  >{{x.privilegeName}}</a>
									  </li>
									</ul>
								</div>
						</li>
                      	<li ng-repeat="item in privileges" ng-class="{'dropdown-submenu mydropdown-submenu':item.child.length > 0,'myundropdown-submenu':item.child.length <= 0}">
					        <a ng-if="!item.child.length >0 && item.path.length>0 && item.path!='#' "   addtabs="{{item.privilegeCode}}" url="<%=JspUtil.path(request)%>{{item.path}}" title="{{item.privilegeName}}"  href="#">{{item.privilegeName}}</a>
					        <a ng-if="item.child.length >0 || item.path.length<=0  || item.path=='#' " href="#" >{{item.privilegeName}}</a>
					        <ul ng-if="item.child.length" class="dropdown-menu" style="background:transparent;border:0;-webkit-box-shadow:0 0 0 transparent;box-shadow:0 0 0 transparent;">
					        	<li style="margin:0;padding:0;border:0;display:block;float:none;">
					        		<div class="arrowWhite"></div>
						        	<ul class="sub-dropdown-menu">
							        	<li ng-repeat="item1 in item.child" style="min-height:24px;" >
								        	<dl>
												<dt style="padding-left:10px;width:40px;color:#ffad8d;float:left;">{{item1.firstLetter}}</dt>
												<dd style="width:565px;margin-right:25px;">
													<a  ng-repeat="item2 in item1.child" class="sub-menu-a" href="#"  addtabs="{{item2.privilegeCode}}" url="<%=JspUtil.path(request)%>{{item2.path}}"  title="{{item2.privilegeName}}" >{{item2.privilegeName}}</a>
												</dd>
											</dl>
							        	</li>
						        	</ul>
					        	</li>
					        </ul>
					    </li>
                      </ul>
                  </li>
              </ul>
		</div>
		<div class="mainlogo float-left">
			<i></i>
		</div>
		<div class="menutab float-left">
			<ul class="nav nav-tabs menutabs"   role="tablist"  >
                <li role="presentation" id="li-home" class="active">
                 <a href="#home" aria-controls="home" role="tab" data-toggle="tab">
                  <span class="left">
                 	</span>
                 	<span class="mid">
                  	首页
                 	</span>
                  <span class="right">
                 	</span>
                 </a>
                </li>
            </ul>
		</div>
		<div class="config float-right">
			<div class="topnav"> 
	        	<a href="#" class="user-a" title="hi,张小芸">
	        		<i class="user-i"></i>
	         	<i class="lineDouble"></i>
	        	</a>
	        	<a href="#" class="upcoming-a" title="消息">
	        		<i class="upcoming-i"></i>
	        		<span class="badge pull-right msg" >50</span>
	        	</a>
	        	<a href="#" class="exit-a" title="注销退出">
	        		<i class="lineDouble"></i>
	        		<i class="exit-i"></i>
	        	</a>
	         </div>
		</div>
	</div>
	<div class="mainContent">
		<div id="myTabContent" class="tab-content">
			<div class="home tab-pane fade in active" id="home">
				<div class="left">
					<div class="home-title">
						<img alt="" src="<%=JspUtil.path(request)%>/app/public/img/userName.png"> 
							欢迎您，
						<font style="font-weight:bold;color:#ff6500">
							阮航（fztest）
						</font>
					</div>
					<div class="home-content">
						<font color="#666666">所属机构:</font>中国电信福州东街营业厅<br /> 
						<font color="#666666">所属团队:</font> <select>
							<option style="width: 200px">团队1</option>
							<option style="width: 200px">团队1</option>
							<option style="width: 200px">团队1</option>
							<option style="width: 200px">团队1</option>
							<option style="width: 200px">团队1</option>
						</select> <br /> 
						<font color="#666666">访问节点：</font>134.132.47.224：9001<br />
					</div>
				</div>
				<div class="right">
					<div class="home-title">
						<img alt="" src="<%=JspUtil.path(request)%>/app/public/img/clock.png"> 
						待办事务<font style="font-weight:bold;color:#ff6500">（8）</font>
					</div>
					<div class="home-content">
						<div id="home-item" class="home-item">
						<ul style="width:98%">
							<li><a href="#">事情111111111111111</a></li>
							<li><a href="#">事情2</a></li>
							<li><a href="#">事情3</a></li>
							<li><a href="#">事情4</a></li>
							<li><a href="#">事情5</a></li>
							<li><a href="#">事情6</a></li>
							<li><a href="#">事情7</a></li>
							<li><a href="#">事情8</a></li>
							<li><a href="#">事情9</a></li>
							<li><a href="#">事情10</a></li>
						</ul>
						</div>
					</div>
				</div>
				<div
					style="display: block;position: absolute;bottom: 0;height: 40px;left: 0;right: 0; text-align: center; padding: 60px; color: #888; font-size: 14px;">Copyright
					© 2015 中国电信股份有限公司福建分公司. All Rights Reserved</div>
					<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
					<%-- <script type="text/javascript"
						src="<%=JspUtil.path(request)%>/resources/public/component/right-suspension-menu/js/quick-links.js?<%=JspUtil.version()%>"></script> --%>
					<script type="text/javascript" src="<%=JspUtil.path(request)%>/app/public/main/main-service.js?<%=JspUtil.version()%>"></script>
					<script type="text/javascript" src="<%=JspUtil.path(request)%>/app/public/main/main-controller.js?<%=JspUtil.version()%>"></script>
					<script type="text/javascript" src="<%=JspUtil.path(request)%>/app/public/js/bootstrap-addtabs.js?<%=JspUtil.version()%>"></script>
					<script type="text/javascript" src="<%=JspUtil.path(request)%>/app/public/js/jquery.nicescroll.min.js?<%=JspUtil.version()%>"></script>
					<script type="text/javascript">
						$("#home-item").niceScroll({  
							cursorcolor:"#ffb889",  
							cursoropacitymin :1,
							cursoropacitymax:1,  
							touchbehavior:false,  
							cursorwidth:"3px",  
							cursorborder:"3px",  
							cursorborderradius:"0px" ,
							overflowy:false,
							railhoffset:false
						}); 
						$("#search-menu").niceScroll({  
							cursorcolor:"#ffb889",  
							cursoropacitymin :1,
							cursoropacitymax:1,  
							touchbehavior:false,  
							cursorwidth:"3px",  
							cursorborder:"3px",  
							cursorborderradius:"0px" ,
							overflowy:false,
							railhoffset:false
						}); 
					</script>
			</div>
		</div>
	</div>
</body>
</html>