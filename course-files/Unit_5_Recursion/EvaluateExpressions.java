import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** This class contains methods to evaluate prefix and postfix expressions
  * recursively.
  */
public class EvaluateExpressions{
  public static void main(String[] args){
    System.out.println(evalPrefix("+ - / + 2 4 3 / - 9 1 2 / / * 8 3 * 6 2 ^ 1 - 4 1"));
    System.out.println(evalPostfix("2 4 * 8 4 / + 2 ^"));
  }

  // evaluate and return the integer answer of a prefix notation
  // Precondition: expression contains only these operators: + - * / ^
  // Precondition: expression contains only integer operands
  // Precondition: individual operators and operands are space-separated
  public static int evalPrefix(String s){
    // scan the String left -> for operator, operand, operand
    Pattern p = Pattern.compile(" [0-9]+ [0-9]+");   // the pattern to search for
    Matcher m = p.matcher(s);

    // isolate the substring of the first instance as this must be preceeded by an operator
    if (m.find()){
      int start = m.start(0)-1; // already captured the space, so subtract 1
      int end = m.end(0);

      String isolate = s.substring(start, end);

      String prefix = s.substring(0,start);
      String postfix = s.substring(end);

      // if isolate is the whole string, you're done
      if (isolate.equals(s)){
        return doPrefix(isolate);
      }
      else{
        return evalPrefix(prefix + doPrefix(isolate) + postfix);
      }
    }
    return 0;
  }

  // perform a single prefix notation operation
  public static int doPrefix(String s){
    // System.out.println(s);
    String operator = s.substring(0,1);

    // locate spaces to isolate operands
    int firstSpace = s.indexOf(" ");
    int secondSpace = s.indexOf(" ",firstSpace + 1);

    int op1 = Integer.parseInt(s.substring(firstSpace+1,secondSpace));
    int op2 = Integer.parseInt(s.substring(secondSpace+1));

    if (operator.equals("+")){
      return op1+op2;
    }
    else if(operator.equals("-")){
      return op1 - op2;
    }
    else if(operator.equals("*")){
      return op1 * op2;
    }
    else if(operator.equals("/")){
      return op1 / op2;
    }
    else{
      return (int) Math.pow(op1, op2);
    }
  }
  // evaluate and return the integer answer of a postfix notation
  // Precondition: expression contains only these operators: + - * / ^
  // Precondition: expression contains only integer operands
  // Precondition: individual operators and operands are space-separated
  public static int evalPostfix(String s){
    // scan the String left -> for operator, operand, operand
    Pattern p = Pattern.compile("[0-9]+ [0-9]+ ");   // the pattern to search for
    Matcher m = p.matcher(s);

    // isolate the substring of the last instance as this must be succeeded by an operator
    int start = 0, end = 0;
    while (m.find()){
      start = m.start();
      end = m.end() + 1; // already captured the space, so add 1
    }
    // isolate the String
    String isolate = s.substring(start, end);
    System.out.println("Isolated: " + isolate);

    String prefix = s.substring(0,start);
    String postfix = s.substring(end);

    // if isolate is the whole string, you're done
    if (isolate.equals(s)){
      return doPostfix(isolate);
    }
    else{
      return evalPostfix(prefix + doPostfix(isolate) + postfix);
    }
    // return 0;
  }

  // perform a single postfix notation operation
  public static int doPostfix(String s){
    String operator = s.substring(s.length()-1);

    // locate spaces to isolate operands
    int firstSpace = s.indexOf(" ");
    int secondSpace = s.indexOf(" ",firstSpace + 1);

    int op1 = Integer.parseInt(s.substring(0,firstSpace));
    int op2 = Integer.parseInt(s.substring(firstSpace+1, secondSpace));

    if (operator.equals("+")){
      return op1+op2;
    }
    else if(operator.equals("-")){
      return op1 - op2;
    }
    else if(operator.equals("*")){
      return op1 * op2;
    }
    else if(operator.equals("/")){
      return op1 / op2;
    }
    else{
      return (int) Math.pow(op1, op2);
    }
  }
}
