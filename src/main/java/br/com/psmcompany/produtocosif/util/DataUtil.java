package br.com.psmcompany.produtocosif.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataUtil {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.RFC_1123_DATE_TIME; // .ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    public static String format(Date date) {
        return DATE_TIME_FORMATTER.format(
                ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
        );
    }
}
