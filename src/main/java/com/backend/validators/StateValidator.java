package com.backend.validators;

import com.backend.annotation.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class StateValidator implements ConstraintValidator<State,String> {

    private final List<String> validStates = Arrays.asList("已发布", "草稿");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }
        return validStates.contains(value);
    }
}
