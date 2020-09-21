package com.vignesh.sfgpetclinic.bootstrap;

import com.vignesh.sfgpetclinic.model.Owner;
import com.vignesh.sfgpetclinic.model.Pet;
import com.vignesh.sfgpetclinic.model.PetType;
import com.vignesh.sfgpetclinic.model.Vet;
import com.vignesh.sfgpetclinic.services.OwnerService;
import com.vignesh.sfgpetclinic.services.PetTypeService;
import com.vignesh.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);
        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("1,ram street");
        owner1.setCity("chennai");
        owner1.setTelephone("222900");
        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);




        PetType cat=new PetType();
        cat.setName("cat");
        PetType savedCatPetType=petTypeService.save(cat);
        Owner owner2 = new Owner();

        owner2.setFirstName("Vicky");
        owner2.setLastName("ragavan");
        owner2.setAddress("15,katcherrty street");
        owner2.setCity("trichy");
        owner2.setTelephone("92222900");
        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);
    System.out.println("loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");


        vetService.save(vet1);
        Vet vet2 = new Vet();

        vet2.setFirstName("Vignesh");
        vet2.setLastName("Ragavan");
        vetService.save(vet2);

        System.out.println("loaded vets");


    }
}
