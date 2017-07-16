package com.book.address.model;

import com.book.address.exception.AddressBookException;
import test.com.book.address.model.AddressBookAppTest;

/**
 * Created by jamit on 17/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        AddressBookAppTest addressBookApp = new AddressBookAppTest();
        try {
            addressBookApp.testAddAddressBook();
            addressBookApp.testPrintUniqueContacts();
        } catch (AddressBookException e) {
            System.out.println(e.getMessage());
        }
    }
}
