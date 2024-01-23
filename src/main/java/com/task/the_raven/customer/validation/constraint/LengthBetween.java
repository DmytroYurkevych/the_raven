package com.task.the_raven.customer.validation.constraint;

import com.task.the_raven.customer.validation.validator.LengthBetweenValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthBetweenValidator.class)
public @interface LengthBetween {

    int min();

    int max();

    String message() default "length is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
