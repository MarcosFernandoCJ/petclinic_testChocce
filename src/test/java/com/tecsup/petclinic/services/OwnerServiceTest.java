package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerService ownerService;

	@Test
	public void testFindOwnerById() {
		// Cambia el nombre esperado a uno que esté en los datos de prueba.
		String FIRST_NAME_EXPECTED = "George";  // Cambia "John" por "George".
		Integer ID = 1;

		Owner owner = null;

		try {
			owner = this.ownerService.findById(ID);
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		assertEquals(FIRST_NAME_EXPECTED, owner.getFirstName());
	}

	@Test
	public void testFindOwnerByFirstName() {
		String FIND_FIRST_NAME = "George"; // Cambia "John" por "George".
		int SIZE_EXPECTED = 1;

		List<Owner> owners = this.ownerService.findByFirstName(FIND_FIRST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	@Test
	public void testFindOwnerByLastName() {
		String LAST_NAME = "Davis"; // Cambia "Doe" por "Davis".
		int SIZE_EXPECTED = 2; // Asegúrate de que este número sea correcto según tus datos.

		List<Owner> owners = this.ownerService.findByLastName(LAST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	@Test
	public void testCreateOwner() {
		String FIRST_NAME = "Alice";
		String LAST_NAME = "Wonderland";
		String ADDRESS = "123 Some St";
		String CITY = "Lima";
		String TELEPHONE = "987654321";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);

		Owner ownerCreated = this.ownerService.create(owner);

		log.info("OWNER CREATED :" + ownerCreated.toString());

		assertNotNull(ownerCreated.getId());
		assertEquals(FIRST_NAME, ownerCreated.getFirstName());
		assertEquals(LAST_NAME, ownerCreated.getLastName());
		assertEquals(ADDRESS, ownerCreated.getAddress());
		assertEquals(CITY, ownerCreated.getCity());
		assertEquals(TELEPHONE, ownerCreated.getTelephone());
	}

	@Test
	public void testUpdateOwner() {
		String FIRST_NAME = "Tom";
		String LAST_NAME = "Cruise";
		String ADDRESS = "456 Hollywood Blvd";
		String CITY = "Los Angeles";
		String TELEPHONE = "123456789";

		String UP_FIRST_NAME = "Tommy";
		String UP_LAST_NAME = "Cruiser";
		String UP_ADDRESS = "789 New Address";
		String UP_CITY = "New City";
		String UP_TELEPHONE = "987654123";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);

		// ------------ Create ---------------
		log.info(">" + owner);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info(">>" + ownerCreated);

		// ------------ Update ---------------
		ownerCreated.setFirstName(UP_FIRST_NAME);
		ownerCreated.setLastName(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);

		// Execute update
		Owner updatedOwner = this.ownerService.update(ownerCreated);
		log.info(">>>>" + updatedOwner);

		assertEquals(UP_FIRST_NAME, updatedOwner.getFirstName());
		assertEquals(UP_LAST_NAME, updatedOwner.getLastName());
		assertEquals(UP_ADDRESS, updatedOwner.getAddress());
		assertEquals(UP_CITY, updatedOwner.getCity());
		assertEquals(UP_TELEPHONE, updatedOwner.getTelephone());
	}

	@Test
	public void testDeleteOwner() {
		String FIRST_NAME = "Michael";
		String LAST_NAME = "Jackson";
		String ADDRESS = "Neverland";
		String CITY = "Los Angeles";
		String TELEPHONE = "123123123";

		// ------------ Create ---------------
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		owner = this.ownerService.create(owner);
		log.info("" + owner);

		// ------------ Delete ---------------
		try {
			this.ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}

		// ------------ Validation ---------------
		try {
			this.ownerService.findById(owner.getId());
			assertTrue(false);
		} catch (OwnerNotFoundException e) {
			assertTrue(true);
		}
	}
}
