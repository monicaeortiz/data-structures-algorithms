// These are the actual tests automatically run by autograder.
package edu.ga.setPractice2;

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

    // --- Problem #1: SetPractice.countUnique --- //
    @Test
    @GradedTest(name="SetPractice.countUnique - empty list", max_score=0.5)
    public void testCountUniqueEmpty() throws NoSuchFieldException, IllegalAccessException {

      assertEquals(0, SetPractice.countUnique(Arrays.asList()));

      System.out.println("Success: SetPractice.countUnique works with empty list");
    }

    @Test
    @GradedTest(name="SetPractice.countUnique - no repeats", max_score=0.5)
    public void testCountUniqueNoRepeats() throws NoSuchFieldException, IllegalAccessException {

      assertEquals(5, SetPractice.countUnique(Arrays.asList(1,2,3,4,5)));

      System.out.println("Success: SetPractice.countUnique works with list - no repeats");
    }

    @Test
    @GradedTest(name="SetPractice.countUnique - generic", max_score=1.5)
    public void testCountUniqueGeneric() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);

      assertEquals(8, SetPractice.countUnique(intList));

      System.out.println("Success: SetPractice.countUnique works with list - generic");
    }


    // --- Problem #2: SetPractice.symmetricSetDifference --- //

    @Test
    @GradedTest(name="SetPractice.symmetricSetDifference - identical lists", max_score=.5)
    public void testSymmetricSetDifferenceIdentical() throws NoSuchFieldException, IllegalAccessException {
      List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
      List<Integer> intList2 = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);

      Set<Integer> set1 = new TreeSet<>(intList);
      Set<Integer> set2 = new TreeSet<>(intList2);
      Set<Integer> received = new TreeSet<>();

      assertEquals(received, SetPractice.symmetricSetDifference(set1, set2));
      assertEquals(set1, new TreeSet<>(intList));
      assertEquals(set2, new TreeSet<>(intList2));


      System.out.println("Success: SetPractice.countCommon works with empty second input");
    }

    @Test
    @GradedTest(name="SetPractice.symmetricSetDifference - nothing in common", max_score=.5)
    public void testSymmetricSetDifferenceNoCommon() throws NoSuchFieldException, IllegalAccessException {


      Set<Integer> set1 = new TreeSet<>(Arrays.asList(1,2,3,4,4,4,2,2));
      Set<Integer> set2 = new TreeSet<>(Arrays.asList(5,5,7,7,6,8,5,7,6));

      Set<Integer> expected = new TreeSet<>(Arrays.asList(1,2,3,4,5,6,7,8));
      Set<Integer> received = new TreeSet<>(SetPractice.symmetricSetDifference(set1, set2));
      assertEquals(expected, received);
      assertEquals(set1, new TreeSet<>(Arrays.asList(1,2,3,4,4,4,2,2)));
      assertEquals(set2, new TreeSet<>(Arrays.asList(5,5,7,7,6,8,5,7,6)));

      System.out.println("Success: SetPractice.symmetricSetDifference works with parameters with no overlap");
    }

    @Test
    @GradedTest(name="SetPractice.symmetricSetDifference - generic", max_score=1.5)
    public void testSymmetricSetDifferenceGeneric() throws NoSuchFieldException, IllegalAccessException {
      Set<Integer> set1 = new TreeSet<>(Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15));
      Set<Integer> set2 = new TreeSet<>(Arrays.asList(5,4,3,2,1,0,-1,-2,-3));

      Set<Integer> expected = new TreeSet<>(Arrays.asList(5,0,-1,-2,6,7,-15));
      Set<Integer> received = new TreeSet<>(SetPractice.symmetricSetDifference(set1, set2));

      assertEquals(expected, received);
      assertEquals(set1, new TreeSet<>(set1));
      assertEquals(set2, new TreeSet<>(set2));

      System.out.println("Success: SetPractice.symmetricSetDifference works generically");
    }


}
