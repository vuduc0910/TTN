/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitracnghiem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuduc
 */
public class StudentsReader {
   private static final String COMMA_DELIMITER = ","; 
   public static void main(String[] args) {
 
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("data/students.csv"));
 
            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                printContry(parseCsvLine(line));
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }
 
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
 
    private static void printContry(List<String> account) {
        System.out.println(
                "Student [name= "
                + account.get(0) 
                + ", password= " + account.get(1) 
                + "]");
    }
}
