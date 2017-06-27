package com.example.spring.security.example.repository;

import com.example.spring.security.example.model.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkpk1234 on 2017/6/27.
 */
@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthority, Long> {
}
