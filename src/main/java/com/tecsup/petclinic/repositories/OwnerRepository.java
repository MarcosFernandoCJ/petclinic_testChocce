package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

/**
 *
 * @author jgomezm
 *
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    // Fetch owners by first name
    List<Owner> findByFirstName(String firstName);

    // Fetch owners by last name
    List<Owner> findByLastName(String lastName);

    @Override
    List<Owner> findAll();

}
