package com.benjamin.sbs_jwt.repositories;

import com.benjamin.sbs_jwt.entities.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<OurUsers, Integer> {
    Optional<OurUsers> findByEmail(String email);
}
