package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.consts.ERole;
import com.fptu.edu.travelservices.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
