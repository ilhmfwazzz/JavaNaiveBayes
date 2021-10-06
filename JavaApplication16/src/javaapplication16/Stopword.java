/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ilhmf
 */
public class Stopword {
    public ArrayList<String> resultStopword = new ArrayList<>();
     public static void main(String[] args){}
    public Stopword() throws IOException {
        Stemming stem = new Stemming();
        Cleansing clean = new Cleansing();
        ArrayList<String> temp = new ArrayList();
        PrintWriter pw = new PrintWriter("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\Data1.csv");
        File fr = new File("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\stopWord.txt");
        Scanner br = new Scanner(fr);
        while (br.hasNext()) {
            temp.add(br.next());
        }
        for (int x = 0; x < stem.resultStemming.size(); x++){
            String raw = stem.resultStemming.get(x);
            String[] split = raw.split(" ");
            String text;
            for (int a = 0; a < split.length; a++){
                String kata = split[a];
                for (int z = 0; z < temp.size(); z++){
                    if(kata.equals(temp.get(z))){
                    split[a] = "";
                }
                    System.out.println(z);
            }
            }
            
                pw.print(clean.list.get(x) + ",");
        for (int y = 0; y < split.length -1; y++){
            if (split[y].isEmpty()){
                
            } else {
                pw.print(split[y] + " ");
            }
        }
        pw.println();
        
            
        }
        pw.close();
    }
}
