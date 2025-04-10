package com.backend.annotation;

import com.backend.validators.StateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StateValidator.class)
public @interface State {
    String message() default "状态只能是'已发布'或'草稿'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
