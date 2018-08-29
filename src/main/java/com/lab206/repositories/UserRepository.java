package com.lab206.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lab206.models.Comment;
import com.lab206.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
  
	@Query(value="SELECT * FROM users JOIN user_roles ON users.id = user_roles.user_id JOIN roles ON roles.id = user_roles.role_id WHERE roles.name = \"ROLE_USER\" OR roles.name = \"ROLE_MOD\" ORDER BY first_name;", nativeQuery=true)
	List <User> findAll();
	
	@Query("SELECT u.firstName FROM User u WHERE ?1 MEMBER OF u.comments")
	String findCommenterOfCommentFirstName(Comment comment);
	
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1%")
	List<User> findByFirstNameOrLastNameContaining(String keyword);

	List<User> findByOrderByPointsDesc();

}
