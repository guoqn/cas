package com.ffcs.crmd.cas.sys.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.meta.repository.IAttrValueRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:conf/spring/applicationContext*.xml",
		"classpath*:conf/spring/**/applicationContext*.xml" })
public class CrmClassUtilsTest {
	
	@Resource
	IAttrValueRepository attrValueRepository;
	@Test
	public void getAttrValues() {
		List<AttrValue> attrList = CrmClassUtils.getAttrValues("AssiAttrSpecConfig", "PackageSo");
		System.out.println("结果：>>>>>>>" + attrList.size());
	}
	
	@Test
	public void getAttrValueNameByValue() {
		String result = CrmClassUtils.getAttrValueNameByValue("AssiAttrSpecConfig", "PackageSo","500");
		System.out.println("结果：>>>>>>" + result);
	}
	
	@Test
	public void getAttrSpecByCode() {
		AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode("AssiAttrSpecConfig", "PackageSo");
		System.err.println("结果：>>>>>>" + attrSpec.getAttrName());
	}
}
