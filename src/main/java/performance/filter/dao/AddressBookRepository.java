package performance.filter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import performance.filter.entity.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook,Integer> {

}