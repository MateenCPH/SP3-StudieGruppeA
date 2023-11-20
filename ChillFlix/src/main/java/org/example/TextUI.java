package org.example;
import java.util.Scanner;


public class TextUI {
    private scanner scan = new scanner(System.in);

    public String getInput(String msg){
        this.(msg);
        return scan.nextLine();
    }

    public void displayMsg(String msg){
        System.out.println(msg);
    }
}
