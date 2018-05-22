package com.shop.repository;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import com.shop.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    void deleteById(Long Id);

    Optional<User> findById(Long Id);

}
