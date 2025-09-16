package dev.zaratechs.comparableComparator;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Stagiaire {

    private int id;
    private String nom;
    private String département;
    private boolean aUnStage;

    public static void main(String[] args) {

        Faker faker = new Faker();

        List<Stagiaire> liste = new ArrayList<>();

        for (int i = 1; i <11 ; i++) {
            Stagiaire s = new Stagiaire();
            s.setId(i);
            s.setNom(faker.name().name());
            s.setDépartement(faker.company().name());

            liste.add(s);
        }

        System.out.println(liste);

    }



}
