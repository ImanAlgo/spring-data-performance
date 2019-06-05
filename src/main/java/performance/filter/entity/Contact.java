package performance.filter.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {

    // *** define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private  String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "addressBook")
    Set<AddressBookContact> addressBookContacts;

    // ***  define constructors

    public Contact() {

    }

    public Contact(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Contact(int id, String fullName, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                fullName.equals(contact.fullName) &&
                phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressBookContacts=" + addressBookContacts +
                '}';
    }

    // *** Setters and Getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<AddressBookContact> getAddressBookContacts() {
        return addressBookContacts;
    }

    public void setAddressBookContacts(Set<AddressBookContact> addressBooksContacts) {
        this.addressBookContacts = addressBooksContacts;
    }

}