package com.task.the_raven.customer.validation.validator;

import com.task.the_raven.customer.validation.constraint.ContainsChar;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsCharValidator implements ConstraintValidator<ContainsChar, String> {

    ContainsChar containsChar;

    @Override
    public void initialize(ContainsChar constraintAnnotation) {
        containsChar = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }

        long charsCount = s.chars().filter(i -> i == containsChar.ch()).count();
        return charsCount == 1;
    }
}
