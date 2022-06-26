package com.company;

 import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Date ;
import java.util.concurrent.TimeUnit;
 
public class oldCustomer  <String> extends customer  {
   // private int meterCode ;
    
    private Date d1 = new Date();
    private Date d2 = new Date();
     
//    private final String oldCustomerFileData  = (String) "customer.txt";
  //  public static ArrayList<oldCustomer> oldCustomers = new ArrayList();


    oldCustomer (){
    }
    oldCustomer (String fName ,String mName,String lName,String phone ,String nationalID,String address, int zipCode,String email, String password ,String region,int meterCode /* double bill*/ ){
        //super(fName,mName,lName,phone,nationalID,address,zipCode,email,password ,region);
        //this.bill=bill;
        //this.meterCode=meterCode;
    }
    
//    public void setMeterCode (int meterCode){
//        this.meterCode=meterCode;
//    }
//    public int getMeterCode(int meterCode){
//        return this.meterCode;
//    }
   
    public double payBill (int meterCode){
     
        operator x = new operator() ;
        d1.getTime();
        return getpayment();
    }
    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void sendEmailWithin3M () throws MessagingException {
        d2.getTime();
        Mail x = new Mail();
        if (getDifferenceDays(d1 , d2) >= 90 ){
            x.generateAndSentMessage();
        }
    }
    public double totalCollected (){
        double totalCollected =0;
        for (int i=0;i<customers.size();i++){
            totalCollected=customers.get(i).getpayment();
        }
        return totalCollected;
    }
    private void LoadFromFile (){
        customers = (ArrayList<customer>) (Object) FManager.read(/*customerFileData*/"customer.txt");
    }
    private void commitToFile() {
        FManager.write(((customer)customers.get(0)).getAddCustomer(), "customers.txt", false);

        for(int i = 1; i < customers.size(); ++i) {
            FManager.write(( (customer) customers.get(i)).getAddCustomer(), "customers.txt", true);
        }

    }

    public void deleteMeterCode(int meterCode) {
        LoadFromFile();
        int index = getmetercode(meterCode);
        customers.remove(index);
        commitToFile();
    }
    
}