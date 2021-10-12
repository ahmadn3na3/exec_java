package com.jumia.test.phonevalidation.service;

import com.jumia.test.phonevalidation.model.Country;
import java.util.List;
import java.util.stream.Collectors;
import com.jumia.test.phonevalidation.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

    private final JdbcTemplate jdbcTemplate;

    public CustomerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.queryForList("select * from customer;").stream()
                .map(customerItem -> new Customer(
                        Integer.parseInt(customerItem.get("id").toString()),
                        customerItem.get("name").toString(), customerItem.get("phone").toString()))
                .map(this::validateCustomerPhone).collect(Collectors.toList());

    }

    private Customer validateCustomerPhone(Customer cus) {
        var phone = cus.getPhone();
        if (Country.CAMEROON.hasCountryCode(phone)) {
            cus.setCountry(Country.CAMEROON);
            if (Country.CAMEROON.isvalidPhone(phone)) {
                cus.setValid(true);
            }
            return cus;
        }
        if (Country.ETHIOPIA.hasCountryCode(phone)) {
            cus.setCountry(Country.ETHIOPIA);
            if (Country.ETHIOPIA.isvalidPhone(phone)) {
                cus.setValid(true);
            }
            return cus;
        }
        if (Country.UGANDA.hasCountryCode(phone)) {
            cus.setCountry(Country.UGANDA);
            if (Country.UGANDA.isvalidPhone(phone)) {
                cus.setValid(true);
            }
            return cus;
        }
        if (Country.MOROCCO.hasCountryCode(phone)) {
            cus.setCountry(Country.MOROCCO);
            if (Country.MOROCCO.isvalidPhone(phone)) {
                cus.setValid(true);
            }
            return cus;
        }
        if (Country.MOZAMBIQUE.hasCountryCode(phone)) {
            cus.setCountry(Country.MOZAMBIQUE);
            if (Country.MOZAMBIQUE.isvalidPhone(phone)) {
                cus.setValid(true);
            }
            return cus;
        }
        return cus;

    }

}
