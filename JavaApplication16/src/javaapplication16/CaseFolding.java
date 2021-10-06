/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.io.IOException;
import java.util.ArrayList;
public class CaseFolding {
    public ArrayList<String> CaseFoldingResult= new ArrayList();
     public static void main(String[] args){}
    
    public CaseFolding() throws IOException{
        Cleansing cleansing = new Cleansing();
        for (int a = 0; a < cleansing.cleansingResult.size(); a++){
            String toLower = cleansing.cleansingResult.get(a).toLowerCase();
            CaseFoldingResult.add(toLower);
        }
       
    }
    
}
