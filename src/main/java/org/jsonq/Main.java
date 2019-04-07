package org.jsonq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception{

        File file = new File("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonq\\src\\main\\resources\\test.json");
        FileWriter writer = new FileWriter(file);
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);


        String st;
        while((st = br.readLine()) != null)
        {
            System.out.println(st);
        }

    }
}
