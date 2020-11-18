// These are the actual tests automatically run by autograder.
package edu.ga.setPractice1;

import java.lang.reflect.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
// This is an annotation for assigning point values to tests
import com.gradescope.jh61b.grader.GradedTest;

// Import anything else you need to run the tests, such as the students' classes

public class MyTestClass {

    // // Workaround so that MyTestClass can access private instance variables of Rectangle class.
    // public static int get(Rectangle r, String fieldName) throws NoSuchFieldException, IllegalAccessException {
    //   Field field = Rectangle.class.getDeclaredField(fieldName);
    //   field.setAccessible(true);
    //   return (int) field.get(r);
    // }

    // --- Problem #1: SetPractice.sortAndRemoveDuplicates --- //
    @Test
    @GradedTest(name="SetPractice.sortAndRemoveDuplicates - empty list", max_score=0.25)
    public void testSortAndRemoveEmpty() throws NoSuchFieldException, IllegalAccessException {

      assertEquals(Arrays.asList(), SetPractice.sortAndRemoveDuplicates(Arrays.asList()));

      System.out.println("Success: SetPractice.sortAndRemoveDuplicates works with empty list!");
    }

    @Test
    @GradedTest(name="SetPractice.sortAndRemoveDuplicates - size of 1 list", max_score=0.25)
    public void testSortAndRemoveSingle() throws NoSuchFieldException, IllegalAccessException {

      assertEquals(Arrays.asList(2), SetPractice.sortAndRemoveDuplicates(Arrays.asList(2)));

      System.out.println("Success: SetPractice.sortAndRemoveDuplicates works with singleton list!");
    }

    @Test
    @GradedTest(name="SetPractice.sortAndRemoveDuplicates - length", max_score=0.75)
    public void testSortAndRemoveLength() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
      assertEquals(Arrays.asList(-15, -3, 1, 2, 3, 4, 6, 7).size(), SetPractice.sortAndRemoveDuplicates(intList).size());

      System.out.println("Success: SetPractice.sortAndRemoveDuplicates - correct size!");
    }
    @Test
    @GradedTest(name="SetPractice.sortAndRemoveDuplicates - general", max_score=1.25)
    public void testSortAndRemoveGeneral() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
      assertEquals(Arrays.asList(-15, -3, 1, 2, 3, 4, 6, 7), SetPractice.sortAndRemoveDuplicates(intList));

      System.out.println("Success: SetPractice.sortAndRemoveDuplicates works with general List!");
    }

    // --- Problem #2: SetPractice.countCommon --- //


    @Test
    @GradedTest(name="SetPractice.countCommon - empty list1", max_score=.5)
    public void testcountCommonEmpty() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
      List<Integer> intList2 = Arrays.asList();
      assertEquals(0, SetPractice.countCommon(intList, intList2));

      System.out.println("Success: SetPractice.countCommon works with empty second input");
    }

    @Test
    @GradedTest(name="SetPractice.countCommon - nothing in common", max_score=1)
    public void testcountCommonNoCommon() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
      List<Integer> intList2 = Arrays.asList(0, 8, 9, 12, 15);
      assertEquals(0, SetPractice.countCommon(intList, intList2));

      System.out.println("Success: SetPractice.countCommon works with parameters without overlap");
    }

    @Test
    @GradedTest(name="SetPractice.countCommon - generic", max_score=1)
    public void testcountCommonGeneric() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
      List<Integer> intList2 = Arrays.asList(5,4,3,2,1,0,-1,-2,-3);
      assertEquals(5, SetPractice.countCommon(intList, intList2));

      System.out.println("Success: SetPractice.countCommon works generically");
    }


}
