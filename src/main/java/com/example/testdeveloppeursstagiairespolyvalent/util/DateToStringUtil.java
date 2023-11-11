package com.example.testdeveloppeursstagiairespolyvalent.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateToStringUtil {
    public static final DateTimeFormatter DATEFORMAT_CONVERTOR = DateTimeFormatter
            .ofPattern("dd/MM/yyyy");

    public static final DateTimeFormatter DATEFORMAT_CONVERTOR_SEARCH = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");


    public static final DateTimeFormatter DATETIME_FORMAT_CONVERTOR_ = DateTimeFormatter
            .ofPattern("dd/MM/yyyy HH:mm");


    public static final DateTimeFormatter DATETIME_FORMAT_CONVERTOR_V3 = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");


    public static final DateTimeFormatter DATETIME_FORMAT_CONVERTOR = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static String getDateToString(LocalDateTime date) {
        return date == null ? "" : DATETIME_FORMAT_CONVERTOR_.format(date);
    }

    public static LocalDateTime convertorDateTime00H00(String dateText) {

        LocalDate l = convertorDate(dateText);
        LocalDateTime ok = l != null ? l.atStartOfDay() : null;

        return ok;
    }

    public static LocalDate convertorDate(String dateText) {

        LocalDateTime l1 = null;

        LocalDate l = null;
        try {

            dateText = dateText == null ? "" : dateText;

            l1 = LocalDateTime.parse(dateText, DATETIME_FORMAT_CONVERTOR);

            l = l1.toLocalDate();

        } catch (Exception DateTimeParseException) {

        }

        try {

            if (l == null) {

                l = LocalDate.parse(dateText, DATEFORMAT_CONVERTOR);
            }

        } catch (Exception DateTimeParseException) {

        }

        try {

            if (l == null) {

                l = LocalDate.parse(dateText, DATEFORMAT_CONVERTOR_SEARCH);
            }

        } catch (Exception DateTimeParseException) {

        }

        try {

            if (l == null) {

                l = LocalDate.parse(dateText, DATETIME_FORMAT_CONVERTOR_V3);
            }

        } catch (Exception DateTimeParseException) {

        }

        return l;
    }
}
