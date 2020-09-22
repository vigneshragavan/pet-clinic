package com.vignesh.sfgpetclinic.bootstrap;

import com.vignesh.sfgpetclinic.model.*;
import com.vignesh.sfgpetclinic.services.OwnerService;
import com.vignesh.sfgpetclinic.services.PetTypeService;
import com.vignesh.sfgpetclinic.services.SpecialityService;
import com.vignesh.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService)
    {
        this.ownerService = ownerService;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }
    @Override

    public void run(String... args) throws Exception {

        int count =petTypeService.findAll().size();

        if(count==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("cat");
        PetType savedCatPetType=petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);
        Speciality surgery=new Speciality();
        surgery.setDescription("surgery");
        Speciality savedsurgery=specialityService.save(surgery);
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
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);
        Vet vet2 = new Vet();

        vet2.setFirstName("Vignesh");
        vet2.setLastName("Ragavan");
        vet2.getSpecialities().add(savedsurgery);
        vetService.save(vet2);

        System.out.println("loaded vets");
    }
}
