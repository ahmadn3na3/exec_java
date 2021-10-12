package com.jumia.test.phonevalidation;

import com.jumia.test.phonevalidation.model.Country;
import java.util.List;
import com.jumia.test.phonevalidation.model.Customer;
import com.jumia.test.phonevalidation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
