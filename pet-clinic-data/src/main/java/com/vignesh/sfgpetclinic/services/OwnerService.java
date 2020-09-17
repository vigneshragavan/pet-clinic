package com.vignesh.sfgpetclinic.services;

import com.vignesh.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner finfByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
