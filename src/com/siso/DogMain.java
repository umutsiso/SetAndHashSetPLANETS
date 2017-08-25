package com.siso;

public class DogMain {

    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); //Labrador is instance of DOG
        System.out.println(rover.equals(rover2)); //DOG is not instance of Labrador
    }
}
