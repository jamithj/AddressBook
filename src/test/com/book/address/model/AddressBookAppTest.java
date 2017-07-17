package test.com.book.address.model;

import com.book.address.Util.Util;
import com.book.address.exception.AddressBookException;
import com.book.address.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamit on 16/07/2017.
 */
public class AddressBookAppTest {
    public AddressBookAppTest() {
    }

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
    private AddressBook addressBookIndividual = new AddressBook(Util.AddressBookType.INDIVIDUAL);
    private AddressBook addressBookCorporate = new AddressBook(Util.AddressBookType.COPORATE);
    private AddressBook addressBookRetail = new AddressBook(Util.AddressBookType.RETAIL);
    private AddressBookApp addressBookApp;
    private List<Contact> contactsList = new ArrayList<>();

    /** populateContactList: populating contact list.
     *
     *  @return List<Contact>
     *  @throws AddressBookException
     */
    private List<Contact> populateContactList(List<Contact> contactList){
        this.contactsList.add(contact1);
        this.contactsList.add(contact2);
        this.contactsList.add(contact3);
        return contactList;
    }

    /**
     * testAddAddressBook: Testing adding multiple address books to address book application.
     * @throws AddressBookException
     */
    @Test
    public void testAddAddressBook() throws AddressBookException {
        addressBookApp = new AddressBookApp();
        addressBookApp.addAddressBook(addressBookIndividual);
        assert(addressBookApp.getAddressBooks().containsValue(addressBookIndividual));
        addressBookApp.addAddressBook(addressBookCorporate);
        assert(addressBookApp.getAddressBooks().containsValue(addressBookCorporate));
        addressBookApp.addAddressBook(addressBookRetail);
        assert(addressBookApp.getAddressBooks().containsValue(addressBookRetail));
    }

    /**
     * testPrintUniqueContacts: Testing of printing unique set of contacts across all address books.
     * @throws AddressBookException
     */
    @Test
    public void testPrintUniqueContacts() throws AddressBookException {
        testAddAddressBook();
        contactsList = populateContactList(this.contactsList);
        addressBookApp.getAddressBooks().get(addressBookIndividual.getId()).addAContacts(contactsList);
        addressBookApp.getAddressBooks().get(addressBookCorporate.getId()).addAContacts(contactsList);
        addressBookApp.getAddressBooks().get(addressBookRetail.getId()).addAContacts(contactsList);
        String allContactsPrintString = addressBookApp.printUniqueContacts();
        System.out.println("All unique contacts of all address books: "+ allContactsPrintString);
    }
}
