package com.ffcs.crmd.cas.base.utils;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.cache.LocalCache;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.meta.entity.SysClass;
import com.ffcs.crmd.platform.meta.repository.IAttrSpecRepository;
import com.ffcs.crmd.platform.meta.repository.IAttrValueRepository;
import com.ffcs.crmd.platform.meta.repository.ISysClassRepository;

import java.util.ArrayList;
import java.util.List;

public class CrmClassUtils {

	private static LocalCache localCache = LocalCache.getInstance();

	public static IAttrValueRepository attrValueRepository;
	
	public static IAttrSpecRepository attrSpecRepository;

	public static ISysClassRepository sysClassRepository;
	/**
	 * 
	 * 根据类code，属性code获取属性值列表.
	 * 
	 * @param className
	 * @param propertyName
	 * @return
	 * @author Luxb
	 * 2016年1月8日 Luxb
	 */
	public static List<AttrValue> getAttrValues(String className, String propertyName) {
		if (attrValueRepository == null) {
			attrValueRepository = ApplicationContextUtil.getBean("attrValueRepository");
		}
		return attrValueRepository.getAttrValuesByCode(className, propertyName);
	}

	/**
	 * 获取属性取值列表.
	 *
	 * @param className
	 *            类名
	 * @param propertyName
	 *            属性名
	 * @return 属性取值列表
	 * @author zhangfzh
	 *         2011-7-16 zhangfzh
	 */
	public static List<String> getAttrValueList(String className, String propertyName) {
		String key = LocalCache.genKey(AttrValue.class.getSimpleName(), className, propertyName);
		if (localCache.contains(key)) {
			return (List<String>) localCache.get(key);
		}
		List<String> valueList = new ArrayList<String>();
		List<AttrValue> attrValues = getAttrValues(className, propertyName);
		if (attrValues != null&&attrValues.size()>0) {
			for (AttrValue attrValue : attrValues) {
				valueList.add(attrValue.getAttrValue());
			}
		}
		localCache.put(key, attrValues);
		return valueList;
	}

	/**
	 * 
	 * 根据类code、属性code、属性值获取属性值名称.
	 * 
	 * @param className
	 * @param propertyName
	 * @param attrValue
	 * @return
	 * @author Luxb
	 * 2016年1月8日 Luxb
	 */
	public static String getAttrValueNameByValue(String className, String propertyName,String attrValue){
		String key = LocalCache
				.genKey("getAttrValueNameByValue", className, propertyName, attrValue);
		if (localCache.contains(key)) {
			return (String) localCache.get(key);
		}
		if (attrValueRepository == null) {
			attrValueRepository = ApplicationContextUtil.getBean("attrValueRepository");
		}
        List<AttrValue> values = attrValueRepository.getAttrValuesByCode(className, propertyName);
        
        SysClass superClass = CrmClassUtils.getSuperClass(className);
        if (superClass != null) {
        	List<AttrValue> supValues = attrValueRepository.getAttrValuesByCode(superClass.getJavaCode(), propertyName);
        	if (supValues != null && supValues.size() >0) {
        		if (values != null && values.size() >0) {
        			values.addAll(supValues);
        		} else {
        			values = supValues;
        		}
        	}
        }
        String result = null;
        if (values != null && values.size() >0) {
	        for (AttrValue value : values) {
	            if (value.getAttrValue().equals(attrValue)) {
	            	result = value.getAttrValueName();
	            	break;
	            }
	        }
        }
		localCache.put(key, result);
		return result;
	}
	/**
	 * 根据类code、属性code获取属性.
	 * @param className
	 * @param propertyName
	 * @author Luxb
	 * 2016年1月8日 Luxb
	 */
	public static AttrSpec getAttrSpecByCode(String className, String propertyName) {
		String key = LocalCache.genKey(AttrSpec.class.getSimpleName(), className, propertyName);
		if (localCache.contains(key)) {
			return (AttrSpec) localCache.get(key);
		}
		AttrSpec attrSpec = null;
		if (attrSpecRepository == null) {
			attrSpecRepository = ApplicationContextUtil.getBean("attrSpecRepository");
		}
		List<AttrSpec> attrList = attrSpecRepository.getAttrSpecsByCode(className, propertyName);
		if (attrList != null && attrList.size() >0) {
			attrSpec = attrList.get(0);
		} else {
			SysClass superClass = getSuperClass(className);
			if (superClass != null) {
				List<AttrSpec> attrList2 = attrSpecRepository.getAttrSpecsByCode(superClass.getJavaCode(),propertyName);
				if (attrList2 != null && attrList2.size() >0) {
					attrSpec = attrList2.get(0);
				}
			}
		}
		localCache.put(key, attrSpec);
		return attrSpec;
	}

	/**
	 * 判断开关是否打开(与区域无关).
	 *
	 * @param switchKey 开关的key，对应attrSpec表的JAVACODE字段
	 * @return boolean
	 * @author huangjb
	 * 2011-5-11 huangjb
	 */
	public static boolean hasSwitch(String switchKey) {
		return hasSwitch(switchKey, null);
	}

