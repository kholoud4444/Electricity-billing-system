package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class FileManger implements Serializable{
   
 public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
         //   System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

           // System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
 } 
    
 public ArrayList<Object> read(String FilePath) {
        // Scanner input = new Scanner(System.in);

        Scanner Reader = null;
        try {
           // System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
      
            ArrayList<customer>  Customers = new ArrayList<customer>();
            customer x;

            while (Reader.hasNext()) {

                x = new customer();
                String Line = Reader.nextLine();
                String[] seprated = Line.split(" ");

               x.setFName(seprated[0]);
               x.setMName(seprated[1]);
               x.setlName(seprated[2]);
               x.setNationalID(seprated[3]);
              // x.setAddress(seprated[4]);
              x.setZipCode(Integer.parseInt(seprated[4]));
               x.setRegion(seprated[5]);
               
               x.setEmail(seprated[6]);
               x.setPhone(seprated[7]);
               x.setpayment(Double.parseDouble(seprated[8]));
               
            Customers.add(x);
            }
            return (ArrayList<Object>)(Object)Customers ;
}
 }