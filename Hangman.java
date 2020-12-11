/**
 * Liam McArdle
 * A simple game of hangman.
 */

import java.util.Scanner;//imports scanner
import java.util.Random;//imports random generator
import java.lang.*;//imports all lang

public class Hangman//makes main class
{
    public static void main(String[] args) //makes main code to execute
    {
        System.out.println('\u000C');//clears screen

        Scanner scanner = new Scanner(System.in);//makes new scanner
        Random randomNum1 = new Random();//makes random number
        Random randomNum2 = new Random();//makes random number

        String [][] game = new String[4][];//makes two dimensional array
        game[0] = new String[] {"FOOD","CHICKEN","BURGER","RICE","TOAST","STEAK"};//makes array of food
        game[1] = new String[] {"ANIMALS","CAT","DOG","IGUANA","LION","JAGUAR"};//makes array of animals
        game[2] = new String[] {"CITY","TORONTO","CALGARY","QUEBEC","BARRIE","WINDSOR"};//makes array of cities
        game[3] = new String[] {"COMPUTER BRAND","ACER","ASUS","APPLE","LENOVO","DELL"};//makes array on computer brands

        System.out.println("Welcome to hangman!");//welcomes user to game

        int  a = randomNum1.nextInt(3) + 0;//adds restrictions to random int
        int  b = randomNum2.nextInt(5) + 1;//adds restrictions to random int
        int i = 0;//makes int i for, for loops

        int numNotFound = 0;//makes int for checking if won game

        String randomCategory = game[a][0];//chooses random word category
        String randomWord = game[a][b];//chooses random word from the category

        char[] strArray = randomWord.toCharArray();//makes random word into a character array
        for(i = 0; i < strArray.length; i++) {
        }

        boolean[] found = new boolean[strArray.length];//makes boolean for the random word array
        for(i = 0; i < found.length; i++) {
            found[i] = false;
        }

        System.out.println("Your category is: "+randomCategory);//tells user the category of word

        int randomWordLength = (randomWord.length());//finds length of the random word

        int x = 0;//makes int for, for loops

        String line = "";//makes string for the lines

        while (x < randomWordLength) {//makes the line for guesses
            line += "_ ";
            x++;
        }
        System.out.println(line);//prints the line

        System.out.println("");//makes spacing
        System.out.println("");//makes spacing

        int tries = 10;//user only gets 10 tries
        int remainingTries = 0;//amount of tries left

        Boolean gameA = true;//makes boolean to keep game running on a condition
        do {
            char firstGuess = scanner.next().charAt(0);//takes the first letter 
            firstGuess = Character.toUpperCase(firstGuess);//changes the character entered into uppercase

            line = "";//clears line variable

            Boolean nxtPrint = false;//makes boolean to check if user won
            for (i = 0; i < strArray.length; i++) {//makes for loop checking if users guess is correct
                if (strArray[i] == firstGuess){
                    found[i] = true;
                    nxtPrint = true;
                }
            }
            numNotFound = 0;//resets value
            for (i = 0; i < found.length; i++){//replaces the blank with correct letter guess
                if (found[i])
                {
                    line = line + strArray[i] + " ";
                }
                else {
                    line = line + "_ ";
                    numNotFound++;
                }
            }

            if(nxtPrint){//runs code if guess is correct
                System.out.println('\u000C');//clears screen
                System.out.println("Your category is: "+randomCategory); //tells user the category again
                System.out.println("Your guess was "+firstGuess+" and that was right!");//tells user their guess was right
                System.out.println(String.valueOf(line));//prints the underscore blanks with correct letter in spot
                if (tries == 9){//prints base if one wrong
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("______");
                }
                if (tries == 8){//prints base and stem of 2 wrong
                    System.out.println("");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 7){//prints the full gallow 3 wrong 
                    System.out.println("   _______");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 6){//prints the gallow with head if 4 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 5){//prints gallow head and body if 5 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |      |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 4){//prints gallow head body and left arm if 6 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 3){//prints gallow head body and both arms if 7 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 2){//prints gallow head body arms and waist if 8 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |      |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 1){//prints gallow head body arms waist and left leg if 9 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |      |");
                    System.out.println("   |     |");
                    System.out.println("___|___");
                }
                if (tries == 0){//prints gallow and hung person of 10 wrong, which is all tries
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |      |");
                    System.out.println("   |    |   |");
                    System.out.println("___|___");
                    System.out.println("You are dead... Game Over...");
                    gameA = false;
                }
            }
            else if(!nxtPrint){//runs code of guess is wrong
                remainingTries = (tries -= 1);//subtracts one off of remaining tries every time
                System.out.println('\u000C');//clears screen
                System.out.println("Your category is: "+randomCategory+ ".");//tells user category
                System.out.println("Your guess was "+firstGuess+" and that was wrong!");//tells user their guess was wrong
                System.out.println(String.valueOf(line));//prints blanks with correct letter guesses
                System.out.println("You have "+remainingTries+ " tries left until you die.");//tells user remaining tries
                if (tries == 9){//prints base if one wrong
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("______");
                }
                if (tries == 8){//prints base and stem of 2 wrong
                    System.out.println("");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 7){//prints the full gallow 3 wrong 
                    System.out.println("   _______");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 6){//prints the gallow with head if 4 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 5){//prints gallow head and body if 5 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |      |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 4){//prints gallow head body and left arm if 6 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 3){//prints gallow head body and both arms if 7 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 2){//prints gallow head body arms and waist if 8 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |      |");
                    System.out.println("   |");
                    System.out.println("___|___");
                }
                if (tries == 1){//prints gallow head body arms waist and left leg if 9 wrong
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |      |");
                    System.out.println("   |     |");
                    System.out.println("___|___");
                }
                if (tries == 0){//prints gallow and hung person of 10 wrong, which is all tries
                    System.out.println("   _______");
                    System.out.println("   |      |");
                    System.out.println("   |      O");
                    System.out.println("   |    | | |");
                    System.out.println("   |      |");
                    System.out.println("   |    |   |");
                    System.out.println("___|___");
                    System.out.println("You are dead... Game Over...");//tells user they have lost
                    System.out.println("The word was "+randomWord);
                    gameA = false;//stops code from running as user has lost 
                }
            }
            if (numNotFound <= 0 ){//checks if numNotFound is smaller or equal to 0 and runs winning code
                System.out.println("You won!!");//tells user they won the game
                gameA = false;//stops code from running
            }
        }while (gameA);//end of do while loop
    }//end of public
}//end of code