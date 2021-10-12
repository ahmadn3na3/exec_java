package com.jumia.test.phonevalidation.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CountryTest {

    @Test
    public void testHasVaildCountryCode() {
        assertTrue(Country.CAMEROON.hasCountryCode("(237) 697151594"));
    }

    @Test
    public void testHasNotVaildCountryCode() {
        assertFalse(Country.CAMEROON.hasCountryCode("(212) 697151594"));
    }

    @Test
    public void testHasVaildPhone() {
        assertTrue(Country.CAMEROON.isvalidPhone("(237) 697151594"));
    }

    @Test
    public void testHasNotVaildPhone() {
        assertFalse(Country.CAMEROON.isvalidPhone("(237) 6A7151594"));
    }


}
