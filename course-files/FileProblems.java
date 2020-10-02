import java.io.*;
import java.util.*;

public class FileProblems{
  public static void main(String[] args)
    throws FileNotFoundException{
    countValues("numbers.txt");
    System.out.printf("%4.1f\n",calcAverage("numbers.txt"));
    System.out.println(calcAverages("numberArray.txt"));
    countCoins(new Scanner(new File("monies.txt")));
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


}