	/**
	 * 判断开关是否打开.
	 *
	 * @param switchKey 开关的key，对应attrSpec表的JAVACODE字段
	 * @param areaId 区域，目前将区域存放于attrValue表的MaxValue字段
	 * @return boolean
	 * @author huangjb
	 * 2011-5-11 huangjb
	 */
	public static boolean hasSwitch(String switchKey, Long areaId) {
		boolean flag = false;
		List<AttrValue> list = getAttrValues(CasConstant.META_CLASS_NAME_SWITCH.getValue(), switchKey);
		if (list != null && list.size() > 0) {
			for (AttrValue attrValue : list) {
				if (CasConstant.SWITCH_VALUE_OPEN.getValue().equals(attrValue.getAttrValue())
						&& (StringUtils.isNullOrEmpty(areaId) || StringUtils.strnull(areaId).equals(attrValue.getMaxValue()))) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 获取父类主数据。
	 * @param className
	 * @return
     */
	public static SysClass getSuperClass(String className) {
		String key = LocalCache.genKey("getSuperClass", className);
		if (localCache.contains(key)) {
			return (SysClass) localCache.get(key);
		}
		if (sysClassRepository == null) {
			sysClassRepository = ApplicationContextUtil.getBean("sysClassRepository");
		}
		SysClass superClass = null;
		List<SysClass> sList = sysClassRepository.getSysClssByCode(className);
		if (sList != null && sList.size() >0) {
			SysClass sysClass = sList.get(0);
			superClass = sysClassRepository.getById(sysClass.getSuperClassId());
		}
		localCache.put(key, superClass);
		return superClass;
	}

	/**
	 * 根据Id获取属性。
	 * @param attrId
	 * @return
     */
	public static AttrSpec getAttrSpecById(Long attrId) {
		String key = LocalCache.genKey(AttrSpec.class.getSimpleName(), attrId+"");
		if (localCache.contains(key)) {
			return (AttrSpec) localCache.get(key);
		}
		if (attrSpecRepository == null) {
			attrSpecRepository = ApplicationContextUtil.getBean("attrSpecRepository");
		}
		AttrSpec attrSpec = (AttrSpec) attrSpecRepository.getById(attrId);
		localCache.put(key, attrSpec);
		return attrSpec;
	}
	/**
	 * 根据code获取外系统地址
	 *
	 * @param code
	 * @return
	 */
	public static String getOutSysUrlByCode(final String code) {
		String url = "";
		final AttrSpec attrSpec = getAttrSpecByCode(IntfConstant.INTF_URL_CLASS.getValue(), code);
		if (attrSpec != null && !StringUtils.isNullOrEmpty(attrSpec.getDefaultValue())) {
			url = attrSpec.getDefaultValue();
		}
		return url;
	}
	/**
	 * 根据javaCode获取主数据对象.
	 * @param className
	 * @return
	 * @author Luxb
	 * 2016年2月24日 Luxb
	 */
	public static SysClass getSysClassByClassName(String className) {
		String key = LocalCache.genKey(SysClass.class.getSimpleName(), className);
		if (localCache.contains(key)) {
			return (SysClass) localCache.get(key);
		}
		if (sysClassRepository == null) {
			sysClassRepository = ApplicationContextUtil.getBean("sysClassRepository");
		}
		SysClass sysClass = null;
		List<SysClass> sList = sysClassRepository.getSysClssByCode(className);
		if (sList != null && sList.size() >0) {
			sysClass = sList.get(0);
		}
		localCache.put(key, sysClass);
		return sysClass;
	}

	/**
	 * 判断指定的值是否在指定的主数据下有配置 .
	 *
	 * @param classJavaCode : 类javaCode
	 * @param attrSpecJavaCode : attrSpec的javaCode
	 * @param channelNbr : 指定的值
	 * @return
	 * =====================================<br>
	 * @author 2013-9-12 chenjw 创建方法并实现功能
	 * =====================================<br>
	 */
	public static boolean isFixedAttrValue(String classJavaCode, String attrSpecJavaCode, String channelNbr) {
		if(channelNbr != null) {
			List<AttrValue> attrValues = CrmClassUtils.getAttrValues(classJavaCode, attrSpecJavaCode);
			if (attrValues != null && attrValues.size() > 0) {
				for (AttrValue attrValue : attrValues) {
					if (attrValue != null && attrValue.getAttrValue() != null) {
						if (attrValue.getAttrValue().equals(channelNbr)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * 根据attrValueName 获取attrValue
	 * @param className
	 * @param propertyName
	 * @param attrValueName
     * @return
     */
	public static String getAttrValueByName(String className, String propertyName,String attrValueName){
		if (attrValueRepository == null) {
			attrValueRepository = ApplicationContextUtil.getBean("attrValueRepository");
		}
		List<AttrValue> values = attrValueRepository.getAttrValuesByCode(className, propertyName);
		String result = null;
		if (values != null && values.size() >0) {
			for (AttrValue value : values) {
				if (value.getAttrValueName().equals(attrValueName)) {
					result = value.getAttrValue();
					break;
				}
			}
		}
		return result;
	}
	public static AttrValue getAttrValueByValueName(String className, String propertyName,String attrValueName) {
		if (attrValueRepository == null) {
			attrValueRepository = ApplicationContextUtil.getBean("attrValueRepository");
		}
		List<AttrValue> values = attrValueRepository.getAttrValuesByCode(className, propertyName);
		AttrValue result = null;
		if (values != null && values.size() >0) {
			for (AttrValue value : values) {
				if (value.getAttrValueName().equals(attrValueName)) {
					result = value;
					break;
				}
			}
		}
		return result;
	}
}
