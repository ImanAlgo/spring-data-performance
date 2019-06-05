package performance.filter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import performance.filter.entity.AddressBookContact;
import performance.filter.entity.AddressBookContactKey;
import performance.filter.entity.Contact;

import java.util.List;

public interface AddressBookContactRepository extends JpaRepository<AddressBookContact, AddressBookContactKey> {

    @Query("SELECT c from Contact c WHERE c.id IN (SELECT ac.contact.id FROM AddressBookContact ac GROUP BY ac.contact HAVING COUNT(ac.contact)=1)")
    public List<Contact> findUniqueContacts();
}