package com.subrutin.lingkar.catalog.validator;

import java.time.LocalDate;

import com.subrutin.lingkar.catalog.validator.annotation.PastTime;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


@ApplicationScoped
public class PastTimeValidator implements ConstraintValidator<PastTime, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        LocalDate date = LocalDate.ofEpochDay(value);
        LocalDate now = LocalDate.now();
        return date.isBefore(now);
    }

}
