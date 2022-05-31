package ru.kpfu.itis.skatingblog.converters;

import com.sun.istack.NotNull;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(@NotNull String dateInString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateInString, formatter);
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}