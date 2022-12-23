package de.goll.components.converter;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements Converter<LocalDate, String> {

    @Override
    public Result<String> convertToModel(LocalDate localDate, ValueContext valueContext) {
        try {
            String date = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return Result.ok(date);
        } catch (Exception e) {
            return Result.error("Konvertierung nicht möglich!");
        }
    }

    @Override
    public LocalDate convertToPresentation(String s, ValueContext valueContext) {
        try {
            LocalDate localDate = LocalDate.parse(s);
            return localDate;
        } catch (Exception e) {
            return null;
        }

    }
}
