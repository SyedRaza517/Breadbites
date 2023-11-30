package com.breadbites.repositories;


import com.breadbites.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query(
            value = "SELECT * FROM customer_record record where record.email =:name and record.password =:password",
            nativeQuery = true
    )
    Registration findByNameAndPassword(@Param("name") String name, @Param("password") String password);


    Optional<Registration> findByEmail(String email);
}
