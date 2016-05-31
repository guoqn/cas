var g_data = {};

/**
 * 截取url参数
 * @param {Object} sHref
 * @param {Object} sArgName
 * @return {TypeName} 
 */
function GetArgsFromHrefs(sHref, sArgName) {
	var retval = new Array();
	var args = sHref.split("?");
	if (args[0] == sHref) /*参数为空*/
	{
		return retval; /*无需做任何处理*/
	}
	var str = args[1];
	args = str.split("&");
	for ( var i = 0; i < args.length; i++) {
		str = args[i];
		var arg = str.split("=");
		if (arg.length <= 1)
			continue;
		if (arg[0] == sArgName)
			retval[retval.length] = arg[1];
	}
	return retval;
}
/**
 * 获取应用程序目录 如crm，webapp
 */
function getWebRootPath() {
	var uri = window.location;
	uri = uri.toString();
	uri = uri.substring(uri.indexOf("/", 8) + 1, uri.length);
	uri = uri.substring(0, uri.indexOf("/"));
	return uri;
}
/**
 * 获取应用程序根Url 如 http://127.0.0.1:8080/crm
 * @return {TypeName} 
 */
function getWebRootUrl() {
	var uri = window.location;
	uri = uri.toString();
	path = uri.substring(0, uri.indexOf("/", 8) + 1) + getWebRootPath();
	return path;
}
/************************************************** 
 将字符串maintext复制到剪贴板 
 **************************************************/
function setClipboard(maintext) {
	if (window.clipboardData) {
		window.clipboardData.setData("Text", maintext);
		//window.clipboardData.setData("name", val.name) ; 
	} else if (window.netscape) {
		try {
			netscape.security.PrivilegeManager
					.enablePrivilege("UniversalXPConnect");
		} catch (e) {
			alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将 'signed.applets.codebase_principal_support'设置为'true'");
		}
		var clip = Components.classes['@mozilla.org/widget/clipboard;1']
				.createInstance(Components.interfaces.nsIClipboard);
		if (!clip)
			return;
		var trans = Components.classes['@mozilla.org/widget/transferable;1']
				.createInstance(Components.interfaces.nsITransferable);
		if (!trans)
			return;
		trans.addDataFlavor('text/unicode');
		var str = new Object();
		var len = new Object();
		var str = Components.classes["@mozilla.org/supports-string;1"]
				.createInstance(Components.interfaces.nsISupportsString);
		str.data = maintext;
		trans.setTransferData("text/unicode", str, str.data.length * 2);
		var clipid = Components.interfaces.nsIClipboard;
		if (!clip)
			return false;
		clip.setData(trans, null, clipid.kGlobalClipboard);
		return true;
	}
	return false;
}

/************************************************** 
 取外系统返回的值 返回剪贴板的内容 
 **************************************************/
function getClipboard() {
	var returnVal;
	if (window.clipboardData) {
		returnVal = window.clipboardData.getData('Text');

	} else if (window.netscape) {
		try {
			netscape.security.PrivilegeManager
					.enablePrivilege("UniversalXPConnect");
		} catch (e) {
			alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将 'signed.applets.codebase_principal_support'设置为'true'");
		}
		var clip = Components.classes['@mozilla.org/widget/clipboard;1']
				.createInstance(Components.interfaces.nsIClipboard);
		if (!clip)
			return;
		var trans = Components.classes['@mozilla.org/widget/transferable;1']
				.createInstance(Components.interfaces.nsITransferable);
		if (!trans)
			return;
		trans.addDataFlavor('text/unicode');
		clip.getData(trans, clip.kGlobalClipboard);
		var str = new Object();
		var len = new Object();
		try {
			trans.getTransferData('text/unicode', str, len);
		} catch (error) {
			return null;
		}
		if (str) {
			if (Components.interfaces.nsISupportsWString)
				str = str.value
						.QueryInterface(Components.interfaces.nsISupportsWString);
			else if (Components.interfaces.nsISupportsString)
				str = str.value
						.QueryInterface(Components.interfaces.nsISupportsString);
			else
				str = null;
		}
		if (str) {
			returnVal = str.data.substring(0, len.value / 2) + "12";
		}
	}
	return returnVal;
	return null;
}
/**
 * 调用外系统
 * @param {Object} url
 * @param {Object} width
 * @param {Object} height
 * @param {Object} mold ： //1--window.returnVal方式 外围系统返回值的方式：window.returnValue=data（返回值）即可。测试只支持ie浏览器 
 * 2--剪切板方式 外围系统返回值的方式：setClipboard(data),需要将setClipboard函数提供给外围系统方（函数见utils.js）；支持ie与firefox 不过此方式用户体验不好.  
 * 3--用window.open 直接打开页面 不取返回值
 */
