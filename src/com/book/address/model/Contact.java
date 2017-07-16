package com.book.address.model;

import java.util.Random;

import static com.book.address.Util.Util.randomNumberGenerator;

/**
 * Created by jamit on 16/07/2017.
 */
public class Contact {
    private Long id;
    private Customer customer;
    private Telephone telephone;
    private String printString;

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

    public void setPrintString(String inPrintString){
        this.printString = inPrintString;
    }

    public String getPrintString(){
        return printString;
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

    public void print(){
        setPrintString("");
        setPrintString("Customer: " + customer.print() + "Telephone: " + telephone.print() + "\n");
    }

}
