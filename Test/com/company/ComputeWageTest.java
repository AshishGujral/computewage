package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class ComputeWageTest {

    ComputeWage obj = new ComputeWage();
    @BeforeEach
    public void initEach(){
        ByteArrayInputStream in = new ByteArrayInputStream("Ashish\n35".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
    }

    @org.junit.jupiter.api.Test
    void acceptData() {
        obj.AcceptData();
      //  obj.ComputeWage();
        assertEquals("Ashish",obj.getName());
        assertEquals(35,obj.getHours());
    }

    @org.junit.jupiter.api.Test
    void computeWage() {
        obj.AcceptData();
        obj.ComputeWage();
        assertEquals(525,obj.getGtotal());
    }

    @Test
    void TestException(){
        ByteArrayInputStream in = new ByteArrayInputStream("Ashish\nxx\n35".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        obj.AcceptData();

        assertTrue(new String(captor.toByteArray()).contains("You didn't enter a valid number"));

        System.setOut(standardOut);
    }
    @org.junit.jupiter.api.Test
    void computeWagewithOT(){
        ByteArrayInputStream in = new ByteArrayInputStream("Ashish\n45".getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        obj.AcceptData();
        obj.ComputeWage();
        assertEquals(682.50,obj.getGtotal());

    }

    @org.junit.jupiter.api.Test
    void display() {
        obj.AcceptData();

        obj.ComputeWage();

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.display();

        assertEquals("The total wage of Ashish is 525.0",captor.toString().trim());
        System.setOut(standardOut);
    }
}