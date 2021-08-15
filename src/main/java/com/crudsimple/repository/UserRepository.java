package com.crudsimple.repository;

import com.crudsimple.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * a repository class to extend JPA repository which provide all
 * crud method default for that entity .
 * @author Aji Pramono
 * @version 1.0
 * @since 2021-08-16
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
