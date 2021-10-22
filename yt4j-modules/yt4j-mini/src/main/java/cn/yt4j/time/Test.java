package cn.yt4j.time;

import com.xkzhangsan.time.converter.DateTimeConverterUtil;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        DateTimeConverterUtil.toZonedDateTime(new Date());
    }
}
