package com.udemy.hibernateJpa.proxies;

import com.udemy.hibernateJpa.exceptions.InvalidFieldException;


public class BaseProxy {

    protected static void validateStringField(String fieldValue, int maxLength, String fieldName) {
        if (fieldValue == null) {
            throw new InvalidFieldException(String.format("%s cannot be null.", fieldName));
        }

        fieldValue = fieldValue.strip();

        if (fieldValue.isBlank() || fieldValue.length() > maxLength) {
            throw new InvalidFieldException(String.format("%s cannot be blank or over 50 characters", fieldName));
        }
    }

    protected static void validateIntegerValue(Integer fieldValue, Integer minValue, Integer maxValue, String fieldName) {
        if (fieldValue == null) {
            throw new InvalidFieldException(String.format("%s cannot be null.", fieldName));
        }

        if (fieldValue < minValue || fieldValue > maxValue) {
            throw new InvalidFieldException(String.format("%s has to be >= %d and <= %d", fieldName, minValue, maxValue));
        }
    }

    protected static void validateBooleanValue(Boolean fieldValue, String fieldName) {
        if (fieldValue == null) {
            throw new InvalidFieldException(String.format("%s cannot be null.", fieldName));
        }
    }
}
