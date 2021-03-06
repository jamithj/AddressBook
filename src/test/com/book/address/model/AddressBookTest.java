package test.com.book.address.model;

/**
 * Created by jamit on 16/07/2017.
 */

import static junit.framework.Assert.assertEquals;

import com.book.address.Util.Util;
import com.book.address.model.AddressBook;
import com.book.address.model.Contact;
import com.book.address.model.Customer;
import com.book.address.model.Telephone;
import org.junit.Test;
import com.book.address.exception.AddressBookException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressBookTest {

    /** Populating test data.
     */
    private Customer customer1 = new Customer("John", "Harris", "Paul");
    private Telephone telephone1 = new Telephone("03 7856 9845", "03 9045 2346", "04 6733 3470");
    private Contact contact1 = new Contact(customer1, telephone1);
    private Customer customer2 = new Customer("Alice", "Tom", "Bell");
    private Telephone telephone2 = new Telephone("02 9745 2346", "02 8756 2345", "04 9834 8756");
    private Contact contact2 = new Contact(customer2, telephone2);
    private Customer customer3 = new Customer("Phill", "Louis");
    private Telephone telephone3 = new Telephone("04 9834 8756");
    private Contact contact3 = new Contact(customer3, telephone3);
    private AddressBook addressBook;

    /**
     * testAddContact: Contact should be able to add to the address book
     * @throws AddressBookException
      */

    @Test
    public void testAddContact() throws AddressBookException{
        addressBook = new AddressBook(Util.AddressBookType.INDIVIDUAL);
        assertEquals(addressBook.addAContact(contact1), true);
        assertEquals(addressBook.getContacts().containsValue(contact1), true);
    }

    /**
     *  testPrintContacts: Contacts of the address book is printable
     *  @throws AddressBookException
      */

    @Test
    public void testPrintContacts() throws AddressBookException{
        testAddContact();
        String printContactsString = addressBook.printContacts();
        System.out.println("printContactsString: " + printContactsString);
        assertEquals(printContactsString.length() > 0, true);
    }

    /**
     * testRemoveContact: Contact can be removed from the address book.
     * @throws AddressBookException
     */

    @Test
    public void testRemoveContact() throws AddressBookException{
        testAddContact();
        assertEquals(addressBook.removeAContact(contact1), true);
        assertEquals(addressBook.getContacts().containsValue(contact1), false);
    }

    /**
     * testAddContacts: Contacts can be added to the address book.
     * @throws AddressBookException
     */

    @Test
    public void testAddContacts() throws AddressBookException{
        addressBook = new AddressBook(Util.AddressBookType.INDIVIDUAL);
        List<Contact> contactsList = new ArrayList<>();
        contactsList.add(contact1);
        contactsList.add(contact2);
        contactsList.add(contact3);
        addressBook.addAContacts(contactsList);
        Map<Long, Contact> contacts =  addressBook.getContacts();
        assertEquals(contacts.size(), 3);
        assertEquals(contacts.containsValue(contact1), true);
        assertEquals(contacts.containsValue(contact2), true);
        assertEquals(contacts.containsValue(contact3), true);
    }

    /**
     * testRemoveContacts: Contacts can be removed from the address book.
     * @throws AddressBookException
     */

    @Test
    public void testRemoveContacts() throws AddressBookException{
        addressBook = new AddressBook(Util.AddressBookType.INDIVIDUAL);
        List<Contact> contactsList = new ArrayList<>();
        contactsList.add(contact1);
        contactsList.add(contact2);
        addressBook.addAContacts(contactsList);
        addressBook.removeAContacts(contactsList);
        Map<Long, Contact> contacts =  addressBook.getContacts();
        assertEquals(contacts.size(), 1);
    }


}
