import java.util.*;

public class ValidateOrdersPath {
    public static boolean isValid(List<String> orders){
        Set<Character> p_set = new HashSet<>(), d_set = new HashSet<>();
        char pickup = 'P', delivery = 'D';

        for (String order : orders){
            char task_type = order.charAt(0);
            char task_num = order.charAt(1);
            if (task_type == pickup){
                if (p_set.contains(task_num)){
                    return false;
                }
                p_set.add(task_num);

            } else if (task_type == delivery){
                if (d_set.contains(task_num) || !p_set.contains(task_num)){
                    return false;
                }

                d_set.add(task_num);
            } else {
                return false;
            }
        }

        return p_set.size() == d_set.size();

    }


    public static void main(String[] args){

        ValidateOrdersPath vop = new ValidateOrdersPath();
        System.out.println(Arrays.asList("P1", "P2", "D1", "D2") + " --> " + vop.isValid(Arrays.asList("P1", "P2", "D1", "D2")));
        System.out.println(Arrays.asList("P1", "D1", "P2", "D2") + " --> " + vop.isValid(Arrays.asList("P1", "D1", "P2", "D2")));
        System.out.println(Arrays.asList("P1", "D2", "D1", "P2") + " --> " + vop.isValid(Arrays.asList("P1", "D2", "D1", "P2")));
        System.out.println(Arrays.asList("P1", "D2") + " --> " + vop.isValid(Arrays.asList("P1", "D2")));
        System.out.println(Arrays.asList("P1", "P2") + " --> " + vop.isValid(Arrays.asList("P1", "P2")));
        System.out.println(Arrays.asList("P1", "D1", "D1") + " --> " + vop.isValid(Arrays.asList("P1", "D1", "D1")));
        System.out.println(Arrays.asList() + " --> " + vop.isValid(Arrays.asList()));
        System.out.println(Arrays.asList("P1", "P1", "D1") + " --> " + vop.isValid(Arrays.asList("P1", "P1", "D1")));
        System.out.println(Arrays.asList("P1", "P1", "D1", "D1") + " --> " + vop.isValid(Arrays.asList("P1", "P1", "D1", "D1")));
        System.out.println(Arrays.asList("P1", "D1", "P1") + " --> " + vop.isValid(Arrays.asList("P1", "D1", "P1")));
        System.out.println(Arrays.asList("P1", "D1", "P1", "D1") + " --> " + vop.isValid(Arrays.asList("P1", "D1", "P1", "D1")));

    }
}
