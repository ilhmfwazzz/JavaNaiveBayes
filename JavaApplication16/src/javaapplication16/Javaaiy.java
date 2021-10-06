/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ilhmf
 */
public class Javaaiy {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       File file1 = new File("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\Data.csv");
            File file2 = new File("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\Data1.csv"); 
            char CharCounter = 0;       
            PrintWriter out;
        try (BufferedReader in = new BufferedReader(new FileReader(file1))) {
            out = (new PrintWriter(new FileWriter(file2)));
            int ch;
            while ((ch = in.read()) != -1){

                if (Character.isUpperCase(ch)){
                    Character.toLowerCase(ch);

                }
                out.write(ch);
                
                
            }
        }
            out.close();
      
    }
    
}
