import java.util.*;
public class TrianglePathSum {
    /*
    Example 1:
        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        Output: 11
        Explanation: The triangle looks like:
           2
          3 4
         6 5 7
        4 1 8 3
        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

    Example 2:
        Input: triangle = [[-10]]
        Output: -10
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                arr[j] = Math.min(arr[j], arr[j+1]) + triangle.get(i).get(j);
            }
        }

        return arr [0];
    }
}
