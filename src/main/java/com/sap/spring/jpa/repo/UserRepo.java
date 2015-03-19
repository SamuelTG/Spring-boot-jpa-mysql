/**
 * 
 */
package com.sap.spring.jpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sap.spring.jpa.User;

/**
 * @author I303450
 *
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepo extends CrudRepository<User,Long>{

	 List<User> findByLastName(@Param("name") String name);
}
