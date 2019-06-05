package performance.filter.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address_book")
public class AddressBook {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "contact")
    Set<AddressBookContact> addressBookContacts;

    public AddressBook() {
    }

    public AddressBook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AddressBook(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressBookContacts=" + addressBookContacts +
                '}';
    }

    // getters/setters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<AddressBookContact> getAddressBookContacts() {
        return addressBookContacts;
    }

    public void setAddressBookContacts(Set<AddressBookContact> addressBookContacts) {
        this.addressBookContacts = addressBookContacts;
    }
}