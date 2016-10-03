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

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import java.util.Random;

import java.util.Scanner;




/**

 *

 * @author jpatel9923

 */

public class WheelOfFortune {




  // To read from the keyboard

  private static final Scanner _keyboard = new Scanner(System.in);




  // Used to get random values for puzzle and wheel

  private static final Random _random = new Random();




  // True if we want to show all letters

  private static boolean revealLetters = false;

  

  private static int _winCash = 0;

  private static int _vowelCash = 250;

  private static char _charPuzzel=' ';

  

  

  //private static int revealLetters = false;




  /*

  * These are the wedges that are part of the wheel.

  * There are 24.  Some values can appear more than once

  */

  private static final List<String> _wedges = Arrays.asList(

      /* 01 */"$5000",

      /* 02 */ "$600",

      /* 03 */ "$500",

      /* 04 */ "$300",

      /* 05 */ "$500",

      /* 06 */ "$800",

      /* 07 */ "$550",

      /* 08 */ "$400",

      /* 09 */ "$300",

      /* 10 */ "$900",

      /* 11 */ "$500",

      /* 12 */ "$300",

      /* 13 */ "$900",

      /* 14 */ "BANKRUPT",

      /* 15 */ "$600",

      /* 16 */ "$400",

      /* 17 */ "$300",

      /* 18 */ "LOSE A TURN",

      /* 19 */ "$800",

      /* 20 */ "$350",

      /* 21 */ "$450",

      /* 22 */ "$700",

      /* 23 */ "$300",

      /* 24 */ "$600"

  );




  /*

  * The number of wedges will not change throughout the game

  * We can cache the value so we're not calling .size() over and over

  */

  private static final int _wedgeCount = _wedges.size();




  private static String chooseRandomWedgeValue() {

    // Choose a random index

    int randomWedgeIndex = _random.nextInt(_wedgeCount);

    //System.out.println("Money is :" +randomWedgeIndex);




    // Return the corresponding wedge

    return _wedges.get(randomWedgeIndex);

  }




  // The menu choices

  private static final List<String> _menuChoices = Arrays.asList(

      "1. Spin the wheel",

      "2. Buy a vowel",

      "3. Solve the puzzle",

      "4. Quit the game",

      "", // 5 possibly used in the future

      "", // 6 possibly used in the future

      "" // 7 possibly used in the future

      

  );

  private static final int _quitChoiceNumber = 4;




  // The different puzzles to choose from

  private static final List<String> _puzzles = Arrays.asList(

      "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",

      "PENN STATE ABINGTON",

      "INFORMATION SCIENCES AND TECHNOLOGY",

      "HOW ARE YOU",

      "ZOOM IN ZOOM OUT"

  );




  /*

  * The number of puzzles will not change throughout the game

  * We can cache the value so we're not calling .size() over and over

  */

  private static final int _puzzlesCount = _puzzles.size();




  /*

  * We will store the guessed letters in a hash map.

  * The "key" will be the character that was guessed

  * The "value" will be true/false

  *

  * Actually, the "value" aspect of this is not relevant.

  * Just the fact that a letter appears in the map as a key, is enough to imply

  * it was guessed.

  */

  private static Map<Character, Boolean> guessedLetters = new HashMap<>();




  /*

  * Given a puzzle, return a masked version, with hidden letters

  */

  private static String maskPuzzle(String puzzle, boolean revealLetters) {

    // Use a string builder, since Java strings are immutable

    StringBuilder maskedPuzzle = new StringBuilder();




    // For each letter in the puzzle

    for (int i = 0; i < puzzle.length(); i++) {

      // Current letter

      _charPuzzel = puzzle.charAt(i);




      /*

      * Either we're revealing all letters, or we've already guessed the

      * letter

      */

      boolean isLetterGuessed = revealLetters || guessedLetters.containsKey(_charPuzzel);




      /*

      * If the letter is not blank (we don't mask blanks), and the letter

      * has not been guessed, then we will mask it.

      */

      if (_charPuzzel != ' ' && !isLetterGuessed){

        _charPuzzel = '_';

      }

      

      // Put one space after each character (even a space) in the puzzle

      maskedPuzzle.append(_charPuzzel + " ");

    }




    // Convert the string builder to a string and return it

    return maskedPuzzle.toString();

  }




  // Choose a random puzzle

  private static String chooseRandomPuzzle() {

    // Choose a random puzzle index

    int randomPuzzleIndex = _random.nextInt(_puzzlesCount);




    //Return the corresponding puzzle

    return _puzzles.get(randomPuzzleIndex);

  }




  // Determine if the given number choice actually appears on the menu

  private static boolean isValidMenuChoice(int choice) {

    if ((choice < 1) || (choice > _menuChoices.size())) {

      return false;

    }




    // Subtrace 1 because arrays/lists are zero-based

    int index = choice - 1;

    String menuText = _menuChoices.get(index);




    return !menuText.equals("");

  }




  // Input a letter from the keyboard

