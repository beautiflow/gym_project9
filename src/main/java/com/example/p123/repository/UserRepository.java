package com.example.p123.repository;

import com.example.p123.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String Username);

    Optional<User> findById(Long id);

    @Query("SELECT id from User")
    List<Long> findId();

    @Query("SELECT u.id from User u where u.username = :name")
    Long findIdByUserName(@Param("name") String name);
}
