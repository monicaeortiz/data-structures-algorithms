import java.util.*;
import java.io.*;

public class RecursionPractice{
  public static void main(String[] args){
    // System.out.println("Math problem #1: f(9) = " + foo1(9));
    // System.out.println("Math problem #2: f(f(f(f(f(4))))) = " + foo2(foo2(foo2(foo2(foo2(4))))));
    // System.out.println("Math problem #3: triangles(1) = " + triangles(1));
    // System.out.println("Math problem #3: triangles(5) = " + triangles(5));
    // solveHanoi(3, 1, 2, 3);
    directoryCrawl(new File("/Users/mortiz/Documents/GitHub/data-structures-algorithms/"),0);

  }

  // math #1
  public static int foo1(int x){
    if(x >= 4){
      return foo1(foo1(x-2)+1);
    }
    else if (x >= 2 && x < 4){
      return foo1(x-1) - 1;
    }
    else{
      return x + 3;
    }
  }

  // math #2
  public static int foo2(int x){
    if(x > 3){
      return foo2(x - 3) + 3;
    }
    else if (x == 3){
      return 2 * x + 1;
    }
    else{
      return (int) Math.pow(x,2) + 2;
    }
  }

  // math #3
  public static int triangles(int n){
    if (n == 1){
      return 1;
    }
    else{
      return (int) Math.pow(3,n-1) + triangles(n-1);
    }
  }


  public static void solveHanoi(int n, int start, int auxiliary, int end) {
      if (n == 1) {
          System.out.println("Move the top disc on peg #" + start + " to peg #" + end);
      } else {
          solveHanoi(n - 1, start, end, auxiliary);
          System.out.println("Move the top disc on peg #" + start + " to peg #" + end);
          solveHanoi(n - 1, auxiliary, start, end);
      }
  }


  public static void directoryCrawl(File f, int indentLevel){
    //print the name of the current file/directory
    for(int i=0; i < indentLevel; i++){
      System.out.print("    ");
    }
    System.out.println(f.getName());

    // if f is a directory, then call again, incrementing the indentLevel
    if(f.isDirectory()){
      for(File subFile: f.listFiles()){
        directoryCrawl(subFile, indentLevel+1);
      }
    }
  }

}
