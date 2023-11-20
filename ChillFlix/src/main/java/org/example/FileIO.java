package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<String> readMediaData(String path){
        ArrayList<String> data = new ArrayList<>();
        //Instantier filerne
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }

    public void saveUserData(User user){

    }


}
