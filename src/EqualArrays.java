import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualArrays {
    boolean checkEqual(int[] a, int[] b) {
        // If lengths of array are not equal means
        // array are not equal
        if (a.length != b.length) return false;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;

        // If all elements were same.
        return true;
    }

    boolean checkEqualHashMap(int a[], int b[]) {
        int n = a.length, m = b.length;
        if (n != m)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(a[i]) == null)
                map.put(a[i], 1);
            else {
                count = map.get(a[i]);
                count++;
                map.put(a[i], count);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(b[i]))
                return false;
            if (map.get(b[i]) == 0)
                return false;
            count = map.get(b[i]);
            --count;
            map.put(b[i], count);
        }

        return true;
    }
}
