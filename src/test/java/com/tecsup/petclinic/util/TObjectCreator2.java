package com.tecsup.petclinic.util;

import com.tecsup.petclinic.entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class TObjectCreator2 {

    public static Owner getOwner() {
        return new Owner(1, "John", "Doe", "1234 Main St", "New York", "555-1234");
    }

    public static Owner newOwner() {
        return new Owner(0, "Jane", "Smith", "4321 Oak St", "Los Angeles", "555-5678");
    }

    public static Owner newOwnerCreated() {
        Owner owner = newOwner();
        owner.setId(1000);
        return owner;
    }

    public static Owner newOwnerForUpdate() {
        return new Owner(0, "Michael", "Brown", "9876 Pine St", "Chicago", "555-9876");
    }

    public static Owner newOwnerCreatedForUpdate() {
        Owner owner = newOwnerForUpdate();
        owner.setId(4000);
        return owner;
    }

    public static Owner newOwnerForDelete() {
        return new Owner(0, "Alice", "Green", "6543 Maple St", "San Francisco", "555-4321");
    }

    public static Owner newOwnerCreatedForDelete() {
        Owner owner = newOwnerForDelete();
        owner.setId(2000);
        return owner;
    }

    public static List<Owner> getOwnersForFindByLastName() {
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner(1, "John", "Doe", "1234 Main St", "New York", "555-1234"));
        return owners;
    }

    public static List<Owner> getOwnersForFindByCity() {
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner(2, "Sarah", "Connor", "5678 Willow St", "Los Angeles", "555-5678"));
        owners.add(new Owner(3, "Rick", "Grimes", "4321 Elm St", "Los Angeles", "555-8765"));
        return owners;
    }
}
