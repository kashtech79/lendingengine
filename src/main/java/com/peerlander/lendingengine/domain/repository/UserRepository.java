package com.peerlander.lendingengine.domain.repository;

import com.peerlander.lendingengine.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
