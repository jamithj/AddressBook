package com.book.address.Util;

import java.util.Random;

/**
 * Created by jamit on 16/07/2017.
 */
public abstract class Util {
    public static final Random randomNumberGenerator = new Random(0);
    public enum AddressBookType {
        INDIVIDUAL,
        RETAIL,
        COPORATE
    }

}
