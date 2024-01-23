package com.task.the_raven.customer.validation.constraint;

import com.task.the_raven.customer.validation.validator.ContainsCharValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContainsCharValidator.class)
public @interface ContainsChar {

    char ch();

    String message() default "doesn't contain char exactly 1 times";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
