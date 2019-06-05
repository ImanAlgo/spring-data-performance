package performance.filter;

import performance.filter.dao.AddressBookContactRepository;
import performance.filter.dao.AddressBookRepository;
import performance.filter.dao.ContactRepository;
import performance.filter.entity.AddressBook;
import performance.filter.entity.AddressBookContact;
import performance.filter.entity.AddressBookContactKey;
import performance.filter.entity.Contact;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressBookContactRepository addressBookContactRepository;

    @Before
    public void setup() {

        contactRepository.saveAll(Arrays.asList(
                new Contact(1, "Iman", "123"),
                new Contact(2, "Elmira", "456"),
                new Contact(3, "John", "789"),
                new Contact(4, "Matt", "1289"),
                new Contact(5, "Mark", "4387"),
                new Contact(6, "Rez", "13098")
        ));
        contactRepository.flush();

        addressBookRepository.saveAll(Arrays.asList(
                new AddressBook(1, "Work" ),
                new AddressBook(2, "Friend" ),
                new AddressBook(3, "Close Friend" ),
                new AddressBook(4, "Family" )
        ));
        addressBookRepository.flush();

        addressBookContactRepository.saveAll(Arrays.asList(
                new AddressBookContact(new AddressBookContactKey(1l,1l)),
                new AddressBookContact(new AddressBookContactKey(1l,2l)),
                new AddressBookContact(new AddressBookContactKey(1l,3l)),
                new AddressBookContact(new AddressBookContactKey(2l,1l)),
                new AddressBookContact(new AddressBookContactKey(3l,4l)),
                new AddressBookContact(new AddressBookContactKey(4l,4l)),
                new AddressBookContact(new AddressBookContactKey(4l,3l)),
                new AddressBookContact(new AddressBookContactKey(5l,2l)),
                new AddressBookContact(new AddressBookContactKey(6l,3l)),
                new AddressBookContact(new AddressBookContactKey(6l,2l))
        ));
        addressBookContactRepository.flush();

    }

    @Test
    public void findAllContacts() {
        Contact[] expectedContacts = {
                new Contact(1, "Iman", "123"),
                new Contact(2, "Elmira", "456"),
                new Contact(3, "John", "789"),
                new Contact(4, "Matt", "1289"),
                new Contact(5, "Mark", "4387"),
                new Contact(6, "Rez", "13098")
        };
        List<Contact> actualContacts = contactRepository.findAll();
        MatcherAssert.assertThat(actualContacts
                , Matchers.containsInAnyOrder(expectedContacts));
    }

    @Test
    public void findAllAddressBooks() {
        AddressBook[] expectedAddressBooks = {
                new AddressBook(1, "Work" ),
                new AddressBook(2, "Friend" ),
                new AddressBook(3, "Close Friend" ),
                new AddressBook(4, "Family" )
        };
        List<AddressBook> actualAddressBooks = addressBookRepository.findAll();
        MatcherAssert.assertThat(actualAddressBooks
                , Matchers.containsInAnyOrder(expectedAddressBooks));
    }

    @Test
    public void findUniqueContacts() {
        Contact[] expectedContacts = {
                new Contact(2, "Elmira", "456"),
                new Contact(3, "John", "789"),
                new Contact(5, "Mark", "4387")
        };
        List<Contact> actualContacts = addressBookContactRepository.findUniqueContacts();
        MatcherAssert.assertThat(actualContacts
                , Matchers.containsInAnyOrder(expectedContacts));
    }

}