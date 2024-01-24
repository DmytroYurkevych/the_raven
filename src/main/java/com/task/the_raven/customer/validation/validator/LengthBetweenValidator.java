package com.task.the_raven.customer.validation.validator;

import com.task.the_raven.customer.validation.constraint.LengthBetween;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LengthBetweenValidator implements ConstraintValidator<LengthBetween, String> {

    private LengthBetween lengthBetween;

    @Override
    public void initialize(LengthBetween constraintAnnotation) {
        lengthBetween = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.length() >= lengthBetween.min() && s.length() <= lengthBetween.max();
    }

}
