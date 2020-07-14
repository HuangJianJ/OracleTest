package Test;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author 黄建军
 * @version V1.0
 * @Package Test
 * @date 2020/7/9 11:09
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */

public class LocalDateTest {
    private LocalDate localDate;

    public static void main(String[] args) {
        LocalDate localDate= LocalDate.now();
        LocalDateTime localDateTime= LocalDateTime.now();

        //新版JDK 8日期 XXXX-XX-XX HH:MM:SS
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("现在的时分秒"+dateTimeFormatter.format(localDateTime));
        System.out.println("今天日期"+localDate);
        System.out.println("现在是哪年"+localDate.getYear());
        System.out.println("现在是哪月"+localDate.getMonth());
        System.out.println("现在是哪月(数字)"+localDate.getMonthValue());
        System.out.println("现在是周几"+localDate.getDayOfWeek());
        System.out.println("现在是这个月的第几天"+localDate.getDayOfMonth());
        System.out.println("现在是这一年的多少天"+localDate.getDayOfYear());
        System.out.println("修改修改当前对象年份"+localDate.withYear(2026));
        System.out.println("修改修改当前对象月份"+localDate.withMonth(3));
        System.out.println("修改当前对象在当月的日期"+localDate.withDayOfMonth(25));
        System.out.println("获取本月第一天"+ localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("获取本月第二天"+ localDate.withDayOfMonth(2));
        System.out.println("获取本月最后一天"+ localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("获取下两天"+ localDate.plusDays(2));
        System.out.println("获取2020年7月第一个周一"+LocalDate.parse("2020-07-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));


        //加减年份月份
        System.out.println("获取下一年"+ localDate.plusYears(1));
        System.out.println("获取下一月"+ localDate.plusMonths(1));

        //日期比较未来时间大于现在时间则是true，过去时间小于现在时间则是false
        System.out.println("后面的年份或者月份大于现在时间则是"+localDate.plusMonths(1).isAfter(localDate));

        //两个时间差
        LocalDateTime changeDate= LocalDateTime.of(2020,8,9,13,40,50);
        //第二个参数减去第一个参数
        Duration duration= Duration.between(localDateTime,changeDate);
        System.out.println("相差时间天数"+duration.toDays());
        System.out.println("相差时间小时"+duration.toHours());
        System.out.println("相差时间分钟"+duration.toMinutes());
        System.out.println("相差时间毫秒"+duration.toMillis());
        System.out.println("相差时间纳秒数"+duration.toNanos());
        double A=Math.random()*10;
        //第一种保留两位小数
        DecimalFormat df=new DecimalFormat("#.00");
        //第二种保留两位小数
        String sta=String.format(String.format("%.02f", A));
        System.out.println(A);
        System.out.println(df.format(A));
        System.out.println(sta);
        //取整Math.random()生存的数大于等于0小于1
        for (int i = 0; i <20 ; i++) {
            int B= (int) (Math.random()*10+1);
            System.out.println(B);
        }

    }
}