  private static char inputLetter() {

    char letter = ' ';

    boolean finished = false;




    while (!finished) {

      System.out.print("Enter a letter: ");




      String line = _keyboard.nextLine();

      if (line.length() != 1) {

        System.out.println("Enter just one letter");

      } else {

        // Convert letter to upper case

        letter = Character.toUpperCase(line.charAt(0));

        if (!Character.isLetter(letter)) {

          System.out.println("That is not a letter");

        } 

        

        /*

        if(!guessedLetters.containsKey(letter)){

            

            System.out.println("Incorrect Letter -> You Loss");

            

        }*/

        if(guessedLetters.containsKey(letter)){

            

            System.out.println("Already Guessed, Enter another Letter");

            

        }

        else {

          // Will exit the loop

          finished = true;

          

          //System.out.println("You won " +);

        }

      }

    }




    return letter;

  }




  // Display the game menu, and handle the choices made

  private static void gameMenu() {

    // Choice from the menu

    int choice = 0;




    // Line entered from keyboard

    String line = "";




    // True when user wants to quit

    boolean quit = false;




    // Choose one of the puzzles at random

    String puzzle = chooseRandomPuzzle();




    // Repeat the menu until the user chooses to quit

    while (!quit) {

      System.out.println("                      ======================");

      System.out.println("                      =  Wheel Of Fortune  =");

      System.out.println("                      ======================");

      System.out.println("                                            ");




      System.out.println(maskPuzzle(puzzle, revealLetters));

      System.out.println();




      // Loop over the menu choices, and display each one

      for (String menuChoice : _menuChoices) {

        // Skip blank place-holder choices

        if (!menuChoice.equals("")) {

          System.out.println(menuChoice);

        }

      }

      System.out.print("Enter choice: ");

      line = _keyboard.nextLine();

      try {

        // If the input was not an integer, then that error will be caught

        choice = Integer.parseInt(line);

      } catch (NumberFormatException nfe) {

        // Error message, then go to the top of the loop

        System.out.println("Invalid input");

        continue;

      }




      // If not valid, then go back to the top of the loop

      if (!isValidMenuChoice(choice)) {

        System.out.println("Not a menu choice");

        continue;

      }




      System.out.println("You chose: " + _menuChoices.get(choice - 1));

      switch (choice) {

        case _quitChoiceNumber:

          // This will allow us to leave the menu loop

          quit = true;

          break;




        case 1: // Spin the wheel

            

            String str = chooseRandomWedgeValue();

            if(str.equals("BANKRUPT")){

                

                _winCash = 0;

                System.out.println("You landed on: " + str + " ->" +"Your cash is : $" +_winCash);

                break;

            }

          System.out.println("You landed on: " + str);

          char letter = inputLetter();

          

          

          System.out.println("Your letter is: " + letter);

          String won=str.substring(1);

          _winCash = Integer.parseInt(won);

         System.out.println("You Won: $" +_winCash);

          guessedLetters.put(letter, true);

          break;

          case 2:

              char vowel = inputLetter();

              if(_winCash < _vowelCash){

                  System.out.println("You don't have enough money to buy Vowel");

              break;

              }

              

              else

                  if(_winCash >=_vowelCash ){

                      

                      System.out.println("Enter vowel: " + vowel);

                      guessedLetters.put(vowel, true);

                      _winCash = _winCash - _vowelCash;

                      System.out.println("Your Cash is : $" + _winCash);

                      break;

                  }

              

              break;

              case 3:

                  

                    //System.out.println("Puzzle :" +puzzle + ":" +maskPuzzle(puzzle, revealLetters)) ;

                  for(int i=0; i< puzzle.length() ; i++){

                      //charPuzzel = puzzle.charAt(i);

                  char solve_puzzel = inputLetter();

                   guessedLetters.put(solve_puzzel, true);

                   if(!puzzle.contains(solve_puzzel+"")){

            _winCash = 0;

            System.out.println("Incorrect Letter -> You Loss" +" Your cash is : $" +_winCash);

            System.out.println("***GAME OVER***");

            System.exit(0);

           

            //System.exit(1);

            

        }

                 // guessedLetters.put(solve_puzzel, true);

                  String guess = maskPuzzle(puzzle, revealLetters);

                   System.out.println(guess);

                  String _nguess= guess.replaceAll("\\s+","");

                 

                  

                   String _pguess= puzzle.replaceAll("\\s+","");

                   //System.out.println("Match :" +_nguess +" :" +_pguess);

                  if(_nguess.equalsIgnoreCase(_pguess)){

                      

                      System.out.println("YOU WON!!!");

                      

                      System.exit(0);

                      

                      

                  }

                  

                  }

                  

                  break;

                  

             

/*

        case 8: // Toggle reveal letters

          revealLetters = !revealLetters;

          break;




        case 9: // Test to read in a letter from the keyboard

          System.out.println("Your letter is: " + inputLetter());

          break;*/

      }

    }

  }




  /**

   * @param args the command line arguments

   */

  public static void main(String[] args) {

    gameMenu();

  }




}