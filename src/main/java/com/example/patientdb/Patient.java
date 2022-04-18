package com.example.patientdb;
import java.util.*;

public class Patient implements java.io.Serializable{
    private String firstName, lastName;
    private int age;
    private int whiteCellCount;
    private Date createdTime;

    public Patient(String fn, String ln, int a, int whiteCell){
        createdTime = new Date();
        firstName = fn;
        lastName = ln;
        age = a;
        whiteCellCount = whiteCell;
    }

    public int getWCellCount(){
        return whiteCellCount;
    }

    public int getAge(){
        return age;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String i) {
        this.firstName = i;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String i) {
        this.lastName = i;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public int getWhiteCellCount(){
        return whiteCellCount;
    }

    public void getOlder(){
        age++;
    }

    public Date getCreation() {
        return createdTime;
    }

    public String toString(){
        return lastName+", "+firstName+" ("+age+"): WBCC: "+whiteCellCount;
    }
}
