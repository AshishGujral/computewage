package com.company;

import java.util.Scanner;

public class ComputeWage {




    //declare your data fields
    private String name;
    private double gtotal;
    private int hours;

    //create your getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    //method to acceptdata
    public void AcceptData(){

        //flag to detect non numeric entry
        boolean inputValid=false;

        Scanner key = new Scanner(System.in);
        System.out.println("Enter the name ");

        this.name = key.nextLine();


        while(!inputValid){
            System.out.println("Enter the hours ");
            String input = key.next();
            try {
                hours = Integer.parseInt(input);
                inputValid= true;
            } catch (NumberFormatException e){
                System.out.println("You didn't enter a valid number.");
            }


        }


    }

    public double ComputeWage(){

        if(this.hours > 40){
            //wage with over time
            this.gtotal = (40 * 15) + (16.5 * (this.hours-40));
        } else {
            //normal wage without overtime
            this.gtotal = this.hours * 15;
        }


        return this.gtotal;

    }

    // mehtod to display
    public void display(){

        System.out.println("The total wage of " + this.name + " is " + this.gtotal);


    }


}

