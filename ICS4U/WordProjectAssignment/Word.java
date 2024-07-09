package WordProjectAssignment;

public class Word {
    private String myWord;

    public Word() {
        myWord = "";
    }

    public Word(String word) {
        myWord = word;
    }

    public String getWord() {
        return myWord;
    }

    public String getFirstLetter() {
        if (myWord.length() > 0) {
            return myWord.substring(0, 1);
        } else {
            return "";
        }
    }

    public String getLastLetter() {
        if (myWord.length() > 0) {
            return myWord.substring(myWord.length() - 1);
        } else {
            return "";
        }
    }

    public void removeFirstLetter() {
        if (myWord.length() > 0) {
            myWord = myWord.substring(1);
        }
    }

    public void removeLastLetter() {
        if (myWord.length() > 0) {
            myWord = myWord.substring(0, myWord.length() - 1);
        }
    }

    public int findLetter(String stringToFind) {
        return myWord.indexOf(stringToFind);
    }
}