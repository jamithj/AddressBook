package com.book.address.model;

import com.book.address.exception.AddressBookException;

import java.util.HashMap;
import java.util.List;
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

    public Map<Long, Contact> populateContactsMap(List<Contact> contacts) throws AddressBookException {
        Map<Long, Contact> contactList = new HashMap<>();
        try {
            if (!contacts.isEmpty()) {
                for (int i = 0; i < contacts.size(); i++) {
                    contactList.put(contacts.get(i).getId(), contacts.get(i));
                }
            } else {
                System.out.println("Empty contact list provided");
            }
            return contactList;
        } catch (Exception e) {
            throw AddressBookException.create("Exception in populating contacts map in address book. ", e);
        }
    }

    public void addAContacts(List<Contact> contacts) throws AddressBookException {
        try {
            Map<Long, Contact> contactsMap = populateContactsMap(contacts);
            if (!contactsMap.isEmpty())
                this.contacts.putAll(contactsMap);
        } catch (Exception e) {
            throw AddressBookException.create("Exception in adding contacts to address book. ", e);
        }
    }

    public List<Contact> removeAContacts(List<Contact> contacts) throws AddressBookException {
        try {
            if (!contacts.isEmpty()) {
                for (int i = 0; i < contacts.size(); i++) {
                    if (this.contacts.remove(contacts.get(i).getId()) == contacts.get(i)) {
                        contacts.remove(i);
                    }
                }
            } else {
                System.out.println("Empty contact list provided");
            }
            return contacts;
        } catch (Exception e) {
            throw AddressBookException.create("Exception in adding contacts to address book. ", e);
        }
    }

    public String printContacts(){
        this.contacts.values().forEach(c -> setPrintString(c.print() + "\n"));
        return getPrintString();
    }
}
