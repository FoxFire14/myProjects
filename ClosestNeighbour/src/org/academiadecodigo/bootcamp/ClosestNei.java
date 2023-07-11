package org.academiadecodigo.bootcamp;

public class ClosestNei {

    public static void main(String[] args) {

        int[] myArray = {0, 5, 6, 2, 111, 112, 33};
        int smallest = 100000;
        int current = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < myArray.length -1; i++){


            current = ( Math.abs(myArray[i] - myArray[i+1]));
            if (current < smallest){
                smallest = current;
                a = myArray[i];
                b = myArray[i+1];

            }

        }System.out.println(a + " and " + b);



    }


}
