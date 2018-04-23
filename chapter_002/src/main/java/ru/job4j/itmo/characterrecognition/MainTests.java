package ru.job4j.itmo.characterrecognition;

import java.io.IOException;

public class MainTests {

    public static void main(String[] args) throws IOException {
        Loader loader = new Loader();
        System.out.println(loader.getMap().get(0).toString());
        System.out.println(loader.getNumberOfRecognition(2).toString());
    }
}
