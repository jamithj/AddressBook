package com.book.address.exception;

/**
 * Created by jamit on 16/07/2017.
 */
public class AddressBookException extends Exception{

    public AddressBookException (String message, Exception fault) {
        super(message, fault);
    }

    public static AddressBookException create(String message, Exception e) {
        System.out.println(message + e.getMessage());
        return new AddressBookException(message, e);
    }

    public static AddressBookException create(String message) {
        System.out.println(message);
        return new AddressBookException(message, new Exception(message));
    }
}
