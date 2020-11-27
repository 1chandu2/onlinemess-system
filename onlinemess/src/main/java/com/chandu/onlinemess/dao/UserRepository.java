package com.chandu.onlinemess.dao;

import com.chandu.onlinemess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUserName(@Param("userName") String username);

    public boolean existsByUserName(@Param("userName") String username);
}
