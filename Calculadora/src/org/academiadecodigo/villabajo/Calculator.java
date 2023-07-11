package org.academiadecodigo.villabajo;

public class Calculator {

        private String brand;
        private String color;

        public Calculator(String brand, String color){
            this.brand = brand;
            this.color = color;


        }

        public int add (int number1, int number2) {


            int result = number1 + number2;
            return result;
        }

        public double add (double number1, double number2){
            return number1 + number2;


        }

        public String getBrand(){
            return this.brand;
        }
        public void setBrand(String brand){
            this.brand = brand;
        }

        public String getColor(){
            return this.color;
        }

        public void setColor(String color){
            this.color = color;
        }


        }
