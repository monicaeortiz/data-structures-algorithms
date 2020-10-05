import java.io.*;
import java.util.*;

public class FileProblems{
  public static void main(String[] args)
    throws FileNotFoundException{
    // countValues("numbers.txt");
    // System.out.printf("%4.1f\n",calcAverage("numbers.txt"));
    // System.out.println(calcAverages("numberArray.txt"));
    // countCoins(new Scanner(new File("monies.txt")));

    //reverseLines(new File("hamlet.txt"), "hamletInReverse.txt");
    // formatBdays("birthdays.txt", "formattedBirthdays.txt");
    printDuplicates(new Scanner(new File("dupText.txt")), "duplicates.txt");
  }

  // count the number of values in the file
  public static void countValues(String pathname)
    throws FileNotFoundException{
      Scanner input = new Scanner(new File(pathname));

      int count = 0;
      while(input.hasNextLine()){
        input.nextLine();
        count++;
      }
      input.close();
      System.out.println("count = " + count);
  }

  // averge numbers in the file and return that average as a double
  public static double calcAverage(String pathname)
    throws FileNotFoundException{
      Scanner input = new Scanner(new File(pathname));

      // set up counter variables
      int count = 0;
      int sum = 0;

      // while there are more lines...
      while(input.hasNextLine()){

        // add current value to sum and increment count
        sum += input.nextInt();
        input.nextLine();
        count++;
      }
      input.close();

      // calculate average
      return (double) sum / count;
  }

  // calculates the average of the integers in each line of a file and returns them in a list
  public static List<Double> calcAverages(String pathname)
    throws FileNotFoundException{
    ArrayList<Double> list = new ArrayList<Double>();
    Scanner input = new Scanner(new File(pathname));

    // while still more lines to process...
    while(input.hasNextLine()){
      // grab a line and put into a new Scanner
      Scanner line = new Scanner(input.nextLine());

      // process a single line
      int count = 0;
      int sum = 0;
      while (line.hasNextInt()){
        sum += line.nextInt();
        count++;
      }
      list.add((double) sum / count);

      line.close();
    }
    input.close();

    return list;
  }

  // Counts the total value of the coins within a file
  public static void countCoins(Scanner input){

    // set up counters
    double money = 0;
    String[] c = {"pennies", "quarters", "nickels", "dimes"};
    double[] vals = {0.01, 0.25, 0.05, 0.10};
    List<String> coins = new ArrayList<String>(Arrays.asList(c));

    // single line input with integer, String pairs
    while(input.hasNext()){
      int num = input.nextInt();
      String coin = input.next();

      // process tokens
      money += num * vals[coins.indexOf(coin)];
    }
    System.out.printf("Total money: $%4.2f\n",money);
  }

  // Creates a file where each line is the reverse of the
  public static void reverseLines(File f, String outputFile)
    throws FileNotFoundException{
    // set up PrintStream
    PrintStream p = new PrintStream(outputFile);

    // open file to Scanner
    Scanner input = new Scanner(f);

    // grab each lines
    while(input.hasNextLine()){
      String line = input.nextLine();
      String newString = "";

      // reverse the text
      for (int i = 0; i < line.length(); i++){
        newString = line.substring(i, i + 1) + newString;
      }
      p.println(newString);
    }
    input.close();
    p.close();
  }


  // reformat birthdays
  public static void formatBdays(String pathIn, String pathOut)
    throws FileNotFoundException{

      // array for months
      String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    // set up Scanner and PrintStream
    Scanner input = new Scanner(new File(pathIn));
    PrintStream p = new PrintStream(pathOut);

    // while there is still information to look at...
    while(input.hasNextLine()){

      // grab the next line and parse
      Scanner line = new Scanner(input.nextLine());

      // parse the line
      String last = line.next();
      last = last.substring(0,last.length()-1); // delete comma

      String first = line.next();

      // change delimiter and get date information
      line.useDelimiter("/");
      String month = line.next();
      String day = line.next();
      String year = line.next();

      p.println(first + " " + last + ": " + months[Integer.parseInt(month.substring(1))-1] + " " + day + ", " + year);

      line.close();
    }
    input.close();
    p.close();

  }

  // prints to a file the duplicate String and the number of duplicates from each line of the input Scanner
  public static void printDuplicates(Scanner input, String pathOut)
    throws FileNotFoundException{

    // set up PrintStream output
    PrintStream p = new PrintStream(pathOut);

    // while there are still more lines to process...
    while(input.hasNextLine()){
      // put the line into its own Scanner
      Scanner line = new Scanner(input.nextLine());

      // what is current word?
      String currentWord = line.next();
      // set up counter
      int count = 1;

      // while there are more words in the line...
      while(line.hasNext()){
        // grab the next line and compare to current.
        String newWord = line.next();

        // if it's the same as the current word, update counter
        if (newWord.equals(currentWord)){
          count++;
        }
        // if it's different from current word, reset current word and print to file if counter >= 2
        else{
          if (count >= 2){
            p.print(currentWord + "*" + count + " ");
          }
          currentWord = newWord;
          count = 1;
        }
      }
      // print newline to file and go onto next line
      p.println();
      line.close();
    }
    input.close();
    p.close();

  }
}
