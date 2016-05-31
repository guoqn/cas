package com.ffcs.crmd.cas.base.utils;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;

import java.util.Date;

/**
 * Created by YULIYAO on 2016/1/15.
 * 用于生成订单编号、预销售单账目项编号等工具
 */
public class CodeBuildUtils {

    private static final String SEQ_DEFAULT_CODE = "SEQ_GEN_DEFAULT_CODE_ID";

    /**
     * 生成格式：yyyyMMddHHmmss+000000(变化)+seq
     * 生成总位数：attrSepc.valueLength
     * seq：取attrSpec.codeParam1的序列
     * @author YULIYAO 2016/1/15
     * return
     */
    public static String buildPreOrderAcctCode(AttrSpec attrSpec) {
        String codeResult = "";
        if (attrSpec != null && !StringUtils.isNullOrEmpty(
            attrSpec.getAttrLength())) {
            //总位数
            int codeLength = NumberUtils.nullToZero(attrSpec.getAttrLength());
            //日期
            String dateStr = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
            //取seq的值
            String seqName = StringUtils.isNullOrEmpty(attrSpec.getCodeParam1()) ?
                SEQ_DEFAULT_CODE :
                attrSpec.getCodeParam1();
            String seqValue = StringUtils.strnull(CrmEntityUtils.getSeq(seqName));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(dateStr);
            for (int i = 0; i < codeLength - dateStr.length() - seqValue.length(); i++) {
                stringBuffer.append("0");
            }
            stringBuffer.append(seqValue);
            codeResult = new String(stringBuffer);
        }
        return codeResult;
    }
}
