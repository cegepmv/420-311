package dev.zaratechs.comparableComparator;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class TestFaker {

    public static void main(String[] args) throws Exception{

        Faker faker = new Faker();
        List<Client> list = new ArrayList<>();

        while (list.size() <5){
            Client c = new Client();
            c.setNumCompte(Utils.autoIncrement++);
            c.setNom(faker.name().lastName());
            c.setPrenom(faker.name().firstName());
            c.setSolde((int)(faker.random().nextDouble() * 1000) / 100.0);
           //  value = (int)(value * 100 + 0.5) / 100.0;
            list.add(c);
        }


        System.out.println(list);

    }

}
