/*

 * CMPSC 261, Section 1

 * Fall 2016

 * Instructor: Phil O'Connell

 * TODO: DON'T FORGET TO PUT YOUR NAME AND ID

 * Student: Jhalak Patel

 * ID: jpp33

 */

package wheeloffortune;




import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.Random;

import java.util.Scanner;




public class WheelOfFortune {




    private static boolean matchLetter(List<String> secretWord, String dashes, char letter) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }




    Scanner input = new Scanner(System.in);




    private static final List<String> secretWord = Arrays.asList(

            "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"

    );

    private ArrayList<String> hiddenWord = new ArrayList();




    public static void displayGameName() {

        System.out.println("");

        System.out.println("                        =====================        ");

        System.out.println("                        == WHEEL OF FORTUNE ==        ");

        System.out.println("                        =====================        ");

    }




    public static void displayMenu() {

        System.out.println("1. Spin the wheel");

        System.out.println("2. Buy a vowel");

        System.out.println("3. Solve the puzzle");

        System.out.println("4. Quit the game");

        System.out.println("8. Toggle puzzle reveal");

        System.out.println("9. Test letter input");

        System.out.print("Enter Choice: ");

    }




    public int getMenuChoice() {

        return input.nextInt();

    }




    public String puzzleWord() {

        List<String> randomList = new ArrayList<>();

        randomList.add(" Hello JAVA ");




        Random random = new Random();




        return (randomList.get(random.nextInt(randomList.size())));




    }




    /* public static StringBuffer makeDashes(String s) {

        StringBuffer dashes = new StringBuffer(s.length());

        for (int count = 0; count < s.length(); count++) {

            dashes.append("_ ");

        }

        return dashes;

    }

 */

    public static void matchLetter(String secret, StringBuffer dashes, char letter) {

     char entry = ' ';

        for (int index = 0; index < secret.length(); index++) {

            if (secret.charAt(index) == letter) {

                dashes.setCharAt(index, letter);

            }

                else{

                

              dashes.setCharAt(index,entry);

            }

                

        }

        System.out.print("good guess - ");

    }

     

    public void guessLetter(String letter) {

        //Loop through the puzzle selected arraylist

        for (int i = 0; i < secretWord.size(); i++) {

            //If letter is in the index of puzzle selected, set the letter in the hidden puzzle to the correct guessed letter

            if (Arrays.asList(letter).contains(secretWord.get(i))) {

                hiddenWord.set(i, letter);




            }

        }

    }




    public static void main(String[] args) {




        int option;

        char letter = 0;

        String word;

        String dashes = null;




        Scanner input = new Scanner(System.in);




        do {

            WheelOfFortune wof = new WheelOfFortune();

            WheelOfFortune.displayGameName();

            System.out.println(secretWord.get(0).replaceAll("[a-zA-Z]", "_ "));

            System.out.println();

            WheelOfFortune.displayMenu();

            option = wof.getMenuChoice();




            switch (option) {




                case 1:




                    List<String> randomList = new ArrayList<>();

                    randomList.add("5000");

                    randomList.add("600");

                    randomList.add("500");

                    randomList.add("300");

                    randomList.add("500");

                    randomList.add("800");

                    randomList.add("550");

                    randomList.add("400");

                    randomList.add("300");

                    randomList.add("900");

                    randomList.add("500");

                    randomList.add("300");

                    randomList.add("900");

                    randomList.add("BANKRUPT");

                    randomList.add("600");

                    randomList.add("400");

                    randomList.add("300");

                    randomList.add("LOST A TURN");

                    randomList.add("800");

                    randomList.add("350");

                    randomList.add("450");

                    randomList.add("700");

                    randomList.add("300");

                    randomList.add("600");




                    Random random = new Random();




                    System.out.println("You landed on: " + randomList.get(random.nextInt(randomList.size())));




                    System.out.print("Enter a letter to guess: ");

                    letter =input.next().charAt(0);

                    

                   /* for (int i = 0; i < secretWord.size(); i++) {

                        //Print out the revealed letter at the index

                        System.out.print(WheelOfFortune.matchLetter(secretWord, dashes, letter));

                    }*/

                    break;

                case 2:

                    System.out.println(" : Buy a vowel");

                    break;




                case 3:

                    System.out.println(" : Solve the puzzle");

                    break;




                case 4:

                    System.out.println(" : Game Quit");

                    break;

                case 8:

                    for (int i = 0; i < secretWord.size(); i++) {

                        //Print out the revealed letter at the index

                        System.out.print(secretWord.add(secretWord.get(i)));

                    }

                    break;

                case 9:   

                    System.out.println("You have selected: " + letter);

                    break;

                default:

                    System.out.println("Invalid option.");

            }

        } while (option != 4);

    }




}