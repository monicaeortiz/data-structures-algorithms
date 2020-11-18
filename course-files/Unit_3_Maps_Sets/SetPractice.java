// package edu.ga.setPractice1;
package edu.ga.setPractice2;


import java.util.*;

public class SetPractice{

  public static void main(String[] args){
    List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);
    List<Integer> intList2 = Arrays.asList(5,4,3,2,1,0,-1,-2,-3);
    List<Integer> intList3 = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);


    System.out.println("intlist = " + intList);
    System.out.println("intlist2 = " + intList2);

    // System.out.println(sortAndRemoveDuplicates(intList));
    // System.out.println(countCommon(intList, intList2));


    // countUnique tests
    // System.out.println(countUnique(intList));
    // System.out.println(countUnique(intList2));
    // System.out.println(countUnique(Arrays.asList()));


    // symmetricSetDifference
    Set<Integer> set1 = new TreeSet<>(intList);
    Set<Integer> set2 = new TreeSet<>(intList2);
    Set<Integer> set3 = new TreeSet<>(intList3);


    System.out.println(set1);
    System.out.println(set2);
    System.out.println(symmetricSetDifference(set1, set3));
    System.out.println(set1);
    System.out.println(set2);

  }

  public static List<Integer> sortAndRemoveDuplicates(List<Integer> lst){
    Set<Integer> set = new TreeSet<>(lst);
    Integer[] arr = set.toArray(new Integer[0]);
    return Arrays.asList(arr);
  }

  public static int countCommon(List<Integer> lst1, List<Integer> lst2){
    Set<Integer> set1 = new TreeSet<>(lst1);
    Set<Integer> set2 = new TreeSet<>(lst2);
    set1.retainAll(set2);

    return set1.size();

  }

  public static int countUnique(List<Integer> lst){
    Set<Integer> set = new HashSet<>(lst);
    return set.size();
  }

  public static Set<Integer> symmetricSetDifference(Set<Integer> set1, Set<Integer> set2){
    Set<Integer> s1 = new HashSet<>(set1);
    Set<Integer> s2 = new HashSet<>(set2);

    // Symmetric difference of two sets
    Set<Integer> intersection = new HashSet<>(s1);
    intersection.retainAll(s2); // -> [b]
    Set<Integer> symmetricDifference = new HashSet<>(s1);
    symmetricDifference.addAll(s2);
    symmetricDifference.removeAll(intersection); // -> [a, c]
    return symmetricDifference;
  }

}
