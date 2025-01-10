import java.util.*;

public class LongestValidOrder {
    /**
     *
     * @param list -- i.e. ("P1", "P2", "D1", "D2")
     * @return output -- i.e [[P1, D1], [P2, D2]]
     */
    private static List<List<String>> isValid(List<String> list) {
        Set<List<String>> output = new HashSet<>();
        Set<String> set = new HashSet<>();

        for (String str : list) {
            char type = str.charAt(0);
            String num = str.substring(1);
            if (type == 'D') {
                String del = "P" + num;
                if (set.contains(del)) {
                    output.add(Arrays.asList(del,str));
                    set.remove(del);
                }
            }
            set.add(str);
        }
        return new ArrayList<>(output);
    }

    public static void main(String[] args){
        String[] orders = {"P1","D1","P1","D1"};

        HashMap<String,Integer> orderMap = new HashMap<>();
        ArrayList<String> previousOrderPickup = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i=0; i<orders.length; i++){
            if (orders[i].charAt(0) == 'P'){
                if (previousOrderPickup.isEmpty() || !previousOrderPickup.contains(orders[i])){
                    orderMap.put(orders[i],i);
                    previousOrderPickup.add(orders[i]);
                } else{
                    orderMap.clear();
                }
            } else{
                String start = 'P' + orders[i].substring(1);
                if (orderMap.containsKey(start)){
                    result.add(start);
                    result.add(orders[i]);
                    orderMap.remove(start);
                } else {
                    orderMap.clear();
                }
            }
        }

        System.out.println("Longest Valid Order: " + result);

        System.out.println(isValid(Arrays.asList("P1", "P2", "D1", "D2")));
        System.out.println(isValid(Arrays.asList("P1", "D1", "P2", "D2")));
        System.out.println(isValid(Arrays.asList("P1", "D2", "D1", "P2")));
        System.out.println(isValid(Arrays.asList("P1", "D2")));
        System.out.println(isValid(Arrays.asList("P1", "P2")));
        System.out.println(isValid(Arrays.asList("P1", "D1", "D1")));
        System.out.println(isValid(List.of()));
        System.out.println(isValid(Arrays.asList("P1", "P1", "D1")));
        System.out.println(isValid(Arrays.asList("P1", "P1", "D1", "D1")));
        System.out.println(isValid(Arrays.asList("P1", "D1", "P1")));
        System.out.println(isValid(Arrays.asList("P1", "D1", "P1", "D1")));
        System.out.println(isValid(Arrays.asList("P1", "D1", "P11", "D11")));
        System.out.println(isValid(Arrays.asList("P11", "D12", "P12", "D11")));
    }
}
