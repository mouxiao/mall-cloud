package com.mall.commons.utils;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by mouxiao on 2018/11/30 0030.
 */
public class StringUtils {

    /**
     * @remark obj为null时返回null 不返回字符串null
     * @param obj
     * @return
     */
    public static String valueOf(Object obj){
        return obj == null ? null : obj.toString();
    }


}
