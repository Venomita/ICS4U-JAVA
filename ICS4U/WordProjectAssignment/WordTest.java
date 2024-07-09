package WordProjectAssignment;
import java.util.Scanner;

public class WordTest {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String userInput = keyboard.next(); // user's inputted word
        Word word1 = new Word(userInput); // testing other constructor
        System.out.println("You entered the word: " + word1.getWord()); // testing getWord
        System.out.println("The first letter of your word is: " + word1.getFirstLetter()); // testing getFirstLetter
        word1.removeFirstLetter();
        System.out.println("The word without the first letter is: " + word1.getWord()); // testing removeFirstLetter
        System.out.println("The last letter of your word is: " + word1.getLastLetter()); // testing getLastLetter
        word1.removeLastLetter();
        System.out.println("The word without the last letter is: " + word1.getWord()); // testing removeLastLetter
        System.out.print("Enter a letter to find: ");
        String letter = keyboard.next(); // letter to find
        int position = word1.findLetter(letter);
        if (position != -1) {
            System.out.println("The letter '" + letter + "' is found at position: " + position); // testing findLetter
        } else {
            System.out.println("The letter '" + letter + "' is not found in the word.");
        }
    }
}