function onInvoke(url, width, height, mold) {
	if (width == 'undefined' || width == null) {
		width = '600px';
	}
	if (height == 'undefined' || height == null) {
		height = '400px';
	}
	var returnVal;
	if (mold == 1) {
		var src = "/" + getWebRootPath();
		src += "/resources/public/out-system/pop_win.html?outSysemUrl=";
		returnVal = showModalDialog(src + encodeURIComponent(url), [ window ],
				"dialogWidth:" + width + ";dialogHeight:" + height
						+ ";titlebar:no;resizable:no;status:no;help:no;");

	} else if (mold == 2) {//剪切板

		showModalDialog(url, [ window ], "dialogWidth:" + width
				+ "px;dialogHeight:" + height
				+ "px;titlebar:no;resizable:no;status:no;help:no;");
		returnVal = getClipboard();
	} else if (mold == 3) {//直接打开
		if (url.indexOf(":") < 0) {
			url = getWebRootUrl() + url;
		}
	    var iTop = screen.availHeight/9;
	    var iLeft  = screen.availWidth/5;
	
		var params='height='+height+', width='+width;
		params+=',toolbar=no, menubar=no,status=no,scrollbars=yes,resizable=yes,status=no';
		params+=',top='+iTop+',left='+iLeft;
	     window.open (url, 'newwindow', params);
	} else if (mold == 4) {//直接打开
		if (url.indexOf(":") < 0) {
			url = getWebRootUrl() + url;
		}
		var params='left=0,top=0,width='+ (screen.availWidth - 10) +',height='+ (screen.availHeight-50) +',scrollbars,resizable=yes,toolbar=no';
	    window.open(url, '', params);
	} else if (mold == 6) {
		var src = "/" + getWebRootPath();
		src += "/mod_intact/out_system/pop_win.html?outSysemUrl=";
		retVal = showModalDialog(src + encodeURIComponent(url), [ window ],
				"dialogWidth:" + width + ";dialogHeight:" + height
						+ ";titlebar:no;resizable:no;status:no;help:no;");
		if(retVal!=null && retVal.length>0){
			returnVal = retVal[0];
		}
	}
	return returnVal;
	//bind('valData', returnVal);
}
/**
 * 调用外系统,连接跟参数分开.
 * @param {Object} url
 * @param {Object} width
 * @param {Object} height
 * @param {Object} mold
 * @param {Object} reqServiceName
 * @param {Object} pars
 * 
 */
