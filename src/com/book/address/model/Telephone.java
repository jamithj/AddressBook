package com.book.address.model;

/**
 * Created by jamit on 16/07/2017.
 */
public class Telephone {
    private String homeNumber;
    private String workNumber;
    private String mobileNumber;

    public Telephone() {
    }

    public Telephone(String mobileNumber){
        setMobileNumber(mobileNumber);
    }

    public Telephone(String homeNumber, String workNumber, String mobileNumber){
        setHomeNumber(homeNumber);
        setWorkNumber(workNumber);
        setMobileNumber(mobileNumber);
    }

    public void setHomeNumber(String number) {
        this.homeNumber = number;
    }

    public String getHomeNumber() {
        return this.homeNumber;
    }

    public void setWorkNumber(String number) {
        this.workNumber = number;
    }

    public String getWorkNumber() {
        return this.workNumber;
    }

    public void setMobileNumber(String number) {
        this.mobileNumber = number;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /** print: get telephone details print string
     *
     *  @return print string
     */
    public String print() {
        String printString = "";
        if (getHomeNumber() != null && getHomeNumber().length() != 0) { printString += "Home number: "+ getHomeNumber() + " ";}
        if (getWorkNumber() != null && getWorkNumber().length() != 0) { printString += "Work number: "+ getWorkNumber() + " ";}
        if (getMobileNumber().length() != 0) { printString += "Mobile number: "+ getMobileNumber();}
        return printString;
    }
}
