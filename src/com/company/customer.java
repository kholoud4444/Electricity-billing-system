package com.company;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Random;
import java.lang.Math;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
 import java.time.LocalDate;
import java.io.IOException;
import java.io.ObjectInputStream;
public class customer<String> extends FileMangerBinary implements Serializable {

    protected String fName;
    protected String mName;
    protected String lName;
    protected String phone;
    protected String nationalID;
    protected String address;
    public  int metercode;
    protected String email;
  
    protected String region;
    public double payment ;
    protected boolean emailReadyToSend;
    FileMangerBinary FManager = new FileMangerBinary();
    public Object logincu;
   

    public customer() {
    }

    private final java.lang.String CustomerFileData = "customer.bin";

    public static ArrayList<customer> customers = new ArrayList<customer>();

    customer(String fName, String mName, String lName, String phone, String nationalID, String address, int metercode, String email, String region, int payment) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.phone = phone;
        this.nationalID = nationalID;
        this.address = address;
        this.metercode=metercode;
        this.email = email;
        this.region = region;
        this.payment = payment;
    }

    customer(String fName, String phone, String nationalID, String address, int metercode, String email, String region,int payment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setpayment(double payment) {
        this.payment = payment;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setmetercode(int metercode) {
        this.metercode = metercode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setEmailReadyToSend(boolean emailReadyToSend) {
        this.emailReadyToSend = emailReadyToSend;
    }

    public String getFName() {
        return fName;
    }

    public String getMName() {
        return mName;
    }

    public String getLName() {
        return lName;
    }

    public String getPhone() {
        return phone;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getAddress (){
        return address;
    }
    public String getEmail() {
        return email;
    }

    public int getmetercode() {
         return metercode;
    }

    public String getRegion() {
        return region;
    }

    public boolean getEmailReadyToSend() {
        return emailReadyToSend;
    }

    public double getpayment() {
        return payment;
    }
//public void getpayment(int parseInt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getCustomerRegion() {
        return region;

    }

    public java.lang.String getAddCustomer() {
        return (getFName() + " " + getNationalID() + " " + getmetercode() + " " + getRegion() + " " + getEmail() + " " + getPhone() + " " + getpayment()+" "+getpayment());
    }

    private void LoadFromFile() {
        customers = (ArrayList<customer>) FManager.read(CustomerFileData);

    }

    private boolean commitToFile() {
        return FManager.write(CustomerFileData, customers);
    }

 

    public void meterIsReady() throws MessagingException {
        Mail x = new Mail();
        if (emailReadyToSend) {
            x.generateAndSentMessage();
        }
    }

   
  

    public boolean loginNew(String Pass) {
        if (Pass.equals("1234")) {
            return true;
        }
        return false;

    }


      private int getcusIndex(int metercode) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getmetercode() == metercode) {
                return i;
            }
        }

        return -1;
    }
    
     public boolean updateCustomer() {
        LoadFromFile();
           int index = this.getCustomerID(metercode);

        if (index != -1) {
            customers.set(index, this);

            return commitToFile();
        }

        return false;
    }
 

    
 
      public int getCustomerID(int metercode) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getmetercode() == metercode) {
                return i;
            }

        }
        return 0;
    }
      
      public customer searchBymetercode(int metercode) {
        customer temp = new customer();
        LoadFromFile();
        int index = getcusIndex(metercode);
        if (index != -1) {
            return customers.get(index);
        } else {
            return temp;
        }
    }

      public void deleteMeterCode(int meterCode) {
        LoadFromFile();
        int index = getCustomerID(metercode);
        customers.remove(index);
        commitToFile();
    }
       public boolean deleteCustomer(int metercode) {
        LoadFromFile();
        int index = this.getcusIndex(metercode);
         if (index != -1) {
            customers.remove(index);

            return commitToFile();
        }

        return false;
    }
      public boolean addCustomer() {
     // commitToFile() ;
     LoadFromFile();

        customers.add(this);
        return commitToFile();
    }

       public ArrayList<customer> listcustomers() {
        LoadFromFile();
        return customers;
    }
    
          
}
