package com.vignesh.sfgpetclinic.services;

import com.vignesh.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner ,Long> {

    Owner findByLastName(String lastName);

}
