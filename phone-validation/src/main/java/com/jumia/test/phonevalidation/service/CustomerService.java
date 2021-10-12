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

        var countries = List.of(Country.CAMEROON, Country.ETHIOPIA, Country.UGANDA,
                Country.MOZAMBIQUE, Country.MOROCCO);
        for (Country country : countries) {
            if (country.hasCountryCode(phone)) {
                cus.setCountry(country);
                if (country.isvalidPhone(phone)) {
                    cus.setValid(true);
                }
                break;
            }
        }
        return cus;

    }

}
