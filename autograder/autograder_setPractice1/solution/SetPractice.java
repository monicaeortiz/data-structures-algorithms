package edu.ga.setPractice1;

import java.util.*;

public class SetPractice{

  public static void main(String[] args){
    List<Integer> intList = Arrays.asList(1,2,3,4,4,4,2,1,6,-3,2,7,-15);

    // List<Integer> intList = new ArrayList<Integer>(arr.length);
    // for (int i : arr)
    // {
    //     intList.add(i);
    // }

    List<Integer> intList2 = Arrays.asList(1, 2, 3);

    System.out.println("intlist = " + intList);
    System.out.println("intlist2 = " + intList2);

    System.out.println(sortAndRemoveDuplicates(intList));
    System.out.println(countCommon(intList, intList2));

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
}
