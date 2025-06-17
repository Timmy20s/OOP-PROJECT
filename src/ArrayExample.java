package basics;

import java.util.Scanner;

public class ArrayExample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] myArray = {1, 3, 5, 7, 9};
        //or
        int[] anotherArray = new int[10];
        int sum = 0;
        String[] gender = {"Female", "Male"};
        //would prefer to focus on for loops over while loops
        for (int i= 0; i< myArray.length; i++){
            System.out.println("Item at: " +i+ " is " + myArray[i]);

            //to update the value of a variable eg.3
            myArray[1] = 13;
            anotherArray[5] = 17;

        for (int k = 0; k < anotherArray.length; k++) {
            System.out.println("Insert item at: " + k);
            anotherArray[k] = input.nextInt();
            System.out.println("Item at: " +k+ " is " + anotherArray[k]);

            //to look for an item, search
        for( int i = 0; i < anotherArray.length; i++){
            if (anotherArray[i] ==13);
            System.out.println("Found it");
            break;

            //use a for loop to get the sum of items within myArray
        for(int j=0; j< myArray.length; j++){
            sum += myArray[j];
            System.out.println("Sum = " + sum);
        }
        }
        }
        }
