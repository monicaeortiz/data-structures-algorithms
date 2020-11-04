import java.util.*;
import java.io.*;

public class ProcessPoetry{
  public static void main(String[] args)
    throws FileNotFoundException{
    process("hamlet.txt", "hamlet_processed.txt", 10);
  }

  // take in file, number of words to find, and output file
  public static void process(String pathIn, String pathOut, int n)
    throws FileNotFoundException{
    // set up scanner and output file
    Scanner input = new Scanner(new File(pathIn));
    PrintStream p = new PrintStream(pathOut);

    // set up data structures to hold information
    ArrayList<String> words = new ArrayList<String>();
    ArrayList<Integer> counts = new ArrayList<Integer>();

    while(input.hasNext()){
      // want to take in each word
      String word = input.next();

      // delete any funny business in the word
      word = removeNonAlpha(word);


      // if word is valid...
      if (isValidWord(word)){
        int ind = words.indexOf(word);

        // if word is a repeat, add one to counts entry
        if (ind != -1){
          counts.set(ind, counts.get(ind) + 1);
        }
        // if a new word, add it to the list and set count to 1
        else{
          words.add(word);
          counts.add(1);
        }
      }
    }
    input.close();

    // create new ArrayList and write to file
    ArrayList<String> toSort = new ArrayList<String>();

    for (int i=0; i < words.size(); i++){
      String toFile = "" + counts.get(i) + " : " + words.get(i);
      p.println(toFile);
      toSort.add(toFile);
    }
    p.println();
    p.println();

    // sort and write to file
    // Collections.sort(toSort);
    // p.println(toSort);

  }

  // a word is valid if it isn't in all caps (would likely be a character name)
  public static boolean isValidWord(String word){
    // word is not all caps, which indicates character line
    if (word.equals(word.toUpperCase())){
      return false;
    }
    return true;
  }

  public static String removeNonAlpha(String word){
    return word.replaceAll("[^A-Za-z]+", "");
  }

}
