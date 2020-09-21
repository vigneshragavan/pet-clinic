package com.vignesh.sfgpetclinic.bootstrap;

import com.vignesh.sfgpetclinic.model.Owner;
import com.vignesh.sfgpetclinic.model.PetType;
import com.vignesh.sfgpetclinic.model.Vet;
import com.vignesh.sfgpetclinic.services.OwnerService;
import com.vignesh.sfgpetclinic.services.PetTypeService;
import com.vignesh.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
    {
        this.ownerService = ownerService;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override

    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);
    System.out.println("loaded owner1");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");


        vetService.save(vet1);
        Vet vet2 = new Vet();

        vet2.setFirstName("Vignesh");
        vet2.setLastName("Ragavan");
        vetService.save(vet2);

        System.out.println("loaded vet1");

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType saveDogPetType=petTypeService.save(dog);
        PetType cat=new PetType();
        cat.setName("cat");
        PetType saveCatPetType=petTypeService.save(cat);
    }
}
