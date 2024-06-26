package ru.yandex.practicum.filmorate.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.yandex.practicum.filmorate.validation.constraints.FilmReleaseDateConstraint;

import java.time.LocalDate;

public class FilmReleaseDateValidator implements ConstraintValidator<FilmReleaseDateConstraint, LocalDate> {

    @Override
    public boolean isValid(LocalDate releaseDateField,
                           ConstraintValidatorContext cxt) {
        return releaseDateField != null
                && releaseDateField.isAfter(LocalDate.of(1895, 12, 28));
    }
}
