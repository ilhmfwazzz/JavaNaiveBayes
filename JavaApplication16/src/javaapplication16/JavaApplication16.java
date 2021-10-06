/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author ilhmf
 */
public class JavaApplication16 {

    ArrayList<String> data = new ArrayList();
    ArrayList<String> stopwords = new ArrayList<>();
    ArrayList<String> tdkTerkait = new ArrayList<>();
    ArrayList<String> singkatan1 = new ArrayList<>();
    ArrayList<String> singkatan2 = new ArrayList<>();
    String[] doc = {"C:\\Users\\ilhmf\\Desktop\\eqweqweasd.txt"};
            public JavaApplication16(){
                normalisasi();
                geraListaDeStopwords();
                processText();
                
            }
    public static void main(String[] args) {
        new JavaApplication16();
    }
    private void processText(){
        for(String s : doc){
            try{
                try(BufferedReader arq = new BufferedReader(new FileReader(s))){
                    while(arq.ready()){
                        String hasil = " "+arq.readLine()+" ";
                        hasil = hasil.toLowerCase();
                        hasil = hasil.replaceAll("[^a-zA-Z0-9_-]", " ");
                        
//                        s = s.replace(",", " ");
//                        s = s.replace("@", " ");
                        if(!relasi(hasil)){
                            for(int i = 0; i < 5;i++){
                                hasil = removerUrl(hasil);
                              
                                
                            }
                            hasil = removerStopwords(hasil);
                                hasil = normalisasiSingkatan(hasil);
                           
                           
                        }
                        if(hasil.charAt(0) == ' '){
                            hasil = hasil.substring(1);
                        }
                        if(hasil.endsWith(" ")){
                            hasil = hasil.substring(0, hasil.length() - 1 );
                        }
                        if(hasil == null || hasil.trim().isEmpty()){}
                        else{
                            data.add(hasil);
                        }
                        
                    }
                    System.out.println(s);
                }
            } catch (IOException e){
                System.out.println("!!! DATA COLLECTION NOT OK\n\n");
                System.exit(0);
            }
            try{
                try (PrintWriter writer = new PrintWriter("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\Data1.csv"+ s, "UTF-8")) {
                    for (int i = 0; i < data.size(); i++) {
                        writer.println(data.get(i));
                    }
                    System.out.println(" data.csv "+ s.toUpperCase()+ " OK");
                    Toolkit.getDefaultToolkit().beep();
                }
            } catch (IOException e) {
                System.out.println("!!! data.csv " + s.toUpperCase()+ " NOT OK\n\n");
            }
        }
    }
    private void kataTdkTerkait(){
        try{
            try(BufferedReader arq = new BufferedReader(new FileReader("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\stopWord.txt"))){
                while(arq.ready()){
                    String hasil = arq.readLine();
                    hasil = hasil.toLowerCase();
                    
                    tdkTerkait.add(hasil);
                }
                    System.out.println("generate related \n\n");
                }
            }catch (IOException e){
                System.out.println("No related \n\n");
                System.exit(0);
        }

    }
    public boolean relasi(String s){
        
        for (String key : tdkTerkait) {
            if (s.matches(".*\\b"+key+"\\b.*")) {
                return true;
            }
            System.out.println(s);
        }

        return false;
        
    }
    public static String removerUrl(String s){
        String aux ="";
        if (s.contains("http")) {
            if (s.contains("…")) {
                Integer http = s.indexOf("http");
                if (s.indexOf("…", http) != -1) {
                    aux = s.substring(s.indexOf("http"), s.indexOf("…", http)+1);
                    s = s.replace(aux, " ");
                }
            }
        }
        s = s.replaceAll("@\\s*(\\w+)", " ");
        return s;
    }
    public static String removerUrlRegex(String s){
        s = s.replaceAll("https?://.*?\\s+", "INICIO_LINK");
        if (s.contains("INICIO_LINK")) {
            String aux = s.substring(s.indexOf("INICIO_LINK"));
            s = s.replace(aux, " ");
        }
        return s;
    }
    private void geraListaDeStopwords(){
        try {
            
            try (BufferedReader arq = new BufferedReader(new FileReader("C:\\Users\\ilhmf\\Desktop\\Text Mining\\src\\stopWord.txt"))) {
                while(arq.ready()){
                    String linha = arq.readLine();
                    linha = linha.toLowerCase();
                    stopwords.add(linha);
                }
                System.out.println("GENERATE STOPWORDS OK\n\n");
            }
        } catch(IOException e) {
            System.out.println("!!! STOPWORDS NOT OK\n\n");
            System.exit(0);
        }
    }
    public String removerStopwords(String s){
        for (String key : stopwords) {
            
            if (s.matches(".*\\b"+key+".*\\b")) {
                s = s.replaceAll("\\b"+key+"\\b", " ");
            }
            
        }
        System.out.println(s);
        return s;
    }
    
    private void normalisasi(){
        try {
            
            try (BufferedReader arq = new BufferedReader(new FileReader("C:\\Users\\ilhmf\\Documents\\NetBeansProjects\\JavaApplication16\\kata_singkatan.txt"))) {
                while(arq.ready()){
                    String linha = arq.readLine();
                    linha = linha.toLowerCase();
                    singkatan1.add(linha);
                }
                System.out.println("!!!!!\n\n");
            }
        } catch(IOException e) {
            System.out.println("!!!!\n\n");
            System.exit(0);
        }
    }
    
    public String normalisasiSingkatan(String s){
         for (String a : singkatan1) {
            
            if (s.matches(".*\\b"+a+"\\b.*")) {
                s = s.replaceAll("\\b"+a+"\\b", "");
            }
            
        }
        
        return s;
    }
    
}

        
    
    

