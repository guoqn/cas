package com.ffcs.crmd.cas.core.ddd.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 功能说明:
 *
 * @author Luxb
 * 
 * @Date 2015年12月26日 下午4:30:52
 *
 * @param <T>
 * @param <ID>
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public abstract class AbsCrmdBaseRepositoryImpl<T extends AbsCrmdBaseEntity<ID>, ID extends Serializable>
    extends AbstractCrmDomBaseRepository<T, ID> implements ICrmdBaseRepository<T, ID> {
    
    public AbsCrmdBaseRepositoryImpl(Class<T> repositoryClass) {
        super(repositoryClass);
    }
    
    @Override
    public <E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params) {
        String sql = this.getSqlByName(name);
        sql = parseSqlArray(sql, params);
        return jdbcFindList(sql, elementType, params);
    }
    
    @Override
    public <E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params,
        boolean isCache) {
        String sql = this.getSqlByName(name);
        sql = parseSqlArray(sql, params);
        return jdbcFindList(sql, elementType, params, isCache);
    }
    
    @Override
    public <E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType,
        List<Object> params, int currentPage, int perPageNum, boolean isCache) {
        String sql = this.getSqlByName(name);
        sql = parseSqlArray(sql, params);
         return jdbcFindPageInfo(sql, elementType, params, currentPage, perPageNum, isCache);
    }
    
    /**
     * 根据参数类型，如果是数组类型，则将sql中对应的"?"按数组长度转换为"(?,?,?,?)",并重装组装params
     * @param sql
     * @param params
     * @return
     */
    public static String parseSqlArray(String sql, List params) {
        if (StringUtils.isNullOrEmpty(sql) || params == null || params.size() == 0) {
            return sql;
        }
        for (int i = 0; i < params.size(); i++) {
            //遍历参数，组装新的sql和参数
            if (params.get(i).getClass().isArray()) {
                //1.根据数组长度，组装问号和参数
                String ques = "";
                Object[] objects = (Object[]) params.get(i);
                params.remove(i);
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < objects.length; j++) {
                    sb.append("?,");
                    params.add(i + j, objects[j]);
                }
                sb = sb.deleteCharAt(sb.lastIndexOf(","));
                ques = "(" + sb.toString() + ")";
                //2.替换sql
                sql = replace(sql, i, ques);
            }
        }
        return sql;
        
    }
    
    public static String replace(String targetString, int index, String targetChar) {
        String[] targetStrings = targetString.split("\\?");
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < targetStrings.length; i++) {
            resultSb.append(targetStrings[i]);
            if (i == index) {
                resultSb.append(targetChar);
            } else {
                resultSb.append("?");
            }
        }
        return resultSb.toString();
    }
    
}
