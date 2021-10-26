package cn.yt4j.time;

import com.xkzhangsan.time.converter.DateTimeConverterUtil;

import java.util.Date;

/**
 * @author gyv12
 */
public class Test {
    public static void main(String[] args) {
        DateTimeConverterUtil.toZonedDateTime(new Date());
    }
}
