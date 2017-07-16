package test.com.book.address.model;

/**
 * Created by jamit on 16/07/2017.
 */

import static junit.framework.Assert.assertEquals;

import com.book.address.model.AddressBook;
import com.book.address.model.Contact;
import com.book.address.model.Customer;
import com.book.address.model.Telephone;
import org.junit.Test;
import com.book.address.exception.AddressBookException;

public class AddressBookTest {

    Customer customer1 = new Customer("John", "Harris", "Paul");
    Telephone telephone1 = new Telephone("03 7856 9845", "03 9045 2346", "04 6733 3470");
    Contact contact1 = new Contact(customer1, telephone1);
    AddressBook addressBook = new AddressBook();

    @Test
    public void testAddContact() throws AddressBookException{
        assertEquals(addressBook.addAContact(contact1), true);
        assertEquals(addressBook.getContacts().containsValue(contact1), true);
    }

    @Test
    public void testPrintContacts() throws AddressBookException{
        testAddContact();
        String printContactsString = addressBook.printContacts();
        System.out.println("printContactsString: " + printContactsString);
        assertEquals(printContactsString.length() > 0, true);
    }

    @Test
    public void testRemoveContact() throws AddressBookException{
        testAddContact();
        assertEquals(addressBook.removeAContact(contact1), true);
        assertEquals(addressBook.getContacts().containsValue(contact1), false);
    }


}
