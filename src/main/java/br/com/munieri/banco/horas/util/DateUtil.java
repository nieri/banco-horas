package br.com.munieri.banco.horas.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String FORMAT_MM_SS = "mm:ss";
    public static final String FORMAT_YYYY_MM_DD = "yyy-MM-dd";

    public static String formatBalance(int sum) {
        if (sum >= 0) {
            return LocalTime.ofSecondOfDay(sum).format(DateTimeFormatter.ofPattern(FORMAT_MM_SS)).toString();
        }
        return "-" + LocalTime.ofSecondOfDay(sum * -1).format(DateTimeFormatter.ofPattern(FORMAT_MM_SS)).toString();
    }
}
