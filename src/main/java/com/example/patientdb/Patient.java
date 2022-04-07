package com.example.patientdb;
import java.util.*;

public class Patient {
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