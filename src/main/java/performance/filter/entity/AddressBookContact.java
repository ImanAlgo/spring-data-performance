package performance.filter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class AddressBookContact implements Serializable {

    @EmbeddedId
    private AddressBookContactKey id;

    @ManyToOne
    @MapsId("contact_id")
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @MapsId("address_book_id")
    @JoinColumn(name = "address_book_id")
    private AddressBook addressBook;

    public AddressBookContact() {
    }

    public AddressBookContact(AddressBookContactKey id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookContact that = (AddressBookContact) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AddressBookContact{" +
                ", contactId=" + contact +
                ", addressBookId=" + addressBook +
                '}';
    }

    public void setContactId(Contact contact) {
        this.contact = contact;
    }

    public void setAddressBookId(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
}
