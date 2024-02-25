package com.dogtor.mscommons.service.utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@NoArgsConstructor
public class DateUtils {

    public static String ISO_Z_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String ISO_Z_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter DATE_FORMATTER_ISO = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static DateTimeFormatter DATE_FORMATTER_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter DATE_FORMATTER_DTHR_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static LocalDate convertTextToDate(String text) {
        if (ObjectUtils.isEmpty(text)) return null;

        text = text.substring(0, 10);
        try {
            return LocalDate.parse(text, DATE_FORMATTER);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return null;
        }
    }

    public static LocalDate convertCustomTextToDate(String text, String pattern) {
        if (ObjectUtils.isEmpty(text)) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            return LocalDate.parse(text, formatter);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return null;
        }
    }

    public static LocalDateTime convertTextToDateTime(String text) {
        if (ObjectUtils.isEmpty(text)) return null;

        try {
            return LocalDateTime.parse(text, DATE_FORMATTER_ISO);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return null;
        }
    }

    public static String convertDateToText(LocalDate date) {
        if (ObjectUtils.isEmpty(date)) return null;

        try {
            return DATE_FORMATTER.format(date);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String convertDateToText(LocalDateTime date) {
        if (ObjectUtils.isEmpty(date)) return null;

        try {
            return DATE_FORMATTER_ISO.format(date);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String convertDateToTextBr(LocalDateTime date) {
        if (ObjectUtils.isEmpty(date)) return null;

        try {
            return DATE_FORMATTER_BR.format(date);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String convertDateToTextBr(LocalDate date) {
        if (ObjectUtils.isEmpty(date)) return null;

        try {
            return DATE_FORMATTER_BR.format(date);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String convertDateToCustomText(LocalDateTime date, String format) {
        if (ObjectUtils.isEmpty(date)) return null;

        try {
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern(format);
            return sdf.format(date);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String convertDateToCustomText(LocalDate date, String format) {
        if (ObjectUtils.isEmpty(date)) return null;

        try {
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern(format);
            return sdf.format(date);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String getHumanReadableDateTime(LocalDateTime localDateTime) {
        if (ObjectUtils.isEmpty(localDateTime)) return null;

        try {

            return DATE_FORMATTER_DTHR_BR.format(localDateTime);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static String getHumanReadableDate(LocalDate localDate) {
        if (ObjectUtils.isEmpty(localDate)) return null;

        try {

            return DATE_FORMATTER_BR.format(localDate);
        } catch (Exception e) {
            log.error("Erro ao converter data", e);
            return "";
        }
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate getTodayDateRef() {
        return LocalDate.now();
    }

    public static LocalDateTime getStartOfTheDay(LocalDate date) {
        return date.atStartOfDay();
    }

    public static LocalDateTime getEndOfTheDay(LocalDate date) {
        return date.atTime(23, 59, 59);
    }

    public static LocalDateTime getTodayStartOfTheDay() {
        return LocalDate.now().atStartOfDay();
    }

    public static LocalDateTime getTodayEndOfTheDay() {
        return LocalDate.now().atTime(23, 59, 59);
    }

    public static LocalDate fromDateToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String convertDateToIsoZText(LocalDateTime localDateTime) {
        return DateUtils.convertDateToCustomText(localDateTime, ISO_Z_FORMAT);
    }
}
