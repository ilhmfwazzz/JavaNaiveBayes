/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author ilhmf
 */
public class Cleansing {
    public static ArrayList<String> cleansingResult = new ArrayList();
    public ArrayList<String> list = new ArrayList();
    public static void main(String[] args){}
    
    public Cleansing() throws IOException{
        String csvFile = "C:\\Users\\ilhmf\\Desktop\\eqweqweasd.txt";
        BufferedReader br = null;
        String line = "";
        String completeSentence = "";
//        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\data_data.csv"));
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            
            int counter = 0;
            String rawSentence = "";
            while((line = br.readLine()) != null) {
                if (counter == 0){
                    counter++;
                } else {
                    String split[] = line.split(",");
                    int col1 = split[0].length();
                    int col2 = split[1].length();
                    int total = col1 + col2 + 2;
                    StringBuilder sb = new StringBuilder(line);
                    sb.replace(0, total, "");
                    rawSentence = sb.toString().toLowerCase();
                    StringTokenizer st = new StringTokenizer(rawSentence, "1234567890`~!@#$%^&*()-_+={}[]|;:'<>,.?/\"");
                    
                    while (st.hasMoreElements()) {
                        completeSentence += st.nextToken() + " ";
                    }
                    completeSentence = completeSentence.substring(0, completeSentence.length() - 9 );
                    cleansingResult.add(completeSentence);
                    list.add(split[1]);
                    counter++;
                }
            }
//           bw.write(completeSentence);
           
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                    
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
