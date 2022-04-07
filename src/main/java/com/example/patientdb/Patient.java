package com.example.patientdb;
import java.util.*;

public class Patient {
    String last;
    String first;
    int age;
    public Patient (String l, String f, int a) {
        last = l;
        first = f;
        age = a;
    }
    public String getLast() {
        return last;
    }
    public String getFirst() {
        return first;
    }
    public int getAge() {
        return age;
    }
}
