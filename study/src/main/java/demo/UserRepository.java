package demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Long>  {
	List<User> findByIdAndAge(Long id);
	List<User> findByAgeAndName(String age, String name);
	
	
	@Query(value="select * from user where age = :age", nativeQuery= true)
	List<User> getUser(@Param(value="age") String age);
}
