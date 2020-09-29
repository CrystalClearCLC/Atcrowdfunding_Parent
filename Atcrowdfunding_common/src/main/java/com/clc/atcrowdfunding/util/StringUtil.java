package com.clc.atcrowdfunding.util;

/**
 * Copyright (C), 2017-2020
 * Author: CrystalClear
 * Date: 2020/9/29 21:38
 * FileName: StringUtil
 * Description: StringUtils
 */
public class StringUtil {

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);
        //     s == null | s.equals("");  //位与,逻辑与区别,非空字符串放置在前面,避免空指针
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}