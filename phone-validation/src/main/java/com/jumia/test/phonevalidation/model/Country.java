/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jumia.test.phonevalidation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.NonNull;

/**
 *
 * @author ahmad
 */
@Getter
public class Country {

        public static final Country CAMEROON =
                        new Country("Cameroon", "+237", "\\(237\\)\\ ?[2368]\\d{7,8}$");
        public static final Country ETHIOPIA =
                        new Country("Ethiopia", "+251", "\\(251\\)\\ ?[1-59]\\d{8}$");
        public static final Country MOROCCO =
                        new Country("Morocco", "+212", "\\(212\\)\\ ?[5-9]\\d{8}$");
        public static final Country MOZAMBIQUE =
                        new Country("Mozambique", "+258", "\\(258\\)\\ ?[28]\\d{7,8}$");
        public static final Country UGANDA = new Country("Uganda", "+256", "\\(256\\)\\ ?\\d{9}$");

        private final String name;
        private final String countryCode;
        @JsonIgnore
        private final Pattern pattern;

        private Country(String name, String code, @NonNull String regex) {
                this.name = name;
                this.countryCode = code;
                this.pattern = Pattern.compile(regex);
        }

        public boolean isvalidPhone(String phone) {
                return this.getPattern().matcher(phone).matches();
        }

        public boolean hasCountryCode(String phone) {
                return phone.startsWith(this.getCountryCode().replace('+', '(') + ")");

        }

}
