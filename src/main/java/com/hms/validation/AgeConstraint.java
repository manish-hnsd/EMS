package com.hms.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AgeValidator.class})
public @interface AgeConstraint {

    String message() default "Invalid Age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
