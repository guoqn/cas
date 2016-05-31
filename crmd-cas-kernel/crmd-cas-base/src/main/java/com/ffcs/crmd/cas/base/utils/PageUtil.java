package com.ffcs.crmd.cas.base.utils;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YULIYAO on 2015/12/22.
 */
public class PageUtil {

    /**
     * 将列表转化为分页
     * @author YULIYAO 2015/12/22
     * return
     */
    public static PageInfo list2PageInfo(List list, int pageNum, int pageSize) {
        if (list == null) {
            return null;
        }
        return list2PageInfo(list, list.size(), pageNum, pageSize);
    }

    /**
     * 将列表转化为分页
     * @author YULIYAO 2015/12/22
     * return
     */
    public static PageInfo list2PageInfo(List list, int total, int pageNum, int pageSize) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(total);
        //当前页的列表
        List curPageList = new ArrayList();
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = pageNum * pageSize;
        if (list.size() > startIndex) {
            curPageList = list
                .subList(startIndex, list.size() > endIndex ? pageNum * pageSize : list.size());
        }
        pageInfo.setList(curPageList);
        return pageInfo;
    }

}
