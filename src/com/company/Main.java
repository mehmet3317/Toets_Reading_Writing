package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path path1 = Path.of("../../FromMehmetToPearl/Message.txt");
        Path path2 = Path.of("../../FromMehmetToPearl/Animal.txt");


        try {
            if (Files.notExists(path1.getParent())) {
                Files.createDirectory(path1.getParent());
                Files.createDirectory(path2.getParent());

            }

            if(Files.notExists(path1)){
                Files.createFile(path1);
                Files.createFile(path2);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path1.toString())
        )){

            bufferedWriter.write("Welk kledingstuk denkt alleen maar aan zichzelf?\n" +
                    "Antwoord: Asosjaal.”");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Lion lion = new Lion("KING",false);

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path2.toString())
        )){

            bufferedWriter.write(lion.getName()+" "+lion.getEdible());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fileReader = new FileReader(path2.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            String line;
            while ((line= bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}

