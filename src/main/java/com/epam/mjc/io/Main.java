package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/Profile.txt");
        Profile profile = FileReader.getDataFromFile(file);
        System.out.println(profile.getName());
        System.out.println(profile.getAge());
        System.out.println(profile.getEmail());
        System.out.println(profile.getPhone());
    }
}