function onInvokeWithArgs(url, width, height, mold, reqServiceName, pars) {
	if (width == 'undefined' || width == null) {
		width = '600px';
	}
	if (height == 'undefined' || height == null) {
		height = '400px';
	}
	var returnVal;
	if (mold == 1) {
		var src = "/" + getWebRootPath();
		if (reqServiceName == "vsop") {
			src += "/mod_intact/out_system/pop_win.html?outSysemUrl=";
			returnVal = showModalDialog(src + encodeURIComponent(url),
					[ window ], "dialogWidth:" + width + ";dialogHeight:"
							+ height
							+ ";titlebar:no;resizable:no;status:no;help:no;");
		} else {
			src += "/mod_intact/out_system/pop_win.html";
			var dataArray = {};
			dataArray.act = reqServiceName;
			dataArray.outUrl = url;
			dataArray.pars = pars;
			returnVal = showModalDialog(src, dataArray, "dialogWidth:" + width
					+ ";dialogHeight:" + height
					+ ";titlebar:no;resizable:no;status:no;help:no;");
			if (returnVal&&reqServiceName == "selectYzfCard") {
				returnVal = returnVal[0];
			}
		}
	} else if (mold == 2) {//剪切板

		showModalDialog(url, [ window ], "dialogWidth:" + width
				+ "px;dialogHeight:" + height
				+ "px;titlebar:no;resizable:no;status:no;help:no;");
		returnVal = getClipboard();
	} else if (mold == 3) {//直接打开
		if (url.indexOf(":") < 0) {
			url = getWebRootUrl() + url;
		}
	    var iTop = document.body.clientWidth /3;
	    var iLeft  = document.body.clientHeight/3;
		var params='height='+height+', width='+width;
		params+=',toolbar=no, menubar=no,status=no,scrollbars=yes,resizable=yes,';
		params+=',top='+iTop+'left='+iLeft;
	　     window.open (url, 'newwindow', params);
	} else if (mold == 5) {// ipad方式
		var src = "/" + getWebRootPath();
		src += "/mod_intact/out_system/pop_win.html";
		var dataArray = {};
		dataArray.act = reqServiceName;
		dataArray.outUrl = url;
		dataArray.pars = pars;
		g_data = dataArray;
		window.open(src);
	}
	if (reqServiceName == "vsop"&&returnVal&&returnVal.vsopOrderId) {
		var vsopStr = "";
		var vsopPrintStr = "";
		var vsopOrderId = returnVal.vsopOrderId;
		var vasList = returnVal.vasList;
		if (vasList && vasList != null) {
			for ( var i = 0; i < vasList.length; i++) {
				var vaObj = vasList[i];
				var opType = vaObj.opType;
				if (vsopPrintStr.length > 0)
					vsopPrintStr += ";";
				if (opType == "21") {
					vsopPrintStr += "[订购]" + vaObj.productName;
				}
				if (opType == "22") {//退订
					vsopPrintStr += "[退订]" + vaObj.productName;
					continue;
				}
				if (opType == "23") {
					vsopPrintStr += "[变更]" + vaObj.productName;
				}
				if (vsopStr.length > 0)
					vsopStr += ";";
				vsopStr += vaObj.productName;
			}
		}
		returnVal = "vsopOrderId=" + vsopOrderId + "&vsopStr=" + vsopStr + "&vsopPrintStr=" + vsopPrintStr;
	}
	if (mold != 5) { // ipad方式不用bind
		bind('valData', returnVal);
	}
}
/**
 * 值绑定到页面控件 并抛出事件
 * @param {Object} id
 * @param {Object} val
 */
function bind(id, val) {
	try {
		//var textbox = jq("$" + id)[0];
		//textbox.value = val;
		var relData = zk.Widget.$(jq("$" + id), document);
		relData.setValue(val);
		relData.smartUpdate('value', val);
		//todo 
		//触发事件button的onClick事件
		zAu.send(new zk.Event(relData, "onClick", val));
	} catch (e) {
		alert(e.name + ": " + e.message);
	}
}
/**
 * 
 */
function getWindowInfo() {
	var returnVal = document.body.clientWidth + ",";
	returnVal += document.body.clientHeight;
	bind('valData', returnVal);
}
/*window.onmousedown=function (){
 window.event.returnValue = false;
 }*/

/**
 * 打开针对性营销界面
 * @param {Object} url
 */
function  openYx(url){
	window.showModalDialog("../targeted_market.htm",url,"dialogHeight:300px;dialogWidth:450px;dialogLeft:200px;dialogTop:200px");
}

/**
 * 值绑定到页面控件 并抛出事件
 * @param {Object} id
 * @param {Object} val
 */
function refreshPropertyValue(iframeId,targetId, val) {
	try {
	    var iframe = jq("$" + iframeId)[0];
	    if(iframe==undefined || iframe==null || iframe=='undefined'){
	    	return;
	    }
	    var win = iframe.contentWindow;
	    if(win==undefined || win==null || win=='undefined' ){
	    	return;
	    }
	    win.eval("bind('"+targetId+"','"+val+"')");
	} catch (e) {
		alert(e.name + ": " + e.message);
	}
 
 
}
/**
 * add by guoqn 2014-8-28
 * @param {Object} url
 */
function  openOds(url){
	window.showModalDialog("../targeted_ods_login.htm",url,"dialogHeight:300px;dialogWidth:450px;dialogLeft:200px;dialogTop:200px");
}