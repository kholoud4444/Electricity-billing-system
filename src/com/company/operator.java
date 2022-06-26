package com.company;
import java.io.Serializable;




public class operator implements Serializable{
    private double totalCollected ;
    operator (){
    }
    int password=4321;
    public void collectPayments (int reading){
        
        customer x = new customer();
        if((reading)<=100)
            totalCollected = 2*(reading);
        else if((reading)>100 && (reading)<=300)
            totalCollected = 2*100 + (totalCollected-100)*3;
        else if((reading)>300)
        {
            totalCollected = 2*100 + 3*200 + (totalCollected-300)*5;
            totalCollected = totalCollected + 2.5*totalCollected/100;
        }
        x.setpayment(totalCollected);
    }
//    public void MeterCanceled (int meterCode){
//        oldCustomer x = new oldCustomer();
//        x.setMeterCode(meterCode);
//    }
}
