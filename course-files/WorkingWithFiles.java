import java.io.*;
import java.util.Scanner;

public class WorkingWithFiles{
  public static void main(String[] args)
  throws FileNotFoundException{
  		File file = new File("textFile.txt");
  		Scanner input = new Scanner(file);
  		while(input.hasNextLine()){
  			String line = input.nextLine();
  			System.out.println(line);
  		}
  		input.close();
  }
}
