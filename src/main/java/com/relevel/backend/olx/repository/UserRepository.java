package com.relevel.backend.olx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.relevel.backend.olx.model.*;

public interface UserRepository extends JpaRepository<User, Long> {

}