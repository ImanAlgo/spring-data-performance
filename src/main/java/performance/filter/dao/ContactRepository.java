package performance.filter.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import performance.filter.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}