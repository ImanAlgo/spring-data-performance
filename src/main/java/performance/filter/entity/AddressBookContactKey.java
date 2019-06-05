package performance.filter.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class AddressBookContactKey implements Serializable {

    @Column(name = "contact_id")
    Long contactId;

    @Column(name = "address_book_id")
    Long addressBookId;

    public AddressBookContactKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookContactKey that = (AddressBookContactKey) o;
        return contactId.equals(that.contactId) &&
                addressBookId.equals(that.addressBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, addressBookId);
    }

    @Override
    public String toString() {
        return "AddressBookContactKey{" +
                "contactId=" + contactId +
                ", addressBookId=" + addressBookId +
                '}';
    }

    public AddressBookContactKey(Long contactId, Long addressBookId) {
        this.contactId = contactId;
        this.addressBookId = addressBookId;
    }

    public Long getContactId() {
        return contactId;
    }

    public Long getAddressBookId() {
        return addressBookId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setAddressBookId(Long addressBookId) {
        this.addressBookId = addressBookId;
    }
}