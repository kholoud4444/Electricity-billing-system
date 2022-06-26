package com.company;
import java.io.Serializable;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Admin <string> extends customer implements Serializable  {
   String password="1234";
     
    Admin (){
   
    }
    public void AddCustomer (){
        customer x = new customer();
        x.addCustomer();
        x.setEmailReadyToSend(true);
    }
    /*public void DeleteCustomer (string ID){
        customer x = new customer();
        x.deleteCustomer(ID);
    }
    /*public void updateCustomer(int oldID, customer newCustomerValues) {
        customer x = new customer();
        x.updateCustomer(metercode, newCustomerValues);
    }*/
   
    public double TotalCollected (){
        oldCustomer x = new oldCustomer();
        double total = x.totalCollected();
        return total;
    }
 /*public void addnewcustomer(String fName , String phone ,String nationalID,String address, int metercode,String email ,String region,int payment){
        customer x=new customer(fName,phone,nationalID,address,metercode,email,region,payment);
        if (x.addCustomer())
            System.out.println(x.toString()+"Add successfully.....!");
        else 
            System.out.println(x.toString()+"Faild.....!");
    }*/
}