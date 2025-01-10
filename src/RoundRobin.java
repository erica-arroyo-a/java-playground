import java.util.ArrayList;
import java.util.List;

public class RoundRobin {

    public static List<Integer> getRoundRobinElements(List<List<Integer>> lists, int n) {
        List<Integer> result = new ArrayList<>();
        int listIndex = 0;

        while (result.size() < n) {
            if (listIndex >= lists.size()) {
                listIndex = 0;
            }

            List<Integer> currentList = lists.get(listIndex);
            if (!currentList.isEmpty()) {
                result.add(currentList.remove(0));
            }

            listIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(List.of(1, 2, 3)));
        lists.add(new ArrayList<>(List.of(4, 5)));
        lists.add(new ArrayList<>(List.of(6, 7, 8, 9)));

        int n = 5;
        List<Integer> result = getRoundRobinElements(lists, n);
        System.out.println(result); // Output: [1, 4, 6, 2, 5]
    }
}