package com.book.address.model;

import com.book.address.exception.AddressBookException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jamit on 16/07/2017.
 */
public class AddressBook {
    private Map<Long, Contact> contacts;
    private String printString;

    public AddressBook() {
        contacts = new ConcurrentHashMap<>();
    }

    public void setPrintString(String in){
        printString += in;
    }

    public String getPrintString(){
        return printString;
    }

    public Map<Long, Contact> getContacts(){
        return contacts;
    }

    public boolean isContactExist(Contact contact){
        return contacts.containsValue(contact);
    }

    public boolean addAContact(Contact contact) throws AddressBookException {
        try {
            this.contacts.put(contact.getId(), contact);
            return isContactExist(contact);
        } catch (Exception e) {
            throw AddressBookException.create("Exception in adding a contact to address book. ", e);
        }
    }

    public boolean removeAContact(Contact contact) throws AddressBookException {
        try {
            this.contacts.remove(contact.getId());
            return !isContactExist(contact);
        } catch (Exception e) {
            throw AddressBookException.create("Exception in removing a contact to address book. ", e);
        }
    }

    public String printContacts(){
        this.contacts.values().forEach(c -> setPrintString(c.print() + "\n"));
        return getPrintString();
    }
}
