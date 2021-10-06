/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;

/**
 *
 * @author ilhmf
 */
public class Stemming {
    public ArrayList<String> resultStemming = new ArrayList<>();
     public static void main(String[] args){}
    public Stemming() throws IOException {
        CaseFolding caseFolding = new CaseFolding();
        Set<String> dictionary = new HashSet<String>();
        InputStream in = Lemmatizer.class.getResourceAsStream("E:\\root-words.text");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null){
            dictionary.add(line);
        }
        Lemmatizer lemmatizer = new DefaultLemmatizer(dictionary);
        String completeWord = "";
        for (int a = 0; a < caseFolding.CaseFoldingResult.size(); a++){
            String kalimat = caseFolding.CaseFoldingResult.get(a);
            String[] splitKalimat = kalimat.split(" ");
            for (int b = 0; b < splitKalimat.length; b++){
                String stemWord = lemmatizer.lemmatize(splitKalimat[b]);
                completeWord += stemWord+ " ";
            }
            resultStemming.add(completeWord);
            completeWord = "";
            
        }
    }
}
