/*
 * CMPSC 261, Section 1
 * Fall 2016
 * Instructor: Phil O'Connell
 * TODO: DON'T FORGET TO PUT YOUR NAME AND ID
 * Student: Jhalak Patel
 * ID: jpp33
 */
package wheeloffortune;

import java.util.Scanner;

public class WheelOfFortune {

   public static void menu(){
        System.out.println("        MENU        ");
        System.out.println("----------------------");
        System.out.println("a - Spin the wheel");
        System.out.println("b - Buy a vowel");
        System.out.println("c - Solve the puzzle");
        System.out.println("d - Quit the game");
        System.out.println(" ");
    }

public static void main(String[] args) {
        char option;
        char letter;
        Scanner input = new Scanner(System.in);
       

        
        do{
            menu();
            System.out.print("Enter Your Choice: ");
            option = input.next().charAt(0);
            System.out.print(option);
            
            switch(option ){
         
             case 'a':
             case 'A':
                System.out.println(" : Spin the wheel");
                
                 System.out.print("Guess the letter: ");
                
                
                while (!input.hasNext("[A-Za-z]")) {
                 System.out.println("oops ! Guess agian..");
                 System.out.print("Guess the letter: ");
                 
                 input.next().charAt(0);
                 }
                letter = input.next().charAt(0);

     
                System.out.print("Guessed Letter: " + letter);
                System.out.println("");
                break;
                
            case 'b':
            case 'B':
                System.out.println(" : Buy a vowel");
                break;
                
            case 'c':
            case 'C':
                System.out.println(" : Solve the puzzle");
                break;
                
            case 'd':
            case 'D':
                System.out.println(" : Game Quit");
                break;
            
            default:
                System.out.println("Invalid option.");
            }
        } while(option != 'd' || option != 'D');
    }

    
    }


