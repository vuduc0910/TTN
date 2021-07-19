/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitracnghiem;


import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.BufferedReader;
/**
 *
 * @author vuduc
 */
public class StudentWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "HoTen,MSSV,Diemso";
    public static void main(String[] args) {
 
        String fileName = "data/kq.csv";
        writeCsvFile(fileName);
    }
    public static void writeCsvFile(String fileName) {
        // Create new Countrys objects
        Account account1 = new Account("cauhoi1","dapan1,dapan2,dapan3,dapan4");
 
        // Create a new list of Country objects
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        FileWriter fileWriter = null;
 
        try {
            fileWriter = new FileWriter(fileName,true);
 
            // Write the CSV file header
            fileWriter.append(FILE_HEADER);
 
            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
 
            // Write a new Country object list to the CSV file
            for (Account account : accounts) {
                fileWriter.append("cauhoi1");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("dapan1-dapan2-dapan3-dapan4");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("dapan1");
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
 
            System.out.println("CSV file was created successfully !!!");
 
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
