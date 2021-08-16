package com.lab.codefellowship.repositories;

import com.lab.codefellowship.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser,Integer> {
    ApplicationUser findByUsername(String username);

}
