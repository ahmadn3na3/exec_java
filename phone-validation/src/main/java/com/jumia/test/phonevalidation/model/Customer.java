/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jumia.test.phonevalidation.model;

import lombok.Data;

/**
 *
 * @author ahmad
 */
@Data
public class Customer {
    private int id;
    private String name;
    private String phone;
    private boolean valid;
    private Country country;

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
