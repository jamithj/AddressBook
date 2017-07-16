package com.book.address.model;

import java.util.Random;

/**
 * Created by jamit on 16/07/2017.
 */
public class Contact {
    private static final Random randomNumberGenerator = new Random(0);
    private Long id;
    private Customer customer;
    private Telephone telephone;

    public Contact(Customer customer, Telephone telephone) {
        setId(randomNumberGenerator.nextLong());
        setCustomer(customer);
        setTelephone(telephone);
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setTelephone(Telephone telephone){
        this.telephone = telephone;
    }

    public Telephone getTelephone(){
        return telephone;
    }
}
