package test.com.book.address.model;

/**
 * Created by jamit on 16/07/2017.
 */

import static junit.framework.Assert.assertEquals;

import com.book.address.model.Contact;
import com.book.address.model.Customer;
import com.book.address.model.Telephone;
import org.junit.Test;
import com.book.address.exception.AddressBookException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AddressBookTest {
    private Map<Long, Contact> contacts;

    public AddressBookTest() {
        contacts = new ConcurrentHashMap<>();
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

    Customer customer1 = new Customer("John", "Harris", "Paul");
    Telephone telephone1 = new Telephone("03 7856 9845", "03 9045 2346", "04 6733 3470");
    Contact contact1 = new Contact(customer1, telephone1);

    @Test
    public void testAddContact() throws AddressBookException{
        assertEquals(addAContact(contact1), true);
        assertEquals(getContacts().containsValue(contact1), true);
    }

    @Test
    public void testRemoveContact() throws AddressBookException{
        testAddContact();
        assertEquals(removeAContact(contact1), true);
        assertEquals(getContacts().containsValue(contact1), false);
    }


}
