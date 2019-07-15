/**
 * 
 */
package com.mind.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mind.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);

//	User findOne(Long id);
//
//	void delete(long id);
}
