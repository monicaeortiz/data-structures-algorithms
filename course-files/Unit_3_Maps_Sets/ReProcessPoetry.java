import java.util.*;
import java.io.*;

public class ReProcessPoetry{
  public static void main(String[] args)
    throws FileNotFoundException{
    process("hamlet.txt", "hamlet_processed_v2.txt", 10);
  }

  // take in file, number of words to find, and output file
  public static void process(String pathIn, String pathOut, int n)
    throws FileNotFoundException{
    // set up scanner and output file
    Scanner input = new Scanner(new File(pathIn));
    PrintStream p = new PrintStream(pathOut);

    // set up data structures to hold information
    Map<String, Integer> wordFreq = new TreeMap<String, Integer>();

    while(input.hasNext()){
      // want to take in each word
      String word = input.next();

      // delete any funny business in the word
      word = removeNonAlpha(word);

      // if word is valid...
      if (isValidWord(word)){

        word = word.toUpperCase();
        // if word is a repeat, add one to counts entry
        if(wordFreq.containsKey(word)){
          wordFreq.put(word, wordFreq.get(word).intValue() + 1);
        }
        // if a new word, add it to the list and set count to 1
        else{
          wordFreq.put(word,1);
        }
      }
    }
    input.close();

    // write map to a file
    for(Map.Entry<String, Integer> entry: wordFreq.entrySet()){
      p.println(entry.getKey() + ":" + entry.getValue());
    }

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
    return word.replaceAll("[^A-Za-z']+", "");
  }

  public static void reverseProcess(String path);

}
