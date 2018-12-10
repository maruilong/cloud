package com.xinyuan.base.common.util;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author 王亚飞
 * @date 2018/5/7
 */
public class NumberFormatToPercent {

    /**
     * 将数据转换给百分比
     * @param
     * @return
     */
    public static String numberFormatToPercent(double number)
    {
        //定义返回的结果
        String result;

        //格式化百分比
        NumberFormat nf = NumberFormat.getPercentInstance();

        //保留小数点后的1位
        nf.setMinimumFractionDigits(2);

        result = nf.format(number);

        return result;
    }



    /**
     * 将百分比还原为数字
     * @param percent
     * @return
     */
    public static double percentFormatToNumber(String percent)
    {

        double number = 0.0;

        NumberFormat nf =NumberFormat.getPercentInstance();
        try {
            number = nf.parse(percent).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return number;
    }
}
