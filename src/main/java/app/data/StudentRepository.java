package app.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByName(String name);
}
