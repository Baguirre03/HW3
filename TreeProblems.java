
/*
 * *** Ben Aguirre COMP 400C 001 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */
import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */

  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    // make tmp set to find the common elemenets (start with setA)
    TreeSet<Integer> commonElements = new TreeSet<Integer>(setA);
    // compare setA (common elements) to setB to see which elements are in both
    commonElements.retainAll(setB);
    // create res tree
    TreeSet<Integer> resTree = new TreeSet<Integer>(setA);
    // add all of set b to setA in result
    resTree.addAll(setB);
    // remove all common elements that are found above
    resTree.removeAll(commonElements);

    return resTree; // return resulting tree
  }

  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even.
   */

  public static void removeEven(Map<Integer, String> treeMap) {
    ArrayList<Integer> keys = new ArrayList<Integer>(); // create array to store keys
    // lopo through treeMap
    for (Map.Entry<Integer, String> mapElement : treeMap.entrySet()) {
      int key = (int) mapElement.getKey();
      if (key % 2 == 0) {
        // original was removing here form key but was getting error
        // instead add even key to an arraylist which we will loop through to delete
        // after
        keys.add(key);
      }
    }
    // remove all even keys from treeMap
    for (Integer key : keys) {
      treeMap.remove(key);
    }
  }

  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a
   * String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1, Map<Integer, String> tree2) {
    // check first if they are the same size
    if (tree1.size() != tree2.size()) {
      return false;
    }
    for (Map.Entry<Integer, String> mapElement : tree1.entrySet()) {
      int key = (int) mapElement.getKey(); // get key
      String tree1Value = mapElement.getValue(); // get value from tree1
      String tree2Value = tree2.get(key); // get value from tree2

      // compare the two string values
      // if they are not equal early return fals
      if (!tree1Value.equals(tree2Value)) {
        return false;
      }
    }
    // else we looped through all tree elements and none were different -> return
    // truee
    return true;
  }

} // end treeProblems class
