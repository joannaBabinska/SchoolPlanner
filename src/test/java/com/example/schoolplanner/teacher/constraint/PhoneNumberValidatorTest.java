package com.example.schoolplanner.teacher.constraint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @Test
    public void shouldReturnTrue() {
        assertTrue(phoneNumberValidator.isValid("345345354", null));
        assertTrue(phoneNumberValidator.isValid("25895114765", null));
        assertTrue(phoneNumberValidator.isValid(null, null));
    }

    @Test
    public void shouldReturnFalse() {
        assertFalse(phoneNumberValidator.isValid("34534535", null));
        assertFalse(phoneNumberValidator.isValid("258951147565", null));
        assertFalse(phoneNumberValidator.isValid("juytssdff", null));
        assertFalse(phoneNumberValidator.isValid("         ", null));
    }
}
