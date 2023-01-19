package com.htfc.qytx.common.view.klinechart.formatter;



import com.htfc.qytx.common.view.klinechart.base.IDateTimeFormatter;
import com.htfc.qytx.common.view.klinechart.utils.DateUtil;

import java.util.Date;

/**
 * 时间格式化器
 * Created by tifezh on 2016/6/21.
 */

public class DateFormatter implements IDateTimeFormatter {
    @Override
    public String format(Date date) {
        if (date != null) {
            return DateUtil.DateFormat2.format(date);
        } else {
            return "";
        }
    }

}
