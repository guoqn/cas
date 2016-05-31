package com.ffcs.crmd.cas.core.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.crmd.devops.test.IntegrationTest;
import com.ffcs.crmd.platform.pub.vo.RetVo;



@Controller
@RequestMapping("/test")
@ResponseBody
public class IntegrationTestController extends CrmdBaseController {
	
	/**
	 * 获取defValue
	 * 
	 * @param confCd
	 * @return
	 */
	@RequestMapping("/startTest")
	public RetVo startTest() {
		RetVo retVo = new RetVo(true);
		IntegrationTest.startTest();
		retVo.setObject(IntegrationTest.getIntegrationTestView());
		return retVo;
	}

	/**
	 * 获取defValue
	 * 
	 * @param confCd
	 * @return
	 */
	@RequestMapping("/showResource")
	public RetVo showResource() {
		RetVo retVo = new RetVo(true);
		retVo.setObject(IntegrationTest.getResourceLoadedView());
		// IntegrationTest.startTest();
		return retVo;
	}
}
