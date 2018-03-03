package cn.brainysoon.repdata.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by brainy on 17-7-5.
 */
public class DateTools {

    /**
     * 20位时间戳
     */
    private static final SimpleDateFormat SDF_LONG_ID_22 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private static final Random random = new Random();

    /**
     * @return 22位的随机Id
     */
    public static String getRandomId22() {

        StringBuffer pre = new StringBuffer(SDF_LONG_ID_22.format(new Date()));

        for (int i = 0; i < 5; i++) {

            int ran = Math.abs(random.nextInt() % 9) + 1;

            pre.append(ran);
        }

        return pre.toString();
    }
}
