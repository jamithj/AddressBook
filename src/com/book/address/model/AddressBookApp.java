package com.book.address.model;

import com.book.address.exception.AddressBookException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jamit on 16/07/2017.
 */
public class AddressBookApp {

    private Map<Long, AddressBook> addressBooks;
    private String printContactsString;

    public void setPrintString(String in) {
        printContactsString = printContactsString + in;
    }

    public String getPrintString() {
        return printContactsString;
    }

    public AddressBookApp() {
        addressBooks = new ConcurrentHashMap<>();
    }

    public Map<Long, AddressBook> getAddressBooks() {
        return addressBooks;
    }

    public boolean isAddressBookExist(AddressBook addressBook) {
        return addressBooks.containsValue(addressBook);
    }

    public boolean addAddressBook(AddressBook addressBook) throws AddressBookException {
        try {
            if (!isAddressBookExist(addressBook)) {
                this.addressBooks.put(addressBook.getId(), addressBook);
                return isAddressBookExist(addressBook);
            } else {
                throw AddressBookException.create("Exception in adding a address book. Address book already exists.");
            }
        } catch (Exception e) {
            throw AddressBookException.create("Exception in adding a address book.", e);
        }
    }

    public String printUniqueContacts() throws AddressBookException {
        Map<Long, Contact> uniqueContacts = new HashMap<>();
        addressBooks.values().forEach(ab -> uniqueContacts.putAll(ab.getContacts()));
        uniqueContacts.values().forEach(c -> {
                    c.print();
                    setPrintString("");
                    setPrintString(c.getPrintString());
                }
        );
        return getPrintString();
    }

}
