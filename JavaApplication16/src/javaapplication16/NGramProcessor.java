/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaapplication16.Unigram;


public class NGramProcessor {
public static void main(String[] args){}
    public NGramProcessor(){
    }

    public File insertUnknowns(File file, int k){
        BufferedReader br;
        File newFile = new File("C:\\Users\\ilhmf\\Documents\\NetBeansProjects\\JavaApplication16\\processUnk.txt");
        try{
            InputStream fis = new FileInputStream(file);
            Reader reader = new InputStreamReader(fis, Charset.defaultCharset());
            br = new BufferedReader(reader);
            Unigram unigram = new Unigram(file , k);
            HashSet unknownWords = unigram.unkWords;
            PrintWriter printWriter = new PrintWriter(newFile);
            String line;
            while((line = br.readLine()) != null){                              //for every line, replace all words in unkSet with <unk>
                Iterator<String> setIterator = unknownWords.iterator();
                while(setIterator.hasNext()){
                    Pattern uncommonWord = Pattern.compile(setIterator.next());
                    Matcher matcher = uncommonWord.matcher(line);
                    StringBuffer newLine = new StringBuffer();
                    while(matcher.find()){
                        matcher.appendReplacement(newLine, "<unk>");
                    }
                    matcher.appendTail(newLine);
                    line = newLine.toString();
                }
                printWriter.println(line);
            }
            printWriter.close();
        }
        catch (Exception e){
        }
        return  newFile;
    }
}

