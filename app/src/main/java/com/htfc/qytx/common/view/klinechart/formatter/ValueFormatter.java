package com.htfc.qytx.common.view.klinechart.formatter;


import com.htfc.qytx.common.view.klinechart.base.IValueFormatter;

/**
 * Value格式化类
 * Created by tifezh on 2016/6/21.
 */

public class ValueFormatter implements IValueFormatter {
    @Override
    public String format(float value) {
        return String.format("%.2f", value);
    }
}
