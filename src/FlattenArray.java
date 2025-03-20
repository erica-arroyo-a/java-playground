import java.util.ArrayList;
import java.util.List;

/**
 * You are given an N-dimensional array (a nested list) and your task is to convert it into a 1D array.
 * The N-dimensional array can have any number of nested lists and each nested list can contain any number of elements.
 * The elements in the nested lists are integers.
 * Write a function that takes an N-dimensional array as input and returns a 1D array.
 *
 * Example 1:
 * Input:
 * array = [1, [2, 3], [4, [5, 6]], 7]
 * Output:
 * flatten_array(array) -> [1, 2, 3, 4, 5, 6, 7]
 *
 * Example 2:
 * Input:
 * array = [[1, 2], [3, 4], [5, 6]]
 * Output:
 * flatten_array(array) -> [1, 2, 3, 4, 5, 6]
 */
public class FlattenArray {

    // Helper function to flatten the nested list
    public static List<Integer> flatten(List<?> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (Object item : nestedList) {
            if (item instanceof List<?>) {  // If item is a nested list
                result.addAll(flatten((List<?>) item));  // Recurse and flatten
            } else {
                result.add((Integer) item);  // If item is an integer, add to result
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(1);
        List<Object> innerList1 = new ArrayList<>();
        innerList1.add(2);
        List<Object> innerList2 = new ArrayList<>();
        innerList2.add(3);
        innerList2.add(4);
        innerList1.add(innerList2);
        innerList1.add(5);
        nestedList.add(innerList1);
        List<Object> innerList3 = new ArrayList<>();
        innerList3.add(6);
        innerList3.add(7);
        List<Object> innerList4 = new ArrayList<>();
        innerList4.add(8);
        innerList4.add(9);
        innerList3.add(innerList4);
        nestedList.add(innerList3);
        nestedList.add(10);

        List<Integer> flattenedList = flatten(nestedList);
        System.out.println(flattenedList);  // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
